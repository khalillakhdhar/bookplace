package com.elitech.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elitech.model.entities.Livre;
import com.elitech.repository.LivreRepository;
import com.elitech.services.LivreService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class LivreServiceImpl implements LivreService {
final LivreRepository livreRepository;
	
	
	
	@Override
	public List<Livre> getAllLivre() {
		// TODO Auto-generated method stub
		return livreRepository.findAll();
	}

	@Override
	public Livre AddOneLivre(Livre livre) {
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

}
