package com.w2m.superheroes.dto;

public class SuperHeroeDTO {

    private Integer id;
    private String nombre;
    private String genero;

    public Integer getId(){
    	return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre(){
    	return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero(){
    	return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}