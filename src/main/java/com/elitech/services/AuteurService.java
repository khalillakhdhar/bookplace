package com.elitech.services;

import java.util.List;
import java.util.Optional;

import com.elitech.model.entities.Auteur;

public interface AuteurService {
	public List<Auteur> getAllAuteur(String nom,String prenom,String domaine);
	public Auteur AddOneAuteur(Auteur auteur);
	public Optional<Auteur> findOneAuteur(long id);
	public void deleteOneAuteur(long id);
	public Auteur findByEmail(String email);

}
