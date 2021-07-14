package ca.elecsoft.seeding;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class MainSeed {
    public static void main(String[] args) {

        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setOutputDirectory("./report");
        testng.setTestClasses(new Class[]{
                SeedQA3.class
        });
        testng.addListener(tla);
        testng.run();

    }
}
