package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Bulletin extends BaseElem{
    protected String appreciation;
    protected Inscription inscription;
    protected Trimestre trimestre;
    protected ArrayList<DetailBulletin> detailBulletins;

    public Bulletin(int id, String appreciation, Inscription inscription, Trimestre trimestre) {
        super(id);
        this.appreciation = appreciation;
        this.inscription = inscription;
        this.trimestre = trimestre;
        inscription.addBulletin(this);
        trimestre.addBulletin(this);
        Ecole.getInstance().addBulletin(this);
    }

    public void addDetailBulletin(DetailBulletin what) {
        detailBulletins.add(what);
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
