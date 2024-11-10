package com.elitech.model.entities;

import java.util.List;

import com.elitech.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

public class Livre extends AuditModel {
@Column(nullable = false)
private int iban;
@Column(nullable = false)
private String titre;
private String description;
@Column(nullable = false)
private double prix;
@ManyToOne(optional = false)
@JsonIgnoreProperties("livres")
private Categorie categorie;
@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
@JsonIgnoreProperties("livres")

private List<Bibliotheque> bibliotheques;
@ManyToOne(optional = true)
@JsonIgnoreProperties("livres")

private Auteur auteur;
}
