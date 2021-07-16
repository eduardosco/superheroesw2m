package com.w2m.superheroes.resources;

import com.w2m.superheroes.dto.SuperHeroeDTO;

import com.w2m.superheroes.services.SuperHeroesService;

import org.junit.runner.RunWith;
import org.junit.Test;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.mock.web.MockHttpServletResponse;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SuperHeroesResource.class)
public class SuperHeroesResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SuperHeroesService superHeroesService;

    @Test
    public void testUpdateSuperHeroeWhenProperSuperHeroeObjectProvided() throws Exception {
        String superHeroeJSON = "{"
	    + "\"id\": 2,"
	    + "\"nombre\": \"AntMan\","
	    + "\"genero\": \"Hombre\""
		+ "}\"";
        Mockito.when(superHeroesService.update(Mockito.any(SuperHeroeDTO.class))).thenReturn(null);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/superheroes")
                .accept(MediaType.APPLICATION_JSON).content(superHeroeJSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testDeleteSuperHeroeById() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/superheroes/30");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}