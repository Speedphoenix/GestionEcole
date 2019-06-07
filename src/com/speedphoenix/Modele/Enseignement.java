package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

/**
 * A mirror of the Enseignement table in the SQL Database
 */
public class Enseignement extends BaseElem {
    protected Classe classe;
    protected Enseignant enseignant;
    protected Discipline discipline;
    protected ArrayList<DetailBulletin> detailBulletins;

    /**
     *
     * @param id The id of the entry in the SQL table
     * @param classe A reference to the {@link Classe} this Enseignement is a child of
     * @param enseignant A reference to the {@link Enseignement} this Enseignement is a child of
     * @param discipline A reference to the {@link Discipline} this Enseignement is a child of
     */
    public Enseignement(int id, Classe classe, Enseignant enseignant, Discipline discipline) {
        super(id);
        this.classe = classe;
        this.enseignant = enseignant;
        this.discipline = discipline;
        detailBulletins = new ArrayList<>();
        classe.addEnseignement(this);
        enseignant.addEnseignement(this);
        discipline.addEnseignement(this);
        Ecole.getInstance().addEnseignement(this);
        this.addTableChildren(detailBulletins);
    }

    /**
     * Adds a reference to a {@link DetailBulletin} to the list of child DetailBulletins
     * @param what the {@link DetailBulletin} to add
     */
    public void addDetailBulletin(DetailBulletin what) {
        detailBulletins.add(what);
    }

    public Classe getClasse() {
        return classe;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    /**
     * Creates the query to add a new Enseignement to the database
     * @param classeId The id of the {@link Classe} of the new Enseignement
     * @param disciplineId The id of the {@link Discipline} of the new Enseignement
     * @param personneId The id of the {@link Personne} of the new Enseignement
     * @param conn The connection to the database used
     */
    public static void createInsertRequest(int classeId, int disciplineId, int personneId, Connexion conn)
    {
        String sql = "INSERT INTO enseignement (classeId,disciplineId,personneId)VALUES("+classeId+","+disciplineId+","+personneId+");";
        conn.ajouterRequeteMaj(sql);
    }

    @Override
    public String getTableName(){
        return "enseignement";
    }
}
