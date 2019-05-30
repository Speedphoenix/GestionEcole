package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Inscription {
    protected int id;
    protected Classe classe;
    protected Eleve eleve;
    ArrayList<Bulletin> bulletins;

    public Inscription(int id, Eleve eleve, Classe classe) {
        this.id = id;
        this.eleve = eleve;
        this.classe = classe;
        classe.addInscription(this);
        eleve.addInscription(this);
    }

    public void addBulletin(Bulletin what) {
        bulletins.add(what);
    }

    public int getId() {
        return id;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public Classe getClasse() {
        return classe;
    }
}
