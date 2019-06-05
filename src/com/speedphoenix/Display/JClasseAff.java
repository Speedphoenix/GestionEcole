package com.speedphoenix.Display;

import com.speedphoenix.ActionListeners.ListSelectListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JClasseAff extends JMother{
    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JList<String> mainList;// Jliste qui va afficher les informations
    private DefaultListModel <String> buffList;// Liste qui va assembles les strings contenant les informations a afficher
    private TreeMap<Integer, Classe> mapCopy;//map contenant les objets avec les infos

    private JPanel buttonPanel;
    private JButton enseignants;
    private JButton eleves;

    private Font defaultF = new Font("Verdana", 1,13);//font par defaut qu'on utilise

    private Class buffClass; //va recuperer la classe de baseElement


    // on affichew toutes les classes, ou on affiche les classes selon id de niveau

    public JClasseAff(BaseElem what) {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);
        buttonPanel = new JPanel();
        buttonPanel.setBounds(0,0, 800, 100 );
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setLayout(null);

        //on fait 2 buttons
        JButton enseignants = new JButton("Enseignements");
        JButton eleves = new JButton("Eleves");
        enseignants.setBounds(100, 20, 200, 60);
        eleves.setBounds(500, 20, 200, 60 );

        buttonPanel.add(enseignants);
        buttonPanel.add(eleves);

        buffList = new DefaultListModel<>();
        this.mapCopy=Ecole.getInstance().getClasses();

        buffClass = what.getClass();

        this.creation(what.getId());
        mainList.addListSelectionListener(new ListSelectListener(mainList));
        super.motherElem = what;
    }

    private void creation(int id){ // methode d'initialisation des Jlists et Jpanels

        if(buffClass==Niveau.class) {
            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getNiveau().getId()==id)
                    addStringToListModel(i);
            }
        }
        else{
            for(Integer i: mapCopy.keySet())
            {
                addStringToListModel(i);
            }
        }


        mainList = new JList<>(buffList);// on ajoute le liste des strings dans notre Jlist
        mainList.setFont(defaultF);
        mainList.setBounds(0,100,800,800);
        mainPanel.add(mainList);// On ajoute notre Jlist avec scroll sur notre Jpanel
        mainPanel.add(buttonPanel);// on ajoute panel avec 2 buttons Eleves + Enseignements
        mainPanel.setBackground(Color.darkGray);
    }

    public void addStringToListModel(Integer i){ // composition de string contenant les infos de l'objet
        String data = new String("");
        data+= "  Classe : "+ mapCopy.get(i).getNom();
        data+= "  Niveau : "+ mapCopy.get(i).getNiveau().getNom();
        data+= "  Année Scolaire : debut: "+ mapCopy.get(i).getAnneeScolaire().getStartYear()+" fin: "+ mapCopy.get(i).getAnneeScolaire().getEndYear();
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

    public TreeMap<Integer, Classe> getMapCopy() {
        return mapCopy;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public JButton getEnseignants() {
        return enseignants;
    }

    public JButton getEleves() {
        return eleves;
    }

    public Font getDefaultF() {
        return defaultF;
    }
}
