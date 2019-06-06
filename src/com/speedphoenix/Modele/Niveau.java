package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

public class Niveau extends BaseElem {
    protected String nom;
    protected ArrayList<Classe> classes;

    public Niveau(int id, String nom) {
        super(id);
        classes = new ArrayList<>();
        this.nom = nom;
        Ecole.getInstance().addNiveau(this);
        this.addTableChildren(classes);
    }

    public void addClasse(Classe what) {
        classes.add(what);
    }

    public String getNom() {
        return nom;
    }

    public static void createInsertRequest(String nom, Connexion conn)
    {
        String sql = "INSERT INTO niveau (nom) VALUES('"+nom+"');";
        conn.ajouterRequeteMaj(sql);
    }
    public void createUpdateRequest(String nom, Connexion conn)
    {
        String sql = "UPDATE niveau SET nom = '"+nom+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }
    public String getTableName(){
        return "niveau";
    }

}
