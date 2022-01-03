package com.valtech.FeignProducer.controller;

import com.valtech.FeignProducer.model.Products;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ProducerController {
    @GetMapping(value = "/getListSoap")
    public List<Products> getProducts()
    {
        Products product=new Products(1,"soap","sanitary",10);
        ArrayList<Products> prodcutsArrayList=new ArrayList<>();
        prodcutsArrayList.add(product);
        return prodcutsArrayList;
    }
}
