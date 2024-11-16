package com.elitech.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
public Livre addOneLivre(@RequestBody @Valid Livre livre,@RequestParam(required = false) long categorieId)
// localhost:8080/livre?categorie=""
{
return livreService.AddOneLivre(livre, categorieId);	
}
@GetMapping("/{id}") 
//localhost:8080/livre/valeurid/...
public ResponseEntity<Livre> getOneBook(@PathVariable long id)
{
Livre livre=livreService.findOneLivre(id).orElse(null);
if(!livre.equals(null))
{
	return ResponseEntity.ok(livre);
}
else
return 	ResponseEntity.status(HttpStatus.NOT_FOUND).build();


}
@GetMapping("/desc/{description}")
public List<Livre> getLivresParDescriptionLike(@PathVariable String description)
{
return livreService.searchByDescriptionContent(description);	
}
/*
 * 	public List<Livre> searchByTitre(String titre);
	public List<Livre> searchTop3();
 */
@GetMapping("/titre/{titre}")
public List<Livre> searchByTitre(@PathVariable String titre)
{
return livreService.searchByTitre(titre);	
}
@GetMapping("/tops")
public List<Livre> findTops()
{
return livreService.searchTop3();	
}

@DeleteMapping("/{id}")
public void deleteOneLivre(@PathVariable long id)
{
livreService.deleteOneLivre(id);	
}
@PatchMapping("{idl}/{ida}")
public Livre assignTOauthor(@PathVariable long idl, @PathVariable long ida)
{
return 	livreService.assignLivreToAuteur(idl, ida);
}

}
