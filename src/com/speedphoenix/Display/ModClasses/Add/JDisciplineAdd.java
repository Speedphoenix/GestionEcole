package com.speedphoenix.Display.ModClasses.Add;


import com.speedphoenix.ActionListeners.AddOrModifyPanel.AddListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;

import javax.swing.*;
import java.awt.*;
/**
 * JPanel qui prpoose de rentrer les informations pour ajouter un Discipline
 * On demande d'entrer: le nom de discipline
 */
public class JDisciplineAdd extends JMotherMod {
    private JTextField textName;
    private JLabel nomFenetre;

    private JButton accept;

    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    public JDisciplineAdd() {

        JLabel labelName;
        JLabel labelSurname;

        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(null);
        //composants
        JLabel nomFenetre = new JLabel("CREATION DISCIPLINE");
        nomFenetre.setBounds(310, 10, 500,200);
        nomFenetre.setFont(new Font("Verdana",3,30));
        accept = new JButton("Ajouter");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));

        textName = new JTextField();
        textName.setFont(defaultF);
        textName.setBounds(400, 450, 200,40);

        labelName = new JLabel("Entrez son nom");
        labelName.setFont(defaultF);
        labelName.setBounds(420, 380, 200,100);

        nomFenetre = new JLabel("Ajout Discipline");
        nomFenetre.setBounds(200, 10, 800,200);
        nomFenetre.setFont(new Font("Verdana",3,30));

        mainPanel.add(nomFenetre);
        mainPanel.add(accept);
        mainPanel.add(textName);

        mainPanel.add(labelName);

        mainPanel.add(nomFenetre);

    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public String getType() {
        return "discipline";
    }// j crois que c ca non?

    public JTextField getTextName() {
        return textName;
    }




    public JButton getAccept() {
        return accept;
    }

    public Font getDefaultF() {
        return defaultF;
    }
}
