package ca.elecsoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloseNewWavePopup {
    WebDriver driver;
    WebDriverWait wait;
    String url;

    public CloseNewWavePopup(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.url = "https://bsh-qa-2.crm3.dynamics.com/main.aspx?appid=0ae14cf9-42ae-ea11-a812-000d3a0c8127&pagetype=entityrecord&etn=account&id=018a459e-0508-eb11-a813-000d3a0c8127";
    }


    public void closePopUp() throws InterruptedException {
        driver.get(this.url);
        Thread.sleep(3000);
        System.out.println(driver.getPageSource());

    }






}
