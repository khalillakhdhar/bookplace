package com.elitech.model.entities;

import java.util.List;

import com.elitech.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Categorie extends AuditModel {

	@Column(nullable = false,unique = true)
	private String categorie;
	@OneToMany(mappedBy = "categorie")
	@JsonIgnoreProperties("categorie")
	List<Livre> livres;
}
