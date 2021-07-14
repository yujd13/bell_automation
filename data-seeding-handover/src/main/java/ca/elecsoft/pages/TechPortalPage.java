package ca.elecsoft.pages;

import ca.elecsoft.model.Product;
import ca.elecsoft.util.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TechPortalPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Util util;
    public String url = "https://apps.powerapps.com/play/73e96231-ba7f-411d-aff9-3107211b0c43?tenantId=b23a76c8-e223-4699-b401-91aab947e94b&WorkOrderID=";
    public String deeplink = "";

    private static final Logger logger = LogManager.getLogger(TechPortalPage.class);


    public HashMap<String, Product> productMap;

    public TechPortalPage(WebDriver driver, WebDriverWait wait, String url) {
        this.driver = driver;
        this.wait = wait;
        util = Util.getInstance();
        this.url = url;

        driver.get(url);
        productMap = new HashMap<>();
    }

    public void switchToIFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("fullscreen-app-host")));
    }

    public void switchToAddress() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-shortcut-id=\"111\"]"))).click();
    }

    public List<WebElement> getInstallList() {
        List<WebElement> elementList = driver.findElements(By.xpath("//button/div"));
        List<WebElement> filteredList = new ArrayList<>();
        for (WebElement e : elementList) {
            System.out.println(e.getText());
            if (e.getText().equals("Install")) {
                filteredList.add(e);
            }
        }
        return filteredList;
    }

    public void clickAllInstall() throws InterruptedException {
        List<WebElement> elementList = getInstallList();
        while (elementList.size() > 0) {
            WebElement element = elementList.get(0);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
            Thread.sleep(3000);
            try {
                driver.findElement(By.xpath("//*[@appmagic-control=\"51. Label - Serial Number Valuetextbox\"]")).sendKeys("0123456789");
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[text()='Add product to work order']/ancestor::button")).click();
            } catch (Exception e) {

            }

            elementList = getInstallList();
        }
    }

    public boolean isPanelLocationEmpty() {

        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@appmagic-control=\"4. Label - Panel Location Valuetextbox\"]"))).getText());

        if (driver.findElement(By.xpath("//*[@appmagic-control=\"4. Label - Panel Location Valuetextbox\"]")).getText().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isTestModeActivated() {

        String text = "Test mode activated";

        try {
            System.out.println(driver.findElement(By.xpath("//*[text()='" + text + "']")).getText());
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    public boolean isPanelPhoneNoEmpty() {
        System.out.println("isPanel()");
        String type = "//*[@appmagic-control=\"4. Text input - Panel Phone Number Value\"]";
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(type))).getText());
        if (driver.findElement(By.xpath(type)).getText().length() > 0) {
            return false;
        } else {
            return true;
        }

    }


    public void clickSave() {
        util.delayClick(driver, wait, By.xpath("//*[@tabindex=\"360\"]"));


    }


    public void enableTestMode() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Enable test-mode']/ancestor::button"))).click();

