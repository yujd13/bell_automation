package ca.elecsoft.model;

public class AdditionalItem {
    public String label;
    public String quantity;

    public void setLabel(String label) {
        this.label = label;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getLabel() {
        return label;
    }

    public String getQuantity() {
        return quantity;
    }

    public AdditionalItem(String label, String quantity) {
        this.label = label;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AdditionalItem{" +
                "label='" + label + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
