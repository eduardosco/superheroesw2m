package com.w2m.superheroes.resources;

import com.w2m.superheroes.dto.SuperHeroeDTO;

import com.w2m.superheroes.services.SuperHeroesService;

import java.net.URI;

import org.junit.runner.RunWith;
import org.junit.Test;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.mock.web.MockHttpServletResponse;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.RequestBuilder;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SuperHeroesResource.class, secure = false)
public class SuperHeroesResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SuperHeroesService superHeroesService;

    private JacksonTester<SuperHeroeDTO> superHeroesJacksonTester;

    @Test
    public void testUpdateSuperHeroeWhenProperSuperHeroeObjectProvided() throws Exception {
        SuperHeroeDTO superHeroeDTO = new SuperHeroeDTO();
        superHeroeDTO.setId(1);
        superHeroeDTO.setNombre("Ant-man");
        superHeroeDTO.setGenero("Hombre");
        String superHeroeJSON = "{"
	    + "\"id\": 2,"
	    + "\"nombre\": \"AntMan\","
	    + "\"genero\": \"Hombre\""
		+ "}\"";
        Mockito.when(superHeroesService.update(
                        Mockito.any(SuperHeroeDTO.class))).thenReturn(superHeroeDTO);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/superheroes")
                .accept(MediaType.APPLICATION_JSON).content(superHeroeJSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }
}