//        WebElement drive = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-control-name=\"4. Button - Enable Test-Mode, Yes\"]")));

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-control-name=\"4. Button - Enable Test-Mode, Yes\"]/descendant:button"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@tabindex=\"90\"]"))).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-control-name=\"4. Button
//        - Enable Test-Mode, Yes\"]/descendant:button"))).click();
    }


    public void productContinue() {
        util.delayClick(driver, wait, By.xpath("//*[@data-control-name=\"50. Button - Continue Product\"]/descendant::button"));

    }

    public void clickContinueAfterTestMode() throws InterruptedException {
        while (!findingStep3()) {
            System.out.println("clickingContinue()");
            try {
                util.delayClick(driver, wait, By.xpath("//*[@data-control-name=\"4. Button - Skip-Test Mode/Continue\"]/descendant::button"));

            } catch (Exception e) {

            }
            Thread.sleep(1000);

        }


    }

    public void clickContinue() {
//        try {
//            util.delayClick(driver, wait, By.xpath("//*[@data-control-name=\"3A. Button - Continue\"]/descendant::button"));
//
//        } catch (Exception e) {
//
//        }
        while (!findingTestSpecification()) {
            System.out.println("clickingContinue()");
            try {
                util.delayClick(driver, wait, By.xpath("//*[@data-control-name=\"3A. Button - Continue\"]/descendant::button"));

            } catch (Exception e) {

            }
        }
    }

    public boolean findingTestSpecification() {
        try {
            System.out.println(driver.findElement(By.xpath("//*[text()='TEST DETAILS']")).getText());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean findingStep3() {
        try {
            System.out.println(driver.findElement(By.xpath("//*[text()='Bundle products']")).getText());
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    public void skipTestMode() throws InterruptedException {
        util.delayClick(driver, wait, By.xpath("//*[text()='Skip test-mode']"));
        Thread.sleep(2000);
//        util.delayClick(driver, wait, By.xpath("//*[text()='Yes']"));
        util.delayClick(driver, wait, By.xpath("//*[@tabindex=\"45\"]"));
    }


    public void inputPanelPhoneNo(String phoneNo) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@appmagic-control=\"4. Text input - Panel Phone Number Valuetextbox\"]"))).sendKeys(phoneNo);

    }

    public void goToAddtionalProductTabl() {
        util.delayClick(driver, wait, By.xpath("//*[text()='Additional']"));
    }


    public void cancelTestMode() {
        util.delayClick(driver, wait, By.xpath("//*[@data-control-name=\"15. Button - Disable Test Mode\"]/descendant::button"));
        util.delayClick(driver, wait, By.xpath("//*[@data-control-name=\"15. Button - Cancel Test-Mode, Yes\"]/descendant::button"));
    }


    public void inputPanelLocation(String panelLocation) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@appmagic-control=\"4. Label - Panel Location Valuetextbox\"]"))).sendKeys(panelLocation);
    }

    public void confirmAll() {
        List<WebElement> confirmButtonList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='Confirm']/ancestor::button")));
        for (WebElement confirmButton : confirmButtonList) {
            confirmButton.click();
        }
    }


    public void confirmSerialProductTabindex(String tabindex, int count) throws InterruptedException {
        System.out.println("confirmSerialProductTabindex()");
        WebElement x = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@tabindex='" + tabindex + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);
        Thread.sleep(1000);
        x.click();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@tabindex=\"14\"]"))).sendKeys("QS9208-5208-124");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@tabindex=\"14\"]"))).sendKeys("QS9208-5208-124");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@tabindex=\"216\"]"))).sendKeys("12345678");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@appmagic-control=\"7. Label - Serial Number Valuetextbox\"]"))).sendKeys("12345678");
        System.out.println("findinglist Elements");
        List<WebElement> elementList = driver.findElements(By.xpath("descendant::input"));
        System.out.println(elementList.size());
        System.out.println("**********");
        for (WebElement e : elementList) {
            try {
                e.sendKeys("12345678");
                System.out.println(e.getAttribute("appmagic-control"));
            } catch (Exception exp) {
            } finally {

            }

        }
        System.out.println("**********");


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@appmagic-control=\"7. Label - Serial Number Valuetextbox\"]"))).sendKeys("12345678");
        Thread.sleep(1000);


//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@appmagic-control=\"7. Label - Serial Number Valuetextbox\"]"))).sendKeys("1234");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Add product to work order']/ancestor::button"))).click();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Adjust']"))).click();


    }

    public void confirmProductTabindex(String tabindex, int count, String xpath) throws InterruptedException {
//        if (count == 0) return;
        System.out.println("confirmProductTabIndex(" + tabindex + " , " + count + " )");
        logger.debug("confirmProductTabIndex(" + tabindex + " , " + count + " )");
        WebElement x = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@tabindex='" + tabindex + "']")));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);
        Thread.sleep(1000);
        x.click();

        for (int i = 0; i < count + 1; i++) {
//            WebElement plusButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@tabindex=\"187\"]")));
            WebElement plusButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", plusButton);

            System.out.println(plusButton.getAttribute("tabindex"));
//            plusButton.click();
            Thread.sleep(3000);
        }


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-control-name=\"18. Button - Save Adjustment\"]/descendant::button"))).click();


    }

    public void confirmProductTabindex(String tabindex, int count) throws InterruptedException {
//        if (count == 0) return;
        System.out.println("confirmProductTabIndex(" + tabindex + " , " + count + " )");
        logger.debug("confirmProductTabIndex(" + tabindex + " , " + count + " )");
        WebElement x = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@tabindex='" + tabindex + "']")));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);
        Thread.sleep(1000);
        x.click();

        for (int i = 0; i < count + 1; i++) {
//            WebElement plusButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@tabindex=\"187\"]")));
            WebElement plusButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-control-name=\"17. Button - Increase Quantity\"]/descendant::button")));

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", plusButton);

            System.out.println(plusButton.getAttribute("tabindex"));
