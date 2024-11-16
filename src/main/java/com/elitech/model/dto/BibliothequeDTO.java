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
public class BibliothequeDto extends BaseDto {
	private String nom;
	private String lieu;
	@JsonIgnoreProperties("bibliotheques")
	public List<LivreDto> livres;
}
