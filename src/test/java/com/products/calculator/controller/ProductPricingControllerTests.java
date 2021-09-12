package com.products.calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.products.calculator.common.enumeration.QuantityType;
import com.products.calculator.dto.ProductPriceRequestDTO;
import com.products.calculator.service.ProductPricingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductPricingController.class)
public class ProductPricingControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductPricingService productPricingService;

    @Test
    public void testPriceCalculationAPI() throws Exception {

        var request = new ProductPriceRequestDTO();
        request.setProductId("1");
        request.setQuantity(5);
        request.setQuantityType(QuantityType.UNIT);

        mvc.perform(post("/products/pricing/calculate/")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());

        //test bad request
        request.setProductId("");
        mvc.perform(post("/products/pricing/calculate/")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());


        request.setProductId("1");
        request.setQuantity(null);
        mvc.perform(post("/products/pricing/calculate/")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

        request.setQuantity(1);
        request.setQuantityType(null);
        mvc.perform(post("/products/pricing/calculate/")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

}
