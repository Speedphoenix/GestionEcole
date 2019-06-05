package com.speedphoenix.Display;

import com.speedphoenix.ActionListeners.ListSelectListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JBulletinsAff extends JMother{
    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JList<String> mainList;// Jliste qui va afficher les informations
    private DefaultListModel <String> buffList;// Liste qui va assembles les strings contenant les informations a afficher
    private TreeMap<Integer, Bulletin> mapCopy;//map contenant les objets avec les infos

    private Font defaultF = new Font("Verdana", 1,13);//font par defaut qu'on utilise

    private Class buffClass; //va recuperer la classe de baseElement


    // allORniv= 1 si on affiche en fct de trimestre, et = 2 si on affiche en fct de eleve

    public JBulletinsAff(BaseElem what) {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
       // mainPanel.setLayout(null);
        buffList = new DefaultListModel<>();
        this.mapCopy= Ecole.getInstance().getBulletins();
        buffClass = what.getClass();
        this.creation(what.getId());
        mainList.addListSelectionListener(new ListSelectListener(mainList));
        super.motherElem = what;
    }

    private void creation(int id){ // methode d'initialisation des Jlists et Jpanels

        if(buffClass == Trimestre.class)
        {
            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getTrimestre().getId()==id)
                    addStringToListModel(i);
            }
        }
        else if (buffClass == Inscription.class) {
            for (Integer i : mapCopy.keySet()) {
                if (mapCopy.get(i).getInscription().getId() == id)
                    addStringToListModel(i);
            }
        }

        mainList = new JList<>(buffList);// on ajoute le liste des strings dans notre Jlist
        mainList.setFont(defaultF);
        mainList.setBounds(0,0,800,900);

        mainPanel.add(mainList);// On ajoute notre Jlist avec scroll sur notre Jpanel
        mainPanel.setBackground(Color.darkGray);
    }

    public void addStringToListModel(Integer i){ // composition de string contenant les infos de l'objet
        String data = new String("");
        data+= "  Nom : "+ mapCopy.get(i).getInscription().getEleve().getNom();
        data+= "  Prenom : "+ mapCopy.get(i).getInscription().getEleve().getPrenom();
        data+= "  Appreciation: "+ mapCopy.get(i).getAppreciation();
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

    public TreeMap<Integer, Bulletin> getMapCopy() {
        return mapCopy;
    }

    public Font getDefaultF() {
        return defaultF;
    }
}
