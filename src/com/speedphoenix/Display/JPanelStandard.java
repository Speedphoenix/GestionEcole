package com.speedphoenix.Display;


import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class JPanelStandard {
    JPanel mainPanel;
    TreeMap<Integer, BaseElem> mapCopy;


    public JPanelStandard(TreeMap<Integer, BaseElem> mapToCopy){
        mainPanel.setBounds(0,0,1000,900);
        mapCopy=mapToCopy;
    }

    private void initialise(){

        Font defaultF = new Font("Verdana", 1,20);

        ArrayList<ArrayList<JLabel>> labelList= new ArrayList<>();
        ArrayList<JComponent> componentList = new ArrayList<>();

        /*if(mapCopy.get(0) instanceof Classe)
        {
            for (Integer i: mapCopy.keySet())
            {
                labelList.add(new ArrayList<JLabel>());

                //labelList.get(0).add()
            }
        }*/
        if(mapCopy.get(0) instanceof Trimestre)
        {

        }
        if(mapCopy.get(0) instanceof Eleve)
        {
           /* JLabel Nom = new JLabel();
            JLabel Prenom = new JLabel();
            JLabel Classe = new JLabel();

            JButton choseStudent = new JButton("Regarder l'etudiant");


            for (Integer i: mapCopy.keySet())
            {
                labelList.add(new ArrayList<JLabel>());

                labelList.get(labelList.size()-1).add(Nom = new JLabel("Nom:" + mapCopy.get(i).getNom()));
            }*/
        }
        if(mapCopy.get(0) instanceof Enseignant)
        {

        }
        if(mapCopy.get(0) instanceof Discipline)
        {

        }
    }

}
