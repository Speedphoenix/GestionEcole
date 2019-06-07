package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

/**
 * Element of the personne table in the database. This class is inherited by {@link Eleve} or {@link Enseignant}
 * depending on its type
 */
public abstract class Personne extends BaseElem {
    /**
     * The integer associated to eleves
     */
    public static final int ELEVE = 0;
    /**
     * The integer associated to enseignants
     */
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

    /**
     * Constructs an {@link Eleve} or an {@link Enseignant} depending on the type and returns yt
     * @param id the id of the entry in the SQL table
     * @param nom The text of the field with the same name in the SQL table
     * @param prenom The text of the field with the same name in the SQL table
     * @param type The type of personne to be added
     * @return The new Personne created
     */
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

    /**
     * Creates the query to add a new Personne to the database
     * @param nom The text of the field with the same name in the SQL table
     * @param prenom The text of the field with the same name in the SQL table
     * @param type The type of Personne to add
     * @param conn The connection to the database used
     */
    public static void createInsertRequest(String nom, String prenom, int type, Connexion conn)
    {
        String sql = "INSERT INTO personne (nom,prenom,type)VALUES('"+nom+"','"+prenom+"',"+type+");";
        conn.ajouterRequeteMaj(sql);
    }

    @Override
    public String getTableName(){
        return "personne";
    }

    /**
     * Creates the query to update this entry in the database
     * @param nom The new nom of this Personne
     * @param prenom The new prenom of this Personne
     * @param conn The connection to the database used
     */
    public void createUpdateRequest(String nom, String prenom, Connexion conn)
    {
        String sql = "UPDATE personne SET nom = '"+nom+"', prenom ='"+prenom+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }
}
