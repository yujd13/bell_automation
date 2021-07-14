package ca.elecsoft.model;

public class CRMPaymentMethod {
    public String paymentType;
    public String bankInstitutionNumber;
    public String bankTransitNumber;
    public String bankAccountNumber;
    public String accountHolderName;
    public String paymentIndex;
    public String SBNGroup2;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getBankInstitutionNumber() {
        return bankInstitutionNumber;
    }

    public void setBankInstitutionNumber(String bankInstitutionNumber) {
        this.bankInstitutionNumber = bankInstitutionNumber;
    }

    public String getBankTransitNumber() {
        return bankTransitNumber;
    }

    public void setBankTransitNumber(String bankTransitNumber) {
        this.bankTransitNumber = bankTransitNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getPaymentIndex() {
        return paymentIndex;
    }

    public void setPaymentIndex(String paymentIndex) {
        this.paymentIndex = paymentIndex;
    }

    public String getSBNGroup2() {
        return SBNGroup2;
    }

    public void setSBNGroup2(String SBNGroup2) {
        this.SBNGroup2 = SBNGroup2;
    }

    @Override
    public String toString() {
        return "CRMPaymentMethod{" +
                "paymentType='" + paymentType + '\'' +
                ", bankInstitutionNumber='" + bankInstitutionNumber + '\'' +
                ", bankTransitNumber='" + bankTransitNumber + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", paymentIndex='" + paymentIndex + '\'' +
                ", SBNGroup2='" + SBNGroup2 + '\'' +
                '}';
    }
}
