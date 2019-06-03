package com.speedphoenix.Display;

import com.speedphoenix.Modele.*;
import sun.security.krb5.JavaxSecurityAuthKerberosAccess;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class JStudentsPanel {
    JPanel mainPanel;
    TreeMap<Integer, Inscription> mapCopy;

    public JStudentsPanel(TreeMap<Integer, Inscription> mapToCopy){
        mainPanel.setBounds(0,0,1000,900);
        mapCopy=mapToCopy;
    }

    private void initialisation (){

        int counter=0;
        Font defaultF = new Font("Verdana", 1,20);

        ArrayList<ArrayList<JLabel>> labelList= new ArrayList<>();
        ArrayList<JComponent> componentList = new ArrayList<>();

        JLabel niveau;

        JLabel td;

        JLabel nom;
        JLabel prenom;
        JLabel id;


        for (Integer i: mapCopy.keySet())
        {
            nom = new JLabel("Nom: " + mapCopy.get(i).getEleve().getNom());
            nom.setBounds(100,0+counter,50,40);
            nom.setFont(defaultF);
            mainPanel.add(nom);

            prenom = new JLabel("Prenom: " + mapCopy.get(i).getEleve().getPrenom());
            prenom.setBounds(150,0+counter,50,40);
            prenom.setFont(defaultF);
            mainPanel.add(prenom);

            id = new JLabel("ID: " + mapCopy.get(i).getEleve().getId());
            id.setBounds(150,0+counter,50,40);
            id.setFont(defaultF);
            mainPanel.add(id);

            td = new JLabel("TD: " + mapCopy.get(i).getClasse().getNom());
            td.setBounds(150,0+counter,50,40);
            td.setFont(defaultF);
            mainPanel.add(td);

            niveau = new JLabel("Niveau: " + mapCopy.get(i).getClasse().getNiveau().getNom());
            niveau.setBounds(150,0+counter,50,40);
            niveau.setFont(defaultF);
            mainPanel.add(niveau);

            /*niveau = new JLabel("Niveau" + mapCopy.get(i));
            niveau.setBounds(0,0,40,40);
            niveau.setFont(defaultF);
            mainPanel.add(niveau);*/

            counter+=40;
        }



        /*ArrayList<ArrayList<JLabel>> labelList= new ArrayList<>();
        ArrayList<JComponent> componentList = new ArrayList<>();


        JLabel Nom = new JLabel();
        JLabel Prenom = new JLabel();
        JLabel Classe = new JLabel();

        JButton choseStudent = new JButton("Regarder l'etudiant");


        for (Integer i: mapCopy.keySet())
        {
            labelList.add(new ArrayList<JLabel>());

            labelList.get(labelList.size()-1).add(Nom = new JLabel("Nom:" + mapCopy.get(i).getNom()));
            labelList.get(labelList.size()-1).add(Prenom = new JLabel("Prenom:" + mapCopy.get(i).getPrenom()));
            labelList.get(labelList.size()-1).add(Nom = new JLabel("Classe:" + mapCopy.get(i).getNom()));
        }*/
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
