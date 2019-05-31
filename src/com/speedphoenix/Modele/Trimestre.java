package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trimestre extends BaseElem {
    protected int numero;
    protected LocalDate debut;
    protected LocalDate fin;
    protected AnneeScolaire anneeScolaire;
    protected ArrayList<Bulletin> bulletins;

    public Trimestre(int id, int numero, LocalDate debut, LocalDate fin, AnneeScolaire anneeScolaire) {
        super(id);
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.anneeScolaire = anneeScolaire;
        anneeScolaire.addTrimestre(this);
        Ecole.getInstance().addTrimestre(this);
    }

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

    public static void createInsertRequest(int numero,LocalDate debut,LocalDate fin, int anneeScolId, Connexion conn)
    {
        String sql = "INSERT INTO trimestre (numero,debut,fin,anneeScolId) VALUES("+numero+",'"+debut.toString()+"','"+fin.toString()+"',"+anneeScolId+");";
        conn.ajouterRequeteMaj(sql);
    }
    public void createUpdateRequest(LocalDate debut,LocalDate fin, Connexion conn)
    {
        String sql = "UPDATE trimestre SET debut = '"+debut.toString()+"', fin = '"+fin.toString()+"'WHERE id="+this.id+";";
        conn.ajouterRequeteMaj(sql);
    }


}
