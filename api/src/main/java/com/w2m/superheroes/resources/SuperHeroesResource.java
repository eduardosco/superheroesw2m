package com.w2m.superheroes.resources;

import com.w2m.superheroes.dto.SuperHeroeDTO;

import com.w2m.superheroes.services.SuperHeroesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.w2m.superheroes.advice.TrackExecutionTime;

@RestController
@RequestMapping("/superheroes")
public class SuperHeroesResource {

    @Autowired
    private SuperHeroesService superHeroesService; 

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @TrackExecutionTime
    public List select(
		@RequestParam(required=false) String id,
    	@RequestParam(required=false) String partNombre){
        return this.superHeroesService.select(id, partNombre);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @TrackExecutionTime
    public String update(@RequestBody SuperHeroeDTO superHeroeDTO){
        return this.superHeroesService.update(superHeroeDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    @TrackExecutionTime
    public String delete(@PathVariable Integer id){
        return this.superHeroesService.delete(id);
    }
}