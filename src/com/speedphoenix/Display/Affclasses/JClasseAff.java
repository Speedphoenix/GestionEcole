package com.speedphoenix.Display.Affclasses;

import com.speedphoenix.ActionListeners.ContentPanel.ClassEleveChoiceListener;
import com.speedphoenix.ActionListeners.ContentPanel.ClassEnseignantChoiceListener;
import com.speedphoenix.ActionListeners.ContentPanel.ListSelectListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;
/**
 * JPanel qui affiche soit toutes les classes soit les classes en fonction de niveau dans un Jtable + deux buttons de navigation vers enseignements et eleves de la classe choisie
 */
public class JClasseAff extends JMother {

    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanTable mainTable; //Panel contenant le tableau d'affichage des donnees
    private Object [] [] data; //Parametres necesaires pour creer le tableau
    private String [] title;// les titres de tableau
    private TreeMap<Integer, Classe> mapCopy;//map contenant les objets avec les infos

    private JPanel buttonPanel; //panel avec buttons de choix de direction
    private JButton enseignant;
    private JButton eleve;

    private Class buffClass; //va recuperer la classe de baseElement

    private int sizeCounter=0;//pour compter combien de "rows" on a a mettre dans data array

    public JClasseAff(BaseElem what) {

    /**/ //Ca ne concerne que les buttons
        JLabel nomFenetre = new JLabel("Menu Principal");
        nomFenetre.setBounds(316, -50, 400,200);
        nomFenetre.setFont(new Font("Verdana",3,20));
        nomFenetre.setForeground(Color.white);
        ;

        buttonPanel = new JPanel();
        buttonPanel.setBounds(0,0, 800, 100 );
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setLayout(null);
        //on fait 2 buttons
        enseignant = new JButton("Enseignements");
        eleve = new JButton("Eleves");
        enseignant.setBounds(100, 20, 200, 60);
        eleve.setBounds(500, 20, 200, 60 );
        enseignant.setEnabled(false);
        enseignant.addActionListener(new ClassEnseignantChoiceListener(this));
        eleve.addActionListener(new ClassEleveChoiceListener(this));
        eleve.setEnabled(false);
        buttonPanel.add(enseignant);
        buttonPanel.add(eleve);
    /**/

        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);
        mainPanel.add(nomFenetre);

        this.mapCopy=Ecole.getInstance().getClasses();
        buffClass = what.getClass();
        this.creation(what.getId());
        super.motherElem = what;
    }
    /**
     * va remplir le tableau d'objets [][] data contenant les infos de classes qu'on va afficher dans JTabel
     * et ensuite va ajoutes les elements necesaires sur le JPanel
     * @param id de BaseElement (Niveau) en fct de qui on va chercher les details bulletins a afficher
     */
    private void creation(int id){

        //creer le titre de tableau
        title = new String[]{"Classe", "Niveau", "Année Scolaire"};

        if(buffClass==Niveau.class) {
            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getNiveau().getId()==id)
                    sizeCounter++;
            }
            //initialiser le tableau de donnees
            data = new Object[sizeCounter][3];
            sizeCounter=0;

            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getNiveau().getId()==id)
                {
                    addStringToDataContainer(i);
                    sizeCounter++;
                }
            }

        }
        else{
            for(Integer i: mapCopy.keySet())
            {
                sizeCounter++;
            }
            //initialiser le tableau de donnees
            data = new Object[sizeCounter][3];
            sizeCounter=0;

            for(Integer i: mapCopy.keySet())
            {
                addStringToDataContainer(i);
                sizeCounter++;
            }
        }

        mainTable = new JPanTable(data, title, 0,100, mainPanel.getWidth(), mainPanel.getHeight()-100);
        mainTable.getTable().getSelectionModel().addListSelectionListener(new ListSelectListener(mainTable.getTable()));

        mainPanel.add(mainTable);// On ajoute notre table sur main Jpanel
        mainPanel.add(buttonPanel);
        mainPanel.setBackground(Color.darkGray);

    }
    /**
     * Compose un objet qu'on met dans un tableau [] [] data qui sera affiche par le JTable
     * @param i itterateur sur un element de treemap contenant les annees scolaires
     */
    public void addStringToDataContainer(Integer i){
        data [sizeCounter] = new Object[]{mapCopy.get(i).getNom(), mapCopy.get(i).getNiveau().getNom(), "debut: "+ mapCopy.get(i).getAnneeScolaire().getStartYear()+" fin: "+ mapCopy.get(i).getAnneeScolaire().getEndYear() };
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

    public JButton getEnseignantButton() {
        return enseignant;
    }

    public JButton getEleveButton() {
        return eleve;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }
}
