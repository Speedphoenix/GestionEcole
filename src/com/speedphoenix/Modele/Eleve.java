package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

public class Eleve extends Personne {
    protected ArrayList<Inscription> inscriptions;
    protected Eleve(int id, String nom, String prenom) {
        super(id, nom, prenom, Personne.ELEVE);
        inscriptions = new ArrayList<>();
        Ecole.getInstance().addEleve(this);
        this.addTableChildren(inscriptions);
    }

    public void addInscription(Inscription what) {
        inscriptions.add(what);
    }

    public static void createInsertRequest(String nom,String prenom, Connexion conn)
    {
        Personne.createInsertRequest(nom,prenom,0,conn);
    }



}
