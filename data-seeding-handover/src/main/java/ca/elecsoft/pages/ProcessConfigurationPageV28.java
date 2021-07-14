package ca.elecsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class ProcessConfigurationPageV28 {
    private WebDriverWait wait;
    private WebDriver driver;

    public ProcessConfigurationPageV28(WebDriverWait wait, WebDriver driver, String url) throws InterruptedException {
        this.wait = wait;
        this.driver = driver;
        driver.get(url);
        Thread.sleep(5000);


    }

    public void switchToIntegrationTab() {
        driver.findElement(By.xpath("//*[@aria-label=\"Integrations\"]")).click();
    }

    public void display() {
        List<WebElement> elementList = driver.findElements(By.xpath("descendant::div"));
        for (WebElement x : elementList) {
            System.out.println(x.getAttribute("data-id"));
        }

    }


    private String getInputField(String id) {
        String format = "//*[@data-id=\"%s\"]/descendant::input";
        By xpath = By.xpath(String.format(format, id));
        WebElement branch = driver.findElement(xpath);
        return branch.getAttribute("title");
    }

    private String getSelectField(String id) {
        String format = "//*[@data-id=\"%s\"]/descendant::select";
        By xpath = By.xpath(String.format(format, id));
        WebElement branch = driver.findElement(xpath);
        Select select = new Select(branch);
        System.out.println(select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText();
    }

    private String getBasicField(String id) {
        return getSelectField(id);
//        String format = "//*[@data-id=\"%s\"]";
//        By xpath = By.xpath(String.format(format, id));
//        scrollTo(xpath);
//        String branchType = driver.findElement(xpath).getAttribute("value");
//        return noIdLabels(xpath);
    }

    private void scrollTo(By xpath) {
        WebElement x = wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);
    }

    public String noIdLabels(By xpath) {

        String d = driver.findElement(xpath).getText();
        String[] split = d.split("\\n");
        System.out.println(Arrays.toString(split));

        String ans = split[split.length - 1];
        return ans;


    }

    private String select(By xpath) {
        WebElement payment = driver.findElement(xpath);
        Select select = new Select(payment);
        System.out.println(select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText();
    }


    public String getFlow() {

        By xpath = By.xpath("//select[@aria-label=\"Flow\"]");
        scrollTo(xpath);
        WebElement payment = driver.findElement(xpath);
        Select select = new Select(payment);
        System.out.println(select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText();
    }

    public String getBranch_type() {
        By xpath = By.xpath("//select[@aria-label=\"Branch Type\"]");
        WebElement branch = driver.findElement(xpath);
        Select select = new Select(branch);
        System.out.println(select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText();
    }

    public String getPayment() {
        By xpath = By.xpath("//*[@aria-label=\"Payment\"]");
        scrollTo(xpath);
        WebElement payment = driver.findElement(xpath);
        Select select = new Select(payment);
        System.out.println(select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText();
    }

    public String getChange_Payment_method() {
        String label = "Change_Payment_method";
        By xpath = By.xpath("//*[@data-id=\"cgi_changepaymentmethod\"]");
        scrollTo(xpath);
        return noIdLabels(xpath);
    }

    public String getContract() {
        String label = "Contract";
        By xpath = By.xpath("//*[@aria-label=\"Contract\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return branchType;
    }

    public String getCreate_new_service_location() {
        String label = "Create_new_service_location";
        By xpath = By.xpath("//*[@data-id=\"cgi_createservicelocation\"]");
        scrollTo(xpath);
        return noIdLabels(xpath);
    }

    public String getMark_lines_ship_to_customer() {
        String label = "Mark_lines_ship_to_customer";
        By xpath = By.xpath("//*[@aria-label=\"Mark Lines Ship to Customer\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return branchType;
    }

    public String getActivate_upgradefunctionality() {
        By xpath = By.xpath("//*[@data-id=\"cgi_activateupgradefunctionality\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getETF_visible() {
        String label = "ETF_visible";
        By xpath = By.xpath("//*[@data-id=\"cgi_etfvisible\"]");
        System.out.println(xpath);
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getService_disconnect_date_visible() {
        String label = "Service_disconnect_date_visible";
        By xpath = By.xpath("//*[@data-id=\"cgi_servicedisconnectdatevisible\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getTrouble_type() {
        String id = "data-id=\"cgi_troubletypevisible\"";
        By xpath = By.xpath("//*[@" + id + "]");
        scrollTo(xpath);
        return noIdLabels(xpath);
    }

    public String getCCE_template() {
        String label = "CCE_template";

//        By xpath = By.xpath("//*[@id=\"id-02676df4-7d36-4846-9174-c267720d898b-12-cgi_ccetemplateopportunity6-cgi_ccetemplateopportunity.fieldControl-option-set-select\"]");
        By xpath = By.xpath("//*[@data-id=\"cgi_ccetemplateopportunity\"]/descendant::select");
        scrollTo(xpath);
        return select(xpath);
    }

    public String getActive_Bundle() {
        String label = "Active_Bundle";
        By xpath = By.xpath("//*[@aria-label=\"Active Bundle\"]");
        scrollTo(xpath);
        return select(xpath);
    }

    public String getQuotation_valid_in_days() {
        String label = "Quotation_valid_in_days";
        By xpath = By.xpath("//*[@data-id=\"cgi_quotationvalidindaysnew\"]/descendant::input");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return branchType;
    }

    public String getShow_Incl_choice_O() {
        String label = "Show_Incl_choice_O";
        By xpath = By.xpath("//*[@data-id=\"cgi_showincludedchoiceopportunity\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getProduct_Category_O() {
        String label = "Product_Category_O";
        By xpath = By.xpath("//*[@aria-label=\"Product Category\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return branchType;
    }

    public String getActivate_Self_install_filter_O() {
        String label = "Activate_Self_install_filter_O";
        By xpath = By.xpath("//*[@data-id=\"cgi_selfinstallopportunity\"]");
        scrollTo(xpath);
        return noIdLabels(xpath);
    }

    public String getActivate_Mail_out_filter_O() {
        String label = "Activate_Mail_out_filter_O";
        By xpath = By.xpath("//*[@data-id=\"cgi_mailoutoopportunity\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getNew_O() {
        String label = "New_O";
        By xpath = By.xpath("//*[@data-id=\"cgi_newopportunity\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getDefault_sign_O() {
        String label = "Default_sign_O";
        By xpath = By.xpath("//*[@data-id=\"cgi_servicedisconnectdatevisible\"]/descendant::input");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return branchType;
    }

    public String getDelete_O() {
        String label = "Delete_O";
        By xpath = By.xpath("//*[@data-id=\"cgi_deleteopportunity\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getCopy_customer_asset_() {
        String label = "Copy_customer_asset_";
        By xpath = By.xpath("//*[@data-id=\"cgi_copycustomerassets\"]/descendant::select");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return select(xpath);
    }

    public String getTruckrollvisible() {
        String label = "Truckrollvisible";
        By xpath = By.xpath("//*[@data-id=\"cgi_truckroll\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("value");
        return noIdLabels(xpath);
    }

    public String getTruck_roll_value() {
        String label = "Truck_roll_value";
        By xpath = By.xpath("//*[@data-id=\"cgi_truckrollvalue\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("value");
        return noIdLabels(xpath);
    }

    public String getContract_field_visible() {
        String label = "Contract_field_visible";
        By xpath = By.xpath("//*[@data-id=\"cgi_contractfieldvisible\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getDetail_section_visible() {
        String label = "Detail_section_visible";
        By xpath = By.xpath("//*[@data-id=\"cgi_detailsectionvisible\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getCCE_template_WO() {
        String label = "CCE_template_WO";
        By xpath = By.xpath("//*[@data-id=\"cgi_ccetemplateworkorder.fieldControl-option-set-select\"]");
        scrollTo(xpath);
        return select(xpath);
    }

    public String getCCE_template_SO() {
        String label = "CCE_template_SO";
        By xpath = By.xpath("//*[@data-id=\"cgi_ccetemplatesalesorder\"]/descendant::select");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return select(xpath);
    }

    public String getShow_Incl_choice_SO() {
        String label = "Show_Incl_choice_SO";
        By xpath = By.xpath("//*[@data-id=\"cgi_showincludedchoicesalesorder\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getProduct_Category_SO() {
        String label = "Product_Category_SO";
        By xpath = By.xpath("//*[@aria-label=\"Product Category\"]");
        scrollTo(xpath);
        return select(xpath);
    }

    public String getActivate_Self_install_filter_SO() {
        String label = "Activate_Self_install_filter_SO";
        By xpath = By.xpath("//*[@data-id=\"cgi_selfinstallsalesorder\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getActivate_Mail_out_filter_SO() {
        String label = "Activate_Mail_out_filter_SO";
        By xpath = By.xpath("//*[@data-id=\"cgi_mailoutsalesorder\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getNew_SO() {
        String label = "New_SO";
        By xpath = By.xpath("//*[@data-id=\"cgi_newsalesorder\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getDefault_sign_SO() {
        String label = "Default_sign_SO";
        By xpath = By.xpath("//*[@aria-label=\"Default_sign_SO\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return branchType;
    }

    public String getDelete_SO() {
        String label = "Delete_SO";
        By xpath = By.xpath("//*[@data-id=\"cgi_deletesalesorder\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getApprove_sales_order_automatically() {
        String label = "Approve_sales_order_automatically";
        By xpath = By.xpath("//*[@data-id=\"cgi_approvesalesorderautomatically\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getCreate_task() {
        String label = "Create_task";
        By xpath = By.xpath("//*[@data-id=\"cgi_createtask\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getTask_expiry_date() {
        String label = "Task_expiry_date";
        By xpath = By.xpath("//*[@data-id=\"cgi_taskexpiry\"]/descendant::input");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("value");
        return branchType;
    }

    public String getOwner() {
        String label = "Owner";
        By xpath = By.xpath("//*[@data-id=\"cgi_taskowner\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }


    public String getTeam(String value) {
        By xpath = null;
        if (value == "") {
            xpath = By.xpath("//*[@data-id=\"cgi_taskownerteam\"]/descendant::input");
        } else {
            String label = "Team";
            xpath = By.xpath("//*[@data-id=\"cgi_taskownerteam\"]/descendant::ul");
        }
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");

        return noIdLabels(xpath);
    }

    public String getUser(String value) {
        By xpath = null;
        if (value == "") {
            xpath = By.xpath("//*[@data-id=\"cgi_taskownerteam\"]/descendant::input");
        } else {
            String label = "Team";
            xpath = By.xpath("//*[@data-id=\"cgi_taskownerteam\"]/descendant::ul");
        }

        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getEdit_emergency_contact() {
        String label = "Edit_emergency_contact";
        By xpath = By.xpath("//*[@data-id=\"cgi_editemergencycontact\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getRequiredispositionciode() {
        String label = "Requiredispositionciode";
        By xpath = By.xpath("//*[@data-id=\"cgi_requiredispositioncode\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getBundle_in_header() {
        String label = "Bundle_in_header";
        By xpath = By.xpath("//*[@data-id=\"cgi_bundleinheader\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getCall_Service_disconnect() {
        String label = "Call_Service_disconnect";
        By xpath = By.xpath("//*[@data-id=\"cgi_callservicedisconnect\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getInstallation_status() {
        String label = "Installation_status";
        By xpath = By.xpath("//*[@data-id=\"cgi_installationstatus\"]/descendant::select");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return select(xpath);
    }

    public String getCreate_Service_request() {
        String label = "Create_Service_request";
        By xpath = By.xpath("//*[@data-id=\"cgi_createservicerequest\"]/descendant::select");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return select(xpath);
    }

    public String getService_request_status() {
        String label = "Service_request_status";
        By xpath = By.xpath("//*[@data-id=\"cgi_servicerequeststatus\"]/descendant::select");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return select(xpath);
    }

    public String getTrigger_marketingintegration() {
        String label = "Trigger_marketingintegration";
        By xpath = By.xpath("//*[@data-id=\"cgi_triggermarketingintegrationjob\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getSend_lines_to_SBN() {
        String label = "Send_lines_to_SBN";
        By xpath = By.xpath("//*[@data-id=\"cgi_sendcustomerassetlinestosbn\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }

    public String getCreate_action_plan() {
        String label = "Create_action_plan";
        By xpath = By.xpath("//*[@data-id=\"cgi_triggeractionplan\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return noIdLabels(xpath);
    }


    public String getFLOW_GENERAL() {
        return getFlow();
    }


    public String getBRANCH_TYPE_GENERAL() {
        return getBranch_type();
    }


    public String getPAYMENT_GENERAL() {
        return getPayment();
    }

    public String getCHANGE_PAYMENT_METHOD_GENERAL() {
        return getChange_Payment_method();
    }

    public String getMETHOD_OF_PAYMENT_GENERAL() {
        By xpath = By.xpath("//select[@aria-label=\"Method of Payment\"]");
        WebElement branch = driver.findElement(xpath);
        Select select = new Select(branch);
        System.out.println(select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText();
    }

    public String getCONTRACT_GENERAL() {
        return getContract();
    }


    public String getMARK_LINES__SHIP_TO_CUSTOMER_GENERAL() {
        return getMark_lines_ship_to_customer();
    }

    public String getACTIVATE_UPGRADE_FUNCTIONALITY_GENERAL() {
        return getActivate_upgradefunctionality();
    }


    public String getDEFAULT_SIGN_GENERAL() {

        return getSelectField("cgi_defaultsign");
    }

    public String getETF_VISIBLE_GENERAL() {
        return getETF_visible();
    }

    public String getSERVICE_DISCONNECT_DATE_VISIBLE_GENERAL() {
        return getService_disconnect_date_visible();
    }

    public String getTROUBLE_TYPE_CASE() {
        return getBasicField("cgi_troubletypevisible");
    }

    public String getCCE_TEMPLATE_OPPORTUNITY() {
        return getCCE_template();
    }


    public String getACTIVE_BUNDLE_OPPORTUNITY() {
        return getActive_Bundle();
    }

    public String getQUOTATION__VALID_IN_DAYS_OPPORTUNITY() {
        return getQuotation_valid_in_days();
    }

    public String getFILTER_WOST_OPPORTUNITY() {
        return getBasicField("cgi_filterwost");
    }

    public String getSHOW_INCL_CHOICE_OPPORTUNITY() {
        return getBasicField("cgi_showincludedchoiceopportunity");
    }


    public String getPRODUCT_CATEGORY_OPPORTUNITY() {
        return getProduct_Category_O();
    }

    public String getACTIVATE_SELF_INSTALL_FILTER_OPPORTUNITY() {
        return getActivate_Self_install_filter_O();
    }

    public String getACTIVATE_MAIL_OUT_FILTER_OPPORTUNITY() {
        return getActivate_Mail_out_filter_O();
    }

    public String getNEW_OPPORTUNITY() {
        return getBasicField("cgi_newopportunity");
    }

    public String getDELETE_OPPORTUNITY() {
        return getSelectField("cgi_deleteopportunity");
    }

    public String getCOPY_CUSTOMER_ASSET_OPPORTUNITY() {
        return getCopy_customer_asset_();
    }


    public String getTRUCKROLL_VISIBLE_OPPORTUNITY() {
        return getTruckrollvisible();
    }


    public String getTRUCK_ROLL_VALUE_OPPORTUNITY() {
        return getTruck_roll_value();
    }

    public String getCONTRACT_FIELD_VISIBLE_OPPORTUNITY() {
        return getSelectField("cgi_contractfieldvisible");
    }

    public String getSALES_ORDER__FILTER_OPPORTUNITY() {
        return getBasicField("cgi_salesorderfilter");
//                "Doesn't exist";
    }

    public String getCREATE_NEW__SERVICE_LOCATION_OPPORTUNITY() {
        return getCreate_new_service_location();
    }

    public String getCOPY_SERVICE_LOCATION_DETAILS_OPPORTUNITY() {
        String a = getBasicField("cgi_copyservicelocation").trim();
        if (a.equals("Copy Service Location")) {
            return "";
        }
        return a;
    }

    public String getNEW_COMMINTMENT___OPPORTUNITY() {
        String a = getBasicField("cgi_new_commit").trim();
        if (a.equals("New Commitment No")) {
            return "";
        }
        return a;
    }


    public String getNEW__CSID___OPPORTUNITY() {
        String a = getBasicField("cgi_new_csid").trim();
        if (a.equals("New CSID")) {
            return "";
        }
        return a;
    }

    public String getSEND_LINE_TYPE__INCL_CHOICE_INTEGRATION() {
        return getBasicField("cgi_sendlinetypeincludedchoice");
    }

    public String getSEND_LINE_TYPE__BUNDLE_INTEGRATION() {
        return getBasicField("cgi_sendlinetypebundle_cad");
    }

    public String getSERVICE_REQUEST_STATUS_INTEGRATION() {
        return getSelectField("cgi_servicerequeststatus");
    }


    public String getCREATE_SERVICE_REQUEST_INTEGRATION() {
        return getSelectField("cgi_createservicerequest");
    }

    public String getINSTALLATION_STATUS_INTEGRATION() {

        return getSelectField("cgi_installationstatus");
    }

    public String getCALL_CONTRACT_DETAILS_INTEGRATION() {
        return getBasicField("cgi_callservicedisconnect");
    }

    public String getCREATE__ACTION_PLAN_INTEGRATION() {
        return getBasicField("cgi_triggeractionplan");
    }

    public String getINTEGRATION_SYNC_BLOCK_INTEGRATION() {
        String a = getBasicField("cgi_integrationsyncblock");
        return emptyFieldHandle(a, "Integration Sync Block");

    }

    private String emptyFieldHandle(String a, String name) {
        if (a.equals(name)) {
            return "";
        }
        return a;
    }


    public String getSEND_LINES__TO_SBN_INTEGRATION() {
        return getBasicField("cgi_sendcustomerassetlinestosbn");
    }

    public String getTRIGGER_MARKETING_INTEGRATION_INTEGRATION() {
        return getBasicField("cgi_triggermarketingintegrationjob");
    }

    public String getBUNDLE_IN__HEADER_INTEGRATION() {
        return getBasicField("cgi_bundleinheader");
    }

    public String getREQUIRE_DISPOSITION_CIODE_TECHPORTAL() {
        return getBasicField("cgi_requiredispositioncode");
    }

    public String getEDIT_EMERGENCY_CONTACT() {
        return null;
    }

    public String getUSER() {
        return null;
    }

    public String getTEAM_SALESORDER() {
        String a = getBasicField("cgi_taskownerteam").trim();
        if (a.equals("Task Owner - Team")) {
            return "";
        }
        return a;
    }

    public String getOWNER_SALESORDER() {
        return getBasicField("cgi_taskowner");
    }

    public String getTASK_EXPIRY_DATE_SALESORDER() {
        return getInputField("cgi_taskexpiry");
    }

    public String getCREATE_TASK_SALESORDER() {
        return getBasicField("cgi_createtask");
    }

    public String getAPPROVE_SALES__ORDER__AUTOMATICALLY_SALESORDER() {
        return getBasicField("cgi_approvesalesorderautomatically");
    }

    public String getDELETE_SALESORDER() {
        return getBasicField("cgi_deletesalesorder");
    }

    public String getNEW_SALESORDER() {
        By xpath = By.xpath("//*[@data-id=\"cgi_newsalesorder\"]");
        scrollTo(xpath);
        return noIdLabels(xpath);
    }

    public String getACTIVATE_MAIL_OUT_FILTER_SALESORDER() {
        return getActivate_Mail_out_filter_SO();
    }

    public String getNEW_PANEL_ID___PHONE___OPPORTUNITY() {

//        String id = "cgi_new_panel";
        String id = "cgi_detailsectionvisible";
        String format = "//*[@data-id=\"%s\"]";
        By xpath = By.xpath(String.format(format, id));
        scrollTo(xpath);
        return noIdLabels(xpath);
    }

    public String getCOPY_SBN_INFORMATION_OPPORTUNITY() {
        return "field doesn't exist";
    }

    public String getDETAIL_SECTION_VISIBLE_OPPORTUNITY() {
        return getSelectField("cgi_detailsectionvisible");// getDetail_section_visible();
    }

    public String getCCE_TEMPLATE_WORKORDER() {
        return getSelectField("cgi_ccetemplateworkorder");
    }

    public String getCCE_TEMPLATE() {
        return null;
    }

    public String getSHOW_INCL__CHOICE_SALESORDER() {
        return getBasicField("cgi_showincludedchoicesalesorder");
    }

    public String getPRODUCT_CATEGORY_SALESORDER() {
        return getProduct_Category_SO();
    }

    public String getACTIVATE_SELF_INSTALL_FILTER_SALESORDER() {
        return getBasicField("cgi_selfinstallsalesorder");
    }

    public String getCCE_TEMPLATE_SALESORDER() {
        return getSelectField("cgi_ccetemplatesalesorder");
    }

    public String getEDIT_EMERGENCY_CONTACT_TECHPORTAL() {
        return getBasicField("cgi_editemergencycontact");

    }

    public String getUSER_SALESORDER() {
        String a = getBasicField("cgi_taskowneruser").trim();
        if (a.equals("Task Owner - User")) {
            return "";
        }
        return a;
    }

    public void switchToCaseTab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Case\" and @role='tab']"))).click();
    }

    public void switchToOpportunityTab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Opportunity\" and @role='tab']"))).click();
    }

    public void switchToWorkOrderTab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Work Order\" and @role='tab']"))).click();
    }

    public void switchToSalesOrderTab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Sales Order\" and @role='tab']"))).click();
    }

    public void switchToTechPortalTab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Tech Portal\" and @role='tab']"))).click();
    }


}
