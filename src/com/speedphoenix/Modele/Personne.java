package com.speedphoenix.Modele;

public class Personne {
    public static final int ELEVE = 0;
    public static final int ENSEIGNANT = 1;
    protected int id;
    protected String nom;
    protected String prenom;
    protected int type;

    protected Personne(int id, String nom, String prenom, int type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
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

    public int getId() {
        return id;
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
}
