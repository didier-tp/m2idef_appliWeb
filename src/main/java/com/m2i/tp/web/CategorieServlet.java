package com.m2i.tp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.m2i.tp.dao.DaoCategorie;
import com.m2i.tp.dao.DaoCategorieJdbc;
import com.m2i.tp.entity.Categorie;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/CategorieServlet")
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	//<a href="./ProduitServlet">liste des produits (servlet+dao+jsp)</a><br/>
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoCategorie daoCategorie = new DaoCategorieJdbc();
		List<Categorie> listeCategories = daoCategorie.rechercherCategories();
		request.setAttribute("listeCategories", listeCategories);
		
		RequestDispatcher rd;
		rd=this.getServletContext().getRequestDispatcher("/categories.jsp");
		rd.forward(request, response);//effectuer une redirection vers la page jsp
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
