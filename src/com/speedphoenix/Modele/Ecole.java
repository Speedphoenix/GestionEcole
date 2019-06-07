package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * The container of every mirror of the entries in the SQL table
 * Is also a mirror of the ecole table in the SQL Database
 */
public class Ecole extends BaseElem {
    protected static Ecole instance;
    protected String nom;
    protected TreeMap<Integer, Classe> classes = new TreeMap();
    protected TreeMap<Integer, AnneeScolaire> anneeScolaires = new TreeMap();
    protected TreeMap<Integer, Bulletin> bulletins = new TreeMap();
    protected TreeMap<Integer, DetailBulletin> detailBulletins = new TreeMap();
    protected TreeMap<Integer, Discipline> disciplines = new TreeMap();
    protected TreeMap<Integer, Enseignement> enseignements = new TreeMap();
    protected TreeMap<Integer, Evaluation> evaluations = new TreeMap();
    protected TreeMap<Integer, Inscription> inscriptions = new TreeMap();
    protected TreeMap<Integer, Niveau> niveaux = new TreeMap();
    protected TreeMap<Integer, Trimestre> trimestres = new TreeMap();
    protected TreeMap<Integer, Personne> personnes = new TreeMap();
    protected TreeMap<Integer, Eleve> eleves = new TreeMap();
    protected TreeMap<Integer, Enseignant> enseignants = new TreeMap();

    /**
     * This constructor is usually not used as the id and name are retrieved after it is constructed
     * @param id the id of the entry in the SQL table
     * @param nom The text of the field with the same name in the SQL table
     */
    public Ecole(int id, String nom) {
        super(id);
        instance = this;
        this.nom = nom;
        refresh();
    }

    public Ecole() {

        instance = this;
        refresh();
    }

    /**
     * Refreshes the whole mirror of the Database.
     * Effectively empties the containers and takes it all again from the database
     */
    public void refresh()
    {
         this.reinitTreeMaps();
         retriveEcole();
         this.fillNiveaux();
         this.fillDisciplines();
         this.fillAnneeScolaires();
         this.fillTrimestres();
         this.fillPersonnes();
         this.fillClasses();
         this.fillInscription();
         this.fillEnseignements();
         this.fillBulletins();
         this.fillDetailBulletins();
         this.fillEvaluations();
    }

    /**
     * Gets the ecole's information from the database.
     * Every method fill...() will fetch every element of that table and add it.
     */
    public void retriveEcole()
    {
        ArrayList<ArrayList<String>> result = null;
        Connexion conn = Connexion.conn;
        int index = 0;
        try {
            result = conn.remplirChampsTable("ecole");
            index = conn.findColomnIndex(result,"nom");
            nom = result.get(1).get(index);
            index = conn.findColomnIndex(result,"id");
            super.id = Integer.parseInt(result.get(1).get(index));

        } catch (SQLException e) {
            e.getCause();
            e.getMessage();
        }
    }

    public void fillNiveaux()
    {
        ArrayList<ArrayList<String>> result = null;
        Connexion conn = Connexion.conn;
        int indexId = 0;
        int indexNom = 0;
        int id = 0;
        String nom;

        try {
            result = conn.remplirChampsTable("niveau");
            //recuperation de l'emplacement des colonnes
            indexId = conn.findColomnIndex(result,"id");
            indexNom = conn.findColomnIndex(result,"nom");
            if(result.size() > 1)
            {
                for(int i = 1; i < result.size() ; i++)
                {
                    id = Integer.parseInt(result.get(i).get(indexId));
                    nom = result.get(i).get(indexNom);
                    new Niveau(id,nom);
                }
            }

        } catch (SQLException e) {
            e.getCause();
            e.getMessage();
        }
    }

