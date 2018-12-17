package com.m2i.tp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.m2i.tp.dao.DaoProduit;
import com.m2i.tp.dao.DaoProduitJdbc;
import com.m2i.tp.entity.Produit;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	//<a href="./ProduitServlet">liste des produits (servlet+dao+jsp)</a><br/>
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>liste des produits</h3>");
		DaoProduit daoProduit = new DaoProduitJdbc();
		List<Produit> listeProduits = daoProduit.rechercherProduits();
		out.println("<table border='1'>");
		out.println("<tr><th>numero</th><th>label</th><th>prix</th></tr>");
		for(Produit prod : listeProduits) {
			out.println("<tr>");
				out.println("<td>"+ prod.getNumero() + "</td>");
				out.println("<td>"+ prod.getLabel() + "</td>");
				out.println("<td>"+ prod.getPrix() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
