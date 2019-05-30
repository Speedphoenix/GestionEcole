package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Eleve extends Personne {
    protected ArrayList<Inscription> inscriptions;
    protected Eleve(int id, String nom, String prenom) {
        super(id, nom, prenom, Personne.ELEVE);
    }

    public void addInscription(Inscription what) {
        inscriptions.add(what);
    }
}
