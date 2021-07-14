package ca.elecsoft.pages;

import ca.elecsoft.dynamics.Config;
import ca.elecsoft.dynamics.Prop;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class DartPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public String url;
    public Prop prop;

    public DartPage(WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException {
        this.driver = driver;
        this.wait = wait;
        prop = Config.getInstance().getProp();

//        String workOrder = "(BSH) BSHP-00001423";
//        String techId = "U04012";

        url = prop.loadProp(prop.getDART_URL());
        driver.get(url);

//        driver.findElement(By.id("nom")).sendKeys("jonathan.yu");
//        driver.findElement(By.id("password")).sendKeys("");
//        driver.findElement(By.name("submit")).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dbImpersonateIcon"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inpfld_TechID"))).sendKeys(techId);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnGetTechWorkload"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dbJobListIcon"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("messageDialogOkay"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ workOrder + "']"))).click();
//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Dispatch']"))).click();
//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dispatchButton'"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dl"))).click();
//        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dl"))).isSelected());
//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dispatchJobNextIcon"))).click();
//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bshCrmBtn")));
//        WebElement w = driver.findElement(By.id("bshCrmBtn"));
//
//        String url = w.getAttribute("href");
//        System.out.println(url);
//
//        Thread.sleep(1000);
//
//        WebDriver driver2 = new ChromeDriver();
//
//
//        ((JavascriptExecutor)driver).executeScript("window.open()");
//
//        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1)); //switches to new tab
//        driver.get("https://www.facebook.com");
//        LoginPage lp = new LoginPage(driver, wait, prop.loadProp(prop.getENVIRONMENT_URL()), 10);
//        TechPortalPage tp = new TechPortalPage(driver, wait, url);
//
//        driver.switchTo().window(tabs.get(0));
//
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bshCrmNextIcon"))).click();
//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerWorkOrderNextIcon"))).click();
//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("choosePinNextIcon"))).click();
//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imageCaptureNextIcon"))).click();
//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("activateSummaryNextIcon"))).click();
//
//        driver.findElement(By.id("submit")).click();


    }

    public void login(String name, String password) {


        driver.findElement(By.id("nom")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit"))).click();


    }

    public void impersonateTech(String techId) {
        System.out.println("impersonateTech()");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dbImpersonateIcon"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inpfld_TechID"))).sendKeys(techId);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnGetTechWorkload"))).click();


    }

    public void openJobList() {
        System.out.println("openJobList()");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dbJobListIcon"))).click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("messageDialogOkay"))).click();
        }catch ( Exception e){
            e.printStackTrace();
        }

    }

    public String openToTechPortal() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dl"))).click();
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dl"))).isSelected());
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dispatchJobNextIcon"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bshCrmBtn")));
        WebElement w = driver.findElement(By.id("bshCrmBtn"));
        String url = w.getAttribute("href");
        System.out.println(url);
        return url;

    }

    public void finishDartOrder() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bshCrmNextIcon"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerWorkOrderNextIcon"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("choosePinNextIcon"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imageCaptureNextIcon"))).click();
        Thread.sleep(1000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("activateSummaryNextIcon"))).click();

    }


    public void changeDate(int year, int month, int day) {
//        String javascript = "var d = new Date(" + String.valueOf(year) + "," + String.valueOf(month) + "," + String.valueOf(day) + ");" +
//                "var Date = function(){ return d};" +
//                "console.log('hello')";
//        System.out.println(javascript);

        String lineOne = "var d = new Date(" + String.valueOf(2020) + "," + String.valueOf(7) + "," + String.valueOf(14) + ");  var Date = function(){ return d};";


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(lineOne);


    }

    public void selectWorkOrder(String workOrder) throws InterruptedException {
        System.out.println("selectWorkOrder(" + workOrder + ");");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + workOrder + "']"))).click();
        System.out.println("f(" + workOrder + ");");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Dispatch']"))).click();
        System.out.println("d(" + workOrder + ");");

        Thread.sleep(1000);

    }


}
