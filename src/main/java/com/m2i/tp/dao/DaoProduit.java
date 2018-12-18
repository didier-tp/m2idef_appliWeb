package com.m2i.tp.dao;

import java.util.List;

import com.m2i.tp.entity.Produit;
/**
 * DAO=Data Access Object
 */
public interface DaoProduit {
	public List<Produit> rechercherProduits(Long numCategorie);
	public void ajouterProduit(Produit p);
	//...
	
}
