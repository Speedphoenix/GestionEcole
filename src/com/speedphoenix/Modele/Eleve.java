package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

/**
 * Element of the personne table in the database that has Inscriptions as children
 */
public class Eleve extends Personne {
    protected ArrayList<Inscription> inscriptions;

    protected Eleve(int id, String nom, String prenom) {
        super(id, nom, prenom, Personne.ELEVE);
        inscriptions = new ArrayList<>();
        Ecole.getInstance().addEleve(this);
        this.addTableChildren(inscriptions);
    }

    /**
     * Adds a reference to a {@link Inscription} to the list of child Inscriptions
     * @param what the {@link Inscription} to add
     */
    public void addInscription(Inscription what) {
        inscriptions.add(what);
    }

    /**
     * Creates the query to add a new Eleve as a Personne to the database
     * @param nom The text of the field with the same name in the SQL table
     * @param prenom The text of the field with the same name in the SQL table
     * @param conn The connection to the database used
     */
    public static void createInsertRequest(String nom, String prenom, Connexion conn)
    {
        Personne.createInsertRequest(nom,prenom,0,conn);
    }
}
