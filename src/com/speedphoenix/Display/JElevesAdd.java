package com.speedphoenix.Display;

import com.speedphoenix.ActionListeners.ListSelectListener;
import com.speedphoenix.Modele.BaseElem;
import com.speedphoenix.Modele.Ecole;
import com.speedphoenix.Modele.Inscription;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JElevesAdd extends JMother{
    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private DefaultListModel <String> buffList;// Liste qui va assembles les strings contenant les informations a afficher
    private TreeMap<Integer, Inscription> mapCopy;//map contenant les objets avec les infos

    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    //ici on passe l'id e la classe
    public JElevesAdd(BaseElem what) {
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
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
        listId.add(mapCopy.get(i).getId());

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
}
