package com.elitech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.model.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
List<Categorie> findByCategorie(String categorie);
}
