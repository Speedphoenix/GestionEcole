package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

/**
 * A mirror of the detailbulletin table in the SQL Database
 */
public class DetailBulletin extends BaseElem {
    protected String appreciation;
    protected Enseignement enseignement;
    protected Bulletin bulletin;
    protected ArrayList<Evaluation> evaluations;

    /**
     *
     * @param id the id of the entry in the SQL table
     * @param appreciation The text of the field with the same name in the SQL table
     * @param enseignement A reference to the {@link Enseignement} this DetailBulletin is a child of
     * @param bulletin A reference to the {@link Bulletin} this DetailBulletin is a child of
     */
    public DetailBulletin(int id, String appreciation, Enseignement enseignement, Bulletin bulletin) {
        super(id);
        this.appreciation = appreciation;
        this.enseignement = enseignement;
        this.bulletin = bulletin;
        evaluations = new ArrayList<>();
        enseignement.addDetailBulletin(this);
        bulletin.addDetailBulletin(this);
        Ecole.getInstance().addDetailBulletin(this);
        this.addTableChildren(evaluations);
    }

    /**
     * Adds a reference to a {@link Evaluation} to the list of child Evaluations
     * @param what the {@link Evaluation} to add
     */
    protected void addEvaluation(Evaluation what) {
        evaluations.add(what);
    }

    public String getAppreciation() {
        return appreciation;
    }

    public Enseignement getEnseignement() {
        return enseignement;
    }

    public Bulletin getBulletin() {
        return bulletin;
    }

    /**
     * Creates the query to add a new DetailBulletin to the database
     *
     * @param appreciation The text of the field with the same name in the SQL table
     * @param bulletinId The id of the {@link Bulletin} of the new DetailBulletin
     * @param enseignementId The id of the {@link Enseignement} of the new DetailBulletin
     * @param conn The connection to the database used
     */
    public static void createInsertRequest(String appreciation,int bulletinId,int enseignementId, Connexion conn)
    {
        String sql = "INSERT INTO detailbulletin  (appreciation,bulletinId,enseignementId)VALUES('"+appreciation+"',"+bulletinId+","+enseignementId+");";
        conn.ajouterRequeteMaj(sql);
    }

    @Override
    public String getTableName(){
        return "detailbulletin";
    }

    /**
     * Creates the query to update this entry in the database
     * @param appreciation The new apprciation of this DetailBulletin
     * @param conn The connection to the database used
     */
    public void createUpdateRequest(String appreciation, Connexion conn)
    {
        String sql = "UPDATE detailbulletin SET appreciation = '"+appreciation+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }
}
