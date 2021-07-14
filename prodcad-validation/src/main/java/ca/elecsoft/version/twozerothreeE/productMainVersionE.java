package ca.elecsoft.version.twozerothreeE;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

/**
 * make sure populate the expected table and actual table before running
 *
 * Run this class to perform the product validation
 */
public class productMainVersionE {
    public static void main(String[] args) {

        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setOutputDirectory("./product-report");
        testng.setTestClasses(new Class[]{
                TestProductEntityVersionE.class
        });
        testng.addListener(tla);
        testng.run();
    }
}