//            plusButton.click();
            Thread.sleep(3000);
        }


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Adjust']"))).click();


    }

    public String getTabIndex(String productCode) throws InterruptedException {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"virtualized-gallery-item galleryCanvasContentDiv transforms_3hmsj\"]")));  // driver.findElements();
        WebElement parent = driver.findElement(By.xpath("//*[text()='" + productCode + "']/ancestor::*[@class=\"virtualized-gallery-item galleryCanvasContentDiv transforms_3hmsj\"]"));
        List<WebElement> buttonList = parent.findElements(By.xpath("descendant::button"));
        for (WebElement x : buttonList) {
            int index = Integer.valueOf(x.getAttribute("tabindex"));
            if (index > 0) {
                String tabIndex = x.getAttribute("tabindex");
                String isDisabled = x.getAttribute("disabled");
                WebElement list = x.findElement(By.xpath("descendant::div[@class=\"appmagic-button-label no-focus-outline\"]"));


                if (isDisabled == null && !list.getText().equals("Substitute")) {
                    return tabIndex;
                }
            }
        }
        return null;
    }

    public void insertProducts(HashMap<String, Product> map) throws InterruptedException {
        for (Map.Entry<String, Product> x : map.entrySet()) {
            if (x.getKey().equals("Qolsys IQ2 Panel - PowerG + 345 (ATT SIM)") || x.getKey().equals("Indoor/Outdoor Video Camera (Dome)") || x.getKey().equals("D-Link WI-FI Range Extender")) {

                continue;
            }

            logger.debug("confirmProduct(" + x.getValue().getTabindex() + ")");
            confirmProductTabindex(x.getValue().getTabindex(), Integer.valueOf(x.getValue().getQuantity()));

        }
    }


    public void confirmProduct(String productName) throws InterruptedException {
        logger.debug("confirmProduct(" + productName + ", " + productMap.get(productName).getQuantity() + ") ");
        if (productMap.containsKey(productName)) {
            confirmProductTabindex(productMap.get(productName).getTabindex(), Integer.valueOf(productMap.get(productName).getQuantity()));

        }
    }

    public void confirmSerialProduct(String productName) throws InterruptedException {
        if (productMap.containsKey(productName)) {
            confirmSerialProductTabindex(productMap.get(productName).getTabindex(), Integer.valueOf(productMap.get(productName).getQuantity()));

        }

    }

    public void pressContinue() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@tabindex=\"93\"]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-control-name=\"4. Button - Skip-Test Mode/Continue\"]/descendant::button"))).click();

    }


    public void confirmAllProductsHl() throws InterruptedException {
        List<Product> productList = scrollDown();
        while (productList.size() > 0) {
            System.out.println("Product is " + productList.size());
            System.out.println(productList.get(0).getProduct() + " | " + productList.get(0).getSerial());
            if (!productList.get(0).getSerial()) {
                System.out.println("confirmProduct");
                confirmProductTabindex(productList.get(0).getTabindex(),
                        Integer.valueOf(productList.get(0).getQuantity()) - Integer.valueOf(productList.get(0).getUsed()));
            } else {
                System.out.println("confirmSerial");

                confirmSerialProductTabindex(productList.get(0).getTabindex(),
                        Integer.valueOf(productList.get(0).getQuantity()) - Integer.valueOf(productList.get(0).getUsed()));
            }
            Thread.sleep(8000);
            productList = scrollDown();

        }


    }

    public void confirmAllNonSerialProducts(List<Product> products) throws InterruptedException {
//        while (products.size() > 0) {
//            System.out.println(products);
        for (Product p : products) {
            int quantity = Integer.valueOf(p.getQuantity()) - Integer.valueOf(p.getUsed());
            System.out.println(p);
            if (!p.getSerial()) {
                confirmProductTabindex(p.getTabindex(), quantity);
            }

            Thread.sleep(8000);

        }
//            products = scrollDown();
//        }

    }

    public void closeWorkOrder() {
        util.delayClick(driver, wait, By.xpath("//*[@tabindex='365']"));

    }

    public List<Product> getAllAdditonalProducts() {

        List<WebElement> elementsText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]" +
                "/descendant::*[@data-control-name=\"18. Label - Product Value, Additional Products\"]" +
                "/descendant::*[@class=\"appmagic-label-text\"]")));  // driver.findElements();
        List<WebElement> quantiyText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]" +
                "/descendant::*[@data-control-name=\"18. Label - Quantity, Estimated Value, Additional Products\"]" +
                "/descendant::*[@class=\"appmagic-label-text\"]")));
        List<WebElement> usedText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]" +
                "/descendant::*[@data-control-name=\"18. Label - Quantity, Picked Value, Additional Products\"]" +
                "/descendant::*[@class=\"appmagic-label-text\"]")));
        List<WebElement> buttonText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]" +
                "/descendant::*[@data-control-name=\"18. Button - Pick, Additional Products\"]" +
                "/descendant::button")));
  /*
        List<WebElement> serialProducts = driver.findElements(By.xpath("//div[@class=\"appmagic-label-text\" and text()='Yes']" +
                "/ancestor::*[@data-control-name=\"17. Label - Serialized Value, Bundle Products\"]" +
                "/preceding-sibling::*[@data-control-name=\"17. Label - Product Value, Bundle Products\"]"));
        //"/descendant::*[@class=\"appmagic-label-text\"]"));
*/

