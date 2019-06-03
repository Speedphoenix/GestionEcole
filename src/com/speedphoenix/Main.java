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
        final String DATABASE_NAME = "G6H93QtWu6";
        final String LOGIN_DATABASE = "G6H93QtWu6"; //"root";
        final String PASSWORD_DATABASE = "TyGM5Zgqrk";
        final String SERVER_DATABASE = "remotemysql.com:3306";

        double moy=0;
        try {
            conn = new Connexion(DATABASE_NAME, LOGIN_DATABASE, PASSWORD_DATABASE, SERVER_DATABASE);
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

        //eco.findEleve(8).createDeleteRequest(Connexion.conn);
        //updateAndRefresh();
        //eco.refresh();

        //eco.showTest();
    }

    public static void updateAndRefresh() {
        Connexion.conn.executeAllupdate();
        Ecole.getInstance().refresh();
    }
}
