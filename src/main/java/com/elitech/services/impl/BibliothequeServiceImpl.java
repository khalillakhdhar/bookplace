package com.elitech.services.impl;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.model.dto.BibliothequeDto;
import com.elitech.model.entities.Bibliotheque;
import com.elitech.model.entities.Livre;
import com.elitech.model.mappers.BibliothequeMapper;
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
	public Page<BibliothequeDto> getAllBibliotheque(Pageable pageable) {
		// TODO Auto-generated method stub
		return bibliothequeRepository.findAll(pageable).map(BibliothequeMapper::convertToDTO);
	}

	@Override
	public BibliothequeDto AddOneBibliotheque(BibliothequeDto bibliotheque) {
		// TODO Auto-generated method stub
		
		return BibliothequeMapper.convertToDTO(bibliothequeRepository.save(BibliothequeMapper.convertToEntity(bibliotheque)));
	}

	@Override
	public BibliothequeDto findOneBibliotheque(long id) {
		// TODO Auto-generated method stub
		return BibliothequeMapper.convertToDTO(bibliothequeRepository.findById(id).orElse(null));
	}

	@Override
	public void deleteOneBibliotheque(long id) {
		// TODO Auto-generated method stub
		bibliothequeRepository.deleteById(id);
		
	}

	@Override
	public BibliothequeDto assignLivre(long idBiblio, long idLivre) {
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
			return BibliothequeMapper.convertToDTO(biblio);
		}
		
		
		return null;
	}

	@Override
	public Page<BibliothequeDto> searchByLieuOrNom(String lieu, String nom,Pageable pageable) {
		// TODO Auto-generated method stub
		if(lieu.equals("")&&nom.equals(""))
		return bibliothequeRepository.findAll(pageable).map(BibliothequeMapper::convertToDTO);
		else
			return bibliothequeRepository.findByLieuOrNom(lieu, nom,pageable).map(BibliothequeMapper::convertToDTO);
	}

}
