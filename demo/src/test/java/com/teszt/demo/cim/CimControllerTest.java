package com.teszt.demo.cim;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CimController.class)
public class CimControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CimService cimService;

    @Test
    public void testGetCimById() throws Exception {
        Cim cim = new Cim();
        cim.setId(1);
        given(cimService.findCimById(1)).willReturn(Optional.of(cim));

        mockMvc.perform(get("/api/cimek/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testCreateCim() throws Exception {
        Cim cim = new Cim();
        cim.setVaros("New City");

        given(cimService.saveCim(any(Cim.class))).willReturn(cim);

        mockMvc.perform(post("/api/cimek")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"varos\":\"New City\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.varos").value("New City"));
    }
}
