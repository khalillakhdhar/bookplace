package com.elitech.controller;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elitech.model.dto.AuteurDto;
import com.elitech.services.AuteurService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("auteur")
public class AuteurController {
final AuteurService auteurService;
@GetMapping
	public ResponseEntity<Page<AuteurDto>> getAll(@RequestParam(required = false) String nom,@RequestParam(required = false) String prenom,@RequestParam(required = false) String domaine,Pageable pageable)
{
Page<AuteurDto> authors= auteurService.getAllAuteur(nom,prenom, domaine,pageable);
return ResponseEntity.ok(authors);
}
@PostMapping
	public ResponseEntity<AuteurDto> addOne(@RequestBody AuteurDto auteur)
	{
	AuteurDto author=auteurService.AddOneAuteur(auteur);
		return new ResponseEntity<>(author,HttpStatus.CREATED);
	}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteOne(@PathVariable long id)
{
	if(auteurService.findOneAuteur(id)==null)
		return ResponseEntity.notFound().build();
	else
	{
auteurService.deleteOneAuteur(id);
return ResponseEntity.noContent().build();
	}
}
@GetMapping("/{id}")
public ResponseEntity<AuteurDto> getOne(@PathVariable long id)
{
if(auteurService.findOneAuteur(id)==null)
	return ResponseEntity.notFound().build();
else
	return ResponseEntity.ok(auteurService.findOneAuteur(id));
}
}
