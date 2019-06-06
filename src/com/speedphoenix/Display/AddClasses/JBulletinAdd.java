package com.speedphoenix.Display.AddClasses;

import com.speedphoenix.ActionListeners.AddListener;
import com.speedphoenix.Modele.BaseElem;
import com.speedphoenix.Modele.Inscription;
import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;
import java.util.Vector;

public class JBulletinAdd extends JMotherMod {


    private JComboBox textTrimestre;
    private JComboBox textInscription;
    private JComboBox textAppreciation;
    private JButton accept;
    private boolean bulOrInscr;//0 for bulletins,1 for inscriptions
    private int sentId;



    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    public JBulletinAdd(int Id,boolean bulOrInscr) {

        //creation des titre au dessus des objets d'interractions
        JLabel labelTrimestre;
        JLabel labelInscription;
        JLabel labelAppreciation;

        this.sentId = Id;
        this.bulOrInscr=bulOrInscr;
        if(bulOrInscr)
        {

        }



        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(null);
        //composants
        JLabel nomFenetre = new JLabel("CREATION BULLETIN");
        nomFenetre.setBounds(300, 10, 400,200);
        nomFenetre.setFont(new Font("Verdana",3,40));
        accept = new JButton("Ajouter");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));

        textTrimestre = new JComboBox();

        textTrimestre.setFont(defaultF);
        textTrimestre.setBounds(400, 300, 200,40);
        textInscription = new JComboBox();
        textInscription.setFont(defaultF);
        textInscription.setBounds(400, 500, 200,40);
        labelTrimestre = new JLabel("Choissisez le trimestre");
        labelTrimestre.setFont(defaultF);
        labelTrimestre.setBounds(400, 140, 200,100);
        labelInscription = new JLabel("Choissisez l'élève");
        labelInscription.setFont(defaultF);
        labelInscription.setBounds(400, 340, 200,100);
        labelInscription = new JLabel("Entrez une appréciation");
        labelInscription.setFont(defaultF);
        labelInscription.setBounds(400, 540, 200,100);
       //ajouts des composants
        mainPanel.add(accept);
        mainPanel.add(textTrimestre);
        mainPanel.add(textInscription);
        mainPanel.add(labelTrimestre);
        mainPanel.add(labelInscription);
        mainPanel.add(nomFenetre);

    }


    private void creation(JComboBox comboBox, TreeMap<Integer, BaseElem> copy, int id, Boolean allOrNot){ // if allOrNot true, just take from a specific Id, else take all

        if(allOrNot)
        {
            for(Integer i: copy.keySet())
            {
                if(copy.get(i).getId()==id)
                    addStringToListModel(i);
            }
        }
        else if (buffClass == Inscription.class) {
            for (Integer i : copy.keySet()) {
                if (copy.get(i).getInscription().getId() == id)
                    addStringToListModel(i);
            }
        }

        mainList = new JList<>(buffList);// on ajoute le liste des strings dans notre Jlist
        mainList.setFont(defaultF);
        mainList.setBounds(0,0,800,900);

        mainPanel.add(mainList);// On ajoute notre Jlist avec scroll sur notre Jpanel
        mainPanel.setBackground(Color.darkGray);
    }

    
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public String getType() {
        return "eleve";
    }

    public JComboBox gettextTrimestre() {
        return textTrimestre;
    }

    public JComboBox gettextInscription() {
        return textInscription;
    }



    public JButton getAccept() {
        return accept;
    }

    public Font getDefaultF() {
        return defaultF;
    }
}
