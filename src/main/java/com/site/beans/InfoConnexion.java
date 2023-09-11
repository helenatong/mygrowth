package com.site.beans;

import javax.servlet.http.HttpServletRequest;

public class InfoConnexion {
	String loginRespond;

	public void verifierIdentifiants(HttpServletRequest request) {
		String name = request.getParameter("name");		
		String pass = request.getParameter("pass");
		
		if (pass.equals(name + "123")){
			loginRespond = "Vous êtes bien connecté";
		}
		else {
			loginRespond = "Mot de passe incorrect";
		}
	}

	public String getLoginRespond() {
		return loginRespond;
	}

	public void setLoginRespond(String loginRespond) {
		this.loginRespond = loginRespond;
	}

}
