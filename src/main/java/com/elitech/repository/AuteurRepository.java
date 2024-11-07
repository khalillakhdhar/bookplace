package com.elitech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.model.entities.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {
List<Auteur> findByNomOrPrenomOrDomaine(String nom,String prenom,String domaine);
List<Auteur> findByEmail(String email);

}
