package ca.elecsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public ProductPage(WebDriver driver, WebDriverWait wait, String url) {
        this.driver = driver;
        this.wait = wait;

        driver.get(url);
    }

    public String getProductCode(){
         return   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Product ID\"]"))).getAttribute("title");
    }





}
