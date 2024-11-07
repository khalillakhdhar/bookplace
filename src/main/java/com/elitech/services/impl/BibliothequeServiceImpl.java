package com.elitech.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elitech.model.entities.Bibliotheque;
import com.elitech.repository.BibliothequeRepository;
import com.elitech.services.BibliothequeService;


@Service

public class BibliothequeServiceImpl implements BibliothequeService{
	@Autowired
	 BibliothequeRepository bibliothequeRepository;
	
	
	@Override
	public List<Bibliotheque> getAllBibliotheque() {
		// TODO Auto-generated method stub
		return bibliothequeRepository.findAll();
	}

	@Override
	public Bibliotheque AddOneBibliotheque(Bibliotheque bibliotheque) {
		// TODO Auto-generated method stub
		return bibliothequeRepository.save(bibliotheque);
	}

	@Override
	public Optional<Bibliotheque> findOneBibliotheque(long id) {
		// TODO Auto-generated method stub
		return bibliothequeRepository.findById(id);
	}

	@Override
	public void deleteOneBibliotheque(long id) {
		// TODO Auto-generated method stub
		bibliothequeRepository.deleteById(id);
		
	}

}
