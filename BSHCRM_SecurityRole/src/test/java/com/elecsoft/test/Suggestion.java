package com.elecsoft.test;

public class Suggestion {
    String product;
    String relatedProduct;
    String relationShipType;
    String direction;

    public Suggestion(String product, String relatedProduct, String relationShipType, String direction) {
        this.product = product;
        this.relatedProduct = relatedProduct;
        this.relationShipType = relationShipType;
        this.direction = direction;
    }

    public String getProduct() {
        return product;
    }

    public String getRelatedProduct() {
        return relatedProduct;
    }

    public String getRelationShipType() {
        return relationShipType;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "product='" + product + '\'' +
                ", relatedProduct='" + relatedProduct + '\'' +
                ", relationShipType='" + relationShipType + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
