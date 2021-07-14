package ca.elecsoft.pages;

import ca.elecsoft.util.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppsPage {
    private WebDriverWait wait;
    int waitAttempts;
    int attemps;

    By bellSmartHomeApp;
    By iframe;

    private static final Logger logger = LogManager.getLogger(AppsPage.class);


    public AppsPage(WebDriver driver, WebDriverWait wait, String url, int waitAttempts) {
        this.wait = wait;
        this.waitAttempts = waitAttempts;

        bellSmartHomeApp = By.id("AppDetailsSec_1_Item_1");
        iframe = By.id("AppLandingPage");

        driver.get(url);
    }

    public void openBellSmartHomeApp() {
        logger.debug("openBellSmartHomeApp");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        wait.until(ExpectedConditions.presenceOfElementLocated(bellSmartHomeApp)).click();

    }


}
