package com.speedphoenix.Display.AddClasses;

import com.speedphoenix.ActionListeners.SideMenu.AddListener;

import javax.swing.*;
import java.awt.*;
import com.speedphoenix.ActionListeners.AddListener;

import com.speedphoenix.Modele.*;

import javax.swing.*;

public class JBulletinAdd extends JMotherMod {

    private JPanel mainPanel;
    private JTextPane appreciation;
    private JComboBox <BaseElem> choiceBox;
    private JTextPane staticAncestorElement;

    private String staticElName;
    private String boxName;
    private String bufferTextAr;
    private String [] boxContent;

    private Class buffClass;

    //private Font defaultF = new Font("Verdana", 1,14);

    public JBulletinAdd(BaseElem what){
        /**/
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);

        appreciation = new JTextPane();
        appreciation.setName("Appreciation");
        appreciation.setText("");
        appreciation.setBounds(300, 600, 400, 200);
        appreciation.setBorder(BorderFactory.createTitledBorder("Entrez l'appreciation"));

        choiceBox = new JComboBox<>();

        staticAncestorElement = new JTextPane();
        staticAncestorElement.setBounds(300, 300, 400, 70);
        /**/

        bufferTextAr = new String("");

        buffClass=what.getClass();
        creation(what.getId());
    }

    public void creation(int id){

        if(buffClass==Trimestre.class){
            staticElName = new String("Trimestre");
            boxName = new String("Inscription");
            bufferTextAr += "Numero : " + Ecole.getInstance().getTrimestres().get(id).getNumero()+ "  Debut: "+
                    Ecole.getInstance().getTrimestres().get(id).getDebut() + "  Fin : " +
                    Ecole.getInstance().getTrimestres().get(id).getFin();

            boxContent= new String [Ecole.getInstance().getInscriptions().size()];
            int counter=0;

            for (Integer i : Ecole.getInstance().getInscriptions().keySet())
            {
                boxContent [counter] = "Nom : " + Ecole.getInstance().getInscriptions().get(i).getEleve().getNom()+ "  Prenom: "+
                        Ecole.getInstance().getInscriptions().get(i).getEleve().getPrenom() + "  ID : " +
                        Ecole.getInstance().getInscriptions().get(i).getId() + "  Classe : " +
                        Ecole.getInstance().getInscriptions().get(i).getClasse().getNom() + "  Niveau : " +
                        Ecole.getInstance().getInscriptions().get(i).getClasse().getNiveau().getNom();

                counter++;
            }

        }
        else if (buffClass==Inscription.class){
            staticElName = new String("Inscription");
            boxName = new String("Trimestre");
            bufferTextAr += "Nom : " + Ecole.getInstance().getInscriptions().get(id).getEleve().getNom()+ "  Prenom: "+
                    Ecole.getInstance().getInscriptions().get(id).getEleve().getPrenom() + "  ID : " +
                    Ecole.getInstance().getInscriptions().get(id).getId() + "  Classe : " +
                    Ecole.getInstance().getInscriptions().get(id).getClasse().getNom() + "  Niveau : " +
                    Ecole.getInstance().getInscriptions().get(id).getClasse().getNiveau().getNom();

            boxContent= new String [Ecole.getInstance().getTrimestres().size()];
            int counter=0;

            for (Integer i : Ecole.getInstance().getTrimestres().keySet())
            {
                boxContent [counter] = "  Debut: "+
                        Ecole.getInstance().getTrimestres().get(i).getDebut() + "  Fin : " +
                        Ecole.getInstance().getTrimestres().get(i).getFin();

                counter++;
            }
        }

        staticAncestorElement.setName(staticElName);
        staticAncestorElement.setText(bufferTextAr);
        staticAncestorElement.setEditable(false);
        staticAncestorElement.setBorder(BorderFactory.createTitledBorder(staticElName));

        choiceBox = new JComboBox(boxContent);
        choiceBox.setBounds(300, 450, 400, 40);
        choiceBox.setBorder(BorderFactory.createTitledBorder(boxName));


        mainPanel.add(staticAncestorElement);
        mainPanel.add(choiceBox);
        mainPanel.add(appreciation);


    }


    public String getType() {
        return "eleve";
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
    /* private JComboBox textTrimestre;
    private JComboBox textInscription;
    private JComboBox textAppreciation;
    private JButton accept;
    private boolean bulOrInscr;//0 for bulletins,1 for inscriptions
    private int sentId;



    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    public JBulletinAdd(int Id,boolean bulOrInscr) {

        //creation des titre au dessus des objets d'interractions
        JLabel labelTrimestre;
        JLabel labelInscription;
        JLabel labelAppreciation;

        this.sentId = Id;
        this.bulOrInscr=bulOrInscr;
        if(bulOrInscr)
        {

        }



        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(null);
        //composants
        JLabel nomFenetre = new JLabel("CREATION BULLETIN");
        nomFenetre.setBounds(300, 10, 400,200);
        nomFenetre.setFont(new Font("Verdana",3,40));
        accept = new JButton("Ajouter");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));

        textTrimestre = new JComboBox();

        textTrimestre.setFont(defaultF);
        textTrimestre.setBounds(400, 300, 200,40);
        textInscription = new JComboBox();
        textInscription.setFont(defaultF);
        textInscription.setBounds(400, 500, 200,40);
        labelTrimestre = new JLabel("Choissisez le trimestre");
        labelTrimestre.setFont(defaultF);
        labelTrimestre.setBounds(400, 140, 200,100);
        labelInscription = new JLabel("Choissisez l'élève");
        labelInscription.setFont(defaultF);
        labelInscription.setBounds(400, 340, 200,100);
        labelInscription = new JLabel("Entrez une appréciation");
        labelInscription.setFont(defaultF);
        labelInscription.setBounds(400, 540, 200,100);
       //ajouts des composants
        mainPanel.add(accept);
        mainPanel.add(textTrimestre);
        mainPanel.add(textInscription);
        mainPanel.add(labelTrimestre);
        mainPanel.add(labelInscription);
        mainPanel.add(nomFenetre);

    }



    
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public String getType() {
        return "eleve";
    }

    public JComboBox gettextTrimestre() {
        return textTrimestre;
    }

    public JComboBox gettextInscription() {
        return textInscription;
    }



    public JButton getAccept() {
        return accept;
    }

    public Font getDefaultF() {
        return defaultF;
    }*/
}
