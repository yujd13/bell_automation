package ca.elecsoft.pages;

import ca.elecsoft.model.MarketingTabValidation;
import ca.elecsoft.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServiceLocationPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Util util;



    public ServiceLocationPage(WebDriver driver, WebDriverWait wait, String url) {
        this.driver = driver;
        this.wait = wait;
        util = Util.getInstance();
        if (url.length() > 1) {
            driver.get(url);
        }

        driver.get(url);


    }

    public void switchToOverview(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Overview\"]"))).click();

    }

    public String getSBNContactNo(){
        String sbnInteralContract = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"SBN Contract No\"]"))).getAttribute("value");
        return  sbnInteralContract;
    }

    public String getSBNNo(){
        String sbnNo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"SBN No\"]"))).getAttribute("value");
        return  sbnNo;
    }

    public String getSBNInteralContractNo(){
        String sbnInteralContract = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"SBN Internal Contract No (s_ctr)\"]"))).getAttribute("value");
        return  sbnInteralContract;
    }



    public void switchToSBNINtegration(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"SBN Integration\"]"))).click();
    }

    public String getContractStart(){
        String contractStart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Contract Start\"]"))).getAttribute("value");
        return  contractStart;
    }

    public String getContractEnd(){
        String contractEnd = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Contract End\"]"))).getAttribute("value");
        return  contractEnd;
    }

    public String getContractLength(){
        String contractLength = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Contract Length\"]"))).getAttribute("title");
        return  contractLength;
    }


    public void getSyncInformation(MarketingTabValidation mtv ){

        String email = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Email\"]"))).getAttribute("value");
        String phoneNumber = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Phone Number\"]"))).getAttribute("value");
        String SBNContact_First_Name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"SBN Contact_First_Name\"]"))).getAttribute("value");
        String SBNConatact_Last_Name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"SBN Contact_Last_Name\"]"))).getAttribute("value");
        String SBNTimezone = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"SBN Timezone\"]"))).getAttribute("value");

        mtv.setEmail(email);
        mtv.setPhone(phoneNumber);
        mtv.setFirstName(SBNContact_First_Name);
        mtv.setLastName(SBNConatact_Last_Name);
        mtv.setTime_zone(SBNTimezone);




    }




    public void getAddressInformation(MarketingTabValidation mtv){
        String streetNumber = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Street Number\"]"))).getAttribute("value");
        String streetOne = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Street 1\"]"))).getAttribute("value");
        String city = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"City\"]"))).getAttribute("value");
        String postalCode = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Postal Code\"]"))).getAttribute("value");
        String province = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Province\"]"))).getAttribute("value");



        mtv.setStreetNoOne(streetNumber);
        mtv.setStreetOne(streetOne);
        mtv.setCity(city);
        mtv.setPostalCode(postalCode);
        mtv.setProvince(province);


    }



}
