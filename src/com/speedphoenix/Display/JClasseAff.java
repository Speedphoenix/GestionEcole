package com.speedphoenix.Display;

import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JClasseAff {
    JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    JList<String> mainList;// Jliste qui va afficher les informations
    DefaultListModel <String> buffList;// Liste qui va assembles les strings contenant les informations a afficher
    TreeMap<Integer, Classe> mapCopy;//map contenant les objets avec les infos

    Font defaultF = new Font("Verdana", 1,13);//font par defaut qu'on utilise


    // allORniv= 1 si on affichew toutes les classes, et = 2 si on affiche les classes selon id de niveau

    public JClasseAff(int id, int allORniv, TreeMap<Integer, Classe> mapToCopy) {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        buffList = new DefaultListModel<>();
        this.mapCopy=mapToCopy;
        this.creation(id, allORniv);
    }

    private void creation(int id, int allORniv){ // methode d'initialisation des Jlists et Jpanels

        switch(allORniv)
        {
            case 1:
                for(Integer i: mapCopy.keySet())
                {
                    addStringToListModel(i);
                }
                break;
            case 2:
                for(Integer i: mapCopy.keySet())
                {
                    if(mapCopy.get(i).getNiveau().getId()==id)
                    addStringToListModel(i);
                }
                break;
        }

        mainList = new JList<>(buffList);// on ajoute le liste des strings dans notre Jlist
        mainList.setFont(defaultF);
        mainPanel.add(new JScrollPane(mainList));// On ajoute notre Jlist avec scroll sur notre Jpanel
        mainPanel.setBackground(Color.darkGray);
    }

    public void addStringToListModel(Integer i){ // composition de string contenant les infos de l'objet
        String data = new String("");
        data+= "  Classe : "+ mapCopy.get(i).getNom();
        data+= "  Niveau : "+ mapCopy.get(i).getNiveau().getNom();
        data+= "  Année Scolaire : debut: "+ mapCopy.get(i).getAnneeScolaire().getStartYear()+" fin: "+ mapCopy.get(i).getAnneeScolaire().getEndYear();

        buffList.addElement(data);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
