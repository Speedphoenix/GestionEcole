package com.speedphoenix.Display.Affclasses;

import com.speedphoenix.ActionListeners.ContentPanel.ListSelectListener;
import com.speedphoenix.Modele.Discipline;
import com.speedphoenix.Modele.Ecole;

import javax.swing.*;
import java.util.TreeMap;
/**
 * JPanel qui affiche  toutes les disciplines dans un Jtable
 */
public class JDisciplineAff extends JMother {

    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanTable mainTable; //Panel contenant le tableau d'affichage des donnees
    private Object [] [] data; //Parametres necesaires pour creer le tableau
    private String [] title;// les titres de tableau
    private TreeMap<Integer, Discipline> mapCopy;//map contenant les objets avec les infos


    private int sizeCounter=0;//pour compter combien de "rows" on a a mettre dans data array

    public JDisciplineAff() {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);

        this.mapCopy=Ecole.getInstance().getDisciplines();
        this.creation();

    }
    /**
     * va remplir le tableau d'objets [][] data contenant les infos de disciplines qu'on va afficher dans JTabel
     * et ensuite va ajoutes les elements necesaires sur le JPanel
     */
    private void creation(){

        //initialiser le tableau de donnees
        data = new Object[mapCopy.size()][1];
        //creer le titre de tableau
        title = new String[]{"Disciplines"};


        for(Integer i: mapCopy.keySet())
        {
            addStringToDataContainer(i);
            sizeCounter++;
        }

        mainTable = new JPanTable(data, title, 0,0, mainPanel.getWidth(), mainPanel.getHeight());
        mainTable.getTable().getSelectionModel().addListSelectionListener(new ListSelectListener(mainTable.getTable()));

        mainPanel.add(mainTable);// On ajoute notre table sur main Jpanel
        //mainPanel.setBackground(Color.darkGray);
    }

    /**
     * Compose un objet qu'on met dans un tableau [] [] data qui sera affiche par le JTable
     * @param i itterateur sur un element de treemap contenant les annees scolaires
     */
    public void addStringToDataContainer(Integer i){
        data [sizeCounter] = new Object[]{mapCopy.get(i).getNom() };
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
