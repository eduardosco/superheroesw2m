package com.w2m.superheroes.services;

import com.w2m.superheroes.dto.SuperHeroeDTO;

import java.util.List;

public interface SuperHeroesService {
    public List select(String id, String nombre);
    public String delete(String id);
    public String update(SuperHeroeDTO superHeroeDTO);
}
