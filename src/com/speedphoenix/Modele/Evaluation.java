package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

/**
 * A mirror of the Evaluation table in the SQL Database
 */
public class Evaluation extends BaseElem {
    protected double note;
    protected String appreciation;
    protected DetailBulletin detailBulletin;

    /**
     *
     * @param id The id of the entry in the SQL table
     * @param note The note in the Sql database
     * @param appreciation The text of the field with the same name in the SQL table
     * @param detailBulletin A reference to the {@link DetailBulletin} this Evaluation is a child of
     */
    public Evaluation(int id, double note, String appreciation, DetailBulletin detailBulletin) {
        super(id);
        this.note = note;
        this.appreciation = appreciation;
        this.detailBulletin = detailBulletin;
        detailBulletin.addEvaluation(this);
        Ecole.getInstance().addEvaluation(this);
    }

    public double getNote() {
        return note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public DetailBulletin getDetailBulletin() {
        return detailBulletin;
    }

    /**
     * Creates the query to add a new Evaluation to the database
     * @param appreciation The text of the field with the same name in the SQL table
     * @param note The note in the Sql database
     * @param detailBulletinId The id of the {@link DetailBulletin} of the new Evaluation
     * @param conn The connection to the database used
     */
    public static void createInsertRequest(String appreciation,double note, int detailBulletinId, Connexion conn)
    {
        String sql = "INSERT INTO evaluation  (appreciation,note,detailBulletinId)VALUES('"+appreciation+"',"+note+","+detailBulletinId+");";
        conn.ajouterRequeteMaj(sql);
    }

    /**
     *
     * @param appreciation The new apreciation of this Evaluation
     * @param note The new note of this Evaluation
     * @param conn The connection to the database used
     */
    public void createUpdateRequest(String appreciation, double note, Connexion conn)
    {
        String sql = "UPDATE evaluation SET appreciation = '"+appreciation+"',note = '"+note+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }

    @Override
    public String getTableName(){
        return "evaluation";
    }
}
