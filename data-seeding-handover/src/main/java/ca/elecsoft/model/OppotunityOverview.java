package ca.elecsoft.model;

public class OppotunityOverview {
    public String serviceLocationType;
    public String workOrderType;
    public String workOrderSubType;

    public OppotunityOverview(String serviceLocationType, String workOrderType, String workOrderSubType) {
        this.serviceLocationType = serviceLocationType;
        this.workOrderType = workOrderType;
        this.workOrderSubType = workOrderSubType;
    }


    public String getServiceLocationType() {
        return serviceLocationType;
    }

    public void setServiceLocationType(String serviceLocationType) {
        this.serviceLocationType = serviceLocationType;
    }

    public String getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(String workOrderType) {
        this.workOrderType = workOrderType;
    }

    public String getWorkOrderSubType() {
        return workOrderSubType;
    }

    public void setWorkOrderSubType(String workOrderSubType) {
        this.workOrderSubType = workOrderSubType;
    }
}