    public void fillInscription()
    {
        ArrayList<ArrayList<String>> result = null;
        Connexion conn = Connexion.conn;
        int indexId = 0;
        int id = 0;
        int indexClasseId = 0;
        int classeId = 0;
        int indexPersonneId = 0;
        int personneId = 0;

        try {
            result = conn.remplirChampsTable("inscription");
            //recuperation de l'emplacement des colonnes
            indexId = conn.findColomnIndex(result,"id");
            indexClasseId = conn.findColomnIndex(result,"classeId");
            indexPersonneId = conn.findColomnIndex(result,"personneId");
            if(result.size() > 1)
            {
                for(int i = 1; i < result.size() ; i++)
                {
                    id = Integer.parseInt(result.get(i).get(indexId));
                    classeId = Integer.parseInt(result.get(i).get(indexClasseId));
                    personneId = Integer.parseInt(result.get(i).get(indexPersonneId));

                    new Inscription(id,eleves.get(personneId),classes.get(classeId));
                }
            }

        } catch (SQLException e) {
            e.getCause();
            e.getMessage();
        }
    }

    public void fillEnseignements()
    {
        ArrayList<ArrayList<String>> result = null;
        Connexion conn = Connexion.conn;
        int indexId = 0;
        int id = 0;
        int indexClasseId = 0;
        int classeId = 0;
        int indexPersonneId = 0;
        int personneId = 0;
        int indexDisciplineId = 0;
        int disciplineId = 0;

        try {
            result = conn.remplirChampsTable("enseignement");
            //recuperation de l'emplacement des colonnes
            indexId = conn.findColomnIndex(result,"id");
            indexClasseId = conn.findColomnIndex(result,"classeId");
            indexPersonneId = conn.findColomnIndex(result,"personneId");
            indexDisciplineId = conn.findColomnIndex(result,"disciplineId");

            if (result.size() > 1)
            {
                for (int i = 1; i < result.size() ; i++)
                {
                    id = Integer.parseInt(result.get(i).get(indexId));
                    classeId = Integer.parseInt(result.get(i).get(indexClasseId));
                    personneId = Integer.parseInt(result.get(i).get(indexPersonneId));
                    disciplineId = Integer.parseInt(result.get(i).get(indexDisciplineId));
                    new Enseignement(id,classes.get(classeId),enseignants.get(personneId),disciplines.get(disciplineId));
                }
            }

        } catch (SQLException e) {
            e.getCause();
            e.getMessage();
        }
    }

    public void fillBulletins()
    {
        ArrayList<ArrayList<String>> result = null;
        Connexion conn = Connexion.conn;
        int indexId = 0;
        int indexApprec = 0;
        int id = 0;
        String apprec;
        int indexTrimestreId = 0;
        int trimestreId = 0;
        int indexInscriptionId = 0;
        int inscriptionId = 0;

        try {
            result = conn.remplirChampsTable("bulletin");
            //recuperation de l'emplacement des colonnes
            indexId = conn.findColomnIndex(result,"id");
            indexApprec = conn.findColomnIndex(result,"appreciation");
            indexTrimestreId = conn.findColomnIndex(result,"trimestreId");
            indexInscriptionId = conn.findColomnIndex(result,"inscriptionId");
            if(result.size() > 1)
            {
                for(int i = 1; i < result.size() ; i++)
                {
                    id = Integer.parseInt(result.get(i).get(indexId));
                    apprec = result.get(i).get(indexApprec);
                    trimestreId = Integer.parseInt(result.get(i).get(indexTrimestreId));
                    inscriptionId = Integer.parseInt(result.get(i).get(indexInscriptionId));

                    new Bulletin(id, apprec, inscriptions.get(inscriptionId), trimestres.get(trimestreId));
                }
            }

        } catch (SQLException e) {
            e.getCause();
            e.getMessage();
        }
    }

