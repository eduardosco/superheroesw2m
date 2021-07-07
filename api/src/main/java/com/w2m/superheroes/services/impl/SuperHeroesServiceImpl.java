package com.w2m.superheroes.services.impl;

import com.w2m.superheroes.dto.SuperHeroeDTO;
import com.w2m.superheroes.mapper.SuperHeroesMapper;
import com.w2m.superheroes.services.SuperHeroesService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

@Service("superHeroesService")
public class SuperHeroesServiceImpl implements SuperHeroesService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SuperHeroesMapper superHeroesMapper;

    @Override
    @Cacheable(cacheNames="headers")
    public List select(String id, String nombre){
        return this.superHeroesMapper.select(id, nombre);
    }

    @Override
    @Cacheable(cacheNames="headers")
    public String delete(Integer id){
    	this.superHeroesMapper.delete(id);
    	return "Success";
    }

    @Override
    @Cacheable(cacheNames="headers")
	public String update(SuperHeroeDTO superHeroeDTO){
		this.superHeroesMapper.update(superHeroeDTO);
		return "Success";
	}
}