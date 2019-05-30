package com.speedphoenix.Modele;

import java.util.ArrayList;

public class AnneeScolaire extends BaseElem{
    protected ArrayList<Trimestre> trimestres;
    protected ArrayList<Classe> classes;

    // maybe add stuff to init the rest too?
    public AnneeScolaire(int id) {
        super(id);
        Ecole.getInstance().addAnneeScolaire(this);
    }


    public void addTrimestre(Trimestre what) {
        trimestres.add(what);
    }

    public void addClasse(Classe what) {
        classes.add(what);
    }
}
