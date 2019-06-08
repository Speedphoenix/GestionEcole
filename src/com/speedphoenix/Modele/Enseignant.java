package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

/**
 * Element of the personne table in the database that has Enseignements as children
 */
public class Enseignant extends Personne {
    protected ArrayList<Enseignement> enseignements;

    protected Enseignant(int id, String nom, String prenom) {
        super(id, nom, prenom, Personne.ELEVE);
        enseignements = new ArrayList<>();
        Ecole.getInstance().addEnseignant(this);
        this.addTableChildren(enseignements);
    }

    /**
     * Adds a reference to a {@link Enseignement} to the list of child Enseignements
     * @param what the {@link Enseignement} to add
     */
    protected void addEnseignement(Enseignement what) {
        enseignements.add(what);
    }

    /**
     * Creates the query to add a new Enseignant as a Personne to the database
     * @param nom The text of the field with the same name in the SQL table
     * @param prenom The text of the field with the same name in the SQL table
     * @param conn The connection to the database used
     */
    public static void createInsertRequest(String nom,String prenom, Connexion conn)
    {
        Personne.createInsertRequest(nom,prenom,1,conn);
    }
}
