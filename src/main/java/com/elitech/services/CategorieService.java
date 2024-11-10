package com.elitech.services;

import java.util.List;
import java.util.Optional;

import com.elitech.model.entities.Categorie;

public interface CategorieService {
	public List<Categorie> getAllCategorie();
	public Categorie AddOneCategorie(Categorie categorie);
	public Optional<Categorie> findOneCategorie(long id);
	public void deleteOneCategorie(long id);
	public Categorie findByNom(String categorie);
}
