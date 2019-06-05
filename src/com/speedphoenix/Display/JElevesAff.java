package com.speedphoenix.Display;

import com.speedphoenix.ActionListeners.ListSelectListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JElevesAff extends JMother{

/*
    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JList<String> mainList;// Jliste qui va afficher les informations
    private DefaultListModel <String> buffList;// Liste qui va assembles les strings contenant les informations a afficher
    private TreeMap<Integer, Inscription> mapCopy;//map contenant les objets avec les infos

    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    //ici on passe l'id e la classe
    public JElevesAff(BaseElem what) {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        buffList = new DefaultListModel<>();
        this.mapCopy=Ecole.getInstance().getInscriptions();
        this.creation(what.getId());
        mainList.addListSelectionListener(new ListSelectListener(mainList));
        super.motherElem = what;
    }

    private void creation(int id){ // methode d'initialisation des Jlists et Jpanels

        for(Integer i: mapCopy.keySet())
        {
            if(mapCopy.get(i).getClasse().getId()==id)
                addStringToListModel(i);
        }

        mainList = new JList<>(buffList);// on ajoute le liste des strings dans notre Jlist
        mainList.setFont(defaultF);
        mainPanel.add(new JScrollPane(mainList));// On ajoute notre Jlist avec scroll sur notre Jpanel
        mainPanel.setBackground(Color.darkGray);
    }

    public void addStringToListModel(Integer i){ // composition de string contenant les infos de l'objet
        String data = new String("");

        data+= "  Nom: "+ mapCopy.get(i).getEleve().getNom();
        data+= "  Prenom: "+ mapCopy.get(i).getEleve().getPrenom();
        data+= "  ID: "+ mapCopy.get(i).getEleve().getId();
        data+= "  Classe: "+ mapCopy.get(i).getClasse().getNom();
        data+= "  Niveau: "+ mapCopy.get(i).getClasse().getNiveau().getNom();

        buffList.addElement(data);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JList<String> getMainList() {
        return mainList;
    }

    public DefaultListModel<String> getBuffList() {
        return buffList;
    }

    public TreeMap<Integer, Inscription> getMapCopy() {
        return mapCopy;
    }

    public Font getDefaultF() {
        return defaultF;
    }

    @Override
    public JPanTable getMainTable() {
        return null;
    }*/
 private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanTable mainTable; //Panel contenant le tableau d'affichage des donnees
    private Object [] [] data; //Parametres necesaires pour creer le tableau
    private String [] title;// les titres de tableau
    private TreeMap<Integer, Inscription> mapCopy;//map contenant les objets avec les infos


    private int sizeCounter=0;//pour compter combien de "rows" on a a mettre dans data array

    public JElevesAff(BaseElem what) {
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

        mainPanel.add(mainTable);// On ajoute notre table sur main Jpanel
        mainPanel.setBackground(Color.darkGray);

    }

    public void addStringToDataContainer(Integer i){
        data [sizeCounter] = new Object[]{mapCopy.get(i).getEleve().getNom(),mapCopy.get(i).getEleve().getPrenom(), String.valueOf(mapCopy.get(i).getEleve().getId()), mapCopy.get(i).getClasse().getNom(), mapCopy.get(i).getClasse().getNiveau().getNom() };
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
