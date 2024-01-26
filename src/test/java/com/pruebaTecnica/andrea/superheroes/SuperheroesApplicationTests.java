package com.pruebaTecnica.andrea.superheroes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebaTecnica.andrea.superheroes.domain.model.Superheroe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.MvcResult;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SuperheroesApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllSuperheroes() throws Exception {
        mockMvc.perform(get("/api/superheroes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(0))));
    }

    @Test
    public void testGetSuperheroById() throws Exception {
        Long superheroId = 1L;

        mockMvc.perform(get("/api/superheroes/{id}", superheroId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(superheroId));
    }

    @Test
    public void testGetSuperheroesByName() throws Exception {
        String nameParam = "man";

        mockMvc.perform(get("/api/superheroes/name/{name}", nameParam))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(0))));
    }

    @Test
    public void testCreateSuperhero() throws Exception {
        Superheroe superheroeRequest = new Superheroe("Spiderman", "Peter Parker", "Agility", "Marvel");

        ResultActions createResult = mockMvc.perform(post("/api/superheroes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(superheroeRequest)))
                .andExpect(status().isCreated());

        MvcResult createMvcResult = createResult.andReturn();
        String location = createMvcResult.getResponse().getHeader("Location");
        assertNotNull(location);
    }

    @Test
    public void testUpdateSuperhero() throws Exception {
        Long superheroId = 1L;

        Superheroe updatedSuperheroeRequest = new Superheroe("Spiderman Updated", "Peter Parker", "Agility", "Marvel");

        mockMvc.perform(put("/api/superheroes/{id}", superheroId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedSuperheroeRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteSuperhero() throws Exception {
        Long superheroId = 1L;

        mockMvc.perform(delete("/api/superheroes/{id}", superheroId))
                .andExpect(status().isOk());
    }
}
