package com.elitech.controller;

import java.util.List;
import java.util.Optional;

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

import com.elitech.model.entities.Livre;
import com.elitech.services.LivreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("livre")
@RequiredArgsConstructor
public class LivreController {
final LivreService livreService; // dependency injection
@GetMapping
public List<Livre> getAll()
{
return livreService.getAllLivre();	
}
@PostMapping
public Livre addOneLivre(@RequestBody @Valid Livre livre,@RequestParam(required = false) String categorie)
{
return livreService.AddOneLivre(livre, categorie);	
}
@GetMapping("/{id}")
public ResponseEntity<Livre> getOneBook(@PathVariable long id)
{
Optional<Livre> livre=livreService.findOneLivre(id);
if(livre.isPresent())
{
	return ResponseEntity.ok(livre.get());
}
else
return 	ResponseEntity.status(HttpStatus.NOT_FOUND).build();


}
@DeleteMapping("/{id}")
public void deleteOneLivre(@PathVariable long id)
{
livreService.deleteOneLivre(id);	
}


}
