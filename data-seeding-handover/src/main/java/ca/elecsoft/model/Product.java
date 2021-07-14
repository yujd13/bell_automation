package ca.elecsoft.model;

public class Product {
    String quantity;
    String product;
    String used;
    int productIndex;
    Boolean isSerial;
    Boolean isConfirmed;


    @Override
    public String toString() {
        return "Product{" +
                "quantity='" + quantity + '\'' +
                ", product='" + product + '\'' +
                ", used='" + used + '\'' +
                ", productIndex=" + productIndex +
                ", isSerial=" + isSerial +
                ", isConfirmed=" + isConfirmed +
                ", tabindex='" + tabindex + '\'' +
                '}';
    }

    public Boolean isConfirmed() {
        if (quantity.trim().equals(used.trim())) {
            return true;
        }
        return false;
    }

    public int getProductIndex() {
        return productIndex;
    }

    public void setProductIndex(int productIndex) {
        this.productIndex = productIndex;
    }

    public Boolean getSerial() {
        return isSerial;
    }

    public void setSerial(Boolean serial) {
        isSerial = serial;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public Product(String product, String quantity, String used, String tabindex) {
        this.quantity = quantity;
        this.product = product;
        this.used = used;
        this.tabindex = tabindex;
        this.isSerial = false;
    }

    String tabindex;

    public Product(String quantity, String product) {
        this.quantity = quantity;
        this.product = product;
    }

    public String getTabindex() {
        return tabindex;
    }

    public void setTabindex(String tabindex) {
        this.tabindex = tabindex;
    }

    public Product() {
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
