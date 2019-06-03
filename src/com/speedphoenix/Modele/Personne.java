package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

public class Personne extends BaseElem {
    public static final int ELEVE = 0;
    public static final int ENSEIGNANT = 1;
    protected String nom;
    protected String prenom;
    protected int type;

    protected Personne(int id, String nom, String prenom, int type) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        Ecole.getInstance().addPersonne(this);
    }

    public static Personne createPersonne(int id, String nom, String prenom, int type) {
        switch (type) {
            default:
            case ELEVE:
                return new Eleve(id, nom, prenom);

            case ENSEIGNANT:
                return new Enseignant(id, nom, prenom);
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getType() {
        return type;
    }

    public static void createInsertRequest(String nom,String prenom,int type, Connexion conn)
    {
        String sql = "INSERT INTO personne (nom,prenom,type)VALUES('"+nom+"','"+prenom+"',"+type+");";
        conn.ajouterRequeteMaj(sql);
    }
    public String getTableName(){
        return "personne";
    }

    public void createUpdateRequest(String nom,String prenom, Connexion conn)
    {
        String sql = "UPDATE personne SET nom = '"+nom+"', prenom ='"+prenom+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }
}
