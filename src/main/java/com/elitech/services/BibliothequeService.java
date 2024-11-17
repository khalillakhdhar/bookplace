package com.elitech.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elitech.model.dto.BibliothequeDto;

public interface BibliothequeService {
	public Page<BibliothequeDto> getAllBibliotheque(Pageable pageable);
	public BibliothequeDto AddOneBibliotheque(BibliothequeDto bibliotheque);
	public BibliothequeDto findOneBibliotheque(long id);
	public void deleteOneBibliotheque(long id);
	public BibliothequeDto assignLivre(long idBiblio,long idLivre);
	//List<Bibliotheque> findByLieuOrNom(String lieu,String nom);
	public Page<BibliothequeDto> searchByLieuOrNom(String lieu,String nom,Pageable pageable);
}
