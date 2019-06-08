package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

/**
 * A mirror of the discipline table in the SQL Database
 */
public class Discipline extends BaseElem {
    protected String nom;
    protected ArrayList<Enseignement> enseignements;

    /**
     *
     * @param id the id of the entry in the SQL table
     * @param nom The text of the field with the same name in the SQL table
     */
    public Discipline(int id, String nom) {
        super(id);
        this.nom = nom;
        enseignements = new ArrayList<>();
        Ecole.getInstance().addDiscipline(this);
        this.addTableChildren(enseignements);
    }

    /**
     * Adds a reference to a {@link Enseignement} to the list of child Enseignements
     * @param what the {@link Enseignement} to add
     */
    protected void addEnseignement(Enseignement what) {
        enseignements.add(what);
    }

    public String getNom() {
        return nom;
    }

    /**
     * Creates the query to add a new Discipline to the database
     * @param nom The text of the field with the same name in the SQL table
     * @param conn The connection to the database used
     */
    public static void createInsertRequest(String nom, Connexion conn)
    {
        String sql = "INSERT INTO discipline (nom) VALUES('"+nom+"');";
        conn.ajouterRequeteMaj(sql);
    }

    @Override
    public String getTableName(){
        return "discipline";
    }

    /**
     * Creates the query to update this entry in the database
     * @param nom The new nom of this Discipline
     * @param conn The connection to the database used
     */
    public void createUpdateRequest(String nom, Connexion conn)
    {
        String sql = "UPDATE discipline SET nom = '"+nom+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }

    public ArrayList<Enseignement> getEnseignements() {
        return enseignements;
    }
}
