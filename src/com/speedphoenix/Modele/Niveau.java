package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Niveau {
    protected int id;
    protected String nom;
    protected ArrayList<Classe> classes;

    public Niveau(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void addClasse(Classe what) {
        classes.add(what);
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
