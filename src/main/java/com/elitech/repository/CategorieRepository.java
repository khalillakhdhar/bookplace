package com.elitech.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.model.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
Optional<Categorie> findByCategorie(String categorie);
}
