package com.speedphoenix.Modele;

import java.util.ArrayList;

public class DetailBulletin extends BaseElem {
    protected String appreciation;
    protected Enseignement enseignement;
    protected Bulletin bulletin;
    protected ArrayList<Evaluation> evaluations;

    public DetailBulletin(int id, String appreciation, Enseignement enseignement, Bulletin bulletin) {
        super(id);
        this.appreciation = appreciation;
        this.enseignement = enseignement;
        this.bulletin = bulletin;
        enseignement.addDetailBulletin(this);
        bulletin.addDetailBulletin(this);
        Ecole.getInstance().addDetailBulletin(this);
    }

    public void addEvaluation(Evaluation what) {
        evaluations.add(what);
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
