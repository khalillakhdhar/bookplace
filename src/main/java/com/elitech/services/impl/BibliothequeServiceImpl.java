package com.elitech.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elitech.model.entities.Bibliotheque;
import com.elitech.model.entities.Livre;
import com.elitech.repository.BibliothequeRepository;
import com.elitech.repository.LivreRepository;
import com.elitech.services.BibliothequeService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BibliothequeServiceImpl implements BibliothequeService{
	
	final BibliothequeRepository bibliothequeRepository;
	final LivreRepository livreRepository;
	
	
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

	@Override
	public Bibliotheque assignLivre(long idBiblio, long idLivre) {
		// TODO Auto-generated method stub
		if(bibliothequeRepository.existsById(idBiblio)&&livreRepository.existsById(idLivre))
		{
			Bibliotheque biblio=bibliothequeRepository.findById(idBiblio).get();
			Livre livre=livreRepository.findById(idLivre).get();
			List<Livre> lv=biblio.getLivres();
			lv.add(livre);
			biblio.setLivres(lv);
			bibliothequeRepository.save(biblio);
			livre.getBibliotheques().add(biblio);
			livreRepository.save(livre);
			return biblio;
		}
		
		
		return null;
	}

	@Override
	public List<Bibliotheque> searchByLieuOrNom(String lieu, String nom) {
		// TODO Auto-generated method stub
		if(lieu.equals("")&&nom.equals(""))
		return bibliothequeRepository.findAll();
		else
			return bibliothequeRepository.findByLieuOrNom(lieu, nom);
	}

}
