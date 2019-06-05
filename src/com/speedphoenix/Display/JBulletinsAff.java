package com.speedphoenix.Display;

import com.speedphoenix.ActionListeners.ListSelectListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JBulletinsAff extends JMother {

    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanTable mainTable; //Panel contenant le tableau d'affichage des donnees
    private Object [] [] data; //Parametres necesaires pour creer le tableau
    private String [] title;// les titres de tableau
    private TreeMap<Integer, Bulletin> mapCopy;//map contenant les objets avec les infos

    private Class buffClass; //va recuperer la classe de baseElement

    private int sizeCounter=0;//pour compter combien de "rows" on a a mettre dans data array

    public JBulletinsAff(BaseElem what) {

        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);

        this.mapCopy=Ecole.getInstance().getBulletins();
        buffClass = what.getClass();
        this.creation(what.getId());
        super.motherElem = what;
    }

    public void creation(int id){

        //creer le titre de tableau
        title = new String[]{"Nom  ", "Prenom", "Appreciation"};

        if(buffClass== Trimestre.class) {
            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getTrimestre().getId()==id)
                    sizeCounter++;
            }
            //initialiser le tableau de donnees
            data = new Object[sizeCounter][3];
            sizeCounter=0;

            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getTrimestre().getId()==id)
                {
                    addStringToDataContainer(i);
                    sizeCounter++;
                }
            }

        }
        else if (buffClass== Inscription.class){
            for(Integer i: mapCopy.keySet())
            {
                if (mapCopy.get(i).getInscription().getId() == id)
                    sizeCounter++;
            }
            //initialiser le tableau de donnees
            data = new Object[sizeCounter][3];
            sizeCounter=0;

            for(Integer i: mapCopy.keySet())
            {
                if (mapCopy.get(i).getInscription().getId() == id)
                {
                    addStringToDataContainer(i);
                    sizeCounter++;
                }
            }

        }

        mainTable = new JPanTable(data, title, 0,0, mainPanel.getWidth(), mainPanel.getHeight());

        mainPanel.add(mainTable);// On ajoute notre table sur main Jpanel
        mainPanel.setBackground(Color.darkGray);

    }

    public void addStringToDataContainer(Integer i){
        data [sizeCounter] = new Object[]{mapCopy.get(i).getInscription().getEleve().getNom(), mapCopy.get(i).getInscription().getEleve().getPrenom(), mapCopy.get(i).getAppreciation() };
    }

    //pour avoir access au tableau ajoute .getTable() apres
    public JPanTable getMainTable() {
        return mainTable;
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public JList<String> getMainList() {
        return null;
    }


    /*private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JList<String> mainList;// Jliste qui va afficher les informations
    private DefaultListModel <String> buffList;// Liste qui va assembles les strings contenant les informations a afficher
    private TreeMap<Integer, Bulletin> mapCopy;//map contenant les objets avec les infos

    private Font defaultF = new Font("Verdana", 1,13);//font par defaut qu'on utilise

    private Class buffClass; //va recuperer la classe de baseElement


    // allORniv= 1 si on affiche en fct de trimestre, et = 2 si on affiche en fct de eleve

    public JBulletinsAff(BaseElem what) {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        mainPanel.setLayout(null);

        buffList = new DefaultListModel<>();
        this.mapCopy= Ecole.getInstance().getBulletins();

        buffClass = what.getClass();

        this.creation(what.getId());
        mainList.addListSelectionListener(new ListSelectListener(mainList));

        super.motherElem = what;
    }

    private void creation(int id){ // methode d'initialisation des Jlists et Jpanels

        if(buffClass== Trimestre.class)
        {
            for(Integer i: mapCopy.keySet())
            {
                if(mapCopy.get(i).getTrimestre().getId()==id)
                    addStringToListModel(i);
            }
        }
        else if (buffClass== Inscription.class) {
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
    }*/
}
