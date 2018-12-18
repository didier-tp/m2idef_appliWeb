package com.m2i.tp.dao;

import com.m2i.tp.entity.Categorie;
import com.m2i.tp.entity.Produit;

public class TestDao {

	//test d'une partie invisible de l'application
	//run as , java application
	public static void main(String[] args) {
		// Classe de Test avec un main()
		// en atendant de voir JUnit plus tard
		DaoProduitJdbc daoProduit = new DaoProduitJdbc();
		Produit np = new Produit(null,"nouveau livre",10.0);
		np.setRef_categorie(2L);
		daoProduit.ajouterProduit(np);
		System.out.println(daoProduit.rechercherProduits(null));
		
		DaoCategorieJdbc daoCategorie = new DaoCategorieJdbc();
		System.out.println(daoCategorie.rechercherCategories());
		Categorie c1 = daoCategorie.rechercherCategorieSelonId(1L);
		System.out.println("categorie1=" + c1);
		c1.setLabel("fournitures de bureau");
		daoCategorie.modifierCategorie(c1);
		c1 = daoCategorie.rechercherCategorieSelonId(1L);
		System.out.println("categorie1=" + c1);
		Categorie nc = new Categorie(null,"nc");
		daoCategorie.ajouterCategorie(nc);
		System.out.println("id nc="+nc.getId());
		System.out.println(daoCategorie.rechercherCategories());
		daoCategorie.supprimerCategorie(nc.getId());
		System.out.println("-----");
		System.out.println(daoCategorie.rechercherCategories());
		
		
		
		//NB : le Dao pourra acceéder à la base de donnée Mysql 
		// que si :
		//			* mysql-connector....jar est bien configuré dans pom.xml
		//			* le serveur Mysql est démarré (avec ou sans WAMP) .
		//			* la base de donnée "baseProd" existe sur localhost
		//			* la table "produit" existe avec structure et données correctes
	}

}
