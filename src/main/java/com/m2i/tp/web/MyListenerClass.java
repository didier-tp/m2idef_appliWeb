package com.m2i.tp.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListenerClass implements ServletContextListener {

   public void contextInitialized(ServletContextEvent sce)  { 
      //méthode appelée automatiquement lors du démarrage de l'application dans tomcat  
	   System.out.println("démarrage ....");
	   ServletContext application = sce.getServletContext();
	   application.setAttribute("compteur", new Integer(0));
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	//méthode appelée automatiquement lors de l'arrêt de l'application dans tomcat  
    	System.out.println("arret ....");
    	ServletContext application = sce.getServletContext(); 
    	System.out.println("compteur=" + application.getAttribute("compteur"));
    }

    
    public MyListenerClass() {
    }
	
}
