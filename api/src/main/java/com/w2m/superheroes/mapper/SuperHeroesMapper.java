package com.w2m.superheroes.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SuperHeroesMapper {
    public List select(@Param("nombre") String nombre);
}