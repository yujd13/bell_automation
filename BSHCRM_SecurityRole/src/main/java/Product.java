class Product {
    String productBundle;
    String product;
    double quantity;

    public Product(String productBundle, String product, double quantity) {
        this.productBundle = productBundle;
        this.product = product;
        this.quantity = quantity;

    }

    @Override
    public String toString() {
        return "Product{" +
                "productBundle='" + productBundle + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
