package com.m2i.tp.dao;

import java.util.List;

import com.m2i.tp.entity.Blague;
/**
 * DAO=Data Access Object
 */
public interface DaoBlague {
	public List<Blague> rechercherBlagues();
	public Blague rechercherBlagueSelonId(Long id);
	public void ajouterBlague(Blague b);
	public void modifierBlague(Blague b);
	public void supprimerBlague(Long idB);
}
