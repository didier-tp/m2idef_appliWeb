package com.m2i.tp.web;

import com.m2i.tp.entity.Produit;

//Selection de produit pour structurer le caddy
public class Selection {
	private Produit produit; //référence vers produit choisi
	private Integer quantite;//quantité choisie
	//+get/set , constructeurs , toString()
	
	public Selection() {
		super();
	}
	
	public Selection(Produit produit, Integer quantite) {
		super();
		this.produit = produit;
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Selection [produit=" + produit + ", quantite=" + quantite + "]";
	}
	
	public Produit getProduit() {
		return produit;
	}
	
	
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
}
