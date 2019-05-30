package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Discipline {
    protected int id;
    protected String nom;
    protected ArrayList<Enseignement> enseignements;

    public Discipline(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void addEnseignement(Enseignement what) {
        enseignements.add(what);
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
