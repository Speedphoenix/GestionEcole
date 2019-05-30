package com.speedphoenix.Modele;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trimestre {
    protected int id;
    protected int numero;
    protected LocalDate debut;
    protected LocalDate fin;
    protected AnneeScolaire anneeScolaire;
    protected ArrayList<Bulletin> bulletins;

    public Trimestre(int id, int numero, LocalDate debut, LocalDate fin, AnneeScolaire anneeScolaire) {
        this.id = id;
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.anneeScolaire = anneeScolaire;
        anneeScolaire.addTrimestre(this);
    }

    public void addBulletin(Bulletin what) {
        bulletins.add(what);
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public int getId() {
        return id;
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
}
