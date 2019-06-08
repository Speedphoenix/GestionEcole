package com.speedphoenix.Display.Affclasses;


import com.speedphoenix.ActionListeners.ContentPanel.ListSelectListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;
/**
 * JPanel qui afficheles trimestres en fonction de l'annee dans un Jtable
 */
public class JTrimestresAff extends JMother {

    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanTable mainTable; //Panel contenant le tableau d'affichage des donnees
    private Object [] [] data; //Parametres necesaires pour creer le tableau
    private String [] title;// les titres de tableau
    private TreeMap<Integer, Trimestre> mapCopy;//map contenant les objets avec les infos


    private int sizeCounter=0;//pour compter combien de "rows" on a a mettre dans data array

    public JTrimestresAff(BaseElem what) {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);
        System.out.println(what.getId());
        //mainList.addListSelectionListener(new ListSelectListener(mainList));
        motherElem = what;
        this.mapCopy=Ecole.getInstance().getTrimestres();
        this.creation(what.getId());

    }
    /**
     * va remplir le tableau d'objets [][] data contenant les infos de trimestres qu'on va afficher dans JTabel
     * et ensuite va ajoutes les elements necesaires sur le JPanel
     * @param id de BaseElement (Annee Scolaire) en fct de qui on va chercher les trimestres a afficher
     */
    private void creation(int id){

        //initialiser le tableau de donnees

        //creer le titre de tableau
        title = new String[]{"Trimestre", "Debut", "Fin"};
        for(Integer i: mapCopy.keySet())
        {
            if(mapCopy.get(i).getAnneeScolaire().getId()==id)
            {
                sizeCounter++;
            }
        }
        data = new Object[sizeCounter][3];
        sizeCounter =0;
        for(Integer i: mapCopy.keySet())
        {
            if(mapCopy.get(i).getAnneeScolaire().getId()==id)
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

    /**
     * Compose un objet qu'on met dans un tableau [] [] data qui sera affiche par le JTable
     * @param i itterateur sur un element de treemap contenant les annees scolaires
     */
    public void addStringToDataContainer(Integer i){
        data [sizeCounter] = new Object[]{String.valueOf(mapCopy.get(i).getNumero()), String.valueOf(mapCopy.get(i).getDebut()),String.valueOf(mapCopy.get(i).getFin()) };
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
