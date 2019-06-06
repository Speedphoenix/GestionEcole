package com.speedphoenix;
import com.speedphoenix.Connexion.*;
import com.speedphoenix.Display.AddClasses.JBulletinAdd;
import com.speedphoenix.Display.AddClasses.JEleveAdd;
import com.speedphoenix.Display.AddClasses.JEnseignantAdd;
import com.speedphoenix.Modele.*;
import com.speedphoenix.Display.*;

import javax.swing.*;
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




        Ecole eco = new Ecole();
        GraphicContainer mainFrame = GraphicContainer.getInstance();
        //logo
        ImageIcon image = new ImageIcon("logo.png");


        JRightNavPanel panel2 = new JRightNavPanel();
        JUpNavBar panel3 = new JUpNavBar();
        //JProfessorsChosen panel4 = new JProfessorsChosen(1,eco.getEnseignements());
        JTrimestresAff trimestresAff = new JTrimestresAff();
        JNiveauAff niveauAff = new JNiveauAff();
        JClasseAff classeAff = new JClasseAff(eco.getNiveaux().get(1));
        JInscriptionAff inscriptionAff = new JInscriptionAff(eco.getClasses().get(1));
        JEnseigmnementsAff enseigmnementsAff = new JEnseigmnementsAff(eco.getClasses().get(1));
        JBulletinsAff bulletinsAff = new JBulletinsAff(eco.getInscriptions().get(1));
        JBulDetAff jBulDetAff = new JBulDetAff(eco.findBulletin(1));
        JEvaluationAff jEvaluationAff = new JEvaluationAff(eco.findDetailBulletin(1));
        JElevesAff jElevesAff = new JElevesAff();
        JEnseignantsAff jEnseignantsAff = new JEnseignantsAff();


        mainFrame.setSize(1050,1000);
        mainFrame.getContentPane().setLayout(null);

        mainFrame.createInstance(panel2,panel3,inscriptionAff);
        mainFrame.createInstance(new JBulletinAdd(eco.getInscriptions().get(1)));
        mainFrame.setIconImage(image.getImage());

        mainFrame.setVisible(true);


    }

    public static void updateAndRefresh() {
        Connexion.conn.executeAllupdate();
        Ecole.getInstance().refresh();
    }
}
