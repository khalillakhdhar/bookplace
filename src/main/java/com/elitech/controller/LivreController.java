package com.elitech.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.elitech.model.dto.LivreDto;
import com.elitech.services.LivreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("livre")
@RequiredArgsConstructor
public class LivreController {
final LivreService livreService; // dependency injection
@GetMapping
public Page<LivreDto> getAll(Pageable pageable)
{
return livreService.getAllLivre(pageable);	
}
@PostMapping
public LivreDto addOneLivre(@RequestBody @Valid LivreDto livre,@RequestParam(required = false) long categorieId)
// localhost:8080/livre?categorie=""
{
return livreService.AddOneLivre(livre, categorieId);	
}
@GetMapping("/{id}") 
//localhost:8080/livre/valeurid/...
public ResponseEntity<LivreDto> getOneBook(@PathVariable long id)
{
LivreDto livre=livreService.findOneLivre(id);
if(!livre.equals(null))
{
	return ResponseEntity.ok(livre);
}
else
return 	ResponseEntity.status(HttpStatus.NOT_FOUND).build();


}
@GetMapping("/desc/{description}")
public Page<LivreDto> getLivresParDescriptionLike(@PathVariable String description,Pageable pageable)
{
return livreService.searchByDescriptionContent(description,pageable);	
}
/*
 * 	public List<Livre> searchByTitre(String titre);
	public List<Livre> searchTop3();
 */
@GetMapping("/titre/{titre}")
public Page<LivreDto> searchByTitre(@PathVariable String titre,Pageable pageable)
{
return livreService.searchByTitre(titre,pageable);	
}
@GetMapping("/tops")
public List<LivreDto> findTops()
{
return livreService.searchTop3();	
}

@DeleteMapping("/{id}")
public void deleteOneLivre(@PathVariable long id)
{
livreService.deleteOneLivre(id);	
}
@PatchMapping("{idl}/{ida}")
public LivreDto assignTOauthor(@PathVariable long idl, @PathVariable long ida)
{
return 	livreService.assignLivreToAuteur(idl, ida);
}

}
