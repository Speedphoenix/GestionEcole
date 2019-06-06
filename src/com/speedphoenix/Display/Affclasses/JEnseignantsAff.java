package com.speedphoenix.Display.Affclasses;

import com.speedphoenix.ActionListeners.ContentPanel.ListSelectListener;
import com.speedphoenix.Modele.Ecole;
import com.speedphoenix.Modele.Enseignant;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JEnseignantsAff extends JMother {
    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanTable mainTable; //Panel contenant le tableau d'affichage des donnees
    private Object [] [] data; //Parametres necesaires pour creer le tableau
    private String [] title;// les titres de tableau
    private TreeMap<Integer, Enseignant> mapCopy;//map contenant les objets avec les infos


    private int sizeCounter=0;//pour compter combien de "rows" on a a mettre dans data array

    public JEnseignantsAff() {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);

        //mainList.addListSelectionListener(new ListSelectListener(mainList));

        this.mapCopy= Ecole.getInstance().getEnseignants();
        this.creation();

    }

    private void creation(){

        //initialiser le tableau de donnees
        data = new Object[mapCopy.size()][2];
        //creer le titre de tableau
        title = new String[]{"Prenom", "Nom"};


        for(Integer i: mapCopy.keySet())
        {
            addStringToDataContainer(i);
            sizeCounter++;
        }

        mainTable = new JPanTable(data, title, 0,0, mainPanel.getWidth(), mainPanel.getHeight());
        mainTable.getTable().getSelectionModel().addListSelectionListener(new ListSelectListener(mainTable.getTable()));

        mainPanel.add(mainTable);// On ajoute notre table sur main Jpanel
        mainPanel.setBackground(Color.darkGray);
    }

    //on rempli notre data array
    public void addStringToDataContainer(Integer i){
        data [sizeCounter] = new Object[]{mapCopy.get(i).getPrenom(), mapCopy.get(i).getNom()};
        listId.add(mapCopy.get(i).getId());
    }

    //pour avoir access au tableau ajoute .getTable() apres
    @Override
    public JPanTable getMainTable() {
        return mainTable;
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }
}