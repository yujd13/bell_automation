package ca.elecsoft.util;

import ca.elecsoft.model.*;
import ca.elecsoft.pages.ProductPage;
import com.github.javafaker.Faker;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class Util {
    private static Util INSTANCE;
    private Mandatory m;
    private int maxAttempts;

    private static final Logger logger = LogManager.getLogger(Util.class);

    public static String getMethodName(final int depth) {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        return ste[ste.length - 1 - depth].getMethodName();
    }

    private Util() {
        m = new Mandatory();
        maxAttempts = 10;
    }

    public Mandatory getM() {
        return m;
    }

    public static Util getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Util();
        }
        return INSTANCE;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public String randPhoneNo() {
        int t = randInt(1000000, 9999999);
        String a = String.valueOf(t);
        return "416" + a;
    }

    public void overWriteLeadInformation(Lead l) {
        Faker f = new Faker();
        l.setFirstName(f.firstName());
        l.setLastName(f.lastName());
        int t = randInt(1000000, 9999999);
        String a = String.valueOf(t);
        l.setMobilePhone("416" + a);
        l.setHomePhone("416" + a);
        l.setEmail(f.firstName() + "@gmail.com");
    }

    public Boolean overWriteAddressInformation(Lead l, DataSeedModel model) {
        Address ad = new Address();
        ad.setPostalCode(model.getPostalCode());
        ad.setCity(model.getCity());
        ad.setStreetNo(model.getStreetNumber());
        ad.setStreetOne(model.getStreetOne());
        ad.setProvince(model.getProvince());
        l.setAddress(ad);
        return true;
    }


    public Lead createLead(HashMap<String, String> map) {
        Lead lead = null;
//        if (m.mandatoryInformation(map)) {
        lead = new Lead();
        lead.setFirstName(map.get("First Name:"));
        lead.setLastName(map.get("Last Name:"));
        lead.setCustomerType("Residential");
        lead.setEmail(map.get("Email:"));
        lead.setPreferredLanguage(map.get("Preferred Language:"));
        String PhoneNo = splitPhoneNumber(map.get("Secondary Contact Number:"));
        lead.setMobilePhone(PhoneNo);
        lead.setHomePhone(PhoneNo);
        Address ad = new Address();
        ad.setPostalCode(map.get("Postal Code:"));
        ad.setCity(map.get("City:"));
        ad.setStreetNo(map.get("Street Number:"));
        ad.setStreetOne(map.get("Street Name:"));
        ad.setProvince(map.get("Province:"));
        lead.setAddress(ad);
//        }
        return lead;
    }



    public List<CrmLineItem> getOpportunityCrmLineItem(String productTable, String url, WebDriver driver, WebDriverWait wait) throws InterruptedException {

//        driver.get("https://bsh-qa.crm3.dynamics.com/main.aspx?appid=0ae14cf9-42ae-ea11-a812-000d3a0c8127&newWindow=true&pagetype=entityrecord&etn=cgi_salesorder&id=2875c007-6af7-ea11-a815-000d3af3bf00");
//        driver.manage().window().maximize();
//        delayClick(driver, wait, By.xpath("//*[@aria-label=\"Product Line Item\"]"));
//        Thread.sleep(5000);

        LinkedList<CrmLineItem> list = new LinkedList<>();

//        String productTable = "//*[@aria-label=\"Sales Order Products (Sales Order)\"]/";
        List<WebElement> quantityElements = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"2\"]"));
        List<WebElement> existingProducts = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"3\"]"));
        List<WebElement> productCategories = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"4\"]"));
        List<WebElement> lineType = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"5\"]"));
        List<WebElement> revenueType = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"6\"]"));
        List<WebElement> pricePerUnitElements = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"7\"]"));
        List<WebElement> extendedAmount = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"8\"]"));

        System.out.println(quantityElements.size());

        for (int i = 0; i < existingProducts.size(); i++) {
            CrmLineItem crmLine = new CrmLineItem(existingProducts.get(i).getAttribute("title"));
            crmLine.setQuantity(quantityElements.get(i).getAttribute("title"));
            crmLine.setProductCategory(productCategories.get(i).getAttribute("title"));
            crmLine.setLineType(lineType.get(i).getAttribute("title"));
            crmLine.setRevenueType(revenueType.get(i).getAttribute("title"));
            crmLine.setPricePerUnit(pricePerUnitElements.get(i).getAttribute("title"));
            crmLine.setExtendedAmount(extendedAmount.get(i).getAttribute("title"));
            System.out.println(existingProducts.get(i).getAttribute("title") + " | " + quantityElements.get(i).getAttribute("title") + " | " + pricePerUnitElements.get(i).getAttribute("title"));
            list.add(crmLine);
        }

        return list;

    }

    public List<CrmLineItem> getSaleOrderCrmLineItem(String productTable, String url, WebDriver driver, WebDriverWait wait) throws InterruptedException {

//        driver.get("https://bsh-qa.crm3.dynamics.com/main.aspx?appid=0ae14cf9-42ae-ea11-a812-000d3a0c8127&newWindow=true&pagetype=entityrecord&etn=cgi_salesorder&id=2875c007-6af7-ea11-a815-000d3af3bf00");
//        driver.manage().window().maximize();
//        delayClick(driver, wait, By.xpath("//*[@aria-label=\"Product Line Item\"]"));
//        Thread.sleep(5000);

        WebElement x = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"2\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);

        LinkedList<CrmLineItem> list = new LinkedList<>();

//        String productTable = "//*[@aria-label=\"Sales Order Products (Sales Order)\"]/";
        List<WebElement> quantityElements = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"2\"]"));
        List<WebElement> existingProducts = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"3\"]/a"));
        List<WebElement> revenueType = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"4\"]"));
        List<WebElement> productCategory = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"5\"]"));
        List<WebElement> pricePerUnitElements = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"6\"]"));
        List<WebElement> extendedAmount = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"7\"]"));

        System.out.println(quantityElements.size());

        for (int i = 0; i < existingProducts.size(); i++) {
            CrmLineItem crmLine = new CrmLineItem(existingProducts.get(i).getAttribute("href"));
            crmLine.setQuantity(quantityElements.get(i).getAttribute("title"));
            crmLine.setRevenueType(revenueType.get(i).getAttribute("title"));
            crmLine.setProductCategory(productCategory.get(i).getAttribute("title"));
            crmLine.setPricePerUnit(pricePerUnitElements.get(i).getAttribute("title"));
            crmLine.setExtendedAmount(extendedAmount.get(i).getAttribute("title"));
            System.out.println(existingProducts.get(i).getAttribute("title") + " | " + quantityElements.get(i).getAttribute("title") + " | " + pricePerUnitElements.get(i).getAttribute("title"));
            list.add(crmLine);
        }

        return list;

    }

    public static String readCell(XSSFCell cell) {
        String value = "";
        if (cell != null && cell.getCellTypeEnum().toString().equals("STRING")) {
            value = cell.getStringCellValue().trim();
        } else if (cell != null && cell.getCellTypeEnum().toString().equals("NUMERIC")) {
            value = String.valueOf(Math.round(cell.getNumericCellValue()));
        } else if (cell != null && cell.getCellTypeEnum().toString().equals("BLANK")) {

        } else if (cell != null && cell.getCellTypeEnum().toString().equals("FORMULA")) {

        } else if (cell != null && cell.getCellTypeEnum().toString().equals("BOOLEAN")) {
            value = cell.getBooleanCellValue() ? "TRUE" : "FALSE";
        } else if (cell != null) {
            System.out.println(cell.getCellTypeEnum().toString());
            value = "ERROR";
        }
        return value;
    }


    public boolean isPagination(String x) {

        String d = x.substring(3);
        String[] split = d.split(" ");
        int no = Integer.valueOf(split[1].trim());
        int last = Integer.valueOf(split[3].trim());
        System.out.println(no + " " + last);
        return no == last;

    }


    public boolean checkIfHaveBottomText(String productTable, WebDriver driver, WebDriverWait wait) {
        WebElement x = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"2\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);
        try {
            String count = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTable + "/descendant::*[@data-id=\"pagingText\"]"))).getText();
            return true;
        } catch (Exception e) {
            return false;
        }
    }




    public List<DataSeedModel> convertTableToListOfDataSeedModel(List<List<String>> list) {
        List<DataSeedModel> dataList = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            List<String> row = list.get(i);
            System.out.println(row);
            DataSeedModel dsm = new DataSeedModel();
            int offset = 2;
            dsm.setRequestType(row.get(0 + offset));
            dsm.setWorkOrderType(row.get(1 + offset));
            dsm.setWorkOrderSubType(row.get(2 + offset));
            dsm.setServiceLocationtype(row.get(3 + offset));
            dsm.setProvince(row.get(4 + offset));
            dsm.setBundle(row.get(5 + offset));
            dsm.setIncludedChoice(row.get(6 + offset));
            dsm.setAddtionalItem(toListOfAddtionalItems(row.get(7 + offset)));
            dsm.setPromotions(toListOfString(row.get(8 + offset)));
            dsm.setPostalCode(row.get(9 + offset));
            dsm.setPaymentMethod(row.get(10 + offset));
            dsm.setInquiryType(row.get(11 + offset));
            dsm.setStreetNumber(row.get(12 + offset));
            dsm.setStreetOne(row.get(13 + offset));
            dsm.setCity(row.get(14 + offset));
            dataList.add(dsm);
        }

        return dataList;

    }

    public HashMap<String, String> fakeOrder(String postalCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Date:", "2020-09-28");
        map.put("Submit State:", "SubmitOrder");
        map.put("Date Of Birth:", "1989-02-17");
        map.put("Secondary Contact Number:", "416-282-2279");
        map.put("Bank Account:", "9876543235");
        map.put("Bank Name:", "NATIONAL BANK OF CANADA");
        map.put("Postal Code:", postalCode);
        map.put("Amount:", "49.99");
        map.put("Version:", "0");
        map.put("Last Name:", "TT");
        map.put("Permission For External Credit Check?:", "Yes");
        map.put("Appointment Reference Id:", "2020092206594689040015B");
        map.put("Street Number:", "62");
        map.put("Due Date Revision Number:", "0");
        map.put("Preferred Language:", "English");
        map.put("Email:", "testid@gmail.com");
        map.put("Name:", "Test TT");
        map.put("Employee pein:", "6022185");
        map.put("Street Name:", "CONLINS");
        map.put("Service Consumer:", "Ordermax");
        map.put("Interval:", "Morning - AM (8am - 12pm)");
        map.put("Action:", "SubmitOrder");
        map.put("Same As Monthly Billing:", "Same as monthly billing");
        map.put("Service Appointment Id:", "2020092206594685914013B");
        map.put("Customer Interaction Type:", "ContactCentre");
        map.put("Preferred Method Of Contact:", "EmailAddress");
        map.put("Scheduling System:", "LiveCalendar");
        map.put("Bank Transit:", "+hvYyeECYQomX4OCIbpZrw==");
        map.put("Bank Institution:", "006");
        map.put("Brand:", "Bell");
        map.put("Country:", "CANADA");
        map.put("City:", "SCARBOROUGH");
        map.put("Service Request User Id:", "6022185");
        map.put("Sales InteractionType:", "ContactCentre");
        map.put("First Name:", "Test");
        map.put("Primary Phone:", "416-282-2279");
        map.put("Type:", "PreAuthorizedDebit");
        map.put("Reference ID:", "BC3SZ5ML");
        map.put("Credit Card Type:", "Visa");
        map.put("Card Holder Name:", "John Smith");
        map.put("Account Number:", "4157315205043891");
        return map;
    }


    public List<String> toListOfString(String string) {
        if (string.equals("NA")) {
            return new ArrayList<>();
        }
        String[] array = string.split(";");
        List<String> addtionalItemList = new ArrayList<>();
        for (String x : array) {
            addtionalItemList.add(x.trim());
        }
        return addtionalItemList;
    }

    public List<AdditionalItem> toListOfAddtionalItems(String string) {
        System.out.println("***sss***");

        if (string.equals("NA")) {
            return new ArrayList<>();
        }
        String[] array = string.split(";");


        List<AdditionalItem> addtionalItemList = new ArrayList<>();
        for (String x : array) {
            System.out.println(x);
            String[] values = x.split(",");
            if (values.length > 1) {
                AdditionalItem item = new AdditionalItem(values[0].trim(), values[1].trim());
                addtionalItemList.add(item);
            }
        }
        System.out.println("***sss***");


        return addtionalItemList;
    }


    public String getProductCodeFromUrl(String url, WebDriver driver, WebDriverWait wait) {
        ProductPage pp = new ProductPage(driver, wait, url);
        return pp.getProductCode();
    }

    public List<CrmLineItem> getSalesOrderPagination(String productTable, String url, WebDriver driver, WebDriverWait wait) throws InterruptedException {

        WebElement x = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"2\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);

        LinkedList<CrmLineItem> list = new LinkedList<>();
        String count = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTable + "/descendant::*[@data-id=\"pagingText\"]"))).getText();


