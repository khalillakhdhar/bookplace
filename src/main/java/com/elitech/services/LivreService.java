package com.elitech.services;

import java.util.List;
import java.util.Optional;

import com.elitech.model.entities.Livre;

public interface LivreService {
	public List<Livre> getAllLivre();
	public Livre AddOneLivre(Livre livre);
	public Optional<Livre> findOneLivre(long id);
	public void deleteOneLivre(long id);
}