    public void fillDetailBulletins()
    {
        ArrayList<ArrayList<String>> result = null;
        Connexion conn = Connexion.conn;
        int indexId = 0;
        int indexApprec = 0;
        int id = 0;
        String apprec;
        int indexBulletinId = 0;
        int bulletinId = 0;
        int indexEnseignementId = 0;
        int enseignementId = 0;

        try {
            result = conn.remplirChampsTable("detailbulletin");
            //recuperation de l'emplacement des colonnes
            indexId = conn.findColomnIndex(result,"id");
            indexApprec = conn.findColomnIndex(result,"appreciation");
            indexBulletinId = conn.findColomnIndex(result,"bulletinId");
            indexEnseignementId = conn.findColomnIndex(result,"enseignementId");
            if(result.size() > 1)
            {
                for(int i = 1; i < result.size() ; i++)
                {
                    id = Integer.parseInt(result.get(i).get(indexId));
                    apprec = result.get(i).get(indexApprec);
                    bulletinId = Integer.parseInt(result.get(i).get(indexBulletinId));
                    enseignementId = Integer.parseInt(result.get(i).get(indexEnseignementId));

                    new DetailBulletin(id,apprec,enseignements.get(enseignementId),bulletins.get(bulletinId));
                }
            }

        } catch (SQLException e) {
            e.getCause();
            e.getMessage();
        }
    }

    public void fillEvaluations()
    {
        ArrayList<ArrayList<String>> result = null;
        Connexion conn = Connexion.conn;
        int indexId = 0;
        int indexApprec = 0;
        int id = 0;
        String apprec;
        int indexDetailBulletinId = 0;
        int detailBulletinId = 0;
        int indexNote = 0;
        double note = 0;

        try {
            result = conn.remplirChampsTable("evaluation");
            //recuperation de l'emplacement des colonnes
            indexId = conn.findColomnIndex(result,"id");
            indexApprec = conn.findColomnIndex(result,"appreciation");
            indexDetailBulletinId = conn.findColomnIndex(result,"detailBulletinId");
            indexNote = conn.findColomnIndex(result,"note");
            if(result.size() > 1)
            {
                for(int i = 1; i < result.size() ; i++)
                {
                    id = Integer.parseInt(result.get(i).get(indexId));
                    apprec = result.get(i).get(indexApprec);
                    detailBulletinId = Integer.parseInt(result.get(i).get(indexDetailBulletinId));
                    note = Double.parseDouble(result.get(i).get(indexNote));

                    new Evaluation(id,note,apprec,detailBulletins.get(detailBulletinId));
                }
            }

        } catch (SQLException e) {
            e.getCause();
            e.getMessage();
        }
    }

    public void fillClasses()
    {
        ArrayList<ArrayList<String>> result = null;
        Connexion conn = Connexion.conn;
        int indexId = 0;
        int indexNom = 0;
        int id = 0;
        String nom;
        int indexEcoleId = 0;
        int ecoleId = 0;
        int indexNiveauId = 0;
        int niveauId = 0;
        int indexAnneeScolId = 0;
        int anneeScolId = 0;


        try {
            result = conn.remplirChampsTable("classe");
            //recuperation de l'emplacement des colonnes
            indexId = conn.findColomnIndex(result,"id");
            indexNom = conn.findColomnIndex(result,"nom");
            indexEcoleId = conn.findColomnIndex(result,"ecoleId");
            indexNiveauId = conn.findColomnIndex(result,"niveauId");
            indexAnneeScolId = conn.findColomnIndex(result,"anneeScolId");
            if(result.size() > 1)
            {
                for(int i = 1; i < result.size() ; i++)
                {
                    id = Integer.parseInt(result.get(i).get(indexId));
                    nom = result.get(i).get(indexNom);
                    niveauId = Integer.parseInt(result.get(i).get(indexNiveauId));
                    ecoleId = Integer.parseInt(result.get(i).get(indexEcoleId));
                    anneeScolId = Integer.parseInt(result.get(i).get(indexAnneeScolId));
                    new Classe(id, nom, this, niveaux.get(niveauId), anneeScolaires.get(anneeScolId));
                }
            }

        } catch (SQLException e) {
            e.getCause();
            e.getMessage();
        }
    }

    public void fillDisciplines()
    {
        ArrayList<ArrayList<String>> result = null;
        Connexion conn = Connexion.conn;
        int indexId = 0;
        int indexNom = 0;
        int id = 0;
        String nom;

        try {
            result = conn.remplirChampsTable("discipline");
            //recuperation de l'emplacement des colonnes
            indexId = conn.findColomnIndex(result,"id");
            indexNom = conn.findColomnIndex(result,"nom");
            if(result.size() > 1)
            {
                for(int i = 1; i < result.size() ; i++)
                {
                    id = Integer.parseInt(result.get(i).get(indexId));
                    nom = result.get(i).get(indexNom);
                    new Discipline(id,nom);
                }
            }

        } catch (SQLException e) {
            e.getCause();
            e.getMessage();
        }
    }

