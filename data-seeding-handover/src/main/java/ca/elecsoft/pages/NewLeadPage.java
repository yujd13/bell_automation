package ca.elecsoft.pages;

import ca.elecsoft.model.Address;
import ca.elecsoft.model.Lead;
import ca.elecsoft.model.MarketingTabValidation;
import ca.elecsoft.util.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NewLeadPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public String url;

    //summary
    public By customerType;
    public By firstName;
    public By lastName;
    public By mobilePhone;
    public By homePhone;
    public By businessPhone;
    public By customerAccount;
    public By email;
    public By preferredLanguage;
    public By source;
    public By sourceLookup;

    public By program;
    public By programLookup;

    public By addressTab;

    //address tab

    public By streetNumber;
    public By streetOne;
    public By city;
    public By postalCode;
    public By province;
    public By nearestIntersection;
    public By save;
    public By qualify;

    public By customerTypeLabel;
    public By notes;


    private static final Logger logger = LogManager.getLogger(NewOpportunityPage.class);


    public NewLeadPage(WebDriver driver, WebDriverWait wait, String url) throws InterruptedException {
        this.driver = driver;
        this.wait = wait;
        this.url = url;
        int maxAttempts = 10;
        if (url.length() > 1) {
            driver.get(url);
        }
        init();

    }

    public void init() {
        customerType = By.xpath("//*[@aria-label=\"Customer Type\"]");
        firstName = By.xpath("//input[@aria-label=\"First Name\"]");
        lastName = By.xpath("//input[@aria-label=\"Last Name\"]");
        mobilePhone = By.xpath("//input[@aria-label=\"Mobile Phone\"]");
        homePhone = By.xpath("//input[@aria-label=\"Home Phone\"]");
        businessPhone = By.xpath("//input[@aria-label=\"Business Phone\"]");
        email = By.xpath("//input[@aria-label=\"Email\"]");
        preferredLanguage = By.xpath("//select[@aria-label=\"Preferred Language\"]");
        customerAccount = By.xpath("//input[@aria-label=\"Business Name\"]");

        source = By.xpath("//input[@aria-label=\"Source, Lookup\"]");
        sourceLookup = By.id("id-c07d585f-3466-4c7e-b7c2-f6116fff3a20-21-cgi_soruceid6-cgi_soruceid.fieldControl-LookupResultsDropdown_cgi_soruceid_4");

        program = By.xpath("//input[@aria-label=\"Program, Lookup\"]");
        programLookup = By.id("id-c07d585f-3466-4c7e-b7c2-f6116fff3a20-20-cgi_programid6-cgi_programid.fieldControl-LookupResultsDropdown_cgi_programid_3");

        streetNumber = By.xpath("//input[@aria-label=\"Street Number\"]");
        streetOne = By.xpath("//input[@aria-label=\"Street 1\"]");
        city = By.xpath("//input[@aria-label=\"City\"]");
        postalCode = By.xpath("//input[@aria-label=\"Postal Code\"]");
        province = By.xpath("//input[@aria-label=\"Province\"]");
        nearestIntersection = By.xpath("//input[@aria-label=\"Nearest Intersection\"]");

        save = By.xpath("//button[@aria-label=\"Save\"]");
        qualify = By.xpath("//button[@aria-label=\"Qualify\"]");
        customerTypeLabel = By.xpath("//*[text()='Customer Type']");

        addressTab = By.xpath("//*[@aria-label=\"Address\"]");
        notes = By.xpath("//*[@aria-label=\"Description\"]");

    }

    public void selectInquiryType(int index) {
        By inquiryType = By.xpath("//*[@aria-label=\"Inquiry type\"]");
        System.out.println("selectInquiryType()");
        Select inquiryTypeSelect = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(inquiryType)));
        inquiryTypeSelect.selectByIndex(index);


    }


    public void getLabels() {
        List<WebElement> element = driver.findElements(By.xpath("//label"));
        for (WebElement x : element) {
            System.out.println(x.getText());
        }

    }

    public void getNames(MarketingTabValidation mtv) {
        String firstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"First Name\"]"))).getAttribute("value");
        String lastName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Last Name\"]"))).getAttribute("value");

        mtv.setFirstName(firstName);
        mtv.setLastName(lastName);
    }

    public void getHomePhone(MarketingTabValidation mtv) {
        String homePhone = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Home Phone\"]"))).getAttribute("value");
        mtv.setPhone(homePhone);


    }

    public void inputDiscover(String discover) {
        wait.until(ExpectedConditions.presenceOfElementLocated(notes)).sendKeys(discover);
    }

    public void verifyFields() {

        String ct = driver.findElement(customerType).getAttribute("value");
        logger.debug("Customer Type:" + ct);

        String fn = driver.findElement(firstName).getAttribute("value");
        logger.debug("First Name:" + fn);

        String ln = driver.findElement(lastName).getAttribute("value");
        logger.debug("Last Name:" + ln);

        String hp = driver.findElement(homePhone).getAttribute("value");
        logger.debug("Home Phone:" + hp);

        String mp = driver.findElement(mobilePhone).getAttribute("value");
        logger.debug("Mobile Phone:" + mp);

        String em = driver.findElement(email).getAttribute("value");
        logger.debug("Email:" + em);

        String pl = driver.findElement(preferredLanguage).getAttribute("value");
        logger.debug("PreferredLanguage:" + pl);

//        String pro = driver.findElement(program).getAttribute("value");
//        logger.debug(pro);

//        String so = driver.findElement(source).getAttribute("value");
//        logger.debug(so);


    }


    public void fillField(By field, String value, int attemps) {
        logger.debug("fillField(" + field + " , " + value + ")");
        try {
            WebElement f = wait.until(ExpectedConditions.presenceOfElementLocated(field));
            f.sendKeys(Keys.DELETE);
            f.sendKeys(Keys.DELETE);
            f.sendKeys(value);
            wait.until(ExpectedConditions.presenceOfElementLocated(customerTypeLabel)).click();
        } catch (Exception e) {
            logger.error(e.toString());

        } finally {
//            WebElement f = wait.until(ExpectedConditions.presenceOfElementLocated(field));
//            if (f.getAttribute("value").equals(value)) {
//            } else {
//                attemps++;
//                if (attemps < maxAttempts) {
//                    fillField(field, value, attemps);
//                }
//            }


        }

    }

    public void fillMandatorySummary(Lead lead) throws InterruptedException {
        logger.debug("fillMandatorySummary");
        int defaultThreadSleep = 1000;
        selectCustomerType(lead.getCustomerType());

        Thread.sleep(defaultThreadSleep);
        fillField(firstName, lead.getFirstName(), 0);
        Thread.sleep(defaultThreadSleep);
        fillField(lastName, lead.getLastName(), 0);
        Thread.sleep(defaultThreadSleep);

        fillField(homePhone, lead.getHomePhone(), 0);
        fillField(mobilePhone, lead.getHomePhone(), 0);
        fillField(email, lead.getEmail(), 0);
        selectPreferredLanguage(lead.getPreferredLanguage());
        insertProgram("BELL");
        insertSource("BELL");

        if (lead.getCustomerType().equals("Commercial")) {
            String phoneNo = "";

            int t = Util.randInt(1000000, 9999999);
            String a = String.valueOf(t);
            phoneNo = "416" + a;


            fillField(By.xpath("//*[@aria-label=\"Business Name\"]"), lead.getFirstName() + " " + "Incorperation", 0);
            fillField(By.xpath("//*[@aria-label=\"Business Phone\"]"), phoneNo, 0);
        }

    }

    public void insertProgram(String value) {
        logger.debug("insertProgram(" + value + ")");
        WebElement caInput = wait.until(ExpectedConditions.visibilityOfElementLocated(program));
        inputContactSearch(caInput, value);

    }

    public void selectProvince(String prov){
        WebElement caSelect = wait.until(ExpectedConditions.presenceOfElementLocated(province));
        Select cs = new Select(caSelect);
        switch (prov) {
            case "ON":
                cs.selectByValue("285050006");
                break;
            case "QC":
                cs.selectByValue("285050008");
                break;
            default:
                break;
        }


    }


    public void selectPreferredLanguage(String languageCode) {
        logger.debug("selectPreferredLanguage(" + languageCode + ")");

        WebElement caSelect = wait.until(ExpectedConditions.presenceOfElementLocated(preferredLanguage));
        Select cs = new Select(caSelect);
        switch (languageCode) {
            case "English":
                cs.selectByIndex(2);
                break;
            case "French":
                cs.selectByIndex(1);
                break;
            default:
                break;
        }

    }

    public void selectCustomerType(String type) {
        logger.debug("selectCustomerType(" + type + ")");

        WebElement caSelect = wait.until(ExpectedConditions.presenceOfElementLocated(customerType));
        Select cs = new Select(caSelect);
        switch (type) {
            case "Residential":
                cs.selectByIndex(1);
                break;
            case "Commercial":
                cs.selectByIndex(2);
                break;
            default:
                break;
        }
    }

    public void insertSource(String value) {
        logger.debug("insertSource(" + value + ")");

        WebElement caInput = wait.until(ExpectedConditions.visibilityOfElementLocated(source));
        inputContactSearch(caInput, value);

    }

    public void inputContactSearch(WebElement caInput, String customerName) {
        logger.debug("inputContactSearch(" + caInput + " , " + customerName + ")");

        inputInput(caInput, customerName);
        By by = By.xpath("//span[text()='" + customerName + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement span = driver.findElement(by);
        span.click();

    }

    private void inputInput(WebElement caInput, String customerName) {
        caInput.sendKeys(Keys.DELETE);
        caInput.sendKeys(Keys.DELETE);
        caInput.sendKeys(customerName);
    }

    public void switchToAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressTab)).click();
    }

    public void fillAddress(Address address) {
        fillField(streetNumber, address.getStreetNo(), 0);
        fillField(streetOne, address.getStreetOne(), 0);
        fillField(city, address.getCity(), 0);
        fillField(postalCode, address.getPostalCode(), 0);
//        fillField(province, address.getPostalCode(), 0);
    }

    public void saveLead() {
        wait.until(ExpectedConditions.presenceOfElementLocated(save)).click();
    }

    public void qualifyLead() {
        wait.until(ExpectedConditions.presenceOfElementLocated(qualify)).click();
    }

}
