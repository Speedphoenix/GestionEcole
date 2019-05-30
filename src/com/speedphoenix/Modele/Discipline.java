package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Discipline extends BaseElem {
    protected String nom;
    protected ArrayList<Enseignement> enseignements;

    public Discipline(int id, String nom) {
        super(id);
        this.nom = nom;
        Ecole.getInstance().addDiscipline(this);
    }

    public void addEnseignement(Enseignement what) {
        enseignements.add(what);
    }


    public String getNom() {
        return nom;
    }
}
