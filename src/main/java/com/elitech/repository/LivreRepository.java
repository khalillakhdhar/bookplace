package com.elitech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.model.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long> {
List<Livre> findByDescriptionContaining(String description);

List<Livre> findByTitre(String titre);
List<Livre> findFirst3ByOrderByPrixDesc();
}
