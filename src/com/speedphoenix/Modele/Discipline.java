package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

public class Discipline extends BaseElem {
    protected String nom;
    protected ArrayList<Enseignement> enseignements;

    public Discipline(int id, String nom) {
        super(id);
        this.nom = nom;
        enseignements = new ArrayList<>();
        Ecole.getInstance().addDiscipline(this);
    }

    public void addEnseignement(Enseignement what) {
        enseignements.add(what);
    }


    public String getNom() {
        return nom;
    }

    public static void createInsertRequest(String nom, Connexion conn)
    {
        String sql = "INSERT INTO discipline (nom) VALUES('"+nom+"');";
        conn.ajouterRequeteMaj(sql);
    }
    public void createUpdateRequest(String nom, Connexion conn)
    {
        String sql = "UPDATE discipline SET nom = '"+nom+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }

    public ArrayList<Enseignement> getEnseignements() {
        return enseignements;
    }
}
