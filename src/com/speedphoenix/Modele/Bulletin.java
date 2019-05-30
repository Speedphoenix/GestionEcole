package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Bulletin {
    protected int id;
    protected String appreciation;
    protected Inscription inscription;
    protected Trimestre trimestre;
    protected ArrayList<DetailBulletin> detailBulletins;

    public Bulletin(int id, String appreciation, Inscription inscription, Trimestre trimestre) {
        this.id = id;
        this.appreciation = appreciation;
        this.inscription = inscription;
        this.trimestre = trimestre;
        inscription.addBulletin(this);
        trimestre.addBulletin(this);
    }

    public void addDetailBulletin(DetailBulletin what) {
        detailBulletins.add(what);
    }

    public int getId() {
        return id;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }
}
