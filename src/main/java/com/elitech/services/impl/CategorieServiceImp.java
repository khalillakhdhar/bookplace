package com.elitech.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elitech.model.entities.Categorie;
import com.elitech.repository.CategorieRepository;
import com.elitech.services.CategorieService;

import lombok.NoArgsConstructor;
@Service
@NoArgsConstructor
public class CategorieServiceImp implements CategorieService {
	@Autowired
	 CategorieRepository categorieRepository;
	
	@Override
	public List<Categorie> getAllCategorie() {
		// TODO Auto-generated method stub
		return categorieRepository.findAll();
	}

	@Override
	public Categorie AddOneCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return categorieRepository.save(categorie);
	}

	@Override
	public Optional<Categorie> findOneCategorie(long id) {
		// TODO Auto-generated method stub
		return categorieRepository.findById(id);
	}

	@Override
	public void deleteOneCategorie(long id) {
		// TODO Auto-generated method stub
		categorieRepository.deleteById(id);
	}

}
