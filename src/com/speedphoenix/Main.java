package com.speedphoenix;
import com.speedphoenix.Connexion.*;
import com.speedphoenix.Modele.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World !");
        Connexion conn = null;
        ArrayList<ArrayList<String>> result = null;
        final String DATABASE_NAME = "gestionecole";
        final String LOGIN_DATABASE = "gestionEcole"; //"root";
        final String PASSWORD_DATABASE = "";

        double moy=0;
        try {
            conn = new Connexion(DATABASE_NAME, LOGIN_DATABASE, PASSWORD_DATABASE);
        } catch (SQLException e) {
            //e.printStackTrace();
            throw e;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //conn.displayRemplirChampsTables("discipline");
        //conn.displayRemplirChampsRequete("Select * from discipline");

        //System.out.println(conn.testExistanceId(2,"anneescolaire"));

        //AnneeScolaire.createInsertRequest(conn);
        //  DetailBulletin.createInsertRequest("vous êtes une truite.",1,1,conn);
        // Enseignant.createInsertRequest("Froussin","Detective",conn);
        //Evaluation.createInsertRequest("gros serieux ?",1,1,conn);
        // Niveau.createInsertRequest("CP",conn);
        //Trimestre.createInsertRequest(2,LocalDate.of(1997,11,03),LocalDate.of(1998,02,03),1,conn);
        //conn.executeAllupdate();


        Ecole eco = new Ecole();

        eco.showTest();




    }
}
