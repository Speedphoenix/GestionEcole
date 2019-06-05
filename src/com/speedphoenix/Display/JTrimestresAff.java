package com.speedphoenix.Display;


import com.speedphoenix.ActionListeners.ListSelectListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class JTrimestresAff extends JMother {

    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanTable mainTable; //Panel contenant le tableau d'affichage des donnees
    private Object [] [] data; //Parametres necesaires pour creer le tableau
    private String [] title;// les titres de tableau
    private TreeMap<Integer, Trimestre> mapCopy;//map contenant les objets avec les infos


    private int itteratorCounter=0;//pour compter combien de "rows" on a a mettre dans data array

    public JTrimestresAff() {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);

        this.mapCopy=Ecole.getInstance().getTrimestres();
        this.creation();

    }

    private void creation(){

        //initialiser le tableau de donnees
        data = new Object[mapCopy.size()][3];
        //creer le titre de tableau
        title = new String[]{"Trimestre", "Debut", "Fin"};


        for(Integer i: mapCopy.keySet())
        {
            addStringToDataContainer(i);
            itteratorCounter++;
        }

        mainTable = new JPanTable(data, title, 0,0, mainPanel.getWidth(), mainPanel.getHeight());

        mainPanel.add(mainTable);// On ajoute notre table sur main Jpanel
        mainPanel.setBackground(Color.darkGray);
    }

    //on rempli notre data array
    public void addStringToDataContainer(Integer i){
        data [itteratorCounter] = new Object[]{mapCopy.get(i).getNumero(), mapCopy.get(i).getDebut(), mapCopy.get(i).getFin() };
    }

    //pour avoir access au tableau ajoute .getTable() apres
    public JPanTable getMainTable() {
        return mainTable;
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public JList<String> getMainList() {
        return null;
    }
}
