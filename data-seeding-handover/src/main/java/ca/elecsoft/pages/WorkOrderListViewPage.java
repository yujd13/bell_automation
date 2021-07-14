package ca.elecsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkOrderListViewPage {
    public WebDriver driver;
    public WebDriverWait wait;


    public WorkOrderListViewPage(WebDriver driver, WebDriverWait wait, String url) {
        this.driver = driver;
        this.wait = wait;

        driver.get(url);

    }


    public boolean insertIntoSearch(String workOrderNo) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Search this view\"]"))).sendKeys(workOrderNo);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Start search\"]"))).click();
        return true;

    }

    public boolean selectFirstResult(String workOrderNo) throws InterruptedException {
//        driver.findElement(By.linkText(workOrderNo));
        Thread.sleep(3000);
//        System.out.println(driver.findElement(By.xpath("//a[@title=\"" + workOrderNo + "\"]")).getTagName());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title=\"" + workOrderNo + "\"]"))).click();
        return true;
    }



}
