package ca.elecsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProcessConfigurationPage {
    private WebDriverWait wait;
    private WebDriver driver;

    public ProcessConfigurationPage(WebDriverWait wait, WebDriver driver, String url) throws InterruptedException {
        this.wait = wait;
        this.driver = driver;
        driver.get(url);
        Thread.sleep(5000);
        System.out.println(driver.getPageSource());




    }

    private void scrollTo(By xpath){
        WebElement x = wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);
    }

    public String getFlow() {
        By xpath = By.xpath("//*[@title=\"Repair\"]");
        scrollTo(xpath);
        String actualFlow = driver.findElement(xpath).getText();
        return actualFlow;
    }


    public String getBranchType() {
        By xpath = By.xpath("//*[@aria-label=\"Branch Type\"]");
        scrollTo(xpath);
        String branchType = driver.findElement(xpath).getAttribute("title");
        return branchType;
    }

    public String getPayment() {
        By xpath = By.xpath("//*[@aria-label=\"Payment\"]");
        scrollTo(xpath);

        WebElement payment = driver.findElement(xpath);
        Select select = new Select(payment);
        System.out.println(select.getFirstSelectedOption().getText());
//        String payment = driver.findElement(By.xpath("//*[@aria-label=\"Payment\"]")).getText();
        return select.getFirstSelectedOption().getText();
    }

    public String getChangePaymentMethod() {
        By xpath = By.xpath("//*[@data-id=\"cgi_changepaymentmethod.fieldControl-checkbox-containercheckbox-inner-first\"]");
        scrollTo(xpath);
        String paymentMethod = driver.findElement(xpath).getAttribute("aria-label");
        return paymentMethod;
    }


    public String getContract() {
        By xpath = By.xpath("//*[@aria-label=\"Contract\"]");
        scrollTo(xpath);
        String contract = driver.findElement(xpath).getAttribute("title");
        return contract;
    }

    public String getMarkLinesShipToCustomer() {
        By xpath = By.xpath("//*[@aria-label=\"Mark Lines Ship to Customer\"]");
        scrollTo(xpath);

        WebElement markLines = driver.findElement(xpath);
        Select select = new Select(markLines);
//        String payment = driver.findElement(By.xpath("//*[@aria-label=\"Payment\"]")).getText();
        return select.getFirstSelectedOption().getText();

    }

    public String getActiveUpgradeFunctionality() {
        By xpath = By.xpath("//*[@data-id=\"cgi_activateupgradefunctionality.fieldControl-checkbox-containercheckbox-inner-first\"]");
        scrollTo(xpath);

        String activeUpgrade = driver.findElement(xpath).getAttribute("aria-label");
        return activeUpgrade;
    }


    public String getCCETemplateOpportunity() {
        By xpath = By.xpath("//*[@aria-label=\"CCE Template\"]");
        scrollTo(xpath);
        WebElement cceTemplate = driver.findElement(xpath);
        Select select = new Select(cceTemplate);
        System.out.println(select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText();

    }

    public String getActiveBundle() {
        By xpath =By.xpath("//*[@aria-label=\"Active Bundle\"]");
        scrollTo(xpath);

        WebElement cceTemplate = driver.findElement(xpath);
        Select select = new Select(cceTemplate);
        System.out.println("the select option  = " + select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText();
    }

    public String getQuotationValidays() {
        By xpath =By.xpath("//*[@aria-label=\"Quotation Valid in Days\"]");
        scrollTo(xpath);
        return driver.findElement(xpath).getAttribute("title");
    }

    public String getShowIncludedChoice() {
        By xpath =By.xpath("//*[@data-id=\"cgi_showincludedchoiceopportunity.fieldControl-checkbox-containercheckbox-inner-first\"]");
        scrollTo(xpath);
        return driver.findElement(xpath).getAttribute("title");
    }

    public String getSelfInstall() {
        By xpath =By.xpath("//*[@data-id=\"cgi_selfinstallopportunity.fieldControl-checkbox-containercheckbox-inner-first\"]");
        scrollTo(xpath);
        return driver.findElement(xpath).getAttribute("title");
    }

    public String getProductCategory() {
        By xpath =By.xpath("//*[@aria-label=\"Product Category\"]");
        scrollTo(xpath);
        WebElement productCat = driver.findElement(xpath);
        Select select = new Select(productCat);
        System.out.println("the select option  = " + select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText();
    }

    public String getMailOutO() {
        return driver.findElement(By.xpath("//*[@data-id=\"cgi_mailoutoopportunity.fieldControl-checkbox-containercheckbox-inner-first\"]")).getAttribute("title");
    }

    public String getNewO() {
        return driver.findElement(By.xpath("//*[@data-id=\"cgi_newopportunity.fieldControl-checkbox-containercheckbox-inner-first\"]")).getAttribute("title");
    }

    public String getDelete_O() {
        return driver.findElement(By.xpath("//*[@data-id=\"cgi_deleteopportunity.fieldControl-checkbox-containercheckbox-inner-first\"]")).getAttribute("title");
    }


    public String getTruckRollVisible() {
        return driver.findElement(By.xpath("//*[@data-id=\"cgi_truckroll.fieldControl-checkbox-containercheckbox-inner-second\"]")).getAttribute("title");
    }

    public String getTruckRollValue() {
        return driver.findElement(By.xpath("//*[@data-id=\"cgi_truckrollvalue.fieldControl-checkbox-empty\"]")).getAttribute("value");

    }

    public String getCCETemplateWO() {

        WebElement cceTempalteWO = driver.findElement(By.xpath("//*[@aria-label=\"CCE Template\"]"));
        Select select = new Select(cceTempalteWO);
        System.out.println("the select option  = " + select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText();

    }


    public String getCCE_Template_SO() {

        WebElement cceTempalteSO = driver.findElement(By.xpath("//*[@data-id=\"cgi_ccetemplatesalesorder.fieldControl-option-set-select\"]"));
        Select select = new Select(cceTempalteSO);
        System.out.println("the select option  = " + select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText();



    }

    public String getProductCategory_SO() {

        WebElement productCategory = driver.findElement(By.xpath("//*[@data-id=\"cgi_productcatagorysalesorder.fieldControl-option-set-select\"]"));
        Select select = new Select(productCategory);
        System.out.println("the select option  = " + select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText();


    }
}
