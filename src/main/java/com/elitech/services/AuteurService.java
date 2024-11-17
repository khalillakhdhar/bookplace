package com.elitech.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elitech.model.dto.AuteurDto;

public interface AuteurService {
	public Page<AuteurDto> getAllAuteur(String nom,String prenom,String domaine,Pageable pageable);
	public AuteurDto AddOneAuteur(AuteurDto auteur);
	public AuteurDto findOneAuteur(long id);
	public void deleteOneAuteur(long id);
	public AuteurDto findByEmail(String email);

}
