package com.elitech.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.model.entities.Bibliotheque;

public interface BibliothequeRepository extends JpaRepository<Bibliotheque, Long> {
Page<Bibliotheque> findByLieuOrNom(String lieu,String nom,Pageable page);
}
