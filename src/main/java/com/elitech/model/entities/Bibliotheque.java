package com.elitech.model.entities;

import java.util.List;

import com.elitech.model.AuditModel;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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

public class Bibliotheque extends AuditModel {
private String nom;
private String lieu;
@ManyToMany(mappedBy = "bibliotheques")
private List<Livre> livres;
}