//        System.out.println(driver.getPageSource());
        List<WebElement> serialProducts = driver.findElements(By.xpath("//div[@data-control-name=\"17. Image - Serialized, Bundle Products\"]"));
//        System.out.println(serialProducts.size());

        List<Product> productList = new ArrayList<>();
//        System.out.println("*****ProductList******");
        for (int i = 0; i < elementsText.size(); i++) {

            String productName = elementsText.get(i).getText();
            String quantity = quantiyText.get(i).getText();
            String used = usedText.get(i).getText();
            String tabIndex = buttonText.get(i).getAttribute("tabindex");
            String isSerializedString = serialProducts.get(i).getAttribute("style");
            Boolean isSerializedBoolean = false;
            if (isSerializedString.equals("width: 30px; height: 30px; z-index: 18; position: absolute; top: 16px; left: 531px;")) {
                isSerializedBoolean = true;
            }

            System.out.println(productName + " " + quantity + " " + used + " " + tabIndex + " " + isSerializedBoolean);

            Product product = new Product(productName, quantity, used, tabIndex);
            product.setSerial(isSerializedBoolean);
            product.setProductIndex(i);


            if (!quantity.trim().equals(used.trim())) {
                productList.add(product);
            }
        }


        return productList;

    }

    public void confirmAllAdditionalProducts() throws InterruptedException {
        List<Product> listProduct = getAllAdditonalProducts();
        int usedCount = listProduct.size();
        while (usedCount > 0) {
            try {
                listProduct = getAllAdditonalProducts();
                usedCount = listProduct.size();
                Product product = listProduct.get(0);
                System.out.println(product.getProduct() + " " + product.getSerial());
                if (product.getSerial()) {
                    System.out.println("confirmSerial");
                    int count = Integer.parseInt(product.getQuantity()) - Integer.valueOf(product.getUsed());
                    confirmSerialProductTabindex(product.getTabindex(), count);

                } else {
                    System.out.println("confirmNormal");

                    int count = Integer.valueOf(product.getQuantity()) - Integer.valueOf(product.getUsed());
                    confirmProductTabindex(product.getTabindex(), count, "//*[@data-control-name=\"18. Button - Increase Quantity\"]/descendant::button");
                }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
//                System.out.println("size is " + usedCount);
                Thread.sleep(3000);
            }

        }
    }

    public void confirmAllProducts() throws InterruptedException {
        List<Product> listProduct = scrollDown();
        int usedCount = listProduct.size();
        while (usedCount > 0) {
            try {
                listProduct = scrollDown();
                usedCount = listProduct.size();
                Product product = listProduct.get(0);
                System.out.println(product.getProduct() + " " + product.getSerial());
                if (product.getSerial()) {
                    System.out.println("confirmSerial");
                    int count = Integer.parseInt(product.getQuantity()) - Integer.valueOf(product.getUsed());
                    confirmSerialProductTabindex(product.getTabindex(), count);

                } else {
                    System.out.println("confirmNormal");

                    int count = Integer.valueOf(product.getQuantity()) - Integer.valueOf(product.getUsed());
                    confirmProductTabindex(product.getTabindex(), count);
                }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("size is " + usedCount);
                Thread.sleep(3000);
            }

        }


    }


    public List<Product> mysteryFunction() throws InterruptedException {
        List<WebElement> elementsText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]" +
                "/descendant::*[@data-control-name=\"17. Label - Product Value, Bundle Products\"]" +
                "/descendant::*[@class=\"appmagic-label-text\"]")));  // driver.findElements();
        List<WebElement> quantiyText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]" +
                "/descendant::*[@data-control-name=\"17. Label - Quantity, Estimated Value, Bundle Products\"]" +
                "/descendant::*[@class=\"appmagic-label-text\"]")));
        List<WebElement> usedText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]" +
                "/descendant::*[@data-control-name=\"17. Label - Quantity, Picked Value, Bundle Products\"]" +
                "/descendant::*[@class=\"appmagic-label-text\"]")));
        List<WebElement> buttonText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]" +
                "/descendant::*[@data-control-name=\"17. Button - Pick, Bundle Products\"]" +
                "/descendant::button")));


        List<WebElement> serialProducts = driver.findElements(By.xpath("//div[@data-control-name=\"17. Image - Serialized, Bundle Products\"]"));
        List<Product> productList = new ArrayList<>();

        for (int i = 0; i < elementsText.size(); i++) {

            String quantity = quantiyText.get(i).getText();
            String used = usedText.get(i).getText();
            if (!quantity.trim().equals(used.trim())) {
                String productName = elementsText.get(i).getText();
                String tabIndex = buttonText.get(i).getAttribute("tabindex");
                String isSerializedString = serialProducts.get(i).getAttribute("style");
                Boolean isSerializedBoolean = false;
                if (isSerializedString.equals("width: 30px; height: 30px; z-index: 18; position: absolute; top: 16px; left: 531px;")) {
                    isSerializedBoolean = true;
                }
                Product product = new Product(productName, quantity, used, tabIndex);
                product.setSerial(isSerializedBoolean);
                product.setProductIndex(i);
                productList.add(product);
            }

        }
        return productList;

    }


    public List<Product> scrollDown() throws InterruptedException {
        List<WebElement> elementsText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]" +
                "/descendant::*[@data-control-name=\"17. Label - Product Value, Bundle Products\"]" +
                "/descendant::*[@class=\"appmagic-label-text\"]")));  // driver.findElements();
        List<WebElement> quantiyText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]" +
                "/descendant::*[@data-control-name=\"17. Label - Quantity, Estimated Value, Bundle Products\"]" +
                "/descendant::*[@class=\"appmagic-label-text\"]")));
        List<WebElement> usedText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]" +
                "/descendant::*[@data-control-name=\"17. Label - Quantity, Picked Value, Bundle Products\"]" +
                "/descendant::*[@class=\"appmagic-label-text\"]")));
        List<WebElement> buttonText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]" +
                "/descendant::*[@data-control-name=\"17. Button - Pick, Bundle Products\"]" +
                "/descendant::button")));
  /*
        List<WebElement> serialProducts = driver.findElements(By.xpath("//div[@class=\"appmagic-label-text\" and text()='Yes']" +
                "/ancestor::*[@data-control-name=\"17. Label - Serialized Value, Bundle Products\"]" +
                "/preceding-sibling::*[@data-control-name=\"17. Label - Product Value, Bundle Products\"]"));
        //"/descendant::*[@class=\"appmagic-label-text\"]"));
*/

