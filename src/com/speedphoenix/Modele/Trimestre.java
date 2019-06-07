package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A mirror of the trimestre table in the SQL Database
 */
public class Trimestre extends BaseElem {
    protected int numero;
    protected LocalDate debut;
    protected LocalDate fin;
    protected AnneeScolaire anneeScolaire;
    protected ArrayList<Bulletin> bulletins;

    /**
     *
     * @param id The id of the entry in the SQL table
     * @param numero The numero of this Trimestre
     * @param debut The starting date of this Trimestre
     * @param fin The ending date of this Trimestre
     * @param anneeScolaire A reference to the {@link AnneeScolaire} this Trimestre is a child of
     */
    public Trimestre(int id, int numero, LocalDate debut, LocalDate fin, AnneeScolaire anneeScolaire) {
        super(id);
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.anneeScolaire = anneeScolaire;
        bulletins = new ArrayList<>();
        anneeScolaire.addTrimestre(this);
        Ecole.getInstance().addTrimestre(this);
        this.addTableChildren(bulletins);
    }

    /**
     * Adds a reference to a {@link Bulletin} to the list of child Bulletins
     * @param what the {@link Bulletin} to add
     */
    public void addBulletin(Bulletin what) {
        bulletins.add(what);
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    /**
     * Creates the query to add a new Trimestre to the database
     * @param numero The numero qof the new Trimestre
     * @param debut The starting date of the new Trimestre
     * @param fin The ending date of the new Trimestre
     * @param anneeScolId The id of the {@link AnneeScolaire} of the new Trimestre
     * @param conn The connection to the database used
     */
    public static void createInsertRequest(int numero, LocalDate debut, LocalDate fin, int anneeScolId, Connexion conn)
    {
        String sql = "INSERT INTO trimestre (numero,debut,fin,anneeScolId) VALUES(" + numero + ",'" + debut.toString() + "','" + fin.toString() + "'," + anneeScolId + ");";
        conn.ajouterRequeteMaj(sql);
    }

    /**
     * Creates the query to update this entry in the database
     * @param debut The new starting date
     * @param fin The new ending date
     * @param conn The connection to the database used
     */
    public void createUpdateRequest(LocalDate debut, LocalDate fin, Connexion conn)
    {
        String sql = "UPDATE trimestre SET debut = '" + debut.toString() + "', fin = '" + fin.toString() + "'WHERE id=" + this.id + ";";
        conn.ajouterRequeteMaj(sql);
    }

    @Override
    public String getTableName(){
        return "trimestre";
    }
}
