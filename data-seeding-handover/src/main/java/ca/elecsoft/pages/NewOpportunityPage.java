package ca.elecsoft.pages;

import ca.elecsoft.model.MarketingTabValidation;
import ca.elecsoft.model.OpportunityProductLineItem;
import ca.elecsoft.model.OppotunityOverview;
import ca.elecsoft.util.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewOpportunityPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Util util;
    private static final Logger logger = LogManager.getLogger(NewOpportunityPage.class);

    By serviceLocationType;

    By detailsTab;
    By productLineItemTab;


    By customerType;
    By customerSubTypeResidential;

    //product line item tab
    By workOrderType;
    By workOrderSubType;
    By responseType;
    By bundleName;

    private By getWorkOrderId;
    //opportunity
    By nextStage;
    By opportunityRibbon;
    By customerAcountInformationChecked;
    By readyForOrderInformation;
    By suggestionsButton;

    //validation
    By workOrderTypeProvisioning;
    By qolysosPackageName;
    By workOrderSubTypeInstallation;
    By customerAccountInformationCheckedYes;
    By getReadyForOrderInformationYes;


    public NewOpportunityPage(WebDriver driver, WebDriverWait wait, String url) {
        this.driver = driver;
        this.wait = wait;
        this.util = Util.getInstance();
        if (url.length() > 1) {
            driver.get(url);
        }

        serviceLocationType = By.xpath("//select[@aria-label=\"Service Location Type\"]");
        workOrderType = By.xpath("//input[@aria-label=\"Work Order Type, Lookup\"]");
        workOrderSubType = By.xpath("//input[@aria-label=\"Work Order Sub-Type, Lookup\"]");
        detailsTab = By.xpath("//*[@aria-label=\"Details\"]");
        customerType = By.xpath("//input[@aria-label=\"Customer Type\"]");
        customerSubTypeResidential = By.xpath("//select[@aria-label=\"Customer Sub-Type Residential\"]");
        productLineItemTab = By.xpath("//li[@aria-label=\"Product Line Item\"]");
        responseType = By.xpath("//select[@aria-label=\"Response Type\"]");
        bundleName = By.xpath("//input[@aria-label=\"Bundle Name, Lookup\"]");
        nextStage = By.xpath("//button[@title=\"Next Stage\"]");
        opportunityRibbon = By.xpath("//div[@title=\"Opportunity\"]");
        getWorkOrderId = By.xpath("//div[@data-lp-id=\"form-header-title\"]/h1");
        customerAcountInformationChecked = By.xpath("//*[@data-id=\"header_process_cgi_customeraccountinformationchecked.fieldControl-checkbox-inner-first\"]");
        readyForOrderInformation = By.xpath("//*[@data-id=\"header_process_cgi_readyfororderinformation.fieldControl-checkbox-containercheckbox-inner-first\"]");

        workOrderTypeProvisioning = By.xpath("//*[@aria-label=\"Provisioning / Approvisionnement\"]");
        workOrderSubTypeInstallation = By.xpath("//*[@aria-label=\"New Installation / Nouvelle installation\"]");
        qolysosPackageName = By.xpath("//*[@aria-label=\"Qolsys Good Package\"]");
        customerAccountInformationCheckedYes = By.xpath("//*[@data-id=\"header_process_cgi_customeraccountinformationchecked.fieldControl-checkbox-containercheckbox-inner-second\"]");
        getReadyForOrderInformationYes = By.xpath("//*[@data-id=\"header_process_cgi_readyfororderinformation.fieldControl-checkbox-containercheckbox-inner-second\"]");
        suggestionsButton = By.xpath("//*[@aria-label=\"Suggestions\"]");


    }


    public void getProgramAndSource(MarketingTabValidation mtv) {

        String program = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Compensation\"]/descendant::*[@data-id=\"cgi_programid\"]/descendant::ul/li"))).getText();
        String source = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Compensation\"]/descendant::*[@data-id=\"cgi_sourceid\"]/descendant::ul/li"))).getText();
        mtv.setProgram(program);
        mtv.setSource(source);

    }

    public void switchToDetails() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Details\"]"))).click();
    }

    public void getDetails(MarketingTabValidation mtv) {
        String B1Number = driver.findElement(By.xpath("//*[@aria-label=\"B1 Number\"]")).getAttribute("value");
        String MobileTelephone = driver.findElement(By.xpath("//*[@aria-label=\"Mobile Telephone #\n\"]")).getAttribute("value");
        String MobileAccount = driver.findElement(By.xpath("//*[@aria-label=\"Mobile Telephone #\n\"]")).getAttribute("value");


    }


    int global = 0;

    public void openSuggestions() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(suggestionsButton)).click();
            global++;
        } catch (Exception e) {
            if (global < 20) {
                openSuggestions();
            }
//            e.printStackTrace();
        }
    }

    public void switchTosuggestionMenu() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FullPageWebResource")));
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='PowerG Carbon Monoxide Detector']"))).getText());


    }

    public void switchToAddress() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Address\"]"))).click();
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("fullscreen-app-host")));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@tabindex=\"35\"]"))).click();
    }

    public void sendQuotation() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Send Quotation\"]"))).click();
    }


    public void getAddressInformation(MarketingTabValidation mtv) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Province\"]")));
        String streetNo = driver.findElement(By.xpath("//*[@aria-label=\"Street Number\"]")).getAttribute("value");
        String streetOne = driver.findElement(By.xpath("//*[@aria-label=\"Street 1\"]")).getAttribute("value");
        String streetTwo = driver.findElement(By.xpath("//*[@aria-label=\"Street 2\"]")).getAttribute("value");
        String city = driver.findElement(By.xpath("//*[@aria-label=\"City\"]")).getAttribute("value");
        String postalCode = driver.findElement(By.xpath("//*[@aria-label=\"Postal Code\"]")).getAttribute("value");
        String province = driver.findElement(By.xpath("//*[@aria-label=\"Province\"]")).getAttribute("title");


        mtv.setStreetNoOne(streetNo);
        mtv.setStreetOne(streetOne);
        mtv.setCity(city);
        mtv.setPostalCode(postalCode);


    }


    public void addAdditionalItem(String productName, String quanity) {
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + productName + "']"))).getText());
        WebElement elementQuanity = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + productName + "']/following::input")));
        WebElement elementButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + productName + "']/following::button")));
        System.out.println(elementQuanity.getAttribute("value"));
        elementQuanity.sendKeys(quanity);
        elementButton.click();

    }

    public void addPromotionItems(String productName) {
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + productName + "']"))).getText());
        WebElement elementButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + productName + "']/following::button")));
        elementButton.click();
    }

    public void closeSuggestionsMenu() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Close\"]"))).click();

    }


    public Boolean checkWorkOrderType() {
        Boolean ans = false;
        try {
            driver.findElement(workOrderTypeProvisioning);
            ans = true;
        } catch (Exception e) {
            logger.debug(e.toString());
            ans = false;
        } finally {
            return ans;
        }

    }

    public Boolean validateLookUp(By lookup) {
        Boolean ans = false;
        try {
            driver.findElement(lookup);
            ans = true;
        } catch (Exception e) {
            logger.debug(e.toString());
            ans = false;
        } finally {
            return ans;
        }
    }


    public Boolean checkworkOrderTypeProvisioning() {
        Boolean ans = false;
        try {
            driver.findElement(workOrderSubTypeInstallation);
            ans = true;
        } catch (Exception e) {
            logger.debug(e.toString());
            ans = false;
        } finally {
            return ans;
        }
    }


    public void fillOrderMaxNumber(String value) {
        util.delayInput(driver, wait, By.xpath("//*[@aria-label=\"Order Max Order Number\"]"), value);
    }


    public void checkCustomerAccount() {
        util.delayClick(driver, wait, customerAccountInformationCheckedYes);
    }

    public void checkReadyForOrderInformation() {
        util.delayClick(driver, wait, readyForOrderInformation);
    }


    public void dropDownMenu( WebElement element){
        Select select = new Select(element);
        select.selectByVisibleText("Yes");


    }

    public void nextStage() throws InterruptedException {
        Thread.sleep(3000);
//        WebElement element = driver.findElement(opportunityRibbon);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).click().build().perform();
        endlessClick(driver, wait, opportunityRibbon, 0);
//        util.delayClick(driver, wait, opportunityRibbon);
//        if (!isCustomerAccountChecked()) {
//            checkCustomerAccount();
//        }

        Thread.sleep(3000);
        dropDownMenu(driver.findElement(By.xpath("//*[@aria-label=\"Customer Account information checked\"]")));

        Thread.sleep(1000);

        dropDownMenu(driver.findElement(By.xpath("//*[@aria-label=\"Ready for Order Information\"]")));
//        if (!isReadyForOrderInformation()) {
//            checkReadyForOrderInformation();
//        }
        Thread.sleep(5000);
        util.delayClick(driver, wait, nextStage);

        selectWorkOrder();

    }

    public void selectWorkOrder() {
        WebDriverWait quickWait = new WebDriverWait(driver, 3);
//        By workOrderNext = By.xpath("//li[@aria-label=\"" + getOpportunityId().trim() + "\" or @aria-label=\"" + getOpportunityId().trim()+ " \"" + "or @aria-label=\"" + getOpportunityId().trim() +"  \"]");
        By workOrderNext = By.xpath("//*[contains(@aria-label, '" + getOpportunityId().trim() + "')]");

        quickWait.until(ExpectedConditions.presenceOfElementLocated(workOrderNext)).click();
//        try {
//            quickWait.until(ExpectedConditions.presenceOfElementLocated(workOrderNext)).click();
//        } catch (Exception e) {
//        }
//        try {
//            workOrderNext = By.x<path("//li[@aria-label=\"" + getOpportunityId().trim() + "  \"]");
//            quickWait.until(ExpectedConditions.presenceOfElementLocated(workOrderNext)).click();
//        } catch (Exception e) {
//
//
//        }

    }


    public Boolean isReadyForOrderInformation() {
        return util.getCheckBox(wait, getReadyForOrderInformationYes);
    }

    public Boolean isCustomerAccountChecked() {
        return util.getCheckBox(wait, customerAccountInformationCheckedYes);
    }

    public void endlessClick(WebDriver driver, WebDriverWait wait, By link, int attempts) throws InterruptedException {
        if (attempts > 10) {

        } else {
            try {
                util.delayClick(driver, wait, opportunityRibbon);

            } catch (Exception e) {
                Thread.sleep(1000);
                endlessClick(driver, wait, opportunityRibbon, attempts++);
            } finally {

            }

        }

    }


    public String getOpportunityId() {
        return util.getText(driver, wait, getWorkOrderId, "title");
    }

    public void fillProductLineItemTab(OpportunityProductLineItem opli) {
        util.setSelect(wait.until(ExpectedConditions.presenceOfElementLocated(responseType)), 2);
        if (!validateLookUp(qolysosPackageName)) {
            util.inputLookUp(driver, wait, bundleName, opli.getBundleName());
        }
    }

    public void fillOverview(OppotunityOverview overview) {
        selectServiceLocationType(overview.getServiceLocationType());
        logger.info(driver.getCurrentUrl());
        if (!checkWorkOrderType()) {
            util.inputLookUp(driver, wait, workOrderType, "Provisioning");
        }
        if (!checkworkOrderTypeProvisioning()) {
            util.inputLookUp(driver, wait, workOrderSubType, overview.getWorkOrderSubType());
        }

    }

    public void switchDetails() {
        wait.until(ExpectedConditions.presenceOfElementLocated(detailsTab)).click();
    }

    public void fillDetails(int index, String customerType) {
        if (customerType.equals("Residential")) {
            util.setSelect(wait.until(ExpectedConditions.presenceOfElementLocated(customerSubTypeResidential)), index);
        } else if (customerType.equals("Commercial")) {
            util.setSelect(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Customer Sub-Type Commercial\"]"))), index);
        }
    }

    public void switchProductLineItem() {
        wait.until(ExpectedConditions.presenceOfElementLocated(productLineItemTab)).click();
    }


    public void selectServiceLocationType(String type) {
        System.out.println("selectServiceLocationType");
        WebElement caSelect = wait.until(ExpectedConditions.presenceOfElementLocated(serviceLocationType));
        Select cs = new Select(caSelect);
        switch (type) {
            case "Video and Automation":
                cs.selectByValue("285050002");
                break;
            case "Medical":
                cs.selectByValue("285050000");
                break;
            case "Security":
                cs.selectByValue("285050001");
                break;
            default:
                System.out.println("error");
                new Exception();
                break;
        }
    }


    public String getWorkOrderType() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-id=\"msdyn_workordertype.fieldControl-LookupResultsDropdown_msdyn_workordertype_selected_tag_text\"]"))).getText();
    }

    public String getWorkOrderSubType() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-id=\"cgi_workordersubtype_new.fieldControl-LookupResultsDropdown_cgi_workordersubtype_new_selected_tag_text\"]"))).getText();
    }

    public void readyForNextStage() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@aria-label=\"Ready for Next Stage\"]")).click();
        Thread.sleep(3000);

    }

    public void clickNextStage() {

        driver.findElement(By.xpath("//*[@aria-label=\"Next Stage\"]")).click();
    }

    public void selectGeneratedWorkOrder() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Select Work Order' or text()='Select Sales Order' ]/../following-sibling::div/li"))).click();
        Thread.sleep(2000);
    }
}
