package com.elitech.model.mappers;

import org.modelmapper.ModelMapper;

import com.elitech.model.dto.BibliothequeDto;
import com.elitech.model.entities.Bibliotheque;

public class BibliothequeMapper {
	private static final ModelMapper modelMapper=new ModelMapper();
	public static BibliothequeDto convertToDTO(Bibliotheque bibliotheque)
	{
		return modelMapper.map(bibliotheque, BibliothequeDto.class);
	}
	public static Bibliotheque convertToEntity(BibliothequeDto bibliothequeDto)
	{
		return modelMapper.map(bibliothequeDto, Bibliotheque.class);
		
	}
}
