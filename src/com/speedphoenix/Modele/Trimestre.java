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
        bulletins = new ArrayList<>();
        anneeScolaire.addTrimestre(this);
        Ecole.getInstance().addTrimestre(this);
        this.addTableChildren(bulletins);
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
    public void createUpdateRequest(int numero,LocalDate debut,LocalDate fin, Connexion conn)
    {
        String sql = "UPDATE trimestre SET debut = '"+debut.toString()+"', fin = '"+fin.toString()+"', numero = "+numero+" WHERE id = "+this.id+";";
        System.out.println(sql);
        conn.ajouterRequeteMaj(sql);
    }
    public static LocalDate changeInLocaldate(String date)
    {
        int annee = Integer.parseInt(date.substring(0,4));
        int mois = Integer.parseInt(date.substring(5,7));
        int jour = Integer.parseInt(date.substring(8,10));

        LocalDate localdate = LocalDate.of(annee,mois,jour);
        return localdate;
    }
    public String getTableName(){
        return "trimestre";
    }



}
