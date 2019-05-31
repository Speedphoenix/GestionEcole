package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

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
        evaluations = new ArrayList<>();
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

    public static void createInsertRequest(String appreciation,int bulletinId,int enseignementId, Connexion conn)
    {
        String sql = "INSERT INTO detailbulletin  (appreciation,bulletinId,enseignementId)VALUES('"+appreciation+"',"+bulletinId+","+enseignementId+");";
        conn.ajouterRequeteMaj(sql);
    }
    public void createUpdateRequest(String appreciation, Connexion conn)
    {
        String sql = "UPDATE detailbulletin SET appreciation = '"+appreciation+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }
}
