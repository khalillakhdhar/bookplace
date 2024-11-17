package com.elitech.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.model.dto.LivreDto;
import com.elitech.model.entities.Auteur;
import com.elitech.model.entities.Categorie;
import com.elitech.model.entities.Livre;
import com.elitech.model.mappers.LivreMapper;
import com.elitech.repository.AuteurRepository;
import com.elitech.repository.CategorieRepository;
import com.elitech.repository.LivreRepository;
import com.elitech.services.LivreService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class LivreServiceImpl implements LivreService {
final LivreRepository livreRepository;
final AuteurRepository auteurRepository;
final CategorieRepository categorieRepository;
	
	
	
	@Override
	public Page<LivreDto> getAllLivre(Pageable pageable) {
		// TODO Auto-generated method stub
		return livreRepository.findAll(pageable).map(LivreMapper::convertToDTO);
	}

	@Override
	public LivreDto  AddOneLivre(LivreDto livre,long categorieId) {
		Livre lv=LivreMapper.convertToEntity(livre);

		if(categorieRepository.existsById(categorieId))
		{
			Categorie cat=categorieRepository.findById(categorieId).orElse(null);
			lv.setCategorie(cat);
			return LivreMapper.convertToDTO(livreRepository.save(lv));
		}
		// TODO Auto-generated method stub
		return LivreMapper.convertToDTO(livreRepository.save(lv));
	}

	@Override
	public LivreDto findOneLivre(long id) {
		// TODO Auto-generated method stub
		return LivreMapper.convertToDTO(livreRepository.findById(id).orElse(null));
	}

	@Override
	public void deleteOneLivre(long id) {
		// TODO Auto-generated method stub
		livreRepository.deleteById(id);
	}

	@Override
	public LivreDto assignLivreToAuteur(long idLivre, long idAuteur) {
		// TODO Auto-generated method stub
		if(livreRepository.existsById(idLivre)&& auteurRepository.existsById(idAuteur))
		{
			Livre currentlivre=livreRepository.findById(idLivre).get();
			// par defaut l'auteur du livre est null
			
			Auteur auteur=auteurRepository.findById(idAuteur).get();
			currentlivre.setAuteur(auteur); // id=3 livre auteur <= null aprés auteur => currentAuteur
			
			return LivreMapper.convertToDTO(livreRepository.save(currentlivre));
		}
		
		
		return null;
	}

	@Override
	public Page<LivreDto> searchByDescriptionContent(String description,Pageable pageable) {
		// TODO Auto-generated method stub
		return livreRepository.findByDescriptionContaining(description,pageable).map(LivreMapper::convertToDTO);
	}

	@Override
	public Page<LivreDto> searchByTitre(String titre,Pageable pageable) {
		// TODO Auto-generated method stub
		return livreRepository.findByTitre(titre,pageable).map(LivreMapper::convertToDTO);
	}

	@Override
	public List<LivreDto> searchTop3() {
		// TODO Auto-generated method stub
	List<LivreDto> livres=new ArrayList<LivreDto>();
		livreRepository.findFirst3ByOrderByPrixDesc().forEach(lv->{
			livres.add(LivreMapper.convertToDTO(lv));
		});
		return livres;
	}
/*
	@Override
	public Livre assignLivreTocategorie(long idLivre, String categorie) {
		// TODO Auto-generated method stub
		if(livreRepository.existsById(idLivre))
		{
			Categorie cat=categorieRepository.findByCategorie(categorie);
			Livre livre=livreRepository.findById(idLivre).get();
			livre.setCategorie(cat);
			livreRepository.save(livre);
		}
		return null;
	}
*/
}
