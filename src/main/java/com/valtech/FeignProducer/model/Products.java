package com.valtech.FeignProducer.model;

import lombok.Data;

@Data
public class Products {
    int id;
    String productName;
    String productType;
    int productQuantity;

    public Products(int id, String productName, String productType, int productQuantity) {
        this.id = id;
        this.productName = productName;
        this.productType = productType;
        this.productQuantity = productQuantity;
    }
}
