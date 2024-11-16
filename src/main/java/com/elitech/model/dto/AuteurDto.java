package com.elitech.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
@NotBlank
private String nom;
@NotBlank
private String prenom;
@Email
private String email;
@NotBlank
private String domaine;
@JsonIgnoreProperties("auteur")
private List<LivreDto> livres;
}
