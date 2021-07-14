package ca.elecsoft.pages;

import ca.elecsoft.model.MarketingTabValidation;
import ca.elecsoft.util.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class NewOrderInformationPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Util util;

    private static final Logger logger = LogManager.getLogger(NewOrderInformationPage.class);

    By paymentMethodInput;
    By paymentMethodButton;

    By paymentMethodIframe;
    By selectCard;

    By bypassCreditCheck;

    public NewOrderInformationPage(WebDriver driver, WebDriverWait wait, String url) {
        this.driver = driver;
        this.wait = wait;
        util = Util.getInstance();
        if (url.length() > 1) {
            driver.get(url);
        }

        paymentMethodInput = By.xpath("//input[@aria-label=\"Payment Methods, Lookup\"]");
        paymentMethodButton = By.xpath("//*[text()='Payment Method']");

        paymentMethodIframe = By.id("FullPageWebResource");
        selectCard = By.id("selectCard");

        bypassCreditCheck = By.xpath("//*[@aria-label=\"Bypass Credit Check\"]");

    }


    public void clickCreditCheck() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Credit Check\"]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Ok']"))).click();

    }

    public void getDateOfBirth(MarketingTabValidation mtv) {
        String dob = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Date of Birth\"]"))).getAttribute("value");
        mtv.setDob(dob);
    }

    public void insertDateOfBirth(String dob) {
        System.out.println("insertDateOfBirth()");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Date of Birth\"]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label=\"Date of Birth\"]"))).sendKeys(dob);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Date of Birth\"]"))).click();

    }


    public void openNextStageMen() {
        util.delayClick(driver, wait, By.xpath("//div[@title=\"Order Information\"]"));
    }

    public void confirmCreditCheck() {
        util.delayClick(driver, wait, By.xpath("//*[@data-id=\"header_process_cgi_creditcheckperformed.fieldControl-checkbox-containercheckbox-inner-first\"]"));
    }

    public void clickNextStage() throws InterruptedException {
        Thread.sleep(5000);
//        util.endlessClick(driver, wait, By.xpath("//button[@aria-label=\"Next Stage\"]"), 0);
        util.delayClick(driver, wait, By.xpath("//button[@aria-label=\"Next Stage\"]"));
        Thread.sleep(3000);
    }

    public void selectWorkOrder() {

//        By element = By.xpath("//*[@data-id=\"MscrmControls.Containers.ProcessStageControl-processCrossEntityItemContainer_0\"]");
//        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
//        webElement.click();

//        List<WebElement> selectNext = driver.findElements(By.xpath("//*[@data-id=\"MscrmControls.Containers.ProcessStageControl-processCrossEntityFlyoutItems\"]/descendant::li"));
//        for (WebElement x : selectNext) {
//            String b = "";
//            try {
//                b = x.getAttribute("aria-label");
//                if (b.matches("0000[0-9][0-9][0-9][0-9]")) {
//                    logger.debug("click next stage");
//                    x.click();
//                }
//            } catch (Exception e) {
//
//            }
//        }
    }

    public boolean isSelectWorkOrder() {
        try {
            System.out.println(driver.findElement(By.xpath("//*[text()='Select Work Order']")).getText());
            return true;
        } catch (Exception e) {
            System.out.println("isSelectFailure()");

            return false;
        }

    }

    public void keepClickingNextStage() throws InterruptedException {
        while (!isSelectWorkOrder()) {
            try {
                driver.findElement(By.xpath("//button[@aria-label=\"Next Stage\"]")).click();
            }catch (Exception e){

            }
            Thread.sleep(3000);
        }
    }

    public void dropDownMenu(WebElement element){
        Select select = new Select(element);
        select.selectByVisibleText("Yes");
    }



    public void nextStage() throws InterruptedException {
        util.delayClick(driver, wait, By.xpath("//div[@title=\"Order Information\"]"));

        WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Ready for Work Order\"]")));
        dropDownMenu(element);


//        util.delayClick(driver, wait, By.xpath("//*[@data-id=\"header_process_cgi_creditcheckperformed.fieldControl-checkbox-containercheckbox-inner-first\"]"));
        Thread.sleep(5000);

//        driver.findElement(By.xpath("//button[@aria-label=\"Next Stage\"]")).click();
//        util.delayClick(driver, wait, By.xpath("//*[@text()='Next Stage']"));

//        util.delayClick(driver, wait, By.xpath("//button[@aria-label=\"Next Stage\"]"));
//        util.delayClick(driver, wait, By.xpath("//*[@data-id=\"MscrmControls.Containers.ProcessStageControl-Next Stage\"]"));
        keepClickingNextStage();

//        Thread.sleep(4000);

