package ca.elecsoft.pages;

import ca.elecsoft.model.BillinAccountValidationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomerAccountPage {
    private WebDriverWait wait;
    public WebDriver driver;


    By bellSmartHomeApp;
    By iframe;

    private static final Logger logger = LogManager.getLogger(AppsPage.class);

    public void switchToAllTab(){
        WebElement elements = driver.findElement(By.xpath("//ul[@id=\"tablist_0\"]/li"));


    }


    public CustomerAccountPage(WebDriver driver, WebDriverWait wait, String url) {
        this.wait = wait;
        this.driver = driver;

        driver.get(url);
    }

    public void switchToCaseTab() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Cases\" and @role='tab']"))).click();
        Thread.sleep(2000);

    }

    private String getBasicField(String id) {
        String format = "//*[@data-id=\"%s\"]";
        By xpath = By.xpath(String.format(format, id));
        String branchType = driver.findElement(xpath).getText();
        return branchType;
    }

    public void getValue(List<String> stringList) {
        for (String x : stringList) {
            try {
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath()))
                String d = getBasicField(x);
                System.out.println(d);
            } catch (Exception e) {

            }
        }

    }

    public void switchToAddressTab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Address\"]"))).click();
    }

    public void getAddressInformation(BillinAccountValidationModel bavm) {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Province\"]")));
        String streetNo = driver.findElement(By.xpath("//*[@aria-label=\"Street Number\"]")).getAttribute("value");
        String streetOne = driver.findElement(By.xpath("//*[@aria-label=\"Street 1\"]")).getAttribute("value");
        String city = driver.findElement(By.xpath("//*[@aria-label=\"City\"]")).getAttribute("value");
        String postalCode = driver.findElement(By.xpath("//*[@aria-label=\"Postal Code\"]")).getAttribute("value");
        String province = driver.findElement(By.xpath("//*[@aria-label=\"Province\"]")).getAttribute("title");


        bavm.setStreet1no1(streetNo);
        bavm.setStreet1(streetOne);
        bavm.setCity(city);
        bavm.setZip(postalCode);
        bavm.setProvince(province);


    }


    public void getBillingAccountDetails(BillinAccountValidationModel bavm) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Mobile Phone\"]")));
        String customerType = driver.findElement(By.xpath("//*[@aria-label=\"Customer Type\"]")).getAttribute("title");
        String BusinessName = driver.findElement(By.xpath("//*[@aria-label=\"Business Name\"]")).getAttribute("value");
        String Email = driver.findElement(By.xpath("//*[@aria-label=\"Email\"]")).getAttribute("value");
        String HomePhone = driver.findElement(By.xpath("//*[@aria-label=\"Home Phone\"]")).getAttribute("value");
        String MobilePhone = driver.findElement(By.xpath("//*[@aria-label=\"Mobile Phone\"]")).getAttribute("value");

        System.out.println(BusinessName);
        String[] split = BusinessName.split(" ");
        String firstName = split[0];
        String lastName = split[1];

        System.out.println(customerType + " " + BusinessName + " " + Email + " " + HomePhone + " " + MobilePhone);

        bavm.setSub_type(customerType);
        bavm.setFirstName(firstName);
        bavm.setLastName(lastName);
        bavm.setEmail(Email);
        bavm.setPhone(HomePhone);
        bavm.setPhone2(MobilePhone);

    }


    public void clickNewCase() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label=\"New Case\"]"))).click();
    }
}
