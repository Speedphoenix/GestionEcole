package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

public class Evaluation extends BaseElem {
    protected double note;
    protected String appreciation;
    protected DetailBulletin detailBulletin;

    public Evaluation(int id, double note, String appreciation, DetailBulletin detailBulletin) {
        super(id);
        this.note = note;
        this.appreciation = appreciation;
        this.detailBulletin = detailBulletin;
        detailBulletin.addEvaluation(this);
        Ecole.getInstance().addEvaluation(this);
    }

    public double getNote() {
        return note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public DetailBulletin getDetailBulletin() {
        return detailBulletin;
    }

    public static void createInsertRequest(String appreciation,double note, int detailBulletinId, Connexion conn)
    {
        String sql = "INSERT INTO evaluation  (appreciation,note,detailBulletinId)VALUES('"+appreciation+"',"+note+","+detailBulletinId+");";
        conn.ajouterRequeteMaj(sql);
    }
    public void createUpdateRequest(String appreciation,double note, Connexion conn)
    {
        String sql = "UPDATE evaluation SET appreciation = '"+appreciation+"',note = '"+note+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }
    public String getTableName(){
        return "evaluation";
    }

}