//        System.out.println(driver.getPageSource());
        List<WebElement> serialProducts = driver.findElements(By.xpath("//div[@data-control-name=\"17. Image - Serialized, Bundle Products\"]"));
//        System.out.println(serialProducts.size());


        List<Product> productList = new ArrayList<>();
        HashMap<String, Product> productHashMap = new HashMap<>();

//        System.out.println("*****ProductList******");
        for (int i = 0; i < elementsText.size(); i++) {

            String productName = elementsText.get(i).getText();
            String quantity = quantiyText.get(i).getText();
            String used = usedText.get(i).getText();
            String tabIndex = buttonText.get(i).getAttribute("tabindex");
            String isSerializedString = serialProducts.get(i).getAttribute("style");
            Boolean isSerializedBoolean = false;
            if (isSerializedString.equals("width: 30px; height: 30px; z-index: 18; position: absolute; top: 16px; left: 531px;")) {
                isSerializedBoolean = true;
            }

//            System.out.println(productName + " " + quantity + " " + used + " " + tabIndex + " " + isSerializedBoolean);

            Product product = new Product(productName, quantity, used, tabIndex);
            product.setSerial(isSerializedBoolean);
            product.setProductIndex(i);

//            System.out.println("TEST:" + quantity.trim() + " " + used.trim());
//            System.out.println(quantity.trim().equals(used.trim()));
            if (!quantity.trim().equals(used.trim())) {
                productList.add(product);
            }
            productHashMap.put(productName, product);
        }
