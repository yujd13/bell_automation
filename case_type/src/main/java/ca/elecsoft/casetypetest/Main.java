package ca.elecsoft.casetypetest;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Main {
    public static void main(String[] args) {

        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setOutputDirectory("./case-values-report");
        testng.setTestClasses(new Class[]{
                CaseValuesTest.class
        });
        testng.addListener(tla);
        testng.run();
    }
}
