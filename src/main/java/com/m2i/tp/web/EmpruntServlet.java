package com.m2i.tp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class EmpruntServlet
 */

@WebServlet("/EmpruntServlet") // fin d'URL qui déclenchera le servlet
public class EmpruntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpruntServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    String chNbMois = request.getParameter("nbMois");
	    int nbMois = Integer.parseInt(chNbMois);
	    String chMontant = request.getParameter("montant");
	    double montant = Double.parseDouble(chMontant);
	    String chTauxInteret = request.getParameter("tauxInteret");
	    double tauxInteret = Double.parseDouble(chTauxInteret);
	    
	    double tauxMensuel = (tauxInteret / 100) / 12; //le depart est en % par an
	    double mensualite = 
	    		(montant * tauxMensuel) / ( 1 - Math.pow(1+tauxMensuel, -nbMois));
	    
	    String format = request.getParameter("format");
	    if(format ==null) {
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.println("<html><body>");
		    out.println("pour rembourser un emprunt de "+montant + " euros ");
		    out.println("sur une duree de "+nbMois + " mois ");
		    out.println("avec un taux de "+tauxInteret + " % par an ");
		    out.println("mensualite=<i>"+mensualite+"</i>");
		    out.println("</body></html>");
	    }
	    else if(format.equals("json")) {
	    	response.setContentType("application/json");
	    	PrintWriter out = response.getWriter();
	    	Info info = new Info("mensualite", String.valueOf(mensualite));
	    	ObjectMapper jackjonMapper = new ObjectMapper();
	    	String jsonString = 
	    			jackjonMapper.writeValueAsString(info);
	    	out.println(jsonString);
	    }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
