package com.m2i.tp.entity;

public class Produit {
	private Long numero;
	private String label;
	private Double prix;
	private Long ref_categorie;
	//...
	//+get/set , constructurs , toString
	
	
	public Produit(Long numero, String label, Double prix) {
		super();
		this.numero = numero;
		this.label = label;
		this.prix = prix;
	}
	
	
	public Produit() {
		super();
	}
	
	

	@Override
	public String toString() {
		return "Produit [numero=" + numero + ", label=" + label + ", prix=" + prix + ", ref_categorie=" + ref_categorie
				+ "]";
	}

	public Long getNumero() {
		return numero;
	}
	
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Long getRef_categorie() {
		return ref_categorie;
	}

	public void setRef_categorie(Long ref_categorie) {
		this.ref_categorie = ref_categorie;
	}
	
}
