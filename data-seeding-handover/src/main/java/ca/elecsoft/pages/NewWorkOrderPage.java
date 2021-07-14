package ca.elecsoft.pages;

import ca.elecsoft.util.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;

public class NewWorkOrderPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Util util;

    private static final Logger logger = LogManager.getLogger(NewWorkOrderPage.class);

    public By serviceAppointmentID;
    public By dueDateReferenceID;
    public By dueDateRevisionNumberElement;


    public NewWorkOrderPage(WebDriver driver, WebDriverWait wait, String url) {
        this.driver = driver;
        this.wait = wait;
        util = Util.getInstance();
        if (url.length() > 1) {
            driver.get(url);
        }

        serviceAppointmentID = By.xpath("//*[@aria-label=\"Service Appointment ID\"]");
        dueDateReferenceID = By.xpath("//*[@aria-label=\"Due Date Reference ID\"]");
        dueDateRevisionNumberElement = By.xpath("//*[@aria-label=\"Due Date Revision Number\"]");
    }

    public String getSBNWorkOrderNo() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"SBN Work Order #\"]"))).getAttribute("title");
    }

    public String getSBNReturnCode() {

        By xpath = By.xpath("//*[@aria-label=\"SBN Return Code\"]");
        String name = wait.until(ExpectedConditions.presenceOfElementLocated(xpath)).getAttribute("value");
//        System.out.println("code is " + name);
        return name;
    }

    public void fillApointment(HashMap<String, String> map) {
        driver.switchTo().defaultContent();
        WebElement technicianNotes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Notes for Technician']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", technicianNotes);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@aria-label=\"Appointment Reserved\"]"))));
        WebElement select = driver.findElement(By.xpath("//*[@aria-label=\"Appointment Reserved\"]"));
        Select s = new Select(select);
        s.selectByIndex(2);

        String serviceAppointment = map.get("Service Appointment Id:");
        String dueDateRefId = map.get("Appointment Reference Id:");
        String dueDateRevisionNumber = map.get("Due Date Revision Number:");

        System.out.println(serviceAppointment);
        System.out.println(dueDateRefId);

        util.delayDelete(driver, wait, By.xpath("//*[@aria-label=\"Service Appointment ID\"]"));
        util.delayInput(driver, wait, By.xpath("//*[@aria-label=\"Service Appointment ID\"]"), serviceAppointment);

        util.delayDelete(driver, wait, By.xpath("//*[@aria-label=\"Due Date Reference ID\"]"));
        util.delayInput(driver, wait, By.xpath("//*[@aria-label=\"Due Date Reference ID\"]"), dueDateRefId);

        util.delayInput(driver, wait, By.xpath("//*[@aria-label=\"Due Date Revision Number\"]"), dueDateRevisionNumber);
        String date = getDate(map.get("Date:"));
        System.out.println("date is " + date);

        util.delayInput(driver, wait, By.xpath("//*[@aria-label=\"Reserved Appointment Date\"]"), date);

        Select s2 = new Select(driver.findElement(By.xpath("//*[@aria-label=\"Reserved Appointment Interval\"]")));
        String interval = getInterval(map.get("Interval:"));
        System.out.println("interval is " + interval);
        if (interval.equals("AM")) {
            s2.selectByIndex(0);
        } else if (interval.equals("PM")) {
            s2.selectByIndex(1);
        } else if (interval.equals("EV")) {
            s2.selectByIndex(2);
        }


    }

    public void switchSbnIntegration() {
        util.delayClick(driver, wait, By.xpath("//*[@aria-label=\"SBN Integration\"]"));
    }


    public String getSbnSync() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-describedby=\"id-6bfd1f9f-759e-459a-b752-3536e6513d25-69-cgi_sbnsynced6-cgi_sbnsynced.fieldControl-checkbox-inner-second\"]"))).getAttribute("title");
    }

    public String getWorkOrderDeepLink() {
        return util.getFieldValue(wait, By.xpath("//*[@aria-label=\"Worker Order Deeplink GUID (String)\"]"), "value");
    }

    public String getWorkOrderNumber() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-id=\"header_title\"]"))).getAttribute("title");
    }

    public void fillAppointment(HashMap<String, String> map) {
        logger.info(driver.getCurrentUrl());

        WebElement appointmentReserved = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Appointment Reserved\"]")));
        WebElement select = appointmentReserved;
        Select s = new Select(select);
        s.selectByIndex(2);


        String serviceAppointment = map.get("Service Appointment Id:");
        String dueDateRefId = map.get("Appointment Reference Id:");
        String dueDateRevisionNumber = map.get("Due Date Revision Number:");
        String date = getDate(map.get("Date:"));


        util.delayInput(driver, wait, serviceAppointmentID, serviceAppointment);
        util.delayInput(driver, wait, dueDateReferenceID, dueDateRefId);
        util.delayInput(driver, wait, dueDateRevisionNumberElement, dueDateRevisionNumber);


        util.delayInput(driver, wait, By.xpath("//*[@aria-label=\"Reserved Appointment Date\"]"), date);

        Select s2 = new Select(driver.findElement(By.xpath("//*[@aria-label=\"Reserved Appointment Interval\"]")));
        String interval = getInterval(map.get("Interval:"));
        selectInterval(s2, interval);


    }

    public void selectInterval(Select s2, String interval) {
        if (interval.equals("AM")) {
            s2.selectByIndex(1);
        } else if (interval.equals("PM")) {
            s2.selectByIndex(2);
        } else if (interval.equals("EV")) {
            s2.selectByIndex(3);
        }
    }

    public void clickSchedule() throws IOException {
        util.delayClick(driver, wait, By.xpath("//button[@aria-label='Schedule']"));
    }

    public void clickBook() {
        util.delayClick(driver, wait, By.xpath("//*[@id='confirmButton']"));

    }

    public String getInterval(String date) {
        String[] split = date.split(" ");
        for (int i = 0; i < split.length; i++) {
            return split[2];
        }
        return "NA";
    }

    public String getDate(String date) {
        //expected format 8/12/2020 mm/dd/yyyy
        //input formt 1997-11-11// yyyy-mm-dd
        String[] split = date.split("-");
        String output = split[1] + "/" + split[2] + "/" + split[0];
        return output;
    }

}
