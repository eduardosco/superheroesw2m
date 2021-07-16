package com.w2m.superheroes.services;

import com.w2m.superheroes.dto.SuperHeroeDTO;
import com.w2m.superheroes.exceptions.InvalidParameterException;

import java.util.List;

public interface SuperHeroesService {
    public List select(String id, String nombre) throws InvalidParameterException;
    public String delete(String id) throws InvalidParameterException;
    public String update(SuperHeroeDTO superHeroeDTO) throws InvalidParameterException;
}
