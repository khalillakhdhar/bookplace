package com.elitech.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elitech.model.entities.Categorie;
import com.elitech.services.CategorieService;
import com.elitech.services.LivreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("categorie")
@RequiredArgsConstructor
public class CategorieController {
final CategorieService categorieService;
@GetMapping
public List<Categorie> getAllCategories()
{
return categorieService.getAllCategorie();

}
@PostMapping
public Categorie addOneCategorie(@RequestBody @Valid Categorie categorie)
{
return categorieService.AddOneCategorie(categorie);	
}
@DeleteMapping("/{id}")
public void deleteMapping(@PathVariable long id)
{
categorieService.deleteOneCategorie(id);	
}
@GetMapping("/{id}")
public Categorie getOne(@PathVariable long id)
{
return categorieService.findOneCategorie(id).orElse(null);

}
@GetMapping("/nom/{nom}")
public Categorie getByNom(@PathVariable String nom)
{
return categorieService.findByNom(nom);	
}

}

