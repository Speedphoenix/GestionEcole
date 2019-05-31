package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.TreeMap;

public class Ecole extends BaseElem {
    protected static Ecole instance;
    protected String nom;
    protected TreeMap<Integer, Classe> classes;
    protected TreeMap<Integer, AnneeScolaire> anneeScolaires;
    protected TreeMap<Integer, Bulletin> bulletins;
    protected TreeMap<Integer, DetailBulletin> detailBulletins;
    protected TreeMap<Integer, Discipline> disciplines;
    protected TreeMap<Integer, Enseignement> enseignements;
    protected TreeMap<Integer, Evaluation> evaluations;
    protected TreeMap<Integer, Inscription> inscriptions;
    protected TreeMap<Integer, Niveau> niveaux;
    protected TreeMap<Integer, Trimestre> trimestres;
    protected TreeMap<Integer, Personne> personnes;
    protected TreeMap<Integer, Eleve> eleves;
    protected TreeMap<Integer, Enseignant> enseignants;

    //maybe put arraylists of every object in the school?

    public Ecole(int id, String nom) {
        super(id);
        instance = this;
        this.nom = nom;
    }

    
    public static Ecole getInstance() {
        return instance;
    }

    public void addClasse(Classe what) {
        classes.put(what.getId(), what);
    }

    public Classe findClasse(int id) {
        return classes.get(id);
    }

    public void addAnneeScolaire(AnneeScolaire what) {
        anneeScolaires.put(what.getId(), what);
    }

    public AnneeScolaire findAnneeScolaire(int id) {
        return anneeScolaires.get(id);
    }

    public void addBulletin(Bulletin what) {
        bulletins.put(what.getId(), what);
    }

    public Bulletin findBulletin(int id) {
        return bulletins.get(id);
    }

    protected void addDetailBulletin(DetailBulletin what) {
        detailBulletins.put(what.getId(), what);
    }

    public DetailBulletin findDetailBulletin(int id) {
        return detailBulletins.get(id);
    }

    protected void addDiscipline(Discipline what) {
        disciplines.put(what.getId(), what);
    }

    public Discipline findDiscipline(int id) {
        return disciplines.get(id);
    }

    protected void addEnseignement(Enseignement what) {
        enseignements.put(what.getId(), what);
    }

    public Enseignement findEnseignement(int id) {
        return enseignements.get(id);
    }

    protected void addEvaluation(Evaluation what) {
        evaluations.put(what.getId(), what);
    }

    public Evaluation findEvaluation(int id) {
        return evaluations.get(id);
    }

    protected void addInscription(Inscription what) {
        inscriptions.put(what.getId(), what);
    }

    public Inscription findInscription(int id) {
        return inscriptions.get(id);
    }

    protected void addNiveau(Niveau what) {
        niveaux.put(what.getId(), what);
    }

    public Niveau findNiveau(int id) {
        return niveaux.get(id);
    }

    protected void addTrimestre(Trimestre what) {
        trimestres.put(what.getId(), what);
    }

    public Trimestre find(int id) {
        return trimestres.get(id);
    }

    protected void addPersonne(Personne what) {
        personnes.put(what.getId(), what);
    }

    public Personne findPersonne(int id) {
        return personnes.get(id);
    }

    protected void addEleve(Eleve what) {
        eleves.put(what.getId(), what);
    }

    public Eleve findEleve(int id) {
        return eleves.get(id);
    }

    protected void addEnseignant(Enseignant what) {
        enseignants.put(what.getId(), what);
    }

    public Enseignant findEnseignant(int id) {
        return enseignants.get(id);
    }

    public String getNom() {
        return nom;
    }

    public static void createInsertRequest(String nom, Connexion conn)
    {
        String sql = "INSERT INTO ecole (nom) VALUES('"+nom+"');";
        conn.ajouterRequeteMaj(sql);
    }
    public void createUpdateRequest(String nom, Connexion conn)
    {
        String sql = "UPDATE ecole SET nom = '"+nom+"' WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }
}
