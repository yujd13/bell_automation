package com.elecsoft.test;

public class Master {
    String sbnItemCode;
    String productName;
    String crmProductCategory;
    String sageCode;

    public Master(String sbnItemCode, String productName, String crmProductCategory) {
        this.sbnItemCode = sbnItemCode;
        this.productName = productName;
        this.crmProductCategory = crmProductCategory;
    }

    public void setSageCode(String sageCode){
        this.sageCode = sageCode;
    }

}