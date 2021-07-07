package com.w2m.superheroes.mapper;

import com.w2m.superheroes.dto.SuperHeroeDTO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SuperHeroesMapper {
    public List select(
    	@Param("id") String id,
    	@Param("nombre") String nombre);
    public void update(@Param("dto") SuperHeroeDTO superHeroeDTO);
    public void delete(@Param("id") Integer id);
}