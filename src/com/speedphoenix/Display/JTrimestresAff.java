package com.speedphoenix.Display;


import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JTrimestresAff {
    JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    JList<String> mainList;// Jliste qui va afficher les informations
    DefaultListModel <String> buffList;// Liste qui va assembles les strings contenant les informations a afficher
    TreeMap<Integer, Trimestre> mapCopy;//map contenant les objets avec les infos

    Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    public JTrimestresAff(TreeMap<Integer, Trimestre> mapToCopy) {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        buffList = new DefaultListModel<>();
        this.mapCopy=mapToCopy;
        this.creation();
    }

    private void creation(){ // methode d'initialisation des Jlists et Jpanels

        for(Integer i: mapCopy.keySet())
        {
            addStringToListModel(i);
        }

        mainList = new JList<>(buffList);// on ajoute le liste des strings dans notre Jlist
        mainList.setFont(defaultF);
        mainPanel.add(new JScrollPane(mainList));// On ajoute notre Jlist avec scroll sur notre Jpanel
        mainPanel.setBackground(Color.darkGray);
    }

    public void addStringToListModel(Integer i){ // composition de string contenant les infos de l'objet
        String professor = new String("");
        professor+= "  Trimestre: "+ mapCopy.get(i).getNumero();
        professor+= "  Debut: "+ mapCopy.get(i).getDebut();
        professor+= "  Fin: "+ mapCopy.get(i).getFin();

        buffList.addElement(professor);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
