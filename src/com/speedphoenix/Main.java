package com.speedphoenix;
import com.speedphoenix.Connexion.*;
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

        double moy=0;
        try {
            conn = new Connexion(DATABASE_NAME, LOGIN_DATABASE, PASSWORD_DATABASE);
        } catch (SQLException e) {
            //e.printStackTrace();
            throw e;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




        Ecole eco = new Ecole();

        //eco.showTest();

        //JStudentsPanel Panel = new JStudentsPanel(eco.getInscriptions());
        //JStudentsChosen panel = new JStudentsChosen(1,1,eco.getInscriptions());
        JRightNavPanel panel2 = new JRightNavPanel();
        JUpNavBar panel3 = new JUpNavBar();
        //JProfessorsChosen panel4 = new JProfessorsChosen(1,eco.getEnseignements());
        //JTrimestresAff trimestresAff = new JTrimestresAff(eco.getTrimestres());
        //JNiveauAff niveauAff = new JNiveauAff(eco.getNiveaux());
        //JClasseAff classeAff = new JClasseAff(1,2, eco.getClasses());
        JElevesAff elevesAff = new JElevesAff(1,eco.getInscriptions());
        //JEnseigmnementsAff enseigmnementsAff = new JEnseigmnementsAff(1,eco.getEnseignements());
        //JBulletinsAff bulletinsAff = new JBulletinsAff(2,2,eco.getBulletins());

        GraphicContainer mainFrame = GraphicContainer.getInstance();

        mainFrame.setSize(1000,1000);
        mainFrame.getContentPane().setLayout(null);
        //mainFrame.add(panel.getMainPanel());
        //mainFrame.add(panel2.getMainPanel());
        //mainFrame.add(panel3.getMainPanel());
        //mainFrame.add(panel4.getMainPanel());
        //mainFrame.add(trimestresAff.getMainPanel());
        //mainFrame.add(niveauAff.getMainPanel());
        //mainFrame.add(classeAff.getMainPanel());
        //mainFrame.add(elevesAff.getMainPanel());

        mainFrame.createInstance(panel2,panel3,elevesAff);

        mainFrame.setVisible(true);




    }
}
