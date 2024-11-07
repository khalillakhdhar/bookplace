package com.elitech.model.entities;

import java.util.List;

import com.elitech.model.AuditModel;

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

public class Auteur extends AuditModel{
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
	private String domaine;
	@OneToMany(mappedBy = "auteur")
	private List<Livre> livres;
	

}
