package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Niveau extends BaseElem {
    protected String nom;
    protected ArrayList<Classe> classes;

    public Niveau(int id, String nom) {
        super(id);
        this.nom = nom;
        Ecole.getInstance().addNiveau(this);
    }

    public void addClasse(Classe what) {
        classes.add(what);
    }

    public String getNom() {
        return nom;
    }
}
