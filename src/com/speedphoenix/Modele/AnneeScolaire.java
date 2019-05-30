package com.speedphoenix.Modele;

import java.util.ArrayList;

public class AnneeScolaire {
    protected int id;
    protected ArrayList<Trimestre> trimestres;
    protected ArrayList<Classe> classes;

    // maybe add stuff to init the rest too?
    public AnneeScolaire(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addTrimestre(Trimestre what) {
        trimestres.add(what);
    }

    public void addClasse(Classe what) {
        classes.add(what);
    }
}
