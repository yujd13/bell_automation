package ca.elecsoft.pages;

import ca.elecsoft.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TechPortalPageBackup {
    public WebDriver driver;
    public WebDriverWait wait;
    public Util util;
    public String url = "https://apps.powerapps.com/play/73e96231-ba7f-411d-aff9-3107211b0c43?tenantId=b23a76c8-e223-4699-b401-91aab947e94b&WorkOrderID=";
    public String deeplink = "";

    public TechPortalPageBackup(WebDriver driver, WebDriverWait wait, String deeplink) throws IOException, InterruptedException {

        this.driver = driver;
        this.wait = wait;
        this.deeplink = deeplink;
//        driver.get(url + deeplink);
        driver.get(deeplink);
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        List<WebElement> list = driver.findElements(By.xpath("//iframe"));
        for (WebElement x : list) {
            System.out.println(x.getAttribute("id"));
        }


//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("fullscreen-app-host")));
        driver.switchTo().frame("fullscreen-app-host");

        Thread.sleep(8000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Customer name']")));
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Thread.sleep(5000);


        util.delayClick(driver, wait, By.xpath("//*[text()='Skip test-mode']"));
        Thread.sleep(1000);
        util.delayClick(driver, wait, By.xpath("//*[text()='Skip test-mode']"));
//        d.delayClick(By.xpath("//*[text()='Yes']"));

        Thread.sleep(1000);

//        List<WebElement> plustList = driver.findElements(By.xpath("//*[text()='+']"));
        WebElement elements = driver.findElement(By.xpath("//*[@tabindex='49']"));
        elements.click();

        Thread.sleep(3000);

        List<WebElement> plustList = driver.findElements(By.xpath("//*[text()='+']/parent::*/parent::*"));
        System.out.println(plustList.size());
        Queue<String> buttonList = new LinkedList();

        for (WebElement x : plustList) {
            System.out.println(x.getAttribute("tabindex") + " | " + x.getTagName());

            String t = driver.findElement(By.xpath("//*[@tabindex='" + x.getAttribute("tabindex") + "']")).getAttribute("disabled");
            System.out.println(t);

            if (t != null) {
                if (driver.findElement(By.xpath("//*[@tabindex='" + x.getAttribute("tabindex") + "']")).getAttribute("disabled").equals("true")) {
                    continue;
                }
            }

            buttonList.add(x.getAttribute("tabindex"));

//
//            driver.findElement(By.xpath("//*[@tabindex='" + x.getAttribute("tabindex") + "']")).click();
//            Thread.sleep(1000);
//            WebElement element2 = driver.findElement(By.xpath("//*[@tabindex='" + "127" + "']"));
//            element2.click();
//
//            Thread.sleep(1000);
//            WebElement element3 = driver.findElement(By.xpath("//*[@tabindex='" + "128" + "']"));
//            element3.click();


        }

        while (!buttonList.isEmpty()) {
            String tabIndex = buttonList.poll();

            String t = driver.findElement(By.xpath("//*[@tabindex='" + tabIndex + "']")).getAttribute("disabled");
            System.out.println(t);

            if (t != null) {
                if (driver.findElement(By.xpath("//*[@tabindex='" + tabIndex + "']")).getAttribute("disabled").equals("true")) {
                    continue;
                }
            }

            try {
                WebElement element = driver.findElement(By.xpath("//*[@tabindex='" + tabIndex + "']"));
                element.click();


                WebElement element2 = driver.findElement(By.xpath("//*[@tabindex='" + "127" + "']"));
                element2.click();

                WebElement element3 = driver.findElement(By.xpath("//*[@tabindex='" + "128" + "']"));
                element3.click();

                WebElement scroll = driver.findElement(By.xpath("//*"));
                scroll.sendKeys(Keys.DOWN);
                scroll.sendKeys(Keys.DOWN);
                scroll.sendKeys(Keys.DOWN);
                scroll.sendKeys(Keys.DOWN);


            } catch (Exception e) {

            }


            Thread.sleep(1000);
        }

        WebElement element4 = driver.findElement(By.xpath("//*[@tabindex='" + "129" + "']"));
        element4.click();

//        for (WebElement x : elements) {
//            try {
//                System.out.println(x.getAttribute("tabindex"));
//                x.click();
//
//            } catch (Exception e) {
//
//            }
//        }


//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//
//        }
//
//        List<WebElement> elements = driver.findElements(By.xpath("//button"));
//        for (WebElement x : elements) {
//            try {
////                System.out.println(x.getAttribute("tabindex"));
//                x.click();
//
//            } catch (Exception e) {
//
//            }
//        }
//
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//
//        }
//
//        List<WebElement> productLineItems = driver.findElements(By.xpath("//*[@data-control-part=\"gallery-item\"]"));
//
////        List<WebElement> lineButtons = driver.findElements(By.xpath("//*[@class=\"appmagic-button middle center\"]//div[contains(string(), \"+\")] "));
//        List<WebElement> lineButtons = driver.findElements(By.xpath("//button[@class=\"appmagic-button-container no-focus-outline\"]"));
//        System.out.println(lineButtons.size());
//        Queue<String> stack = new LinkedList<>();
//
//        for (WebElement x : lineButtons) {
//            String isDisabled = x.getAttribute("disabled");
//            if (isDisabled == null) {
////                System.out.println(x.findElement(By.xpath("//child::div[1]/child::div[1]")).getText());
//                String button = x.findElement(By.xpath("//*[text()='+']")).getText();
//                System.out.println(button + " = " + "+");
//                if(button.equals("+")){
//                    stack.add(x.getAttribute("tabindex"));
//                }
//
//            } else {
//            }
//        }
//        System.out.println("end");
////        for (WebElement x : lineButtons) {
//////            stack.push(x);
////            String value = x.getAttribute("tabindex");
////            driver.findElement(By.xpath("//*[@tabindex='" + value + "']"));
////            x.click();
////            Thread.sleep(1000);
////            Logger loat = new Logger();
////            loat.Logger(driver.getPageSource(), new File("./fill.html"));
////            List<WebElement> box = driver.findElements(By.xpath("//*[@class=\"appmagic-button middle center\"]"));
////            for (WebElement a : box) {
////                try {
////                    a.click();
////                    System.out.println(a.getAttribute("tabindex"));
////                } catch (Exception e) {
////
////                }
////            }
//////            driver.findElement(By.xpath("//*[@data-control-name=\"17. Icon - Close Adjust Quantity\"]")).click();
////
//////            d.delayClick(By.xpath("//*[text()='+']"));
//////            d.delayClick(By.xpath("//*[text()='adjust']"));
////        }
//        System.out.println("stack size is " + stack.size());
//        System.out.println("***Start***");
//        System.out.println(stack);
//        System.out.println("***End***");
//        while (!stack.isEmpty()) {
//            System.out.println("**Running**");
//            String e = stack.poll();
//            if(e.equals("205") || e.equals("51")|| e.equals("204") ){
//                continue;
//            }
//            System.out.println(e);
//
//
//
//
//            WebElement fill = driver.findElement(By.xpath("//button[@tabindex=\"" + e + "\"]/child::div[1]/child::div[1]"));
//            System.out.println(fill.getAttribute("class"));
//
//            Actions actions = new Actions(driver);
//
//            actions.moveToElement(fill).click().perform();
//
////            fill.click();
//
//            Thread.sleep(300);
//
//            WebElement de = driver.findElement(By.xpath("//button[@tabindex=\"203\"]/child::div[1]/child::div[1]"));
//
//            actions = new Actions(driver);
//
//            actions.moveToElement(de).click().perform();
////            de.click();
//
//            Thread.sleep(300);
//
//
//            WebElement adjust = driver.findElement(By.xpath("//*[text()='Adjust']"));
//            actions = new Actions(driver);
//            actions.moveToElement(adjust).click().perform();
////            adjust.click();
//
////            driver.switchTo().defaultContent();
////            WebElement scroll = driver.findElement(By.xpath("//*"));
////            scroll.sendKeys(Keys.DOWN);
////            scroll.sendKeys(Keys.DOWN);
////            scroll.sendKeys(Keys.DOWN);
////            scroll.sendKeys(Keys.DOWN);
//
//
//
//
//            Thread.sleep(1000);
//
////            List<WebElement> box = driver.findElements(By.xpath("//*[@class=\"appmagic-button middle center\"]"));
////            for (WebElement x : box) {
////                x.click();
////            }
//            System.out.println("**Ending**");
//
//        }
//
//        WebElement fill = driver.findElement(By.xpath("//button[@tabindex=\"" + "205" + "\"]/child::div[1]/child::div[1]"));
//        fill.click();


//        Stack<String> stack = new Stack<>();
//        System.out.println("***********big*********");
//        for (WebElement x : productLineItems) {
//            List<WebElement> a = x.findElements(By.xpath("//descendant::button"));
//
//            System.out.println("**mini**");
//            for (WebElement s : a) {
//                System.out.println(s.getAttribute("tabindex"));
//                stack.push(s.getAttribute("tabindex"));
//            }
//            System.out.println("**end**");
//            break;
//        }
//        System.out.println("***********big*********");
////110 is adjust 165, 200, 203
//        System.out.println("****Stack Start*****");
//        while (!stack.isEmpty()) {
//            String x = stack.pop();
//            if (x.equals("205")) {
//                continue;
//            }
//            try {
//                driver.findElement(By.xpath("//*[@tabindex='" + x + "']")).click();//                driver.findElement(By.xpath("//*[@data-control-name=\"17. Icon - Close Adjust Quantity\"]")).click();
//                Thread.sleep(500);
//                System.out.println(x);
//
//            } catch (Exception e) {
//
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//        System.out.println("****Stack End*****");


//        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
//        List<String> success = new ArrayList<>();
//        for(WebElement x: buttons){
//            try {
//                x.click();
//                System.out.println(x.getAttribute("tabindex"));
//                success.add(x.getAttribute("tabindex"));
//            }catch (Exception e){
//            }
//        }

//        System.out.println("**Start**");
//        for(String x: success){
//            System.out.println(x);
//        }
//        System.out.println("**End**");


//        d.delayClick(By.xpath("//button[@tabindex='46']"));

//
//        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
//        for(WebElement e: inputs){
//            System.out.println(e.getAttribute("appmagic-control"));
//            System.out.println(e.getAttribute("tabindex"));
//        }
//
//        Faker f = new Faker();
//
//        d.delayInput(By.xpath("//*[@tabindex='33']"),         f.phoneNumber());
//        d.delayInput(By.xpath("//*[@tabindex='35']"), "Front Door");


    }
}
