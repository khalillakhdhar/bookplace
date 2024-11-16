package com.elitech.model.mappers;

import org.modelmapper.ModelMapper;

import com.elitech.model.dto.CategorieDto;
import com.elitech.model.entities.Categorie;

public class CategorieMapper {
	private static final ModelMapper modelMapper=new ModelMapper();
	public static CategorieDto convertToDTO(Categorie categorie)
	{
		return modelMapper.map(categorie, CategorieDto.class);
	}
	public static Categorie convertToEntity(CategorieDto categorieDto)
	{
		return modelMapper.map(categorieDto, Categorie.class);
		
	}

}
