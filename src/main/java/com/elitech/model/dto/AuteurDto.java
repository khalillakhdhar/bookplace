package com.elitech.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class AuteurDto extends BaseDto{
@NotBlank(message = "le nom est obligatoire")
@Pattern(regexp = "^[A-Za-zéçà '\\s]+$",message = "veuillez saisir un nom correcte")
@Size(min = 2,max = 30,message = "le nom doit comporter 2-30 caractére")
private String nom;
@NotBlank(message = "le prenom est obligatoire")
@Pattern(regexp = "^[A-Za-zéçà '\\s]+$",message = "veuillez saisir un prénom correcte")
@Size(min = 2,max = 30,message = "le prénom doit comporter 2-30 caractére")
private String prenom;
@Email(message = "veuillez saisir un email correcte")
@NotBlank(message = "email obligatoire")
private String email;
@NotBlank(message = "domaine obligatoire")
private String domaine;
@JsonIgnoreProperties("auteur")
private List<LivreDto> livres;
}
