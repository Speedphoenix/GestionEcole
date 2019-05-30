package com.speedphoenix.Modele;

public class Evaluation {
    protected int id;
    protected int note;
    protected String appreciation;
    protected DetailBulletin detailBulletin;

    public Evaluation(int id, int note, String appreciation, DetailBulletin detailBulletin) {
        this.id = id;
        this.note = note;
        this.appreciation = appreciation;
        this.detailBulletin = detailBulletin;
        detailBulletin.addEvaluation(this);
    }
}
