package ca.elecsoft.dynamics;

import ca.elecsoft.model.*;
import ca.elecsoft.pages.*;
import ca.elecsoft.util.Excel;
import ca.elecsoft.util.Folder;
import ca.elecsoft.util.Util;
import ca.elecsoft.util.Word;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataSeedMainVersionDataProvider {
    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DataSeedMainVersionDataProvider.class);
    public static String folderPath;
    public static Boolean takeScreenshots = true;
    public static List<BufferedImage> bufferedImageList;
    public static Word word = Word.getINSTANCE();
    public static String fileName = "ThreadRunner-";
    public static Thread st;
    public static String errorMessage;
    public static String workOrderNo = "";



    private static String getTimeStamp() {
        LocalDate ld = LocalDate.now();
        System.out.println(ld.toString());
        return ld.toString();
    }

    public static String leadToWorkOrderSchedule(WebDriver driver, WebDriverWait wait, String index, DataSeedModel dataSeedModel) throws Exception {
        Prop prop = Prop.getInstance();
        Util util = Util.getInstance();
        DOMConfigurator.configure("log4j.xml");


        HashMap<String, String> map = util.fakeOrder(dataSeedModel.getPostalCode());

        Lead lead = util.createLead(map);
        util.overWriteLeadInformation(lead);
        util.overWriteAddressInformation(lead, dataSeedModel);

        if (dataSeedModel.getRequestType().equals("Residential")) {
            lead.setCustomerType("Residential");
        } else {
            lead.setCustomerType("Commercial");
        }
//

        OppotunityOverview oo = new OppotunityOverview(dataSeedModel.getServiceLocationtype(), dataSeedModel.getWorkOrderType(), dataSeedModel.getWorkOrderSubType());
        OpportunityProductLineItem opli = new OpportunityProductLineItem("Private Guard", dataSeedModel.getBundle());

        String appsUrl = prop.loadProp(prop.getAPP_PAGE_URL());
        String newLeadPageUrl = prop.loadProp(prop.getNEW_LEAD_PAGE_URL());
        String newOpportunityPageUrl = "";//"https://bsh-qa.crm3.dynamics.com/main.aspx?appid=9686dcf5-4dfc-42f3-a4d2-7250ae0ea14f&pagetype=entityrecord&etn=opportunity&id=5a376114-b2e3-ea11-a813-000d3a0c8cd2&cmdbar=true";
        String newOrderInformationPageUrl = "";
        String newWorkOrderPageUrl = "";
        String opportunityPage = "";

        List<AdditionalItem> addtionalItemList = dataSeedModel.getAddtionalItem();
        List<String> promotionList = dataSeedModel.getPromotions();


        System.out.println(addtionalItemList);

        Boolean hasAdditionalItems = addtionalItemList.size() > 0;
        Boolean hasPromotions = promotionList.size() > 0;
        Boolean noIncludedChoice = dataSeedModel.getIncludedChoice().equals("NA");
        Boolean payWithCredit = dataSeedModel.getPaymentMethod().equals("Credit");
        if (!payWithCredit) {
            map.put("Type:", "PreAuthorizedDebit");
        }
        Reporter.log(dataSeedModel.getBundle());
        try {
            driver.manage().window().maximize();
            driver.get(prop.loadProp(prop.getENVIRONMENT_URL()));
            int attempts = Integer.valueOf(prop.loadProp(prop.getDEFAULT_WAIT_TIME()));
            logger.info("Process Start");
            LoginPage lp = new LoginPage(driver, wait, prop.loadProp(prop.getENVIRONMENT_URL()), attempts);
            lp.login(prop.loadProp(prop.getUSER_NAME()), prop.loadProp(prop.getPASSWORD()));
            NewLeadPage newLeadPage = new NewLeadPage(driver, wait, newLeadPageUrl);
            newLeadPage.fillMandatorySummary(lead);

            newLeadPage.switchToAddress();
            newLeadPage.fillAddress(lead.getAddress());

            newLeadPage.saveLead();
            newLeadPage.qualifyLead();
            NewOpportunityPage newOpportunityPage = new NewOpportunityPage(driver, wait, newOpportunityPageUrl);
            newOpportunityPage.fillOverview(oo);

            opportunityPage += driver.getCurrentUrl();
            newOpportunityPage.switchDetails();
            newOpportunityPage.fillDetails(1, lead.getCustomerType());

            newOpportunityPage.switchProductLineItem();
            newOpportunityPage.fillProductLineItemTab(opli);

            Thread.sleep(5000);
            if (hasAdditionalItems || hasPromotions || !noIncludedChoice) {
                newOpportunityPage.openSuggestions();
                newOpportunityPage.switchTosuggestionMenu();
                for (AdditionalItem ai : addtionalItemList) {
                    newOpportunityPage.addAdditionalItem(ai.getLabel(), ai.getQuantity());
                    Thread.sleep(2000);
                }

                for (String b : promotionList) {
                    newOpportunityPage.addPromotionItems(b);
                    Thread.sleep(2000);
                }
                driver.navigate().refresh();
                newOpportunityPage.switchProductLineItem();
            }
            newOpportunityPage.nextStage();
            NewOrderInformationPage orderInformation = new NewOrderInformationPage(driver, wait, newOrderInformationPageUrl);
            if (lead.getCustomerType().equals("Residential")) {
                orderInformation.bypassCreditCheck();
            }
            if (payWithCredit) {
                orderInformation.addCreditPaymentMethod(map);
            } else {
                orderInformation.addDebitPaymentMethod(map);
            }
            orderInformation.insertPaymentMethodLookup(map);
            Thread.sleep(5000);
            orderInformation.nextStage();
            orderInformation.openNextStageMen();
            Thread.sleep(3000);
            NewWorkOrderPage newWorkOrderPage = new NewWorkOrderPage(driver, wait, newWorkOrderPageUrl);
            workOrderNo = newWorkOrderPage.getWorkOrderNumber();

            workOrderNo += ",";
            workOrderNo += driver.getCurrentUrl();

            Thread.sleep(2000);
            newWorkOrderPage.clickSchedule();

            SchedulePage sp = new SchedulePage(driver, wait);
            sp.scheduleFirstAvailableDate();

            logger.info("Process Complete");
            System.out.println(workOrderNo);

            return workOrderNo;


        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return "F-" + e.toString() + "," + opportunityPage;
        } finally {
            Thread.sleep(3000);


        }

    }


}
