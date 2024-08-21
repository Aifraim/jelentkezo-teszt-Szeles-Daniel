package com.teszt.demo.szemely;

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

@WebMvcTest(SzemelyController.class)
public class SzemelyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SzemelyService szemelyService;

    @Test
    public void testGetSzemelyById() throws Exception {
        Szemely szemely = new Szemely();
        szemely.setId(1);
        given(szemelyService.findSzemelyById(1)).willReturn(Optional.of(szemely));

        mockMvc.perform(get("/api/szemelyek/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testCreateSzemely() throws Exception {
        Szemely szemely = new Szemely();
        szemely.setNev("New Person");

        given(szemelyService.saveSzemely(any(Szemely.class))).willReturn(szemely);

        mockMvc.perform(post("/api/szemelyek")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nev\":\"New Person\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nev").value("New Person"));
    }
}
