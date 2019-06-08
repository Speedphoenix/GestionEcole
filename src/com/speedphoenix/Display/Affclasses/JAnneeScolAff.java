package com.speedphoenix.Display.Affclasses;

import com.speedphoenix.ActionListeners.ContentPanel.ListSelectListener;
import com.speedphoenix.Modele.AnneeScolaire;
import com.speedphoenix.Modele.Ecole;
import com.speedphoenix.Modele.Eleve;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

/**
 * JPanel qui affiche toutes les annees scolaires dans un Jtable
 */
public class JAnneeScolAff extends JMother {

    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanTable mainTable; //Panel contenant le tableau d'affichage des donnees
    private Object [] [] data; //Parametres necesaires pour creer le tableau
    private String [] title;// les titres de tableau
    private TreeMap<Integer, AnneeScolaire> mapCopy;//map contenant les objets avec les infos


    private int sizeCounter=0;//pour compter combien de "rows" on a a mettre dans data array

    public JAnneeScolAff() {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);

        //mainList.addListSelectionListener(new ListSelectListener(mainList));

        this.mapCopy= Ecole.getInstance().getAnneeScolaires();
        this.creation();

    }

    /**
     * va remplir le tableau d'objets [][] data contenant les infos de annees scolaires qu'on va afficher dans JTabel
     * et ensuite va ajoutes les elements necesaires sur le JPanel
     */
    private void creation(){

        //initialiser le tableau de donnees
        data = new Object[mapCopy.size()][2];
        //creer le titre de tableau
        title = new String[]{"Id", "Période"};


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

    /**
     * Compose un objet qu'on met dans un tableau [] [] data qui sera affiche par le JTable
     * @param i itterateur sur un element de treemap contenant les annees scolaires
     */
    public void addStringToDataContainer(Integer i){
        int startYear = mapCopy.get(i).getStartYear();
        int endYear = mapCopy.get(i).getEndYear();
        String periode = "Année "+startYear+ "/"+endYear;
        if(endYear == 0 || startYear == 0)
            periode = "Periode Indéterminée";
        data [sizeCounter] = new Object[]{ ""+mapCopy.get(i).getId()+"",periode};
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
