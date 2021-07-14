package ca.elecsoft.seeding;

import ca.elecsoft.dynamics.Prop;
import ca.elecsoft.model.DataSeedModel;
import ca.elecsoft.util.Excel;
import ca.elecsoft.util.Util;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static ca.elecsoft.dynamics.DataSeedMainVersionDataProvider.leadToWorkOrderSchedule;

public class SeedQA2 {
    Excel excel = Excel.getInstance();
    Prop prop = Prop.getInstance();
    File inputFile;
    WebDriver driver;
    WebDriverWait defaultWait;

    int count = 0;

    @DataProvider(name = "workOrders")
    public Object[][] priceList() throws InterruptedException, IllegalAccessException, IOException, InvalidFormatException {

        inputFile = new File(prop.loadProp(prop.getDATA_SEED_FILE()));
        List<List<String>> listOfList = excel.readFile(inputFile);
        Util util = Util.getInstance();
        List<DataSeedModel> dataList = util.convertTableToListOfDataSeedModel(listOfList);

        Object[][] ans = new Object[dataList.size()][1];

        for (int i = 0; i < dataList.size(); i++) {
            ans[i][0] = dataList.get(i);
        }

        return ans;
    }


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod()");
        System.setProperty(prop.loadProp(prop.getBROSWER()), prop.loadProp(prop.getWEB_DRIVER_PATH()));
        driver = new ChromeDriver();
        defaultWait = new WebDriverWait(driver, 20);

    }




    @Test(dataProvider = "workOrders")
    public void seedOrder(DataSeedModel product) throws Exception {
        Reporter.log("WORK");
        String workOrderNo = leadToWorkOrderSchedule(driver, defaultWait, String.valueOf(count), product);
//        Reporter.log(workOrderNo);


        Assert.assertNotEquals(workOrderNo.substring(0, 1), "F");
    }


    @AfterMethod
    public void afterMethod() {
        count++;

        driver.quit();

    }


}
