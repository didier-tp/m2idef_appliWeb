package com.m2i.tp.dao;

public class TestDao {

	//test d'une partie invisible de l'application
	//run as , java application
	public static void main(String[] args) {
		// Classe de Test avec un main()
		// en atendant de voir JUnit plus tard
		DaoProduitJdbc daoProduit = new DaoProduitJdbc();
		System.out.println(daoProduit.rechercherProduits());
	}

}
