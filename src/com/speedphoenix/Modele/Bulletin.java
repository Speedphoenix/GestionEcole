package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.*;

import java.util.ArrayList;

/**
 * A mirror of the bulletin table in the SQL Database
 */
public class Bulletin extends BaseElem{
    protected String appreciation;
    protected Inscription inscription;
    protected Trimestre trimestre;
    protected ArrayList<DetailBulletin> detailBulletins = new ArrayList<>();

    /**
     *
     * @param id the id of the entry in the SQL table
     * @param appreciation The text of the field with the same name in the SQL table
     * @param inscription A reference to the {@link Inscription} this Bulletin is a child of
     * @param trimestre A reference to the {@link Trimestre} this Bulletin is a child of
     */
    public Bulletin(int id, String appreciation, Inscription inscription, Trimestre trimestre) {
        super(id);
        this.appreciation = appreciation;
        this.inscription = inscription;
        this.trimestre = trimestre;
        inscription.addBulletin(this);
        trimestre.addBulletin(this);
        Ecole.getInstance().addBulletin(this);
        this.addTableChildren(detailBulletins);
    }

    /**
     * Adds a reference to a {@link DetailBulletin} to the list of child DetailBulletins
     * @param what the {@link DetailBulletin} to add
     */
    public void addDetailBulletin(DetailBulletin what) {
        detailBulletins.add(what);
    }

    public String getAppreciation() {
        return appreciation;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }

    /**
     * Creates the query to add a new Bulletin to the database
     * @param conn The connection to the database used
     */
    public static void createInsertRequest(String appreciation,int inscriptionId,int trimestreId, Connexion conn)
    {
        String sql = "INSERT INTO bulletin (appreciation,inscriptionId,trimestreId)VALUES('"+appreciation+"',"+inscriptionId+","+trimestreId+");";
        conn.ajouterRequeteMaj(sql);
    }

    @Override
    public String getTableName(){
        return "bulletin";
    }

    /**
     * Creates the query to update this entry in the database
     * @param conn The connection to the database used
     */
    public void createUpdateRequest(String appreciation, Connexion conn)
    {
        String sql = "UPDATE bulletin SET appreciation = '"+appreciation+"'WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }
}
