package com.speedphoenix.temp;

import com.speedphoenix.Connexion.Connexion;

import java.sql.SQLException;
import java.util.ArrayList;

public class bulletin {

    public Connexion conn;

    public bulletin(Connexion conn) {
        this.conn = conn;
    }

    public void main()
    {
        ArrayList<ArrayList<String>> result = null;

        try {
            result = conn.remplirChampsTable("");
        } catch (SQLException e) {
            e.getCause();
            e.printStackTrace();
        }
    }

    public double findMoyEnseignement(int enseigneId, int inscriptionId ,int trimestreId )
    {
        //déclaration des variables
        String requete;
        double moyenne = 21;
        int bulletinId = 0;
        int bulletinDetId = 0;
        ArrayList<ArrayList<String>> result = null;

        //on récupère d'abord l'id du bulletin
        requete = "SELECT id FROM `bulletin` WHERE InscriptionId="+inscriptionId+" and trimestreId ="+trimestreId+"";
        try {
            result = conn.remplirChampsRequete(requete);
        } catch (SQLException e) {
            e.getCause();
            e.printStackTrace();
            return 21;

        }
        //si on trouve 1 seul bulletin (ce qui est normal)
        if(result.size() == 2)
        {
            bulletinId=Integer.parseInt(result.get(1).get(0));
            requete = "SELECT id FROM `detailbulletin` WHERE enseignementId ="+enseigneId+" AND bulletinId = "+bulletinId+"";
            try {
                result = conn.remplirChampsRequete(requete);
            } catch (SQLException e) {
                e.getCause();
                e.printStackTrace();
                return 21;

            }
            //si on trouve 1 seul bulletin (ce qui est normal)
            if(result.size() == 2)
            //noinspection Duplicates
            {
                bulletinDetId = Integer.parseInt(result.get(1).get(0));
                requete = "SELECT AVG(note) FROM `evaluation` WHERE detailBulletinId = "+bulletinDetId+"";
                try {
                    result = conn.remplirChampsRequete(requete);
                } catch (SQLException e) {
                    e.getCause();
                    e.printStackTrace();
                    return 21;
                }
                if(result.size() == 2)
                {
                    moyenne = Double.parseDouble(result.get(1).get(0));
                }else
                {
                    System.err.println("Erreur de resultat pour les parametres suivants : \n" +
                            "bulletinDetId : " + bulletinDetId +
                            "\ntaille du resultat : "+result.size());
                }

            }
            else
            {
                System.err.println("pas de bulletin détaillé trouvé ou trop de résultats pour les parametres suivants : \n" +
                        "bulletinId : " + bulletinId +
                        "\nenseignementId : " + enseigneId +
                        "\ntaille du resultat : "+result.size());
            }



        }
        else
        {
            System.err.println("pas de bulletin trouvé ou trop de résultats pour les parametres suivants : \n" +
                    "inscriptionId : "+ inscriptionId +
                    "\ntrimestreId : " + trimestreId +
                    "\ntaille du resultat : "+result.size());
        }


        return moyenne;
    }
    @SuppressWarnings("Duplicates")
    public double findMoyGen(int inscriptionId , int trimestreId )
    {

        //déclaration des variables
        String requete;
        double moyenne = 21;
        int bulletinId = 0;
        ArrayList<Integer> bulletinDetId = new ArrayList<Integer>();
        ArrayList<Double> moyennes = new ArrayList<Double>();
        ArrayList<ArrayList<String>> result = null;

        //on récupère d'abord l'id du bulletin
        requete = "SELECT id FROM `bulletin` WHERE InscriptionId="+inscriptionId+" and trimestreId ="+trimestreId+"";
        try {
            result = conn.remplirChampsRequete(requete);
        } catch (SQLException e) {
            e.getCause();
            e.printStackTrace();
            return 21;

        }
        //si on trouve 1 seul bulletin (ce qui est normal)
        if(result.size() == 2)
        {
            bulletinId=Integer.parseInt(result.get(1).get(0));
            requete = "SELECT id FROM `detailbulletin` WHERE  bulletinId = "+bulletinId+"";
            try {
                result = conn.remplirChampsRequete(requete);
            } catch (SQLException e) {
                e.getCause();
                e.printStackTrace();
                return 21;

            }
            //si on trouve au moins 1 résultat
            if(result.size() > 1)
            {
                for(int i = 1;i < result.size(); i++)
                {
                    bulletinDetId.add(Integer.parseInt(result.get(i).get(0)));
                }

                //on calcule les moyennes pour chaque enseignements et on les sauvegarde
                for(int i = 0;i < result.size(); i++)
                {
                    requete = "SELECT AVG(note) FROM `evaluation` WHERE detailBulletinId = "+bulletinDetId.get(i)+"";
                    try {
                        result = conn.remplirChampsRequete(requete);
                    } catch (SQLException e) {
                        e.getCause();
                        e.printStackTrace();
                        return 21;
                    }
                    if(result.size() == 2)
                    {
                        moyennes.add(Double.parseDouble(result.get(1).get(0)));
                    }else
                    {
                        System.err.println("Erreur de resultat pour les parametres suivants : \n" +
                                "bulletinDetId : " + bulletinDetId +
                                "\ntaille du resultat : "+result.size());
                    }
                }
                //calcul de la moyenne total
                moyenne=0;
                for (int i = 0; i < moyennes.size();i++){
                    moyenne += moyennes.get(i);
                }
                return moyenne/moyennes.size();


            }
            else
            {
                System.err.println("pas de bulletin détaillé trouvé ou trop de résultats pour les parametres suivants : \n" +
                        "bulletinId : " + bulletinId +
                        "\ntaille du resultat : "+result.size());
            }



        }
        else
        {
            System.err.println("pas de bulletin trouvé ou trop de résultats pour les parametres suivants : \n" +
                    "inscriptionId : "+ inscriptionId +
                    "\ntrimestreId : " + trimestreId +
                    "\ntaille du resultat : "+result.size());
        }


        return moyenne;
    }

}
