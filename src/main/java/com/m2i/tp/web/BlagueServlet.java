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
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		DaoBlague daoBlague = DaoBlagueJdbc.getInstance(); //avec singleton
		/*  new DaoBlagueJdbc(); sans singleton */
		
		if(task!=null && task.equals("ajout")) {
			Blague nouvelleBlague = new Blague(null,request.getParameter("titre"),request.getParameter("texte"),null,null);
			daoBlague.ajouterBlague(nouvelleBlague);
		}
		
		if(task!=null && task.equals("noter")) {
			Long idBlague = Long.parseLong(request.getParameter("blagueId"));
			Double nouvelleNote = Double.parseDouble(request.getParameter("nouvelleNote"));
			Blague blague = daoBlague.rechercherBlagueSelonId(idBlague);
			Integer nbVotes = blague.getNbVotes();
			if(nbVotes==null || nbVotes==0) {
				blague.setNote(nouvelleNote); blague.setNbVotes(1);
			}else {
			   Double note = blague.getNote(); //ancienne note moyenne
			   //calcul nouvelle note moyenne:
			   note = (nouvelleNote + note * nbVotes) / (nbVotes + 1);
			   //mise à jour de l'objet java qui sera "updaté en base":
			   blague.setNote(note); 
			   blague.setNbVotes(nbVotes + 1);
			}
			daoBlague.modifierBlague(blague);
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
