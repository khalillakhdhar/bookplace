package com.elitech.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elitech.model.entities.Bibliotheque;
import com.elitech.services.BibliothequeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("biblio")
@RequiredArgsConstructor
public class BibliothequeController {
	final BibliothequeService bibliothequeService;
	@GetMapping
	public List<Bibliotheque> getBibliotheque(@RequestParam(required = false) String lieu,@RequestParam(required = false) String nom)
	{
	//List<Bibliotheque> findByLieuOrNom(String lieu,String nom);
		if(lieu==null && nom==null)
			return bibliothequeService.getAllBibliotheque();
	return bibliothequeService.searchByLieuOrNom(lieu, nom);
		
	}
	@PostMapping
	public Bibliotheque addOne(@RequestBody @Valid Bibliotheque bibliotheque)
	{
		return bibliothequeService.AddOneBibliotheque(bibliotheque);
	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable long id)
	{
	bibliothequeService.deleteOneBibliotheque(id);	

	}
	@GetMapping("/{id}")
	public Bibliotheque findOneBib(@PathVariable long id)
	{
	return bibliothequeService.findOneBibliotheque(id).orElse(null);	
	}
	@PutMapping("/{idb}/{idl}")
	public Bibliotheque assignLivre(@PathVariable long idb,@PathVariable long idl)
	{
	return bibliothequeService.assignLivre(idb, idl);

	}

}
