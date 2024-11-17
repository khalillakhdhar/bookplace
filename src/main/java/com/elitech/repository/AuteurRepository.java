package com.elitech.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.model.entities.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {
Page<Auteur> findByNomOrPrenomOrDomaine(String nom,String prenom,String domaine,Pageable page);
Auteur findByEmail(String email);

}
