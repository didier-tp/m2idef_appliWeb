package com.m2i.tp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.m2i.tp.dao.DaoBlague;
import com.m2i.tp.dao.DaoBlagueJdbc;
import com.m2i.tp.entity.Blague;


@WebServlet("/BlagueServlet")
public class BlagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	//<a href="./BlagueServlet">liste des blagues (servlet+dao+jsp)</a><br/>
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		
		DaoBlague daoBlague = new DaoBlagueJdbc();
		
		if(task!=null && task.equals("ajout")) {
			Blague nouvelleBlague = new Blague(null,request.getParameter("titre"),request.getParameter("texte"),null,null);
			daoBlague.ajouterBlague(nouvelleBlague);
		}
		//dans tous les cas (task null ou suite à "ajout" ou "liste") :
		List<Blague> listeBlagues = daoBlague.rechercherBlagues();
		request.setAttribute("listeBlagues", listeBlagues);
	
		RequestDispatcher rd;
		rd=this.getServletContext().getRequestDispatcher("/visuBlagues.jsp");
		rd.forward(request, response);//effectuer une redirection vers la page jsp
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
