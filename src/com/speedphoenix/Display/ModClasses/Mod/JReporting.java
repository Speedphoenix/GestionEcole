package com.speedphoenix.Display.ModClasses.Mod;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.ModListener;
import com.speedphoenix.ActionListeners.ContentPanel.ListSelectListener;
import com.speedphoenix.Display.Affclasses.JPanTable;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.BaseElem;
import com.speedphoenix.Modele.Ecole;
import com.speedphoenix.Modele.Eleve;
import com.speedphoenix.Modele.Enseignant;

import javax.swing.*;
import java.awt.*;

public class JReporting extends JMotherMod {

    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private BaseElem motherElem;
    private JButton retour_menu;


    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise


    /** Constructeur */
    public JReporting(BaseElem what)
    {
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(null);

        //composants
        JLabel nomFenetre = new JLabel(" STATISTIQUES " );
        nomFenetre.setBounds(360, 10, 360,80);
        nomFenetre.setFont(new Font("Verdana",3,30));
        motherElem = what;

        String[] liste_reporting = {"Moyennes par TD","Moyennes par matières","Moyennes par promo","Nombre d'élèves par promo","Nombre de profs par discipline"};
        JComboBox menu = new JComboBox(liste_reporting);
        menu.setBounds(400,100,200,30);

        retour_menu = new JButton("Retour menu");
        retour_menu.setFont(defaultF);
        retour_menu.setBounds(800, 900, 180,40);
        retour_menu.addActionListener(new ModListener(this));


        //ajouts des composants
        mainPanel.add(retour_menu);
        mainPanel.add(nomFenetre);
        mainPanel.add(menu);


    }



    /** String[] liste_reporting = {"Moyennes par TD","Moyennes par matières","Moyennes par promo","Nombre d'élèves par promo","Nombre de profs par discipline"}
     * JComboBox menu_déroulant = new JComboBox(liste_reporting);
     *
     *
     * **/





    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public String getType() {
        return null;
    }

}
