package com.elitech.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elitech.model.entities.Auteur;
import com.elitech.model.entities.Categorie;
import com.elitech.model.entities.Livre;
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
	public List<Livre> getAllLivre() {
		// TODO Auto-generated method stub
		return livreRepository.findAll();
	}

	@Override
	public Livre AddOneLivre(Livre livre,String categorie) {
		if(categorieRepository.findByCategorie(categorie)!=null)
		{
			Categorie cat=categorieRepository.findByCategorie(categorie).orElse(null);
			livre.setCategorie(cat);
		}
		// TODO Auto-generated method stub
		return livreRepository.save(livre);
	}

	@Override
	public Optional<Livre> findOneLivre(long id) {
		// TODO Auto-generated method stub
		return livreRepository.findById(id);
	}

	@Override
	public void deleteOneLivre(long id) {
		// TODO Auto-generated method stub
		livreRepository.deleteById(id);
	}

	@Override
	public Livre assignLivreToAuteur(long idLivre, long idAuteur) {
		// TODO Auto-generated method stub
		if(livreRepository.existsById(idLivre)&& auteurRepository.existsById(idAuteur))
		{
			Livre currentlivre=livreRepository.findById(idLivre).get();
			// par defaut l'auteur du livre est null
			
			Auteur auteur=auteurRepository.findById(idAuteur).get();
			currentlivre.setAuteur(auteur); // id=3 livre auteur <= null aprés auteur => currentAuteur
			
			livreRepository.save(currentlivre);
		}
		
		
		return null;
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
