package com.elitech.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
@NotNull
@Size(min = 4,max = 6, message = "le iban est composé de 4 à 6 chiffres")
private int iban;
@NotBlank(message = "le titre ne doit pas être vide")
private String titre;
private String description;
@Positive
@NotNull
private double prix;

@JsonIgnoreProperties("livres")
private CategorieDto categorie;
@JsonIgnoreProperties("livres")

private List<BibliothequeDto> bibliotheques;

@JsonIgnoreProperties("livres")

private AuteurDto auteur;
}
