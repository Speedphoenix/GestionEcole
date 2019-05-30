package com.speedphoenix.Modele;

public class Evaluation extends BaseElem {
    protected int note;
    protected String appreciation;
    protected DetailBulletin detailBulletin;

    public Evaluation(int id, int note, String appreciation, DetailBulletin detailBulletin) {
        super(id);
        this.note = note;
        this.appreciation = appreciation;
        this.detailBulletin = detailBulletin;
        detailBulletin.addEvaluation(this);
        Ecole.getInstance().addEvaluation(this);
    }

    public int getNote() {
        return note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public DetailBulletin getDetailBulletin() {
        return detailBulletin;
    }
}
