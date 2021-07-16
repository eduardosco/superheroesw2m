package com.w2m.superheroes.resources;

import com.w2m.superheroes.advice.TrackExecutionTime;

import com.w2m.superheroes.dto.ResponseDTO;
import com.w2m.superheroes.dto.SuperHeroeDTO;

import com.w2m.superheroes.exceptions.InvalidParameterException;

import com.w2m.superheroes.services.SuperHeroesService;

import com.w2m.superheroes.utils.ResponseDispatcher;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/superheroes")
@Api(value = "Esta aplicación provee herramientas basicas para la gestión de superheroes",
    description = "Esta aplicación tiene la capacidad de gestionar superheroes de una base de datos H2",
    produces = "application/json;charset=UTF-8")
public class SuperHeroesResource {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SuperHeroesService superHeroesService; 

    @ApiOperation(value = "Obtener superheroes",
        produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @TrackExecutionTime
    public <T> ResponseEntity<ResponseDTO<T>> select(
		@RequestParam(required=false) String id,
    	@RequestParam(required=false) String partNombre) throws InvalidParameterException {
        this.LOGGER.info("Se inicia el servicio de consulta de superheroes");
        return new ResponseDispatcher<T>().setResponseOkWithBodyHeader((T) this.superHeroesService.select(id, partNombre));
    }

    @ApiOperation(value = "Actualizar un superheroe", produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @TrackExecutionTime
    public <T> ResponseEntity<ResponseDTO<T>> update(@RequestBody SuperHeroeDTO superHeroeDTO) throws InvalidParameterException {
        this.LOGGER.info("Se inicia el servicio de actualización de superheroes");
        return new ResponseDispatcher<T>().setResponseOkWithBodyHeader((T) this.superHeroesService.update(superHeroeDTO));
    }

    @ApiOperation(value = "Borrar un superheroe por ID", produces = "application/json;charset=UTF-8")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    @TrackExecutionTime
    public <T> ResponseEntity<ResponseDTO<T>> delete(@PathVariable String id) throws InvalidParameterException {
        this.LOGGER.info("Se inicia el servicio de inserción de superheroes");
        return new ResponseDispatcher<T>().setResponseOkWithBodyHeader((T) this.superHeroesService.delete(id));
    }
}