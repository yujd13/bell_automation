package com.elecsoft.test;

import java.io.*;
import java.util.*;

public class Prop {

    private static Prop INSTANCE;
    File outputFilePath;
    Properties prop;

    public  final String ervfilePath="ervfilePath";
    public  final String priceList="priceList";
    public  final String sbnFile="sbnFile";
    public  final String productRelationship="productRelationship";

    public  final String securityQA3="SecurityRoleQA3";
    public  final String securityBSH="It2SecurityRoleBSH";


    public String getErvfilePath() {
        return ervfilePath;
    }

    public String getPriceList() {
        return priceList;
    }


    public String getSbnFile() {
        return sbnFile;
    }

    public String getProductRelationship() {
        return productRelationship;
    }

    public String getSecurityQA3File() {
        return securityQA3;
    }

    public String getSecurityRoleBSHFile() {
        return securityBSH;
    }


    public List<String> getProperties() {
        return properties;
    }

    List<String> properties;

    public static Prop getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Prop();
        return INSTANCE;
    }

    private Prop() {
        this.outputFilePath = outputFilePath;
        this.properties = new ArrayList<>();
        this.prop = openPropertyFile(new File("./config"));
    }

    public Properties openPropertyFile(File propFile) {
        try (InputStream input = new FileInputStream(propFile)) {
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public void saveProp(HashMap<String, String> map, File outputFilePath) {
        this.prop = new Properties();
        try (OutputStream output = new FileOutputStream(outputFilePath)) {
            for (Map.Entry<String, String> d : map.entrySet()) {
                prop.setProperty(d.getKey(), d.getValue());
            }
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }


    public String loadProp(String key) {
        return prop.getProperty(key);
    }


    public Properties getProp() {
        return prop;
    }


    public static void main(String[] args) {
    /*

        ervfilePath = "C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\QA2-1.7-Feb3\\Product Offerings Master List Consolidation V4 1.2 WIP6.xlsx";
        productAssociation = "./src/main/resources/pc/CSV/ERV094/Excel/Product Association Aug13.xlsx";
        productRelationship = "C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\QA2-1.7-Feb3\\Product Relationship.xlsx";
        priceList = "C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\QA2-1.7-Feb3\\Price List Items .xlsx";
        sbnFile = "C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\QA2-1.7\\SBNQA2 items-Jan 29 2021.xlsx";
        ignoreProducts = "C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\ERV113\\IgnoreProducts.xlsx";


     */

        Prop p = Prop.getInstance();
        HashMap<String, String> map = new HashMap<>();
        map.put("ervfilePath", "Naruto");
        map.put("productRelationship", "Fam");
        map.put("priceList", "Fdf");
        map.put("sbnFile", "Fdf");
        p.saveProp(map, new File("./config"));
    }
}
