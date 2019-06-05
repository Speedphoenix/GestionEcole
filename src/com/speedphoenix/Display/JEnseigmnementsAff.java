package com.speedphoenix.Display;

import com.speedphoenix.ActionListeners.ListSelectListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JEnseigmnementsAff extends JMother {
    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JList<String> mainList;// Jliste qui va afficher les informations
    private DefaultListModel <String> buffList;// Liste qui va assembles les strings contenant les informations a afficher
    private TreeMap<Integer, Enseignement> mapCopy;//map contenant les objets avec les infos

    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    //ici on passe l'id de la classe
    public JEnseigmnementsAff(BaseElem what) {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        buffList = new DefaultListModel<>();
        this.mapCopy=Ecole.getInstance().getEnseignements();
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

        data+= "  Enseignement: "+ mapCopy.get(i).getDiscipline().getNom();
        data+= "  Professeur: "+ mapCopy.get(i).getEnseignant().getPrenom()+" "+mapCopy.get(i).getEnseignant().getNom();
        data+= "  Classe: "+ mapCopy.get(i).getClasse().getNom();

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

    public TreeMap<Integer, Enseignement> getMapCopy() {
        return mapCopy;
    }

    public Font getDefaultF() {
        return defaultF;
    }
}
