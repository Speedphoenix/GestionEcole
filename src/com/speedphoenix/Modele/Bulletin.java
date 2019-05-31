package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.*;

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
        detailBulletins = new ArrayList<>();
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
    public static void createInsertRequest(String appreciation,int inscriptionId,int trimestreId, Connexion conn)
    {
        String sql = "INSERT INTO bulletin (appreciation,inscriptionId,trimestreId)VALUES('"+appreciation+"',"+inscriptionId+","+trimestreId+");";
        conn.ajouterRequeteMaj(sql);
    }
    public void createUpdateRequest(String appreciation, Connexion conn)
    {
        String sql = "UPDATE bulletin SET appreciation = '"+appreciation+"'WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }
}
