package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Enseignant extends Personne {
    protected ArrayList<Enseignement> enseignements;
    protected Enseignant(int id, String nom, String prenom) {
        super(id, nom, prenom, Personne.ELEVE);
        Ecole.getInstance().addEnseignant(this);
    }

    public void addEnseignement(Enseignement what) {
        enseignements.add(what);
    }
}
