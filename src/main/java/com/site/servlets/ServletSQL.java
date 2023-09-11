package com.site.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.beans.Utilisateur;
import com.site.dao.DaoFactory;
import com.site.dao.UtilisateurDao;

@WebServlet("/ServletSQL")
public class ServletSQL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao;
	
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.utilisateurDao = daoFactory.getUtilisateurDao();
	}
	       
    public ServletSQL() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("utilisateurs", utilisateurDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/sqlTest.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom(request.getParameter("name"));
        utilisateurDao.ajouter(utilisateur);
        
        request.setAttribute("utilisateurs", utilisateurDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/sqlTest.jsp").forward(request, response);
	}

}
