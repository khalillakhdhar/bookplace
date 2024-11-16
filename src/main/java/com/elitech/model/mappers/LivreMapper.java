package com.elitech.model.mappers;

import org.modelmapper.ModelMapper;

import com.elitech.model.dto.LivreDto;
import com.elitech.model.entities.Livre;

public class LivreMapper {
	private static final ModelMapper modelMapper=new ModelMapper();
	public static LivreDto convertToDTO(Livre livre)
	{
		return modelMapper.map(livre, LivreDto.class);
	}
	public static Livre convertToEntity(LivreDto livreDto)
	{
		return modelMapper.map(livreDto, Livre.class);
		
	}
}
