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
    private String [] title;
    //private DefaultListModel <String> buffList;// Liste qui va assembles les strings contenant les informations a afficher
    private TreeMap<Integer, Trimestre> mapCopy;//map contenant les objets avec les infos


    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise
    private int itteratorCounter=0;

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

        mainPanel.add(mainTable);// On ajoute notre Jlist avec scroll sur notre Jpanel
        mainPanel.setBackground(Color.darkGray);
    }

    public void addStringToDataContainer(Integer i){ // composition de string contenant les infos de l'objet
        data [itteratorCounter] = new Object[]{mapCopy.get(i).getNumero(), mapCopy.get(i).getDebut(), mapCopy.get(i).getFin() };
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public JList<String> getMainList() {
        return null;
    }




/* private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JList<String> mainList;// Jliste qui va afficher les informations
    private DefaultListModel <String> buffList;// Liste qui va assembles les strings contenant les informations a afficher
    private TreeMap<Integer, Trimestre> mapCopy;//map contenant les objets avec les infos

    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    public JTrimestresAff() {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        buffList = new DefaultListModel<>();
        this.mapCopy=Ecole.getInstance().getTrimestres();
        this.creation();
        mainList.addListSelectionListener(new ListSelectListener(mainList));
    }

    private void creation(){ // methode d'initialisation des Jlists et Jpanels

        for(Integer i: mapCopy.keySet())
        {
            addStringToListModel(i);
        }

        mainList = new JList<>(buffList);// on ajoute le liste des strings dans notre Jlist
        mainList.setFont(defaultF);
        mainPanel.add(new JScrollPane(mainList));// On ajoute notre Jlist avec scroll sur notre Jpanel
        mainPanel.setBackground(Color.darkGray);
    }

    public void addStringToListModel(Integer i){ // composition de string contenant les infos de l'objet
        String data = new String("");
        data+= "  Trimestre: "+ mapCopy.get(i).getNumero();
        data+= "  Debut: "+ mapCopy.get(i).getDebut();
        data+= "  Fin: "+ mapCopy.get(i).getFin();

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

    public TreeMap<Integer, Trimestre> getMapCopy() {
        return mapCopy;
    }

    public Font getDefaultF() {
        return defaultF;
    }*/
}
