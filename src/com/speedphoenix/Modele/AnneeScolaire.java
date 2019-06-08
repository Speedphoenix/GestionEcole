package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A mirror of the anneescolaire table in the SQL Database
 */
public class AnneeScolaire extends BaseElem{
    protected ArrayList<Trimestre> trimestres;
    protected ArrayList<Classe> classes;

    /**
     *
     * @param id the id of the entry in the SQL table
     */
    public AnneeScolaire(int id) {
        super(id);
        trimestres = new ArrayList<>();
        classes = new ArrayList<>();
        Ecole.getInstance().addAnneeScolaire(this);
        this.addTableChildren(trimestres);
        this.addTableChildren(classes);
    }

    /**
     * Adds a reference to a Trimestre to the list of child Trimestres
     * @param what the {@link Trimestre} to add
     */
    protected void addTrimestre(Trimestre what) {
        trimestres.add(what);
    }

    /**
     * Adds a reference to a {@link Classe} to the list of child Classes
     * @param what the {@link Classe} to add
     */
    protected void addClasse(Classe what) {
        classes.add(what);
    }

    /**
     * Returns the starting year of this school year. This looks through the trimestres of this year to find it
     * @return The starting year of this school year
     */
    public int getStartYear() {
        if (trimestres.isEmpty())
            return 0;
        Iterator<Trimestre> i = trimestres.iterator();
        LocalDate earliest = i.next().getDebut();
        while (i.hasNext()) {
            LocalDate curr = i.next().getDebut();
            if (curr.compareTo(earliest) < 0)
                earliest = curr;
        }
        return earliest.getYear();
    }


    /**
     * Returns the ending year of this school year
     * note this behaves in essence as getStartYear() + 1;
     * @return The ending year of this school year
     */
    public int getEndYear() {
        if (trimestres.isEmpty())
            return 0;
        Iterator<Trimestre> i = trimestres.iterator();
        LocalDate latest = i.next().getFin();
        while (i.hasNext()) {
            LocalDate curr = i.next().getFin();
            if (curr.compareTo(latest)  > 0)
                latest = curr;
        }
        return latest.getYear();
    }

    /**
     * Creates the query to add a new AnneeScolaire to the database
     * @param conn The connection to the database used
     */
    public static void createInsertRequest(Connexion conn) {

        String sql = "INSERT INTO anneescolaire VALUES ();";
        conn.ajouterRequeteMaj(sql);
    }

    @Override
    public String getTableName(){
        return "anneescolaire";
    }


}
