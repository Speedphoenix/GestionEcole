package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

/**
 * A mirror of the niveau table in the SQL Database
 */
public class Niveau extends BaseElem {
    protected String nom;
    protected ArrayList<Classe> classes;

    /**
     * @param id The id of the entry in the SQL table
     * @param nom The text of the field with the same name in the SQL table
     */
    public Niveau(int id, String nom) {
        super(id);
        classes = new ArrayList<>();
        this.nom = nom;
        Ecole.getInstance().addNiveau(this);
        this.addTableChildren(classes);
    }

    /**
     * Adds a reference to a {@link Classe} to the list of child Classes
     * @param what the {@link Classe} to add
     */
    protected void addClasse(Classe what) {
        classes.add(what);
    }

    public String getNom() {
        return nom;
    }

    /**
     * Creates the query to add a new Niveau to the database
     * @param nom The text of the field with the same name in the SQL table
     * @param conn The connection to the database used
     */
    public static void createInsertRequest(String nom, Connexion conn)
    {
        String sql = "INSERT INTO niveau (nom) VALUES('"+nom+"');";
        conn.ajouterRequeteMaj(sql);
    }

    /**
     * Creates the query to update this entry in the database
     * @param nom The new nom of this Niveau
     * @param conn The connection to the database used
     */
    public void createUpdateRequest(String nom, Connexion conn)
    {
        String sql = "UPDATE niveau SET nom = '"+nom+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }

    @Override
    public String getTableName(){
        return "niveau";
    }

}
