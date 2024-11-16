package com.elitech.services.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.model.dto.CategorieDto;
import com.elitech.model.entities.Categorie;
import com.elitech.model.mappers.CategorieMapper;
import com.elitech.repository.CategorieRepository;
import com.elitech.services.CategorieService;

import lombok.NoArgsConstructor;
@Service
@NoArgsConstructor
public class CategorieServiceImp implements CategorieService {
	@Autowired
	 CategorieRepository categorieRepository;
	
	@Override
	public Page<CategorieDto> getAllCategorie(Pageable page) {
		// TODO Auto-generated method stub
		Page<Categorie> categories= categorieRepository.findAll(page);
		return categories.map(CategorieMapper::convertToDTO);
	}

	@Override
	public CategorieDto AddOneCategorie(CategorieDto categorie) {
		// TODO Auto-generated method stub
		Categorie cat =CategorieMapper.convertToEntity(categorie);
		
		 Categorie saved= categorieRepository.save(cat);
		 return CategorieMapper.convertToDTO(saved);
	}

	@Override
	public CategorieDto findOneCategorie(long id) {
		// TODO Auto-generated method stub
		if(categorieRepository.existsById(id))
		{
			CategorieMapper.convertToDTO(categorieRepository.findById(id).get());
			
		}
		return null;
	}

	@Override
	public void deleteOneCategorie(long id) {
		// TODO Auto-generated method stub
		categorieRepository.deleteById(id);
	}

	@Override
	public CategorieDto findByNom(String categorie) {
		// TODO Auto-generated method stub
		return CategorieMapper.convertToDTO(categorieRepository.findByCategorie(categorie).orElse(null));
	}

}
