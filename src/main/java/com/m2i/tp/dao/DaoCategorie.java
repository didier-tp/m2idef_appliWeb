package com.m2i.tp.dao;

import java.util.List;

import com.m2i.tp.entity.Categorie;
/**
 * DAO=Data Access Object
 */
public interface DaoCategorie {
	public List<Categorie> rechercherCategories();
	public Categorie rechercherCategorieSelonId(Long id);
	public void ajouterCategorie(Categorie p);
	public void modifierCategorie(Categorie p);
	public void supprimerCategorie(Long idCat);
}
