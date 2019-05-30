package com.speedphoenix.Modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class AnneeScolaire extends BaseElem{
    protected ArrayList<Trimestre> trimestres;
    protected ArrayList<Classe> classes;

    // maybe add stuff to init the rest too?
    public AnneeScolaire(int id) {
        super(id);
        Ecole.getInstance().addAnneeScolaire(this);
    }

    public void addTrimestre(Trimestre what) {
        trimestres.add(what);
    }

    public void addClasse(Classe what) {
        classes.add(what);
    }

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

    //not that this could normally be replaced by getStartYear() + 1;
    public int getEndYear() {
        if (trimestres.isEmpty())
            return 0;
        Iterator<Trimestre> i = trimestres.iterator();
        LocalDate latest = i.next().getFin();
        while (i.hasNext()) {
            LocalDate curr = i.next().getDebut();
            if (curr.compareTo(latest)  > 0)
                latest = curr;
        }
        return latest.getYear();
    }
}
