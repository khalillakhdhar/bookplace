package com.elitech.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elitech.model.dto.CategorieDto;

public interface CategorieService {
	public Page<CategorieDto> getAllCategorie(Pageable pageable);
	public CategorieDto AddOneCategorie(CategorieDto categorie);
	public CategorieDto findOneCategorie(long id);
	public void deleteOneCategorie(long id);
	public CategorieDto findByNom(String categorie);
}
