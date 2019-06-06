package com.speedphoenix;
import com.speedphoenix.Connexion.*;
import com.speedphoenix.Display.ModClasses.JBulletinAdd;
import com.speedphoenix.Display.ModClasses.JBulletinMod;
import com.speedphoenix.Display.ModClasses.JEleveMod;
import com.speedphoenix.Display.ModClasses.JEnseignantMod;
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



        //on crée l'école dont les données sont automatiquement téléchargés depuis la BDD
        Ecole eco = new Ecole();
        GraphicContainer mainFrame = GraphicContainer.getInstance();
        //logo
        ImageIcon image = new ImageIcon("logo.png");
        //menu De navigation gauche
        JRightNavPanel panel2 = new JRightNavPanel();
        //menu De navigation au dessus
        JUpNavBar panel3 = new JUpNavBar();
        //on crée le premier Jpanel qui sera afficher
        JClasseAff classeAff = new JClasseAff(eco);
        /*
        JInscriptionAff inscriptionAff = new JInscriptionAff(eco.getClasses().get(1));
        JEnseigmnementsAff enseigmnementsAff = new JEnseigmnementsAff(eco.getClasses().get(1));
        JBulletinsAff bulletinsAff = new JBulletinsAff(eco.getTrimestres().get(2));
        JBulDetAff jBulDetAff = new JBulDetAff(eco.findBulletin(1));
        JEvaluationAff jEvaluationAff = new JEvaluationAff(eco.findDetailBulletin(1));
        JElevesAff jElevesAff = new JElevesAff();
        JEnseignantsAff jEnseignantsAff = new JEnseignantsAff();
        JTrimestresAff trimestresAff = new JTrimestresAff();
        JNiveauAff niveauAff = new JNiveauAff();
         */


        mainFrame.setSize(1016,1000);
        mainFrame.getContentPane().setLayout(null);
        //Le premier panel à etre afficher sera les classes
        mainFrame.createInstance(panel2,panel3,classeAff);
        //l'icone du programme est inséré

        mainFrame.createInstance(panel2,panel3,classeAff);
        //mainFrame.createInstance(new JBulDetAdd(eco.getBulletins().get(1)));
       // mainFrame.createInstance(new JBulDetAdd(eco.getEnseignements().get(1)));
        //mainFrame.createInstance(new JBulletinAdd(eco.getTrimestres().get(2)));
        mainFrame.createInstance(new JClasseAdd(eco.getNiveaux().get(1)));
        //mainFrame.createInstance(new JEnseignementAdd(eco.getClasses().get(1)));

        mainFrame.setIconImage(image.getImage());
        //on affiche la Jframe
        mainFrame.setVisible(true);
    }

    public static void updateAndRefresh() {
        Connexion.conn.executeAllupdate();
        Ecole.getInstance().refresh();
    }
}
