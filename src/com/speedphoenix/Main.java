package com.speedphoenix;
import com.jcraft.jsch.*;
import com.speedphoenix.Connexion.*;
import com.speedphoenix.Modele.*;
import com.speedphoenix.temp.bulletin;

import java.sql.SQLException;
import java.time.LocalDate;
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
        //conn.displayRemplirChampsRequete("Select * from discipline");

        bulletin bullet = new bulletin(conn);


        //System.out.println(conn.testExistanceId(2,"anneescolaire"));

        //AnneeScolaire.createInsertRequest(conn);
      //  DetailBulletin.createInsertRequest("vous êtes une truite.",1,1,conn);
       // Enseignant.createInsertRequest("Froussin","Detective",conn);
        //Evaluation.createInsertRequest("gros serieux ?",1,1,conn);
       // Niveau.createInsertRequest("CP",conn);
        //Trimestre.createInsertRequest(2,LocalDate.of(1997,11,03),LocalDate.of(1998,02,03),1,conn);


        conn.executeAllupdate();




    }
}
