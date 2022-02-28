package com.valtech.FeignProducer.controller;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.valtech.FeignProducer.model.Products;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestProducerController {

    @Autowired
    ProducerController producerController; //= new ProducerController();


    @Test
    public void testControllerGetProducts() {

        Products product = new Products(1, "soap", "sanitary", 10);
        ArrayList<Products> productsArrayListActual = new ArrayList<>();
        productsArrayListActual.add(product);
        ArrayList<Products> productsArrayListExpected = (ArrayList<Products>) producerController.getProducts();
        assertEquals(productsArrayListActual, productsArrayListExpected);
    }
}
