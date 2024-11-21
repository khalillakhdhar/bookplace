package com.elitech.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elitech.model.dto.BibliothequeDto;
import com.elitech.services.BibliothequeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("biblio")
@RequiredArgsConstructor
public class BibliothequeController {
	final BibliothequeService bibliothequeService;
	@GetMapping
	public Page<BibliothequeDto> getBibliotheque(@RequestParam(required = false) String lieu,@RequestParam(required = false) String nom,Pageable pageable)
	{
	//List<Bibliotheque> findByLieuOrNom(String lieu,String nom);
		if(lieu==null && nom==null)
			return bibliothequeService.getAllBibliotheque(pageable );
	return bibliothequeService.searchByLieuOrNom(lieu, nom,pageable);
		
	}
	@PostMapping
	public BibliothequeDto addOne(@RequestBody @Valid BibliothequeDto bibliotheque)
	{
		return bibliothequeService.AddOneBibliotheque(bibliotheque);
	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable long id)
	{
	bibliothequeService.deleteOneBibliotheque(id);	

	}
	@GetMapping("/{id}")
	public BibliothequeDto findOneBib(@PathVariable long id)
	{
	return bibliothequeService.findOneBibliotheque(id);	
	}
	@PutMapping("/{idb}/{idl}")
	public BibliothequeDto assignLivre(@PathVariable long idb,@PathVariable long idl)
	{
	return bibliothequeService.assignLivre(idb, idl);

	}

}
