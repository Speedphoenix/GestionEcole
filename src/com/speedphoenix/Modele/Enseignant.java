package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

public class Enseignant extends Personne {
    protected ArrayList<Enseignement> enseignements;
    protected Enseignant(int id, String nom, String prenom) {
        super(id, nom, prenom, Personne.ELEVE);
        enseignements = new ArrayList<>();
        Ecole.getInstance().addEnseignant(this);
    }

    public void addEnseignement(Enseignement what) {
        enseignements.add(what);
    }
    public static void createInsertRequest(String nom,String prenom, Connexion conn)
    {
        Personne.createInsertRequest(nom,prenom,1,conn);
    }
}
