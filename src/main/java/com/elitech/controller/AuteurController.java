package com.elitech.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elitech.model.entities.Auteur;
import com.elitech.services.AuteurService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("auteur")
public class AuteurController {
final AuteurService auteurService;
@GetMapping
	public List<Auteur> getAll(@RequestParam(required = false) String nom,@RequestParam(required = false) String prenom,@RequestParam(required = false) String domaine)
{
return auteurService.getAllAuteur(nom,prenom, domaine);
}
@PostMapping
	public Auteur addOne(@RequestBody Auteur auteur)
	{
		return auteurService.AddOneAuteur(auteur);
	}
@DeleteMapping("/{id}")
public void deleteOne(@PathVariable long id)
{
auteurService.deleteOneAuteur(id);	
}
}
