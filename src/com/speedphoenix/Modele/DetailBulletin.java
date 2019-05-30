package com.speedphoenix.Modele;

import java.util.ArrayList;

public class DetailBulletin {
    protected int id;
    protected String appreciation;
    protected Enseignement enseignement;
    protected Bulletin bulletin;
    protected ArrayList<Evaluation> evaluations;

    public DetailBulletin(int id, String appreciation, Enseignement enseignement, Bulletin bulletin) {
        this.id = id;
        this.appreciation = appreciation;
        this.enseignement = enseignement;
        this.bulletin = bulletin;
        enseignement.addDetailBulletin(this);
        bulletin.addDetailBulletin(this);
    }

    public void addEvaluation(Evaluation what) {
        evaluations.add(what);
    }

    public int getId() {
        return id;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public Enseignement getEnseignement() {
        return enseignement;
    }

    public Bulletin getBulletin() {
        return bulletin;
    }
}
