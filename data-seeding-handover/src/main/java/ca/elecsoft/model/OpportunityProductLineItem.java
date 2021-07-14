package ca.elecsoft.model;

public class OpportunityProductLineItem {
    public String responseType;
    public String bundleName;

    public OpportunityProductLineItem(String responseType, String bundleName) {
        this.responseType = responseType;
        this.bundleName = bundleName;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }
}


