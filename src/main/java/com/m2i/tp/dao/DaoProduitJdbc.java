package com.m2i.tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.m2i.tp.entity.Produit;

public class DaoProduitJdbc implements DaoProduit {
	
	
	public List<Produit> rechercherProduits(Long numCategorie) {
		List<Produit> listeProduits = new ArrayList<Produit>();
		Connection cn = MyJdbcUtil.seConnecter();
		ResultSet rs = null;
		try {  Statement st = cn.createStatement();
			  String reqSql = "SELECT * FROM produit";
			  if(numCategorie!=null)
				  reqSql += (" WHERE ref_categorie="+numCategorie);
			 rs = st.executeQuery(reqSql);
			while(rs.next()) {
				Produit produit = new Produit();
				produit.setNumero(rs.getLong("numero"));
				produit.setLabel(rs.getString("label"));
				produit.setPrix(rs.getDouble("prix"));
				produit.setRef_categorie(rs.getLong("ref_categorie"));
				listeProduits.add(produit);
			}
			rs.close();	st.close();//fermetures dans l'ordre inverse des ouvertures
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeCn(cn);
		}
		return listeProduits;
	}
	
	
	
	public void ajouterProduit(Produit p) {
		Connection cn = MyJdbcUtil.seConnecter();
		try {  
			String reqSql = 
					/*"INSERT INTO produit(numero,label,prix) VALUES("
						  + p.getNumero() + ",'" + p.getLabel()+"',"
						  + p.getPrix()+")";pas bien*/
				    "INSERT INTO produit(label,prix,ref_categorie) VALUES(?,?,?)";
			PreparedStatement pst = cn.prepareStatement(reqSql,
					                      Statement.RETURN_GENERATED_KEYS);
			//pst.setLong(1, p.getNumero());//1,2 et 3 sont les positions
			pst.setString(1, p.getLabel());//des ? dans la requête
			pst.setDouble(2, p.getPrix()); // à remplacer par des valeurs
			pst.setDouble(3, p.getRef_categorie()); 
			pst.executeUpdate();
			p.setNumero(MyJdbcUtil.getAutoIncrPk(pst));//nécessite auto_increment (mysql)
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeCn(cn);
		}
	}
	
	

}
