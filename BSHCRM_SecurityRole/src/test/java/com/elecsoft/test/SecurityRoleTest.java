package com.elecsoft.test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityRoleTest implements ITest {

    private ThreadLocal<String> testName = new ThreadLocal<String>();
    public List<String> alist = new ArrayList<String>();

    public Report r = Report.getInstance();
    public ExtentTest test = r.getTest();
    public ExtentReports report = r.getReport();
    public Config c = Config.getInstance();
    public String securityRoleBSH;

    @DataProvider(name = "SecurityRoles")
    public Object[][] priceList() throws InterruptedException, IllegalAccessException, InvalidFormatException, IOException {


        File fRoleBSH = new File(c.getSecurityRoleBSHPath());
        File fRoleQA3= new File(c.getSecurityQA3Path());
        ExcelReader exRoleBSH = new ExcelReader(fRoleBSH);
        ExcelReader exRoleQA3 = new ExcelReader(fRoleQA3);

        HashMap<String, String> sExpectedRole = exRoleBSH.getExpectedSecurityRole(securityRoleBSH);
        HashMap<String, String> sActualRole = exRoleQA3.getActualSecurityRole(securityRoleBSH);

        Object[][] arEntityRole = new Object[sExpectedRole.size()][3];

        int i = 0;
        for (Map.Entry<String, String> x : sExpectedRole.entrySet()) {

            arEntityRole[i][0] = x.getKey();
            arEntityRole[i][1] = x.getValue();

            if (sActualRole.containsKey(x.getKey())) {
                String acRole = sActualRole.get(x.getKey());
                arEntityRole[i][2] = acRole;
            }else{
                arEntityRole[i][2] = " Entity Not Found ";
            }

//            System.out.println( "entity  " + x.getKey() + "     exRole    " + arEntityRole[i][1]);
//            System.out.println( "                               acRole    " + arEntityRole[i][2] );

            i++;
        }
        return arEntityRole;
    }


    @Test(dataProvider = "SecurityRoles")
    public void comparePriceList(String entity , String expected, String actual) throws InterruptedException {

            int i = 0;
            String result = "Pass" ;
            String acresult = "Pass" ;
            String role="";
            String action = "Read";

            if (entity.equals("CASE SUBTYPE")){
                entity = "CASE SUB-TYPE/CASE SUBTYPE";
            }

            if (securityRoleBSH.contains("Agent-L+R")) {
                securityRoleBSH="BSH Operation Agent-L&R";
            }

            String[] arExpect= expected.split(",");

            if (actual.contains("Entity Not Found")){
                result = "Fail";

                alist.add(securityRoleBSH+ " | "+  entity + " | " + "Entity Not Found" + " | NA  | NA  |" + result);
                test.log(LogStatus.PASS, entity + " | " + expected + " | " + actual);

            }else{
                String[] arActul= actual.split(",");
                while (i < arActul.length){
                    role = arActul[i].trim().toLowerCase();
                    if (role.equals("organization")){
                        role = "Global";
                    }else if(role.contains("parent:")){
                        role = "Deep";
                    }else if(role.equals("user")){
                        role = "Basic";
                    }else if(role.equals("Business Unit")){
                        role = "Local";
                    }else if(role.equals("none")){
                        role = "BLANK";
                    }

                    if (!role.equalsIgnoreCase(arExpect[i])){
                        result = "Fail"; acresult = "Fail";
                    }else{
                        acresult = "Pass";
                    }

                    String  exOut = arExpect[i].equals("BLANK") ? " " : arExpect[i];

                     switch (i) {
                        case 0:
                            action= "Create";
                            break;
                        case 1:
                            action= "Read";
                            break;
                        case 2:
                            action= "Write";
                            break;
                        case 3:
                            action= "Delete";
                            break;
                        case 4:
                            action= "Append";
                            break;
                        case 5:
                            action= "AppendTo";
                            break;
                        case 6:
                            action= "Assign";
                            break;
                        case 7:
                            action= "Share";
                            break;
                        default:
                    }

                    alist.add(securityRoleBSH+ " | "+  entity + " | " + action + " | " + exOut + " | " + arActul[i] + " | " + acresult);
                    test.log(LogStatus.PASS, securityRoleBSH+ " | "+  entity + " | " + action + " | " + exOut + " | " + arActul[i] + " | " + acresult);

                    i++;
                }
            }
            Assert.assertEquals(result,"Pass");
        }

    @BeforeClass @Parameters("securityRole")
    public void testbc(String role ) {
           securityRoleBSH = role;
    }


    @BeforeMethod
    public void BeforeMethod(Method method, Object[] testData) {
        test = report.startTest("SecurityRole_" + testData[2]);
        testName.set(method.getName() + "_" + testData[2]);
    }

    @AfterMethod
    public void aft() {
        report.endTest(test);
        report.flush();
    }

    @AfterClass
    public void testaf() {

        for (String x : alist) {
            System.out.println(x);
        }
    }

    @Override
    public String getTestName() {
        return testName.get();
    }

}
