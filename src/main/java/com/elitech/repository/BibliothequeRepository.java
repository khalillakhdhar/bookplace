package com.elitech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.model.entities.Bibliotheque;

public interface BibliothequeRepository extends JpaRepository<Bibliotheque, Long> {
List<Bibliotheque> findByLieuOrNom(String lieu,String nom);
}
