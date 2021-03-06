package com.speedphoenix.Display.Affclasses;

import com.speedphoenix.ActionListeners.ContentPanel.ListSelectListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;
/**
 * JPanel qui affiche les enseignements en fonction de la classe ou du discipline dans un Jtable
 */
public class JEnseigmnementsAff extends JMother {

    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanTable mainTable; //Panel contenant le tableau d'affichage des donnees
    private Object [] [] data; //Parametres necesaires pour creer le tableau
    private String [] title;// les titres de tableau
    private TreeMap<Integer, Enseignement> mapCopy;//map contenant les objets avec les infos

    private Class buffClass; //va recuperer la classe de baseElement

    private int sizeCounter=0;//pour compter combien de "rows" on a a mettre dans data array

    public JEnseigmnementsAff(BaseElem what) {

        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);

        this.mapCopy=Ecole.getInstance().getEnseignements();
        buffClass = what.getClass();
        this.creation(what.getId());
        super.motherElem = what;
    }
    /**
     * va remplir le tableau d'objets [][] data contenant les infos des enseignements qu'on va afficher dans JTabel
     * et ensuite va ajoutes les elements necesaires sur le JPanel
     * @param id de BaseElement (Classe ou Discipline) en fct de qui on va chercher les enseignements a afficher
     */
    private void creation(int id){

        //creer le titre de tableau
        title = new String[]{"Enseignement", "Professeur", "Classe"};

        if(buffClass == Classe.class) {
            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getClasse().getId()==id)
                    sizeCounter++;
            }
            //initialiser le tableau de donnees
            data = new Object[sizeCounter][3];
            sizeCounter=0;

            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getClasse().getId()==id)
                {
                    addStringToDataContainer(i);
                    sizeCounter++;
                }
            }
        }
        else if(buffClass == Discipline.class){
            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getDiscipline().getId()==id)
                    sizeCounter++;
            }
            //initialiser le tableau de donnees
            data = new Object[sizeCounter][3];
            sizeCounter=0;

            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getDiscipline().getId()==id)
                {
                    addStringToDataContainer(i);
                    sizeCounter++;
                }
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
        data [sizeCounter] = new Object[]{mapCopy.get(i).getDiscipline().getNom(),mapCopy.get(i).getEnseignant().getPrenom()+" "+mapCopy.get(i).getEnseignant().getNom(), mapCopy.get(i).getClasse().getNom()   };
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
