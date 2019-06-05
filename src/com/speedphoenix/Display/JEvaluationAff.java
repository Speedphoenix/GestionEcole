package com.speedphoenix.Display;

import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JEvaluationAff extends JMother{

    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanTable mainTable; //Panel contenant le tableau d'affichage des donnees
    private Object [] [] data; //Parametres necesaires pour creer le tableau
    private String [] title;// les titres de tableau
    private TreeMap<Integer, Evaluation> mapCopy;//map contenant les objets avec les infos

    private Class buffClass; //va recuperer la classe de baseElement

    private int sizeCounter=0;//pour compter combien de "rows" on a a mettre dans data array

    public JEvaluationAff(BaseElem what) {

        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);

        this.mapCopy= Ecole.getInstance().getEvaluations();
        buffClass = what.getClass();
        this.creation(what.getId());
        super.motherElem = what;
    }

    public void creation(int id){

        //creer le titre de tableau
        title = new String[]{"Discipline", "Note", "Appreciation"};

            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getDetailBulletin().getId()==id)
                    sizeCounter++;
            }
            //initialiser le tableau de donnees
            data = new Object[sizeCounter][3];
            sizeCounter=0;

            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getDetailBulletin().getId()==id)
                {
                    addStringToDataContainer(i);
                    sizeCounter++;
                }
            }


        mainTable = new JPanTable(data, title, 0,100, mainPanel.getWidth(), mainPanel.getHeight()-100);

        mainPanel.add(mainTable);// On ajoute notre table sur main Jpanel
        mainPanel.setBackground(Color.darkGray);

    }

    public void addStringToDataContainer(Integer i){
        data [sizeCounter] = new Object[]{mapCopy.get(i).getDetailBulletin().getEnseignement().getDiscipline(), mapCopy.get(i).getNote(), mapCopy.get(i).getAppreciation()};
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
