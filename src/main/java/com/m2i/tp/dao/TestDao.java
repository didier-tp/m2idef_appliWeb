package com.m2i.tp.dao;

public class TestDao {

	//test d'une partie invisible de l'application
	//run as , java application
	public static void main(String[] args) {
		// Classe de Test avec un main()
		// en atendant de voir JUnit plus tard
		DaoProduitJdbc daoProduit = new DaoProduitJdbc();
		System.out.println(daoProduit.rechercherProduits());
		//NB : le Dao pourra acceéder à la base de donnée Mysql 
		// que si :
		//			* mysql-connector....jar est bien configuré dans pom.xml
		//			* le serveur Mysql est démarré (avec ou sans WAMP) .
		//			* la base de donnée "baseProd" existe sur localhost
		//			* la table "produit" existe avec structure et données correctes
	}

}
