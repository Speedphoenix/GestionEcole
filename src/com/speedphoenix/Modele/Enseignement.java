package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

public class Enseignement extends BaseElem {
    protected Classe classe;
    protected Enseignant enseignant;
    protected Discipline discipline;
    protected ArrayList<DetailBulletin> detailBulletins;

    public Enseignement(int id, Classe classe, Enseignant enseignant, Discipline discipline) {
        super(id);
        this.classe = classe;
        this.enseignant = enseignant;
        this.discipline = discipline;
        detailBulletins = new ArrayList<>();
        classe.addEnseignement(this);
        enseignant.addEnseignement(this);
        discipline.addEnseignement(this);
        Ecole.getInstance().addEnseignement(this);
    }

    public void addDetailBulletin(DetailBulletin what) {
        detailBulletins.add(what);
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

    public static void createInsertRequest(int classeId,int disciplineId,int personneId, Connexion conn)
    {
        String sql = "INSERT INTO enseignement (classeId,disciplineId,personneId)VALUES("+classeId+","+disciplineId+","+personneId+");";
        conn.ajouterRequeteMaj(sql);
    }

}
