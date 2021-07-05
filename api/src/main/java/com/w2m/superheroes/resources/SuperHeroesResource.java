package com.w2m.superheroes.resources;

import com.w2m.superheroes.services.SuperHeroesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/superheroes")
public class SuperHeroesResource {

    @Autowired
    SuperHeroesService superHeroesService; 

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List select(@RequestParam(required=false) String partNombre){
        return this.superHeroesService.select(partNombre);
    }
}