package com.elecsoft.test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Report {
    // static variable single_instance of type Singleton
    private static Report single_instance = null;
    public static ExtentReports report = null;
    public static ExtentTest test = null;


    // variable of type String
    public String s;

    // private constructor restricted to this class itself
    private Report()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\BSH-PC-084.html");

    }

    // static method to create instance of Singleton class
    public static Report getInstance()
    {
        if (single_instance == null)
            single_instance = new Report();

        return single_instance;
    }

    public static ExtentReports getReport() {
        return report;
    }

    public static ExtentTest getTest() {
        return test;
    }

}
