package com.speedphoenix.Modele;

import java.util.ArrayList;

public class Enseignement {
    protected int id;
    protected Classe classe;
    protected Enseignant enseignant;
    protected Discipline discipline;
    protected ArrayList<DetailBulletin> detailBulletins;

    public Enseignement(int id, Classe classe, Enseignant enseignant, Discipline discipline) {
        this.id = id;
        this.classe = classe;
        this.enseignant = enseignant;
        this.discipline = discipline;
        classe.addEnseignement(this);
        enseignant.addEnsegnement(this);
        discipline.addEnseignement(this);
    }

    public void addDetailBulletin(DetailBulletin what) {
        detailBulletins.add(what);
    }

    public int getId() {
        return id;
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
}
