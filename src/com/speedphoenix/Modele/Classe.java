package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Classe {
    protected int id;
    protected String nom;
    protected Ecole ecole;
    protected Niveau niveau;
    protected AnneeScolaire anneeScolaire;
    protected ArrayList<Inscription> inscriptions;
    protected ArrayList<Enseignement> enseignements;

    public Classe(int id, String nom, Ecole ecole, Niveau niveau, AnneeScolaire anneeScolaire) {
        this.id = id;
        this.nom = nom;
        this.ecole = ecole;
        this.niveau = niveau;
        this.anneeScolaire = anneeScolaire;
        ecole.addClasse(this);
        niveau.addClasse(this);
        anneeScolaire.addClasse(this);
    }

    public void addInscription(Inscription what) {
        inscriptions.add(what);
    }

    public void addEnseignement(Enseignement what) {
        enseignements.add(what);
    }
}
