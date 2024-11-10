package com.elitech.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elitech.model.entities.Auteur;
import com.elitech.repository.AuteurRepository;
import com.elitech.services.AuteurService;
@Service
public class AuteurServiceimpl implements AuteurService {
	@Autowired
	 AuteurRepository auteurRepository;
	
	
	@Override
	public List<Auteur> getAllAuteur(String nom,String prenom,String domaine) {
		if(!nom.equals(null)|| !prenom.equals(null)|| !domaine.equals(null))
			return auteurRepository.findByNomOrPrenomOrDomaine(nom, prenom, domaine);
		
		
		return auteurRepository.findAll();
	}

	@Override
	public Auteur AddOneAuteur(Auteur auteur) {
		// TODO Auto-generated method stub
		return auteurRepository.save(auteur);
	}

	@Override
	public Optional<Auteur> findOneAuteur(long id) {
		// TODO Auto-generated method stub
		return auteurRepository.findById(id);
	}

	@Override
	public void deleteOneAuteur(long id) {
		// TODO Auto-generated method stub
		auteurRepository.deleteById(id);
		
	}



	@Override
	public Auteur findByEmail(String email) {
		// TODO Auto-generated method stub
		return this.auteurRepository.findByEmail(email);
	}
}