    public void fillAnneeScolaires()
    {
        ArrayList<ArrayList<String>> result = null;
        Connexion conn = Connexion.conn;
        int indexId = 0;
        int id = 0;

        try {
            result = conn.remplirChampsTable("anneescolaire");
            //recuperation de l'emplacement des colonnes
            indexId = conn.findColomnIndex(result,"id");
            if(result.size() > 1)
            {
                for(int i = 1; i < result.size() ; i++)
                {
                    id = Integer.parseInt(result.get(i).get(indexId));
                    new AnneeScolaire(id);
                }
            }

        } catch (SQLException e) {
            e.getCause();
            e.getMessage();
        }
    }

    public void fillPersonnes()
    {
        ArrayList<ArrayList<String>> result = null;
        Connexion conn = Connexion.conn;
        int indexId = 0;
        int id = 0;
        int indexPrenom = 0;
        String prenom;
        int indexNom = 0;
        String nom;
        int indexType = 0;
        int type = 0;

        try {
            result = conn.remplirChampsTable("personne");
            //recuperation de l'emplacement des colonnes
            indexId = conn.findColomnIndex(result,"id");
            indexNom = conn.findColomnIndex(result,"nom");
            indexPrenom = conn.findColomnIndex(result,"prenom");
            indexType = conn.findColomnIndex(result,"type");
            if(result.size() > 1)
            {
                for(int i = 1; i < result.size() ; i++)
                {
                    id = Integer.parseInt(result.get(i).get(indexId));
                    type = Integer.parseInt(result.get(i).get(indexType));
                    nom = result.get(i).get(indexNom);
                    prenom = result.get(i).get(indexPrenom);
                   Personne.createPersonne(id,nom,prenom,type);
                }
            }

        } catch (SQLException e) {
            e.getCause();
            e.getMessage();
        }
    }

    public void fillTrimestres()
    {
        ArrayList<ArrayList<String>> result = null;
        Connexion conn = Connexion.conn;
        int indexId = 0;
        int id = 0;
        int indexNum = 0;
        int num = 0;
        int indexAnneeScolId = 0;
        int anneeScolId = 0;
        int indexDebut = 0;
        LocalDate debut;
        int indexfin = 0;
        LocalDate fin;
        String annee;
        String mois;
        String jour;


        try {
            result = conn.remplirChampsTable("trimestre");
            //recuperation de l'emplacement des colonnes
            indexId = conn.findColomnIndex(result,"id");
            indexNum = conn.findColomnIndex(result,"numero");
            indexAnneeScolId = conn.findColomnIndex(result,"anneeScolId");
            indexDebut = conn.findColomnIndex(result,"debut");
            indexfin = conn.findColomnIndex(result,"fin");

            if(result.size() > 1)
            {
                for(int i = 1; i < result.size() ; i++)
                //noinspection Duplicates
                {
                    annee = result.get(i).get(indexDebut).substring(0,4);
                    mois = result.get(i).get(indexDebut).substring(5,7);
                    jour = result.get(i).get(indexDebut).substring(8,10);
                    debut = LocalDate.of(Integer.parseInt(annee),Integer.parseInt(mois),Integer.parseInt(jour));
                    annee = result.get(i).get(indexfin).substring(0,4);
                    mois = result.get(i).get(indexfin).substring(5,7);
                    jour = result.get(i).get(indexfin).substring(8,10);
                    fin = LocalDate.of(Integer.parseInt(annee),Integer.parseInt(mois),Integer.parseInt(jour));
                    id = Integer.parseInt(result.get(i).get(indexId));
                    num = Integer.parseInt(result.get(i).get(indexNum));
                    anneeScolId = Integer.parseInt(result.get(i).get(indexAnneeScolId));
                    new Trimestre(id,num,debut,fin,anneeScolaires.get(anneeScolId));
                }
            }

        } catch (SQLException e) {
            e.getCause();
            e.getMessage();
        }
    }

