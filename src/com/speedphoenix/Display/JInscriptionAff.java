package com.speedphoenix.Display;

import com.speedphoenix.ActionListeners.ContentPanel.ListSelectListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JInscriptionAff extends JMother{

 private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanTable mainTable; //Panel contenant le tableau d'affichage des donnees
    private Object [] [] data; //Parametres necesaires pour creer le tableau
    private String [] title;// les titres de tableau
    private TreeMap<Integer, Inscription> mapCopy;//map contenant les objets avec les infos


    private int sizeCounter=0;//pour compter combien de "rows" on a a mettre dans data array

    public JInscriptionAff(BaseElem what) {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);
        this.mapCopy=Ecole.getInstance().getInscriptions();
        this.creation(what.getId());
        super.motherElem = what;

    }

    public void creation(int id){

        //on a besoin de savoir cmb d'eleves on va ajouter dans notre data array
        for(Integer i: mapCopy.keySet())
        {
            if(mapCopy.get(i).getClasse().getId()==id)
                sizeCounter++;
        }

        //initialiser le tableau de donnees
        data = new Object[sizeCounter][5];
        //creer le titre de tableau
        title = new String[]{"Nom", "Prenom", "ID", "Classe", "Niveau"};

        sizeCounter=0;//on annule le counteur

        for(Integer i: mapCopy.keySet())
        {
            if(mapCopy.get(i).getClasse().getId()==id)
            {
                addStringToDataContainer(i);
                sizeCounter++;
            }
        }

        mainTable = new JPanTable(data, title, 0,0, mainPanel.getWidth(), mainPanel.getHeight());
        mainTable.getTable().getSelectionModel().addListSelectionListener(new ListSelectListener(mainTable.getTable()));
        mainPanel.add(mainTable);// On ajoute notre table sur main Jpanel
        mainPanel.setBackground(Color.darkGray);

    }

    public void addStringToDataContainer(Integer i){
        data [sizeCounter] = new Object[]{mapCopy.get(i).getEleve().getNom(),mapCopy.get(i).getEleve().getPrenom(), String.valueOf(mapCopy.get(i).getEleve().getId()), mapCopy.get(i).getClasse().getNom(), mapCopy.get(i).getClasse().getNiveau().getNom() };
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
