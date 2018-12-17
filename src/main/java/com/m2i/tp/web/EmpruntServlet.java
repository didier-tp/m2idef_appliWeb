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
	    PrintWriter out = response.getWriter();
	    
	    if(format ==null || format.equals("html")) {
		    response.setContentType("text/html");
		    out.println("<html><body>");
		    out.println("pour rembourser un emprunt de "+montant + " euros ");
		    out.println("sur une duree de "+nbMois + " mois ");
		    out.println("avec un taux de "+tauxInteret + " % par an ");
		    out.println("mensualite=<i>"+mensualite+"</i>");
		    out.println("</body></html>");
	    }
	    else if(format.equals("json")) {
	    	response.setContentType("application/json");
	    	Info info = new Info("mensualite", String.valueOf(mensualite));
	    	ObjectMapper jackjonMapper = new ObjectMapper();
	    	String jsonString = 
	    			jackjonMapper.writeValueAsString(info);
	    	out.println(jsonString);
	    }
	    else if(format.equals("svg")) {
	    	response.setContentType("image/svg+xml");
	    	out.println("<svg xmlns='http://www.w3.org/2000/svg' version='1.1' width='400' height='350' >");
	    	out.println("<rect width='100' height='80' x='0' y='70' fill='green' />");
	    	out.println("<line x1='5' y1='5' x2='250' y2='95' stroke='red' />");
	    	out.println("<circle cx='90' cy='80' r='50' fill='blue' />");
	    	out.println("<text x='20' y='20'>mensualite="+mensualite+"</text>");
	    	out.println("</svg>");
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
