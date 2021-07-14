package ca.elecsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProcessConfigurationPageF {
    private WebDriverWait wait;
    private WebDriver driver;

    public ProcessConfigurationPageF(WebDriverWait wait, WebDriver driver, String url) throws InterruptedException {
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

    private void scrollTo(By xpath) {
        WebElement x = wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);
    }

    public String noIdLabels(By xpath) {

        String d = driver.findElement(xpath).getText();
        String[] split = d.split("\\n");
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


}
