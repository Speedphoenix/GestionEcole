package com.speedphoenix.Display.ModClasses.Mod;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.ModListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.BaseElem;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class JReporting extends JMotherMod {

    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanel upPanel;
    private JPanel graphicPanel;

    private BaseElem motherElem;
    private JButton retour_menu;
    public JComboBox menu;
    private JButton accepter;

    String categorie, donnee;
    ArrayList<String> liste;

    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise


    /** Constructeur */
    public JReporting(BaseElem what)
    {
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(null);

        upPanel = new JPanel();
        upPanel.setBounds(0,0,1000,200);
        upPanel.setBackground(Color.lightGray);
        upPanel.setLayout(null);

        graphicPanel = new JPanel();
        graphicPanel.setBounds(0,200,1000,800);
        graphicPanel.setBackground(Color.lightGray);
        graphicPanel.setLayout(null);

        //composants
        JLabel nomFenetre = new JLabel(" STATISTIQUES " );
        nomFenetre.setBounds(360, 10, 360,80);
        nomFenetre.setFont(new Font("Verdana",3,30));
        motherElem = what;

        String[] liste_reporting = {"Moyennes par TD","Moyennes par matières","Moyennes par promo","Nombre d'élèves par promo","Nombre de profs par discipline"};
        menu = new JComboBox(liste_reporting);
        menu.setBounds(400,100,200,30);

        retour_menu = new JButton("Retour menu");
        retour_menu.setFont(defaultF);
        retour_menu.setBounds(5, 80, 180,40);
        retour_menu.addActionListener(new ModListener(this));

        accepter = new JButton("accepter");
        accepter.setFont(defaultF);
        accepter.setBounds(620,100,120,25);
        accepter.addActionListener(new ModListener(this));

        //ajouts des composants
        upPanel.add(nomFenetre);
        upPanel.add(retour_menu);
        upPanel.add(menu);
        upPanel.add(accepter);

        mainPanel.add(upPanel);
        mainPanel.add(graphicPanel);
    }

    public void choix()
    {
        if(menu.getSelectedItem().toString().equals("Moyennes par TD"))
        {
            //renvoyer vers fonction
            categorie = "TD";
            donnee = "Moyennes";
        }
        else if(menu.getSelectedItem().toString().equals("Moyennes par matières"))
        {
            //renvoyer vers fonction
            categorie = "Matières";
            donnee = "Moyennes";
        }
        else if(menu.getSelectedItem().toString().equals("Moyennes par promo"))
        {
            //renvoyer vers fonction
            categorie = "Promo";
            donnee = "Moyennes";
        }
        else if(menu.getSelectedItem().toString().equals("Nombre d'élèves par promo"))
        {
            //renvoyer vers fonction
            categorie = "Promo";
            donnee = "Nombre d'élèves";
        }
        else if(menu.getSelectedItem().toString().equals("Nombre de profs par discipline"))
        {
            //renvoyer vers fonction
            categorie = "Matières";
            donnee = "Nombre de profs";
                    System.out.println("Coucou");
        }
    }

    public void histogramme(Hashtable<Integer,Double> a)
    {

    }

    public void camembert(Hashtable<Integer,Integer> a)
    {

    }




    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public String getType() {
        return null;
    }

}
