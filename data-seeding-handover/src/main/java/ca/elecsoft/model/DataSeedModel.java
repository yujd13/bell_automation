package ca.elecsoft.model;

import java.util.List;

public class DataSeedModel {
    public String requestType;
    public String workOrderType;
    public String workOrderSubType;
    public String serviceLocationtype;
    public String province;
    public String bundle;
    public String includedChoice;
    public List<AdditionalItem> addtionalItem;
    public List<String> promotions;
    public String postalCode;
    public String paymentMethod;
    public String inquiryType;
    public String streetNumber;
    public String streetOne;
    public String city;

    public String getInquiryType() {
        return inquiryType;
    }

    public void setInquiryType(String inquiryType) {
        this.inquiryType = inquiryType;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetOne() {
        return streetOne;
    }

    public void setStreetOne(String streetOne) {
        this.streetOne = streetOne;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setWorkOrderSubType(String workOrderSubType) {
        this.workOrderSubType = workOrderSubType;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getWorkOrderSubType() {
        return workOrderSubType;
    }

    public DataSeedModel() {

    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(String workOrderType) {
        this.workOrderType = workOrderType;
    }

    public String getServiceLocationtype() {
        return serviceLocationtype;
    }

    public void setServiceLocationtype(String serviceLocationtype) {
        this.serviceLocationtype = serviceLocationtype;
    }

    public List<AdditionalItem> getAddtionalItem() {
        return addtionalItem;
    }

    public String getProvince() {
        return province;
    }

    public void setPromotions(List<String> promotions) {
        this.promotions = promotions;
    }

    @Override
    public String toString() {
        return "DataSeedModel{" +
                "requestType='" + requestType + '\'' +
                ", workOrderType='" + workOrderType + '\'' +
                ", workOrderSubType='" + workOrderSubType + '\'' +
                ", serviceLocationtype='" + serviceLocationtype + '\'' +
                ", province='" + province + '\'' +
                ", bundle='" + bundle + '\'' +
                ", includedChoice='" + includedChoice + '\'' +
                ", addtionalItem=" + addtionalItem +
                ", promotions=" + promotions +
                ", postalCode='" + postalCode + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getBundle() {
        return bundle;
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    public String getIncludedChoice() {
        return includedChoice;
    }

    public void setIncludedChoice(String includedChoice) {
        this.includedChoice = includedChoice;
    }


    public void setAddtionalItem(List<AdditionalItem> addtionalItem) {
        this.addtionalItem = addtionalItem;
    }



    public List<String> getPromotions() {
        return promotions;
    }


}
