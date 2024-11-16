package com.elitech.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LivreDto extends BaseDto{

private int iban;

private String titre;
private String description;

private double prix;

@JsonIgnoreProperties("livres")
private CategorieDto categorie;

private List<BibliothequeDto> bibliotheques;

@JsonIgnoreProperties("livres")

private AuteurDto auteur;
}
