package com.site.forms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.site.bbd.Users;
import com.site.beans.InfoConnexion;
import com.site.beans.Utilisateur;

@WebServlet("/ConnectionForm")
public class ConnectionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConnectionForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users tableUsers = new Users();
		request.setAttribute("utilisateurs", tableUsers.recupererUtilisateurs());
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Partie Connexion
		InfoConnexion form = new InfoConnexion();
		form.verifierIdentifiants(request);
		
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		request.setAttribute("form", form);
		
		
		//Partie BBD
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom(request.getParameter("name"));
        
        Users tableUsers = new Users();
        tableUsers.ajouterUtilisateur(utilisateur);
        
        request.setAttribute("utilisateurs", tableUsers.recupererUtilisateurs());
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}
}