//        System.out.println(productList.get(0).getAttribute("href"));

//        System.out.println(util.getProductCodeFromUrl(pcUrl, driver, wait));

        while (!isPagination(count)) {

            Thread.sleep(1000);
            x = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"2\"]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);

            List<WebElement> quantityList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"2\"]")));
            List<WebElement> productList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"3\"]/a")));
            List<WebElement> revenueType = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"4\"]")));
            List<WebElement> productCategory = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"5\"]")));
            List<WebElement> lineType = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"6\"]")));
            List<WebElement> pricePerUnit = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"7\"]")));
            List<WebElement> extendedAmount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"8\"]")));

            for (int i = 0; i < productList.size(); i++) {
                CrmLineItem crmLine = new CrmLineItem(productList.get(i).getAttribute("href"));
                crmLine.setQuantity(quantityList.get(i).getAttribute("title"));
                crmLine.setProductCategory(productCategory.get(i).getAttribute("title"));
                crmLine.setRevenueType(revenueType.get(i).getAttribute("title"));
                crmLine.setLineType(lineType.get(i).getAttribute("title"));
                crmLine.setPricePerUnit(pricePerUnit.get(i).getAttribute("title"));
                crmLine.setExtendedAmount(extendedAmount.get(i).getAttribute("title"));
                list.add(crmLine);
            }


            count = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTable + "/descendant::*[@data-id=\"pagingText\"]"))).getText();
            System.out.println(count);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTable + "/descendant::*[@aria-label=\"Load Next Page\"]"))).click();


        }

        return list;

    }

    public void translate(List<CrmLineItem> crmLineItems, WebDriver driver, WebDriverWait wait) {
        for (CrmLineItem lineItem : crmLineItems) {
            String productCode = getProductCodeFromUrl(lineItem.getExistingProduct(), driver, wait);
            System.out.println(lineItem.getExistingProduct() + " " + productCode);
            lineItem.setProductCode(productCode);
        }
    }

    public List<CrmLineItem> getWorkOrderCrmLineItem(String productTable, String url, WebDriver driver, WebDriverWait wait) throws InterruptedException {

//        driver.get("https://bsh-qa.crm3.dynamics.com/main.aspx?appid=0ae14cf9-42ae-ea11-a812-000d3a0c8127&newWindow=true&pagetype=entityrecord&etn=cgi_salesorder&id=2875c007-6af7-ea11-a815-000d3af3bf00");
//        driver.manage().window().maximize();
//        delayClick(driver, wait, By.xpath("//*[@aria-label=\"Product Line Item\"]"));
//        Thread.sleep(5000);

        WebElement x = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"4\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);

        LinkedList<CrmLineItem> list = new LinkedList<>();

//        String productTable = "//*[@aria-label=\"Sales Order Products (Sales Order)\"]/";
        List<WebElement> product = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"2\"]/a"));
        List<WebElement> productCategory = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"3\"]"));
        List<WebElement> lineType = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"4\"]"));
        List<WebElement> esimateQuatity = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"5\"]"));
        List<WebElement> realizedQty = driver.findElements(By.xpath(productTable + "/descendant::*[@role=\"gridcell\" and @aria-colindex=\"6\"]"));


        System.out.println(product.size());
        System.out.println(productCategory.size());
        System.out.println(lineType.size());
        System.out.println(esimateQuatity.size());
        System.out.println(realizedQty.size());

        for (int i = 0; i < product.size(); i++) {
            CrmLineItem crmLine = new CrmLineItem(product.get(i).getAttribute("href"));
            crmLine.setProductCategory(productCategory.get(i).getAttribute("title"));
            crmLine.setLineType(lineType.get(i).getAttribute("title"));
            crmLine.setEstimatedQuantity(esimateQuatity.get(i).getAttribute("title"));
            crmLine.setRealizedQuantity(realizedQty.get(i).getAttribute("title"));
            list.add(crmLine);
        }

        return list;

    }

    public void endlessClick(WebDriver driver, WebDriverWait wait, By link, int attempts) throws InterruptedException {
        if (attempts > maxAttempts) {

        } else {
            try {
                delayClick(driver, wait, link);

            } catch (Exception e) {
                Thread.sleep(1000);
                endlessClick(driver, wait, link, attempts++);
            } finally {

            }

        }

    }

    private String splitPhoneNumber(String phoneNo) {
        String[] phoneNoList = phoneNo.split("-");
        StringBuilder word = new StringBuilder("");
        for (String x : phoneNoList) {
            word.append(x);
        }
        return word.toString();

    }

    public String getFieldValue(WebDriverWait wait, By field, String value) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(field)).getAttribute("value");
    }

    public Boolean getCheckBox(WebDriverWait wait, By field) {
        String ans = wait.until(ExpectedConditions.presenceOfElementLocated(field)).getAttribute("tabindex");
        if (ans.equals("0")) {
            return true;
        } else {
            return false;
        }
    }


    public void inputGeneralLookUp(WebDriver driver, WebDriverWait wait, By label, String lookUpValue) throws InterruptedException {
        WebElement l = driver.findElement(label);
        inputInput(l, lookUpValue);


        Thread.sleep(1000);

        WebElement elementList = driver.findElement(By.xpath("//*[@aria-label=\"Lookup Search Results\"]/li"));
        elementList.click();
//        String[] split = e.split(",");
//        String d = split[0];


//        By by = By.xpath("//span[text()='" + lookUpValue + "']");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//        WebElement span = driver.findElement(by);
//        span.click();
    }

    public void inputLookUp(WebDriver driver, WebDriverWait wait, By label, String lookUpValue) {
        WebElement l = driver.findElement(label);
        inputInput(l, lookUpValue);
        By by = By.xpath("//span[text()='" + lookUpValue + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement span = driver.findElement(by);
        span.click();
    }

    public void inputInput(WebElement caInput, String customerName) {
        caInput.sendKeys(Keys.DELETE);
        caInput.sendKeys(Keys.DELETE);

        caInput.sendKeys(customerName);
    }

    public String getText(WebDriver driver, WebDriverWait wait, By link, String atr) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(link)).getAttribute(atr);
    }

    public void delayInput(WebDriver driver, WebDriverWait wait, By link, String value) {
        logger.debug("delayInput(" + link + " , " + value + ");");
        wait.until(ExpectedConditions.presenceOfElementLocated(link)).sendKeys(value);
    }

    public void setSelect(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);

    }

    public void delayDelete(WebDriver driver, WebDriverWait wait, By link) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(link));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(Keys.DELETE);
        element.sendKeys(Keys.DELETE);
    }

    public void delayClick(WebDriver driver, WebDriverWait wait, By link) {
        logger.debug("delayClick(" + link + ");");

        wait.until(ExpectedConditions.presenceOfElementLocated(link));
        driver.findElement(link).click();
    }

    public int Int(String value) {
        int ans = (int) Double.parseDouble(value);
        return ans;
    }

}
