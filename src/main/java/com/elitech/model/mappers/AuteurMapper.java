package com.elitech.model.mappers;

import org.modelmapper.ModelMapper;

import com.elitech.model.dto.AuteurDto;
import com.elitech.model.entities.Auteur;

public class AuteurMapper {

	private static final ModelMapper modelMapper=new ModelMapper();
	public static AuteurDto convertToDTO(Auteur auteur)
	{
		return modelMapper.map(auteur, AuteurDto.class);
	}
	public static Auteur convertToEntity(AuteurDto auteurDto)
	{
		return modelMapper.map(auteurDto, Auteur.class);
		
	}
	
	
}
