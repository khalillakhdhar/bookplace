package com.elitech.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.model.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long> {
Page<Livre> findByDescriptionContaining(String description,Pageable pageable);

Page<Livre> findByTitre(String titre,Pageable pageable);
List<Livre> findFirst3ByOrderByPrixDesc();
}
