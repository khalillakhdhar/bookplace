package com.elitech.services;

import java.util.List;
import java.util.Optional;

import com.elitech.model.entities.Livre;

public interface LivreService {
	
	public List<Livre> getAllLivre();
	public Livre AddOneLivre(Livre livre,String categorie);
	public Optional<Livre> findOneLivre(long id);
	public void deleteOneLivre(long id);
	public Livre assignLivreToAuteur(long idLivre,long idAuteur);

	public List<Livre> searchByDescriptionContent(String description);
	public List<Livre> searchByTitre(String titre);
	public List<Livre> searchTop3();

}
