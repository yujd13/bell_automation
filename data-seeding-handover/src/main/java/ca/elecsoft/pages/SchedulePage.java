package ca.elecsoft.pages;

import ca.elecsoft.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class SchedulePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Util util;

    public SchedulePage(WebDriver driver, WebDriverWait wait) throws IOException {
        this.driver = driver;
        this.wait = wait;
        util = Util.getInstance();


    }

    public Boolean scheduleFirstAvailableDate() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FullPageWebResource")));
        driver.switchTo().frame(driver.findElement(By.id("FullPageWebResource")));

        Thread.sleep(10000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@style=\"color: rgb(0, 100, 0);\"]/descendant::input")));

        List<WebElement> elementList = driver.findElements(By.xpath("//td[@style=\"color: rgb(0, 100, 0);\"]/descendant::input"));

        System.out.println(driver.getPageSource());
        System.out.println(elementList);
        if(elementList.size() > 0){
            elementList.get(0).click();
            util.delayClick(driver, wait, By.id("butBegin"));
            driver.switchTo().defaultContent();
            util.delayClick(driver, wait, By.id("okButton"));
            return true;
        }

        return false;

//                util.delayClick(driver, wait, By.xpath("descendant::input[" + day + "]"));



    }


    public void scheduleDate(String day) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FullPageWebResource")));
        driver.switchTo().frame(driver.findElement(By.id("FullPageWebResource")));
        util.delayClick(driver, wait, By.xpath("descendant::input[" + day + "]"));
        util.delayClick(driver, wait, By.id("butBegin"));
        driver.switchTo().defaultContent();
        util.delayClick(driver, wait, By.id("okButton"));
    }


    public String getDeepLink() throws IOException {
        util.delayClick(driver, wait, By.xpath("//*[@aria-label=\"SBN Integration\"]"));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label=\"Worker Order Deeplink GUID (String)\"]"))).getAttribute("title");
    }
}