    private void reinitTreeMaps()
    {
        Ecole cont = Ecole.getInstance();
        cont.classes.clear();
        cont.anneeScolaires.clear();
        cont.bulletins.clear();
        cont.detailBulletins.clear();
        cont.disciplines.clear();
        cont.enseignements.clear();
        cont.evaluations.clear();
        cont.inscriptions.clear();
        cont.niveaux.clear();
        cont.trimestres.clear();
        cont.personnes.clear();
        cont.eleves.clear();
        cont.enseignants.clear();
    }

    public void showTest()
    {
        System.err.println("\n----------------------------------------------------");
        System.err.println("niveaux " + niveaux.size());
        niveaux.forEach((key, value) -> System.err.println("Clé : " + key + " Valeur : " + value.getNom()));
        System.err.println(disciplines.size());
        disciplines.forEach((key, value) -> System.err.println("Clé : " + key + " Valeur : " + value.getNom()));
        System.err.println(anneeScolaires.size());
        anneeScolaires.forEach((key, value) -> System.err.println("Clé : " + key + " Valeur : " + value.getEndYear()));
        System.err.println(trimestres.size());
        trimestres.forEach((key, value) -> System.err.println("Clé : " + key + " Valeur : " + value.getDebut().toString()));
        System.err.println(personnes.size());
        personnes.forEach((key, value) -> System.err.println("Clé : " + key + " Valeur : " + value.getNom()));
        System.err.println(classes.size());
        classes.forEach((key, value) -> System.err.println("Clé : " + key + " Valeur : " + value.getNom()));
        System.err.println("inscri " + inscriptions.size());
        inscriptions.forEach((key, value) -> System.err.println("Clé : " + key + " Valeur : " + value.getId()));
        System.err.println(enseignements.size());
        enseignements.forEach((key, value) -> System.err.println("Clé : " + key + " Valeur : " + value.getDiscipline().getNom()));
        System.err.println(bulletins.size());
        bulletins.forEach((key, value) -> System.err.println("Clé : " + key + " Valeur : " + value.getAppreciation()));
         System.err.println(detailBulletins.size());
            detailBulletins.forEach((key, value) -> System.err.println("Clé : " + key + " Valeur : " + value.getAppreciation()));
         System.err.println(evaluations.size());
            evaluations.forEach((key, value) -> System.err.println("Clé : " + key + " Valeur : " + value.getNote()));

        System.err.println("----------------------------------------------------\n\n\n\n\n");
    }

    /**
     * Returns the static instance of this class. There can only be one Ecole at any given time
     * @return The static instance of this class.
     */
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

    public Trimestre findTrimestre(int id) {
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

    public TreeMap<Integer, Inscription> getInscriptions() {
        return inscriptions;
    }

    public TreeMap<Integer, Enseignement> getEnseignements() { return enseignements; }

    public TreeMap<Integer, Classe> getClasses() {
        return classes;
    }

    public TreeMap<Integer, AnneeScolaire> getAnneeScolaires() {
        return anneeScolaires;
    }

    public TreeMap<Integer, Bulletin> getBulletins() {
        return bulletins;
    }

    public TreeMap<Integer, DetailBulletin> getDetailBulletins() {
        return detailBulletins;
    }

    public TreeMap<Integer, Discipline> getDisciplines() {
        return disciplines;
    }

    public TreeMap<Integer, Evaluation> getEvaluations() {
        return evaluations;
    }

    public TreeMap<Integer, Niveau> getNiveaux() {
        return niveaux;
    }

    public TreeMap<Integer, Trimestre> getTrimestres() {
        return trimestres;
    }

    public TreeMap<Integer, Personne> getPersonnes() {
        return personnes;
    }

    public TreeMap<Integer, Eleve> getEleves() {
        return eleves;
    }

    public TreeMap<Integer, Enseignant> getEnseignants() {
        return enseignants;
    }

    @Override
    public String getTableName(){
        return "ecole";
    }

}
