package com.speedphoenix.Display;

import com.speedphoenix.Modele.Bulletin;
import com.speedphoenix.Modele.Classe;
import com.speedphoenix.Modele.Ecole;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JBulletinsAff extends JMother{
    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JList<String> mainList;// Jliste qui va afficher les informations
    private DefaultListModel <String> buffList;// Liste qui va assembles les strings contenant les informations a afficher
    private TreeMap<Integer, Bulletin> mapCopy;//map contenant les objets avec les infos

    private Font defaultF = new Font("Verdana", 1,13);//font par defaut qu'on utilise


    // allORniv= 1 si on affiche en fct de trimestre, et = 2 si on affiche en fct de eleve

    public JBulletinsAff(int id, int elORtrim) {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);

        buffList = new DefaultListModel<>();
        this.mapCopy= Ecole.getInstance().getBulletins();
        this.creation(id, elORtrim);
    }

    private void creation(int id, int elORtrim){ // methode d'initialisation des Jlists et Jpanels

        switch(elORtrim)
        {
            case 1:
                for(Integer i: mapCopy.keySet())
                {
                    if(mapCopy.get(i).getTrimestre().getId()==id)
                        addStringToListModel(i);
                }
                break;
            case 2:
                for(Integer i: mapCopy.keySet())
                {
                    if(mapCopy.get(i).getInscription().getEleve().getId()==id)
                        addStringToListModel(i);
                }
                break;
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
