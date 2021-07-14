package ca.elecsoft.pages;

import ca.elecsoft.model.CRMPaymentMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
    private WebDriverWait wait;
    private WebDriver driver;
    int waitAttempts;
    int attemps;

    public PaymentPage(WebDriverWait wait, WebDriver driver, String url) {
        this.wait = wait;
        this.driver = driver;
        driver.get(url);

    }

    public void getCreditDetails(CRMPaymentMethod pm) {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Payment Type\"]")));

        String paymentType = driver.findElement(By.xpath("//*[@aria-label=\"Payment Type\"]")).getAttribute("title");
        String bankInstitutionNumber = driver.findElement(By.xpath("//*[@aria-label=\"Bank institution number\"]")).getAttribute("value");
        String bankTransitNumber = driver.findElement(By.xpath("//*[@aria-label=\"Bank transit number\"]")).getAttribute("value");
        String bankAccountNumber = driver.findElement(By.xpath("//*[@aria-label=\"Bank account number\"]")).getAttribute("value");
        String accountHolderName = driver.findElement(By.xpath("//*[@aria-label=\"Account holder (name)\"]")).getAttribute("value");
//        String SBNGroup2 = driver.findElement(By.xpath("//*[@aria-label=\"SBNGroup2\"]")).getAttribute("value");

        System.out.println( paymentType + " " + bankInstitutionNumber + " " + bankTransitNumber + " " + bankAccountNumber + " " + accountHolderName + " " );


        pm.setPaymentType(paymentType);
        pm.setBankInstitutionNumber(bankInstitutionNumber);
        pm.setBankTransitNumber(bankTransitNumber);
        pm.setBankAccountNumber(bankAccountNumber);
        pm.setAccountHolderName(accountHolderName);



    }


}
