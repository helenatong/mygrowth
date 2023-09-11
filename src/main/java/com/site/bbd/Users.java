package com.site.bbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.site.beans.Utilisateur;

public class Users {
	public Connection connexion; //Si on a réussi à se connecter avec la BBD
	
	public List<Utilisateur> recupererUtilisateurs(){
	List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
    Statement statement = null; // Requete à la base
    ResultSet resultat = null; //Resultat en out put
	
    loadDatabase(); 
    
    try {
        statement = connexion.createStatement(); //ICI BUG
        resultat = statement.executeQuery("SELECT prenom FROM listuser;");
        while (resultat.next()) {
            String prenom = resultat.getString("prenom");
            
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setPrenom(prenom);
            utilisateurs.add(utilisateur);
        }
    } catch (SQLException e) {
    } finally {
        // Fermeture de la connexion à la base
        try {
            if (resultat != null)
                resultat.close();
            if (statement != null)
                statement.close();
            if (connexion != null)
                connexion.close();
        } catch (SQLException ignore) {
        }
    }
    return utilisateurs;
}

public void loadDatabase() {
    // Chargement du driver
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
    }

    try {
        connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaeee", "root", "2004");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void ajouterUtilisateur(Utilisateur utilisateur) {
    loadDatabase();
    
    try {
        PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO listuser(prenom) VALUES(?);");
        preparedStatement.setString(1, utilisateur.getPrenom());
        
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}