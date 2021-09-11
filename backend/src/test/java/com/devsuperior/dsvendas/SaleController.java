package com.devsuperior.dsvendas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SaleController {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void saleTestGetAll() throws Exception {
        mockMvc.perform(get("/sales/find-all"))
                .andExpect(status().isOk());
    }

    @Test
    public void amountGroupedBySeller() throws Exception {
        mockMvc.perform(get("/sales/amount-grouped-by-seller"))
                .andExpect(status().isOk());
    }

    @Test
    public void saleSucess() throws Exception {
        mockMvc.perform(get("/sales/sale-sucess"))
                .andExpect(status().isOk());
    }
}
