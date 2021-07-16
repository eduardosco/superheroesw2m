package com.w2m.superheroes.services.impl;

import com.w2m.superheroes.dto.SuperHeroeDTO;
import com.w2m.superheroes.exceptions.InvalidParameterException;
import com.w2m.superheroes.mapper.SuperHeroesMapper;
import com.w2m.superheroes.services.SuperHeroesService;

import java.lang.NumberFormatException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

import java.sql.BatchUpdateException;

@Service("superHeroesService")
public class SuperHeroesServiceImpl implements SuperHeroesService {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SuperHeroesMapper superHeroesMapper;

	//Este es el unico servicio que es cacheable ya que es el unico que devuelve datos.
	@Override
	@Cacheable(cacheNames="headers")
	public List select(String id, String nombre) throws InvalidParameterException {
	    if(id!=null){
	    	try {
	    		Integer.parseInt(id);
	    	} catch (NumberFormatException e) { 
				throw new InvalidParameterException("El parametro id debe de ser numerico");
		    }
	    }
		return this.superHeroesMapper.select(id, nombre);
	}

	@Override
	public String delete(String id) throws InvalidParameterException {
	    try { 
			this.superHeroesMapper.delete(Integer.parseInt(id));
			return null;
	    } catch (NumberFormatException e) { 
			throw new InvalidParameterException("El parametro id debe de ser numerico");
	    } catch (NullPointerException e) {
			throw new InvalidParameterException("El parametro id es requerido");
	    }
	}

	@Override
	public String update(SuperHeroeDTO superHeroeDTO) throws InvalidParameterException {
		if(superHeroeDTO.getId()==null){
			throw new InvalidParameterException("El parametro id es requerido");
		}
		if((superHeroeDTO.getNombre()==null||"".equals(superHeroeDTO.getNombre()))&&
			(superHeroeDTO.getGenero()==null||"".equals(superHeroeDTO.getGenero()))){
			throw new InvalidParameterException("Es requerido al menos uno de los parametros [Nombre y/o Genero] para poder editar un registro.");
		}
		if(superHeroeDTO.getNombre()!=null&&!"".equals(superHeroeDTO.getNombre())){
			if(this.superHeroesMapper.select(null, superHeroeDTO.getNombre()).size()>0){
				throw new InvalidParameterException("El parametro Nombre ya se encuentra en uso.");
			}
		}
		this.superHeroesMapper.update(superHeroeDTO);
		return null;
	}
}