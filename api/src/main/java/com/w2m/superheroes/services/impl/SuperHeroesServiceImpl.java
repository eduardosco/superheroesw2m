package com.w2m.superheroes.services.impl;

import com.w2m.superheroes.mapper.SuperHeroesMapper;
import com.w2m.superheroes.services.SuperHeroesService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("superHeroesService")
public class SuperHeroesServiceImpl implements SuperHeroesService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SuperHeroesMapper superHeroesMapper;

    @Override
    public List select(String nombre){
        return this.superHeroesMapper.select(nombre);
    }
}