package com.speedphoenix;
import com.jcraft.jsch.*;
import com.speedphoenix.Connexion.*;
import com.speedphoenix.temp.bulletin;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World !");
        Connexion conn = null;
        ArrayList<ArrayList<String>> result = null;
        final String DATABASE_NAME="gestionecole";
        final String LOGIN_DATABASE="root";
        final String PASSWORD_DATABASE="";
        final int ENSEIGN_ID=2;
        final int INSCRIPTION_ID=1;
        final int TRIMESTRE_ID=2;

        double moy=0;
        try {
            conn = new Connexion(DATABASE_NAME, LOGIN_DATABASE, PASSWORD_DATABASE);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //conn.displayRemplirChampsTables("discipline");
        conn.displayRemplirChampsRequete("Select * from discipline");

        bulletin bullet = new bulletin(conn);
        moy = bullet.findMoyEnseignement(ENSEIGN_ID,INSCRIPTION_ID,TRIMESTRE_ID);
        if(moy > 20)
        {
            System.err.println("Erreur au calcul de la moyenne");
        }
        else
            System.out.println("La moyenne de l'enseignement"+ENSEIGN_ID+" est de : " + moy);
        moy = bullet.findMoyGen(1,2);
        if(moy > 20)
        {
            System.err.println("Erreur au calcul de la moyenne");
        }
        else
            System.out.println("La moyenne totale est de : " + moy);


    }
}
