package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

/**
 * A mirror of the inscription table in the SQL Database
 */
public class Inscription extends BaseElem {
    protected Classe classe;
    protected Eleve eleve;
    ArrayList<Bulletin> bulletins;

    /**
     * @param id The id of the entry in the SQL table
     * @param eleve A reference to the {@link Eleve} this Inscription is a child of
     * @param classe A reference to the {@link Classe} this Inscription is a child of
     */
    public Inscription(int id, Eleve eleve, Classe classe) {
        super(id);
        this.eleve = eleve;
        this.classe = classe;
        bulletins = new ArrayList<>();
        classe.addInscription(this);
        eleve.addInscription(this);
        Ecole.getInstance().addInscription(this);
        this.addTableChildren(bulletins);
    }

    /**
     * Adds a reference to a {@link Bulletin} to the list of child Bulletins
     * @param what the {@link Bulletin} to add
     */
    protected void addBulletin(Bulletin what) {
        bulletins.add(what);
    }

    public Eleve getEleve() {
        return eleve;
    }

    public Classe getClasse() {
        return classe;
    }

    /**
     * Creates the query to add a new Enseignant as a Personne to the database
     * @param classeId The id of the {@link Classe} of the new Inscription
     * @param personneId The id of the {@link Eleve} of the new Inscription
     * @param conn The connection to the database used
     */
    public static void createInsertRequest( int classeId, int personneId, Connexion conn)
    {
        String sql = "INSERT INTO inscription  (classeId,personneId)VALUES("+classeId+","+personneId+");";
        conn.ajouterRequeteMaj(sql);
    }

    public ArrayList<Bulletin> getBulletins() {
        return bulletins;
    }

    @Override
    public String getTableName(){
        return "inscription";
    }

}
