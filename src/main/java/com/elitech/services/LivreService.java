package com.elitech.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elitech.model.dto.LivreDto;

public interface LivreService {
	
	public Page<LivreDto> getAllLivre(Pageable pageable);
	public LivreDto AddOneLivre(LivreDto livre,long categorieId);
	public LivreDto findOneLivre(long id);
	public void deleteOneLivre(long id);
	public LivreDto assignLivreToAuteur(long idLivre,long idAuteur);

	public Page<LivreDto> searchByDescriptionContent(String description,Pageable pageable);
	public Page<LivreDto> searchByTitre(String titre,Pageable pageable);
	public List<LivreDto> searchTop3();

}
