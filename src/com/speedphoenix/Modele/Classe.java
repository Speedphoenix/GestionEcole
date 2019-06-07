package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

/**
 * A mirror of the classe table in the SQL Database
 */
public class Classe extends BaseElem {
    protected String nom;
    protected Ecole ecole;
    protected Niveau niveau;
    protected AnneeScolaire anneeScolaire;
    protected ArrayList<Inscription> inscriptions;
    protected ArrayList<Enseignement> enseignements;

    /**
     *
     * @param id The id of the entry in the SQL table
     * @param nom The text of the field with the same name in the SQL table
     * @param niveau A reference to the {@link Niveau} this Classe is a child of
     * @param anneeScolaire A reference to the {@link AnneeScolaire} this Classe is a child of
     */
    public Classe(int id, String nom, Niveau niveau, AnneeScolaire anneeScolaire) {
        this(id, nom, Ecole.getInstance(), niveau, anneeScolaire);
    }

    /**
     *
     * @param id The id of the entry in the SQL table
     * @param nom The text of the field with the same name in the SQL table
     * @param ecole A reference to the {@link Ecole} this Classe is a child of. Can be omitted
     * @param niveau A reference to the {@link Niveau} this Classe is a child of
     * @param anneeScolaire A reference to the {@link AnneeScolaire} this Classe is a child of
     */
    public Classe(int id, String nom, Ecole ecole, Niveau niveau, AnneeScolaire anneeScolaire) {
        super(id);
        this.nom = nom;
        this.ecole = ecole;
        this.niveau = niveau;
        this.anneeScolaire = anneeScolaire;
        inscriptions = new ArrayList<>();
        enseignements = new ArrayList<>();
        ecole.addClasse(this);
        niveau.addClasse(this);
        anneeScolaire.addClasse(this);
        this.addTableChildren(inscriptions);
        this.addTableChildren(enseignements);
    }

    /**
     * Adds a reference to a {@link Inscription} to the list of child Inscriptions
     * @param what the {@link Inscription} to add
     */
    public void addInscription(Inscription what) {
        inscriptions.add(what);
    }

    /**
     * Adds a reference to a {@link Enseignement} to the list of child Enseignements
     * @param what the {@link Enseignement} to add
     */
    public void addEnseignement(Enseignement what) {
        enseignements.add(what);
    }

    public String getNom() {
        return nom;
    }

    public Ecole getEcole() {
        return ecole;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public ArrayList<Inscription> getInscriptions() {
        return inscriptions;
    }

    public ArrayList<Enseignement> getEnseignements() {
        return enseignements;
    }

    /**
     * Creates the query to add a new Classe to the database
     * @param nom The text of the field with the same name in the SQL table
     * @param ecoleId The id of the {@link Ecole} of the new Classe
     * @param niveauId The id of the {@link Niveau} of the new Classe
     * @param anneeScolId The id of the {@link AnneeScolaire} of the new Classe
     * @param conn The connection to the database used
     */
    public static void createInsertRequest(String nom, int ecoleId, int niveauId, int anneeScolId, Connexion conn)
    {
        String sql = "INSERT INTO classe (nom,ecoleId,niveauId,anneeScolId)VALUES('"+nom+"',"+ecoleId+","+niveauId+","+anneeScolId+");";
        conn.ajouterRequeteMaj(sql);
    }

    /**
     * Creates the query to update this entry in the database
     * @param nom The new nom of this Classe
     * @param conn The connection to the database used
     */
    public void createUpdateRequest(String nom, Connexion conn)
    {
        String sql = "UPDATE classe SET nom = '"+nom+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }

    @Override
    public String getTableName(){
        return "classe";
    }

}
