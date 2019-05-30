package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Ecole {
    protected int id;
    protected String nom;
    protected ArrayList<Classe> classes;
    //maybe put arraylists of every object in the school?

    public Ecole(int id, String nom) {
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
