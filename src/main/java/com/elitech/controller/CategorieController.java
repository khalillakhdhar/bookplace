package com.elitech.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elitech.model.dto.CategorieDto;
import com.elitech.services.CategorieService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("categorie")
@RequiredArgsConstructor
public class CategorieController {
final CategorieService categorieService;
@GetMapping
public Page<CategorieDto> getAllCategories(Pageable pageable)
{
return categorieService.getAllCategorie(pageable);

}
@PostMapping
public CategorieDto addOneCategorie(@RequestBody @Valid CategorieDto categorie)
{
return categorieService.AddOneCategorie(categorie);	
}
@DeleteMapping("/{id}")
public void deleteMapping(@PathVariable long id)
{
categorieService.deleteOneCategorie(id);	
}
@GetMapping("/{id}")
public CategorieDto getOne(@PathVariable long id)
{
return categorieService.findOneCategorie(id);

}
@GetMapping("/nom/{nom}")
public CategorieDto getByNom(@PathVariable String nom)
{
return categorieService.findByNom(nom);	
}

}

