package com.elitech.services.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.model.dto.AuteurDto;
import com.elitech.model.entities.Auteur;
import com.elitech.model.mappers.AuteurMapper;
import com.elitech.repository.AuteurRepository;
import com.elitech.services.AuteurService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AuteurServiceimpl implements AuteurService {
	
	final AuteurRepository auteurRepository;
	
	
	@Override
	public Page<AuteurDto> getAllAuteur(String nom,String prenom,String domaine,Pageable pageable) {
		if(!nom.equals("")|| !prenom.equals("")|| !domaine.equals(""))
		{
			
			Page<Auteur> authors= auteurRepository.findByNomOrPrenomOrDomaine(nom, prenom, domaine,pageable);
			return authors.map(AuteurMapper::convertToDTO);
		}
		
		
		
		return auteurRepository.findAll(pageable).map(AuteurMapper::convertToDTO);
	}

	@Override
	public AuteurDto AddOneAuteur(AuteurDto auteur) {
		// TODO Auto-generated method stub
		return AuteurMapper.convertToDTO(auteurRepository.save(AuteurMapper.convertToEntity(auteur)));
	}

	@Override
	public AuteurDto findOneAuteur(long id) {
		// TODO Auto-generated method stub
		return AuteurMapper.convertToDTO(auteurRepository.findById(id).get());
	}

	@Override
	public void deleteOneAuteur(long id) {
		// TODO Auto-generated method stub
		auteurRepository.deleteById(id);
		
	}



	@Override
	public AuteurDto findByEmail(String email) {
		// TODO Auto-generated method stub
		return AuteurMapper.convertToDTO(this.auteurRepository.findByEmail(email));
	}
}
