package com.speedphoenix.Display.Affclasses;

import com.speedphoenix.ActionListeners.ContentPanel.ListSelectListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.TreeMap;
/**
 * JPanel qui affiche les inscriptions de la classe choisie dans un Jtable
 */
public class JInscriptionAff extends JMother {

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
    /**
     * va remplir le tableau d'objets [][] data contenant les infos des inscriptions qu'on va afficher dans JTabel
     * et ensuite va ajoutes les elements necesaires sur le JPanel
     * @param id de BaseElement (Classe) en fct de qui on va chercher les inscriptions a afficher
     */
    private void creation(int id){

        //on a besoin de savoir cmb d'eleves on va ajouter dans notre data array
        for(Integer i: mapCopy.keySet())
        {
            if(mapCopy.get(i).getClasse().getId()==id)
                sizeCounter++;
        }

        //initialiser le tableau de donnees
        data = new Object[sizeCounter][5];
        //creer le titre de tableau
        title = new String[]{"Prenom", "Nom", "ID", "Classe", "Niveau"};

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
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        mainTable.getTable().setDefaultRenderer(String.class, centerRenderer);
        mainTable.getTable().getSelectionModel().addListSelectionListener(new ListSelectListener(mainTable.getTable()));
        mainPanel.add(mainTable);// On ajoute notre table sur main Jpanel
        mainPanel.setBackground(Color.darkGray);

    }
    /**
     * Compose un objet qu'on met dans un tableau [] [] data qui sera affiche par le JTable
     * @param i itterateur sur un element de treemap contenant les annees scolaires
     */
    public void addStringToDataContainer(Integer i){
        data [sizeCounter] = new Object[]{mapCopy.get(i).getEleve().getPrenom(),mapCopy.get(i).getEleve().getNom(), String.valueOf(mapCopy.get(i).getEleve().getId()), mapCopy.get(i).getClasse().getNom(), mapCopy.get(i).getClasse().getNiveau().getNom() };
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
