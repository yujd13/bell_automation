package ca.elecsoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadViewPage {


    public LeadViewPage(WebDriver driver, WebDriverWait wait, String url) {
        driver.get(url);

    }


}
