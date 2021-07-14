package ca.elecsoft.dynamics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Config {

    private static Config INSTANCE = null;

    public WebDriver driver;

    public Prop getProp() {
        return prop;
    }

    public WebDriverWait defaultWait;
    public int waitTime;
    public Prop prop;



    private Config() {
        prop = Prop.getInstance();
        waitTime = Integer.valueOf(prop.loadProp(prop.getDEFAULT_WAIT_TIME()));
        System.setProperty(prop.loadProp(prop.getBROSWER()), prop.loadProp(prop.getWEB_DRIVER_PATH()));
        driver = new ChromeDriver();
        defaultWait = new WebDriverWait(driver, waitTime);
    }

    public static Config getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Config();
        return INSTANCE;
    }



    public int getWaitTime() {
        return waitTime;
    }

    public WebDriverWait getDefaultWait() {
        return defaultWait;
    }

    public WebDriver getDriver() {
        SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
        if(sessionid == null){
            driver = new ChromeDriver();
            defaultWait = new WebDriverWait(driver, waitTime);
        }
        return driver;
    }

}
