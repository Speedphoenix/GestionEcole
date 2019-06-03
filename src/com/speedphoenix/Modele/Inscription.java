package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

public class Inscription extends BaseElem {
    protected Classe classe;
    protected Eleve eleve;
    ArrayList<Bulletin> bulletins;

    public Inscription(int id, Eleve eleve, Classe classe) {
        super(id);
        this.eleve = eleve;
        this.classe = classe;
        bulletins = new ArrayList<>();
        classe.addInscription(this);
        eleve.addInscription(this);
        Ecole.getInstance().addInscription(this);
        this.addTableChildren(bulletins);
    }

    public void addBulletin(Bulletin what) {
        bulletins.add(what);
    }

    public Eleve getEleve() {
        return eleve;
    }

    public Classe getClasse() {
        return classe;
    }

    public static void createInsertRequest( int classeId, int personneId, Connexion conn)
    {
        String sql = "INSERT INTO inscription  (classeId,personneId)VALUES("+classeId+","+personneId+");";
        conn.ajouterRequeteMaj(sql);
    }
    public String getTableName(){
        return "inscription";
    }

}