//        By element = By.xpath("//*[@data-id=\"MscrmControls.Containers.ProcessStageControl-processCrossEntityItemContainer_0\"]");
//        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
//        webElement.click();

//        List<WebElement> selectNext = driver.findElements(By.xpath("//*[@data-id=\"MscrmControls.Containers.ProcessStageControl-processCrossEntityFlyoutItems\"]/descendant::li"));
//        for (WebElement x : selectNext) {
//            String b = "";
//            try {
//                b = x.getAttribute("aria-label");
//                if (b.matches("0000[0-9][0-9][0-9][0-9]")) {
//                    logger.debug("click next stage");
//                    x.click();
//                }
//            } catch (Exception e) {
//
//            }
//        }


        List<WebElement> selectNext = driver.findElements(By.xpath("//descendant::li"));
        for (WebElement x : selectNext) {
            String b = "";
            try {
                b = x.getAttribute("aria-label");
                if (b.matches("0000[0-9][0-9][0-9][0-9]")) {
                    logger.debug("click next stage");
                    System.out.println("Click Next Stage");
                    x.click();
                }
            } catch (Exception e) {
            }
        }

    }

    public void insertPaymentMethodLookup(HashMap<String, String> map) throws InterruptedException {
        String paymentMethod = map.get("Type:");
        if (paymentMethod.equals("PreAuthorizedDebit")) {
            String bankAccountNo = map.get("Bank Account:");
            String last4 = bankAccountNo.substring(bankAccountNo.length() - 4);

            util.inputLookUp(driver, wait, paymentMethodInput, "Direct Debit " + last4);
        } else {
            String cardNumber = map.get("Account Number:");
            String last4 = cardNumber.substring(cardNumber.length() - 4);
            String cardType = map.get("Credit Card Type:");

            util.inputLookUp(driver, wait, paymentMethodInput, "Credit Card " + cardType + " " + last4);
        }


    }

    public void bypassCreditCheck() throws IOException {
        util.delayClick(driver, wait, bypassCreditCheck);
        WebElement reasonCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label=\"Reason Code\"]")));
        Select reasonSelect = new Select(reasonCode);
        reasonSelect.selectByIndex(4);
    }

    public void addCreditPaymentMethod(HashMap<String, String> map) throws InterruptedException {
        logger.info(driver.getCurrentUrl());
//        util.delayClick(driver, wait, paymentMethodButton);
        util.endlessClick(driver, wait, paymentMethodButton, 0);

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentMethodIframe));
        WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(selectCard));
        Select cardSelect = new Select(card);
        cardSelect.selectByIndex(1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String cardType = map.get("Credit Card Type:");
        String cardHolder = map.get("Card Holder Name:");
        String cardNumber = map.get("Account Number:");


        util.delayInput(driver, wait, By.id("cardholdernameTextId"), cardHolder);
        util.delayInput(driver, wait, By.id("creditCardTextId"), cardNumber);//"4157315205043891"
        util.delayInput(driver, wait, By.id("cvvTextId"), "1234");

        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("10");
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByValue("27");

        Thread.sleep(1000);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("authorizeMethod();");
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        util.delayClick(driver, wait, By.id("okButton"));

        try {
            WebDriverWait w = new WebDriverWait(driver, 5);
            w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentMethodIframe));
            util.delayClick(driver, w, By.id("btnCancel"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.switchTo().defaultContent();


    }


    public String getCreditCheckResult() {
        String result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Credit Check Result\"]"))).getAttribute("title");
        return result;
    }


    public void addDebitPaymentMethod(HashMap<String, String> map) throws IOException, InterruptedException {

        logger.info(driver.getCurrentUrl());
//        util.delayClick(driver, wait, paymentMethodButton);
        util.endlessClick(driver, wait, paymentMethodButton, 0);

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentMethodIframe));
        WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(selectCard));
        Select cardSelect = new Select(card);
        cardSelect.selectByIndex(3);
        Thread.sleep(1000);

        util.delayInput(driver, wait, By.id("bankInstitutionNumberId"), map.get("Bank Institution:"));
        util.delayInput(driver, wait, By.id("bankTransitNumberId"), map.get("Bank Transit:"));
        util.delayInput(driver, wait, By.id("bankAccountNumberId"), map.get("Bank Account:"));
        util.delayInput(driver, wait, By.id("accountHolderId"), map.get("Bank Account:"));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("saveDirectDebit();");
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        util.delayClick(driver, wait, By.id("okButton"));

//        try {
//            WebDriverWait w = new WebDriverWait(driver, 3);
//            w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentMethodIframe));
//            util.delayClick(driver, w, By.id("btnCancel"));
//        } catch (Exception e) {
////            e.printStackTrace();
//        }
//
//        driver.switchTo().defaultContent();


    }


}
