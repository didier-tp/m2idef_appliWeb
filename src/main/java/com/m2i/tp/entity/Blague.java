package com.m2i.tp.entity;

public class Blague {
	private Long id;
	private String titre;
	private String texte;
	private Double note; //noteMoyenne
	private Integer nbVotes;
	
	
	
	@Override
	public String toString() {
		return "Blague [id=" + id + ", titre=" + titre + ", texte=" + texte + ", note=" + note + ", nbVotes=" + nbVotes
				+ "]";
	}
	public Blague() {
		super();
	}
	public Blague(Long id, String titre, String texte, Double note, Integer nbVotes) {
		super();
		this.id = id;
		this.titre = titre;
		this.texte = texte;
		this.note = note;
		this.nbVotes = nbVotes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Double getNote() {
		return note;
	}
	public void setNote(Double note) {
		this.note = note;
	}
	public Integer getNbVotes() {
		return nbVotes;
	}
	public void setNbVotes(Integer nbVotes) {
		this.nbVotes = nbVotes;
	}
	
	
	
	
	

}
