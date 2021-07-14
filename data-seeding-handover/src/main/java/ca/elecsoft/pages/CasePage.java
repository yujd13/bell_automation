package ca.elecsoft.pages;

import ca.elecsoft.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CasePage {
    WebDriver driver;
    WebDriverWait wait;
    String url;

    By caseType = By.xpath("//*[@aria-label=\"Case Type\"]");
    By caseSubType = By.xpath("//*[@aria-label=\"Case Subtype\"]");
    By caseDetailsTab = By.xpath("//*[@aria-label=\"Case Details\"]");

    public CasePage(WebDriver driver, WebDriverWait wait, String url) throws InterruptedException {
        this.wait = wait;
        this.driver = driver;
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(caseSubType));
    }

    public String getProcess() {
        String[] split = driver.findElement(By.xpath("//*[@data-control-name=\"cgi_process\"]")).getText().split("\n");
        return split[split.length - 1];
    }

    public void clickCase() {
        driver.findElement(By.xpath("//*[@title=\"Case\"]")).click();
    }

    public void readyForNextStage() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@aria-label=\"No\" and @tabindex='0']")).click();

    }

    public void selectGeneratedOpportunity() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Select Opportunity' or text()='Select Sales Order' ]/../following-sibling::div/li"))).click();
        Thread.sleep(2000);


    }


    public void switchToCaseDetails() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(caseDetailsTab)).click();
//        driver.findElement(caseDetailsTab).click();
        Thread.sleep(3000);
    }

    public void selectServiceLocation() throws InterruptedException {
        Util util = Util.getInstance();
        util.inputGeneralLookUp(driver, wait, By.xpath("//input[@aria-label=\"Service Location, Lookup\"]"), "*");

    }


    public void selectCaseType(String caseString) throws InterruptedException {
        Select select = new Select(driver.findElement(caseType));
        select.selectByVisibleText(caseString);
        Thread.sleep(3000);
    }

    public void selectCaseSubType(String subtype) throws InterruptedException {
        Select select = new Select(driver.findElement(caseSubType));
        select.selectByVisibleText(subtype);
        Thread.sleep(3000);

    }

    public void clickNextStage() {
        driver.findElement(By.xpath("//*[@aria-label=\"Next Stage\"]")).click();
    }
}
