package com.site.dao;

import java.util.List;

import com.site.beans.Utilisateur;

public interface UtilisateurDao {
	void ajouter(Utilisateur utilisateur);
	List<Utilisateur> lister();
}