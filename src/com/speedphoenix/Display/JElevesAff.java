package com.speedphoenix.Display;

import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JElevesAff {
    JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    JList<String> mainList;// Jliste qui va afficher les informations
    DefaultListModel <String> buffList;// Liste qui va assembles les strings contenant les informations a afficher
    TreeMap<Integer, Inscription> mapCopy;//map contenant les objets avec les infos

    Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    //ici on passe l'id e la classe
    public JElevesAff(int id, TreeMap<Integer, Inscription> mapToCopy) {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        buffList = new DefaultListModel<>();
        this.mapCopy=mapToCopy;
        this.creation(id);
    }

    private void creation(int id){ // methode d'initialisation des Jlists et Jpanels

        for(Integer i: mapCopy.keySet())
        {
            if(mapCopy.get(i).getClasse().getId()==id)
            addStringToListModel(i);
        }

        mainList = new JList<>(buffList);// on ajoute le liste des strings dans notre Jlist
        mainList.setFont(defaultF);
        mainPanel.add(new JScrollPane(mainList));// On ajoute notre Jlist avec scroll sur notre Jpanel
        mainPanel.setBackground(Color.darkGray);
    }

    public void addStringToListModel(Integer i){ // composition de string contenant les infos de l'objet
        String data = new String("");

        data+= "  Nom: "+ mapCopy.get(i).getEleve().getNom();
        data+= "  Prenom: "+ mapCopy.get(i).getEleve().getPrenom();
        data+= "  ID: "+ mapCopy.get(i).getEleve().getId();
        data+= "  Classe: "+ mapCopy.get(i).getClasse().getNom();
        data+= "  Niveau: "+ mapCopy.get(i).getClasse().getNiveau().getNom();

        buffList.addElement(data);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
