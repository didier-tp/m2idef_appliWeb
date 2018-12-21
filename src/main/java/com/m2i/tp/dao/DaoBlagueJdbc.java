package com.m2i.tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.m2i.tp.entity.Blague;

public class DaoBlagueJdbc implements DaoBlague {
	
	//************ DEBUT design pattern "SINGLETON" **********
	public static DaoBlagueJdbc uniqueInstance=null;
	
	public static DaoBlagueJdbc getInstance() {
		if(uniqueInstance==null) {
			//construire uniqueInstance que si elle n'a pas encore été construite
			uniqueInstance = new DaoBlagueJdbc();
		}
		//dans tous les cas , retourner l'unique instance construite (récemment ou depuis longtemps):
		return uniqueInstance;
	}
	
	private DaoBlagueJdbc() {
		//constructeur ici volontairement privé pour interdire new en direct depuis une autre classe
	}
	
	//************ FIN design pattern "SINGLETON" **********

	@Override
	public List<Blague> rechercherBlagues() {
		List<Blague> listeBlagues = new ArrayList<Blague>();
		Connection cn = MyJdbcUtil.seConnecter();
		ResultSet rs = null;
		try {  Statement st = cn.createStatement();
			  String reqSql = "SELECT * FROM Blague";
			 rs = st.executeQuery(reqSql);
			while(rs.next()) {
				Blague b = new Blague();
				b.setId(rs.getLong("id"));
				b.setTitre(rs.getString("titre"));
				b.setTexte(rs.getString("texte"));
				b.setNote(rs.getDouble("note"));
				b.setNbVotes(rs.getInt("nbVotes"));
				listeBlagues.add(b);
			}
			rs.close();	st.close();//fermetures dans l'ordre inverse des ouvertures
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeCn(cn);
		}
		return listeBlagues;
	}

	@Override
	public void ajouterBlague(Blague b) {
		Connection cn = MyJdbcUtil.seConnecter();
		try {  
			String reqSql = 
				    "INSERT INTO Blague(titre,texte,nbVotes) VALUES(?,?,0)";
			PreparedStatement pst = cn.prepareStatement(reqSql,
					                      Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, b.getTitre()); pst.setString(2, b.getTexte());
			pst.executeUpdate();
			b.setId(MyJdbcUtil.getAutoIncrPk(pst));//nécessite auto_increment (mysql)
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeCn(cn);
		}
	}

	@Override
	public Blague rechercherBlagueSelonId(Long id) {
		Blague b = null;
		Connection cn = MyJdbcUtil.seConnecter();
		ResultSet rs = null;
		try {  
			  String reqSql = "SELECT * FROM Blague WHERE id=?";
			  PreparedStatement pst = cn.prepareStatement(reqSql);
			  pst.setLong(1, id);
			 rs = pst.executeQuery();
			if(rs.next()) {
				b= new Blague();
				b.setId(rs.getLong("id"));
				b.setTitre(rs.getString("titre"));
				b.setTexte(rs.getString("texte"));
				b.setNote(rs.getDouble("note"));
				b.setNbVotes(rs.getInt("nbVotes"));
			}
			rs.close();	pst.close();//fermetures dans l'ordre inverse des ouvertures
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeCn(cn);
		}
		return b;
	}

	@Override
	public void modifierBlague(Blague b) {
		Connection cn = MyJdbcUtil.seConnecter();
		try {  
			String reqSql = 
				    "UPDATE Blague SET titre= ? , texte=?  , note=? , nbVotes=?  WHERE id=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);
			pst.setString(1, b.getTitre());
			pst.setString(2, b.getTexte());
			pst.setDouble(3, b.getNote());
			pst.setInt(4, b.getNbVotes());
			pst.setLong(5, b.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeCn(cn);
		}
	}

	@Override
	public void supprimerBlague(Long idB) {
		Connection cn = MyJdbcUtil.seConnecter();
		try {  
			String reqSql = "DELETE FROM Blague WHERE id=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);
			pst.setLong(1, idB);//numero des ? dans la requête
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeCn(cn);
		}
	}

}
