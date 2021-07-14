package ca.elecsoft.model;

public class CrmLineItem {
    String quantity;
    String existingProduct;
    String productCode;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    String productCategory;
    String lineType;
    String revenueType;
    String pricePerUnit;
    String extendedAmount;

    @Override
    public String toString() {
        return "CrmLineItem{" +
                "quantity='" + quantity + '\'' +
                ", existingProduct='" + existingProduct + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", lineType='" + lineType + '\'' +
                ", revenueType='" + revenueType + '\'' +
                ", pricePerUnit='" + pricePerUnit + '\'' +
                ", extendedAmount='" + extendedAmount + '\'' +
                ", estimatedQuantity='" + estimatedQuantity + '\'' +
                ", realizedQuantity='" + realizedQuantity + '\'' +
                '}';
    }

    public String getEstimatedQuantity() {
        return estimatedQuantity;
    }

    public void setEstimatedQuantity(String estimatedQuantity) {
        this.estimatedQuantity = estimatedQuantity;
    }

    public String getRealizedQuantity() {
        return realizedQuantity;
    }

    public void setRealizedQuantity(String realizedQuantity) {
        this.realizedQuantity = realizedQuantity;
    }

    String estimatedQuantity;
    String realizedQuantity;


    public CrmLineItem(String existingProduct) {
        this.existingProduct = existingProduct;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getExistingProduct() {
        return existingProduct;
    }

    public void setExistingProduct(String existingProduct) {
        this.existingProduct = existingProduct;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getExtendedAmount() {
        return extendedAmount;
    }

    public void setExtendedAmount(String extendedAmount) {
        this.extendedAmount = extendedAmount;
    }
}
