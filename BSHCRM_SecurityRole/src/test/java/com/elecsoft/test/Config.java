package com.elecsoft.test;

public class Config {

    private static Config single_instance = null;

    // variable of type String
    public String ervfilePath;
    public String productAssociation;
    public String productRelationship;
    public String priceList;
    public String sbnFile;
    public String ignoreProducts;

    public String securityQA3Path;
    public String securityRoleBSHPath;


    private Config() {
        Prop prop = Prop.getInstance();

        ervfilePath = prop.loadProp(prop.getErvfilePath());
        productAssociation ="./src/main/resources/pc/CSV/ERV094/Excel/Product Association Aug13.xlsx";
        productRelationship = prop.loadProp(prop.getProductRelationship());//"C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\QA2-1.7-Feb3\\Product Relationship.xlsx";
        priceList = prop.loadProp(prop.getPriceList());//"C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\QA2-1.7-Feb3\\Price List Items .xlsx";
        sbnFile = prop.loadProp(prop.getSbnFile());//"C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\QA2-1.7\\SBNQA2 items-Jan 29 2021.xlsx";
        ignoreProducts = "C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\ERV113\\IgnoreProducts.xlsx";
        securityQA3Path = prop.loadProp(prop.getSecurityQA3File());
        securityRoleBSHPath = prop.loadProp(prop.getSecurityRoleBSHFile());

    }

    // private constructor restricted to this class itself
//    private Config() {
//        ervfilePath = "C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\QA2-1.7-Feb3\\Product Offerings Master List Consolidation V4 1.2 WIP6.xlsx";
//    productAssociation = "./src/main/resources/pc/CSV/ERV094/Excel/Product Association Aug13.xlsx";
//    productRelationship = "C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\QA2-1.7-Feb3\\Product Relationship.xlsx";
//    priceList = "C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\QA2-1.7-Feb3\\Price List Items .xlsx";
//    sbnFile = "C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\QA2-1.7\\SBNQA2 items-Jan 29 2021.xlsx";
//    ignoreProducts = "C:\\project\\ProductCatalogue\\src\\main\\resources\\PC\\CSV\\ERV113\\IgnoreProducts.xlsx";
//}

    public String getIgnoreProducts() {
        return ignoreProducts;
    }

    public String getSbnFile() {
        return sbnFile;
    }

    public String getPriceList() {
        return priceList;
    }

    public String getProductRelationship() {
        return productRelationship;
    }

    public String getErvfilePath() {
        return ervfilePath;
    }

    public String getProductAssociation() {
        return productAssociation;
    }

    public String getSecurityQA3Path() {
        return securityQA3Path;
    }

    public String getSecurityRoleBSHPath() {
        return securityRoleBSHPath;
    }

    // static method to create instance of Singleton class
    public static Config getInstance() {
        if (single_instance == null)
            single_instance = new Config();

        return single_instance;
    }

    public String leftPading(String strSrc,String flag,int strSrcLength) {
        String strReturn = "";
        String strtemp = "";
        int curLength = strSrc.trim().length();
        if (strSrc != null && curLength > strSrcLength) {
            strReturn = strSrc.trim().substring(0, strSrcLength);
        } else if (strSrc != null && curLength == strSrcLength) {
            strReturn = strSrc.trim();
        } else {

            for (int i = 0; i < (strSrcLength - curLength); i++) {
                strtemp = strtemp + flag;
            }

            strReturn = strtemp + strSrc.trim();
        }
        return strReturn;
    }

}
