package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Enseignant extends Personne {
    protected ArrayList<Enseignement> ensegnements;
    protected Enseignant(int id, String nom, String prenom) {
        super(id, nom, prenom, Personne.ELEVE);
    }

    public void addEnsegnement(Enseignement what) {
        ensegnements.add(what);
    }
}
