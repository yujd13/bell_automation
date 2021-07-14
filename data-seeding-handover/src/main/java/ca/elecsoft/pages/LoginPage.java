package ca.elecsoft.pages;

import ca.elecsoft.dynamics.Config;
import ca.elecsoft.dynamics.Prop;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    int waitAttempts;
    //By
    By emailInput;
    By submitInput;
    By passwordInput;
    //
    Config config;
    Prop prop;

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver, WebDriverWait wait, String url, int waitAttempts) throws InterruptedException {
        this.driver = driver;
        this.wait = wait;
//        config = Config.getInstance();
        prop = Prop.getInstance();

        this.waitAttempts = waitAttempts;

        driver.get(url);

        emailInput = By.id("i0116");
        submitInput = By.id("idSIButton9");
        passwordInput = By.id("i0118");

    }


    public void login(String USER_NAME, String PASSWORD) throws InterruptedException {
        logger.debug("login()");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(emailInput)).sendKeys(USER_NAME);
        wait.until(ExpectedConditions.presenceOfElementLocated(submitInput)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordInput)).sendKeys(PASSWORD);
        wait.until(ExpectedConditions.attributeToBe(submitInput, "value", "Sign in"));
        wait.until(ExpectedConditions.elementToBeClickable(submitInput)).click();
    }

    //hacky
    public void waitUntil(int attempts, String t) throws InterruptedException {
        try {
            t += "\t";
            String button_Text = driver.findElement(submitInput).getAttribute("value");
            if (button_Text.equals("Sign in")) {
                wait.until(ExpectedConditions.presenceOfElementLocated(submitInput)).click();
            } else if (attempts < waitAttempts) {
                Thread.sleep(1000);
                attempts++;
                waitUntil(attempts, t);

            }
        } catch (Exception e) {
            Thread.sleep(1000);
            attempts++;
            if (attempts < waitAttempts) {
                waitUntil(attempts, t);
            }
        } finally {
        }
    }


}
