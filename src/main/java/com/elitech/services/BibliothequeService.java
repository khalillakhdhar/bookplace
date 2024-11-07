package com.elitech.services;

import java.util.List;
import java.util.Optional;

import com.elitech.model.entities.Bibliotheque;

public interface BibliothequeService {
	public List<Bibliotheque> getAllBibliotheque();
	public Bibliotheque AddOneBibliotheque(Bibliotheque bibliotheque);
	public Optional<Bibliotheque> findOneBibliotheque(long id);
	public void deleteOneBibliotheque(long id);
}
