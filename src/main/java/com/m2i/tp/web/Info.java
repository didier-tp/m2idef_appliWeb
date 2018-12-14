package com.m2i.tp.web;

public class Info {
	private String titre;
	private String texte;
	//+les constructeurs
	//+toString()
	//+get/set
	public Info(String titre, String texte) {
		super();
		this.titre = titre;
		this.texte = texte;
	}
	
	public Info() {
		super();
	}
	
	@Override
	public String toString() {
		return "Info [titre=" + titre + ", texte=" + texte + "]";
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	
	
}
