package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

public class Classe extends BaseElem {
    protected String nom;
    protected Ecole ecole;
    protected Niveau niveau;
    protected AnneeScolaire anneeScolaire;
    protected ArrayList<Inscription> inscriptions;
    protected ArrayList<Enseignement> enseignements;

    public Classe(int id, String nom, Niveau niveau, AnneeScolaire anneeScolaire) {
        this(id, nom, Ecole.getInstance(), niveau, anneeScolaire);
    }

    public Classe(int id, String nom, Ecole ecole, Niveau niveau, AnneeScolaire anneeScolaire) {
        super(id);
        this.nom = nom;
        this.ecole = ecole;
        this.niveau = niveau;
        this.anneeScolaire = anneeScolaire;
        inscriptions = new ArrayList<>();
        enseignements = new ArrayList<>();
        ecole.addClasse(this);
        niveau.addClasse(this);
        anneeScolaire.addClasse(this);
        this.addTableChildren(inscriptions);
        this.addTableChildren(enseignements);
    }

    public void addInscription(Inscription what) {
        inscriptions.add(what);
    }

    public void addEnseignement(Enseignement what) {
        enseignements.add(what);
    }

    public String getNom() {
        return nom;
    }

    public Ecole getEcole() {
        return ecole;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public static void createInsertRequest(String nom,int ecoleId,int niveauId,int anneeScolId, Connexion conn)
    {
        String sql = "INSERT INTO classe (nom,ecoleId,niveauId,anneeScolId)VALUES('"+nom+"',"+ecoleId+","+niveauId+","+anneeScolId+");";
        conn.ajouterRequeteMaj(sql);
    }

    public void createUpdateRequest(String nom, Connexion conn)
    {
        String sql = "UPDATE classe SET nom = '"+nom+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }
    public String getTableName(){
        return "classe";
    }

}
