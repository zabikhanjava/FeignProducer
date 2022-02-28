package com.valtech.FeignProducer.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.valtech.FeignProducer.FeignProducerApplication;
import com.valtech.FeignProducer.model.Products;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ProducerController.class)
@SpringBootTest(classes = FeignProducerApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestProducerRESTController {
   // @Autowired
    //private MockMvc mvc;
   @LocalServerPort
   private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /* @Test
    public void testControllerGetProducts() throws Exception {

        mvc.perform( MockMvcRequestBuilders
                        .get("/getListSoap")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        //  .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
        // .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
    }*/
  /* @Test
   public void testControllerGetProductsWireMock() throws Exception {

       WireMockServer server = new WireMockServer();
       configureFor("localhost", 8080);
       server.start();
       mvc.perform(MockMvcRequestBuilders
                       .get("/getListSoap")
                       .accept(MediaType.APPLICATION_JSON))
               .andDo(print())
               .andExpect(status().isOk());
       //  .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
       // .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
   }*/
    @Test
    public void testAllEmployees()
    {
        assertTrue(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/getListSoap", ArrayList.class).get(0).getClass().equals(Products.class));
                        //.getProductType().equals("sanitary"));
    }

}
