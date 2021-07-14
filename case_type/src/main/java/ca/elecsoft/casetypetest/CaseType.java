package ca.elecsoft.casetypetest;

public class CaseType {
    public String Case_sub_type_EN;
    public String Case_sub_type_FR;
    public String Case_type;
    public String Customer_type;
    public String work_order_type;
    public String work_order_sub_type;
    public String Priority;
    public String Process;

    @Override
    public String toString() {
        return "CaseType{" +
                "Case_sub_type_EN='" + Case_sub_type_EN + '\'' +
                ", Case_sub_type_FR='" + Case_sub_type_FR + '\'' +
                ", Case_type='" + Case_type + '\'' +
                ", Customer_type='" + Customer_type + '\'' +
                ", work_order_type='" + work_order_type + '\'' +
                ", work_order_sub_type='" + work_order_sub_type + '\'' +
                ", Priority='" + Priority + '\'' +
                ", Process='" + Process + '\'' +
                '}';
    }

    public String getCase_sub_type_EN() {
        return Case_sub_type_EN;
    }

    public void setCase_sub_type_EN(String case_sub_type_EN) {
        Case_sub_type_EN = case_sub_type_EN;
    }

    public String getCase_sub_type_FR() {
        return Case_sub_type_FR;
    }

    public void setCase_sub_type_FR(String case_sub_type_FR) {
        Case_sub_type_FR = case_sub_type_FR;
    }

    public String getCase_type() {
        return Case_type;
    }

    public void setCase_type(String case_type) {
        Case_type = case_type;
    }

    public String getCustomer_type() {
        return Customer_type;
    }

    public void setCustomer_type(String customer_type) {
        Customer_type = customer_type;
    }

    public String getWork_order_type() {
        return work_order_type;
    }

    public void setWork_order_type(String work_order_type) {
        this.work_order_type = work_order_type;
    }

    public String getWork_order_sub_type() {
        return work_order_sub_type;
    }

    public void setWork_order_sub_type(String work_order_sub_type) {
        this.work_order_sub_type = work_order_sub_type;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public String getProcess() {
        return Process;
    }

    public void setProcess(String process) {
        Process = process;
    }
}