//        System.out.println("*****End******");

//        System.out.println("*****ProductList******");
//            System.out.println(p.getProduct() + " " + p.getQuantity() + " " + p.getUsed() + " ");
//        System.out.println("*****End******");

        return productList;

    }


    public void itemRowsV2() {
//        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"virtualized-gallery-item galleryCanvasContentDiv transforms_3hmsj\"]")));  // driver.findElements();
        System.out.println(driver.getPageSource());
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"react-gallery-items-window\"]/child::*")));  // driver.findElements();
        System.out.println(elements.size());
        for (WebElement element : elements) {
            System.out.println(element.getAttribute("aria-labelledby"));
            System.out.println(element.findElement(By.xpath("//*[@data-control-name=\"17. Label - Product Value, Bundle Products\"]" +
                    "/descendant::div[@class=\"appmagic-label-text\"]")).getText());

        }

    }

    public HashMap<String, Product> itemRows() throws InterruptedException {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"virtualized-gallery-item galleryCanvasContentDiv transforms_3hmsj\"]")));  // driver.findElements();
        List<WebElement> plusButtons = driver.findElements(By.xpath("descendant::button"));
//        List<WebElement> barCodes = driver.findElements(By.xpath("descendant::*[@class=\"appmagic-image-pseudo-button\"]"));
        List<WebElement> quantityLabels = driver.findElements(By.xpath("descendant::*[@class=\"appmagic-label-text\"]"));

        for (int i = 0; i < quantityLabels.size(); i++) {
            WebElement used = quantityLabels.get(i);
            if (used.getText().equals("Used")) {
                WebElement usedQuantity = quantityLabels.get(i + 1);
                WebElement productCode = quantityLabels.get(i + 4);
                Product p = new Product(usedQuantity.getText(), productCode.getText());
                if (!productCode.getText().equals("")) {
                    productMap.put(p.getProduct(), p);
                }
            }
        }

        for (Map.Entry<String, Product> x : productMap.entrySet()) {
            String tabIndex = getTabIndex(x.getKey());
            productMap.get(x.getKey()).setTabindex(tabIndex);
        }

        return productMap;
    }


    public void confirmProductItem() throws InterruptedException {

        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"virtualized-gallery-item galleryCanvasContentDiv transforms_3hmsj\"]")));  // driver.findElements();
        System.out.println(elements.size());
        for (WebElement e : elements) {
            List<WebElement> ele = e.findElements(By.xpath("descendant::button"));
            for (WebElement x : ele) {
                List<WebElement> t = x.findElements(By.xpath("//*[@class=\"appmagic-label-text\"]"));
                if (x.getText().equals("+")) {
                    Thread.sleep(3000);
                    x.click();
                    driver.findElement(By.xpath("//*[@tabindex=\"158\"]")).click();
                    driver.findElement(By.xpath("//*[@tabindex=\"159\"]")).click();


                }
            }

        }

    }


}
