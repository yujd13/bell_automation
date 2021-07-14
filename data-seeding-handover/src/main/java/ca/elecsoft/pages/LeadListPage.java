package ca.elecsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadListPage {
    int waitAttempts;

    By newButton;


    public LeadListPage(WebDriver driver, WebDriverWait wait, String url, int waitAttempts) {
        this.waitAttempts = waitAttempts;

        this.newButton = By.xpath("aria-label=\"New\"");

        driver.get(url);


    }




}
