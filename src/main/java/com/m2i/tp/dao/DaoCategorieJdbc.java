package com.m2i.tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.m2i.tp.entity.Categorie;

public class DaoCategorieJdbc implements DaoCategorie {

	@Override
	public List<Categorie> rechercherCategories() {
		List<Categorie> listeCategories = new ArrayList<Categorie>();
		Connection cn = MyJdbcUtil.seConnecter();
		ResultSet rs = null;
		try {  Statement st = cn.createStatement();
			  String reqSql = "SELECT * FROM Categorie";
			 rs = st.executeQuery(reqSql);
			while(rs.next()) {
				Categorie categorie = new Categorie();
				categorie.setId(rs.getLong("id"));
				categorie.setLabel(rs.getString("label"));
				listeCategories.add(categorie);
			}
			rs.close();	st.close();//fermetures dans l'ordre inverse des ouvertures
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeCn(cn);
		}
		return listeCategories;
	}

	@Override
	public void ajouterCategorie(Categorie p) {
		Connection cn = MyJdbcUtil.seConnecter();
		try {  
			String reqSql = 
				    "INSERT INTO Categorie(label) VALUES(?)";
			PreparedStatement pst = cn.prepareStatement(reqSql,
					                      Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, p.getLabel());//des ? dans la requête
			pst.executeUpdate();
			p.setId(MyJdbcUtil.getAutoIncrPk(pst));//nécessite auto_increment (mysql)
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeCn(cn);
		}
	}

	@Override
	public Categorie rechercherCategorieSelonId(Long id) {
		Categorie categorie = null;
		Connection cn = MyJdbcUtil.seConnecter();
		ResultSet rs = null;
		try {  
			  String reqSql = "SELECT * FROM Categorie WHERE id=?";
			  PreparedStatement pst = cn.prepareStatement(reqSql);
			  pst.setLong(1, id);
			 rs = pst.executeQuery();
			if(rs.next()) {
				categorie = new Categorie();
				categorie.setId(rs.getLong("id"));
				categorie.setLabel(rs.getString("label"));
			}
			rs.close();	pst.close();//fermetures dans l'ordre inverse des ouvertures
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeCn(cn);
		}
		return categorie;
	}

	@Override
	public void modifierCategorie(Categorie p) {
		Connection cn = MyJdbcUtil.seConnecter();
		try {  
			String reqSql = 
				    "UPDATE Categorie SET label=? WHERE id=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);
			pst.setString(1, p.getLabel());//des ? dans la requête
			pst.setLong(2, p.getId());//des ? dans la requête
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeCn(cn);
		}
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		Connection cn = MyJdbcUtil.seConnecter();
		try {  
			String reqSql = "DELETE FROM Categorie WHERE id=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);
			pst.setLong(1, idCat);//des ? dans la requête
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeCn(cn);
		}
	}

}
