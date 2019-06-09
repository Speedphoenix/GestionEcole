package com.speedphoenix;
import com.speedphoenix.Connexion.*;

import com.speedphoenix.Display.*;
import com.speedphoenix.Display.Affclasses.JClasseAff;
import com.speedphoenix.Display.Affclasses.JRightNavPanel;
import com.speedphoenix.Display.Affclasses.JUpNavBar;
import com.speedphoenix.Display.ModClasses.Add.JTrimestreAdd;


import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;



/*
*
* SOURCES :
*   - DatePicker : https://stackoverflow.com/questions/26794698/how-do-i-implement-jdatepicker
*   - Center a text Area : https://stackoverflow.com/questions/17161587/how-to-center-align-text-in-jtextarea/49081289
* */
public class Main {

    public static void main(String[] args) throws SQLException {
        //declaration des variables

        final String DATABASE_NAME = "G6H93QtWu6";
        final String LOGIN_DATABASE = "G6H93QtWu6"; //"root";
        final String PASSWORD_DATABASE = "TyGM5Zgqrk";
        final String SERVER_DATABASE = "remotemysql.com:3306";
        Connexion conn = null;
        ArrayList<ArrayList<String>> result = null;
        double moy=0;
        GraphicContainer mainFrame = GraphicContainer.getInstance();


        //connextion à la Bdd Mysql en ligne
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



        //logo
        ImageIcon image = new ImageIcon("logo.png");
        //menu De navigation gauche
        JRightNavPanel panel2 = new JRightNavPanel();
        //menu De navigation au dessus
        JUpNavBar panel3 = new JUpNavBar();
        //on crée le premier Jpanel qui sera afficher
        JClasseAff classeAff = new JClasseAff(eco);

        mainFrame.setSize(1016,1060);
        mainFrame.getContentPane().setLayout(null);


        //Le premier panel à etre afficher sera les classes
        mainFrame.createInstance(panel2,panel3,classeAff);
        //l'icone du programme est inséré

        mainFrame.setIconImage(image.getImage());

        mainFrame.setIconImage(image.getImage()); **/

        mainFrame.createInstance(new JReporting(eco));


        //on affiche la Jframe
        mainFrame.setVisible(true);
    }

    public static void updateAndRefresh() {
        Connexion.conn.executeAllupdate();
        Ecole.getInstance().refresh();
    }
}
