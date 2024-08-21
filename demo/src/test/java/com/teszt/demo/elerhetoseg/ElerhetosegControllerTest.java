package com.teszt.demo.elerhetoseg;

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

@WebMvcTest(ElerhetosegController.class)
public class ElerhetosegControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ElerhetosegService elerhetosegService;

    @Test
    public void testGetElerhetosegById() throws Exception {
        Elerhetoseg elerhetoseg = new Elerhetoseg();
        elerhetoseg.setId(1);
        given(elerhetosegService.findElerhetosegById(1)).willReturn(Optional.of(elerhetoseg));

        mockMvc.perform(get("/api/elerhetosegek/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testCreateElerhetoseg() throws Exception {
        Elerhetoseg elerhetoseg = new Elerhetoseg();
        elerhetoseg.setErtek("test@example.com");

        given(elerhetosegService.saveElerhetoseg(any(Elerhetoseg.class))).willReturn(elerhetoseg);

        mockMvc.perform(post("/api/elerhetosegek")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"ertek\":\"test@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ertek").value("test@example.com"));
    }
}
