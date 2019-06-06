package com.speedphoenix.Display.AddClasses;

import com.speedphoenix.ActionListeners.SideMenu.AddListener;

import javax.swing.*;
import java.awt.*;

public class JEleveAdd extends JMotherMod {

    private JTextField textName;
    private JTextField textSurname;

    private JButton accept;



    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    public JEleveAdd() {

         JLabel labelName;
         JLabel labelSurname;

        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(null);
        //composants
        JLabel nomFenetre = new JLabel("CREATION ELEVE");
        nomFenetre.setBounds(300, 10, 400,200);
        nomFenetre.setFont(new Font("Verdana",3,40));
        accept = new JButton("Ajouter");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));

        textName = new JTextField();
        textName.setFont(defaultF);
        textName.setBounds(400, 300, 200,40);
        textSurname = new JTextField();
        textSurname.setFont(defaultF);
        textSurname.setBounds(400, 500, 200,40);
        labelName = new JLabel("Entrez le prénom");
        labelName.setFont(defaultF);
        labelName.setBounds(400, 240, 200,100);
        labelSurname = new JLabel("Entrez le Nom");
        labelSurname.setFont(defaultF);
        labelSurname.setBounds(400, 440, 200,100);
       //ajouts des composants
        mainPanel.add(accept);
        mainPanel.add(textName);
        mainPanel.add(textSurname);
        mainPanel.add(labelName);
        mainPanel.add(labelSurname);
        mainPanel.add(nomFenetre);

    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public String getType() {
        return "eleve";
    }

    public JTextField getTextName() {
        return textName;
    }

    public JTextField getTextSurname() {
        return textSurname;
    }



    public JButton getAccept() {
        return accept;
    }

    public Font getDefaultF() {
        return defaultF;
    }
}
