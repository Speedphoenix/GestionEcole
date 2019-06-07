package com.speedphoenix.Display.ModClasses.Mod;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.AddListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;

import javax.swing.*;
import java.awt.*;

public class JNiveauMod extends JMotherMod {
    private JTextField textName;

    private JButton accept;

    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    public JNiveauMod() {

        JLabel labelName;

        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(null);
        //composants
        JLabel nomFenetre = new JLabel("MODIFICATION NIVEAU");
        nomFenetre.setBounds(310, 10, 500,200);
        nomFenetre.setFont(new Font("Verdana",3,30));
        accept = new JButton("Modifier");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));

        textName = new JTextField();
        textName.setFont(defaultF);
        textName.setBounds(400, 450, 200,40);

        labelName = new JLabel("Entrez le nom");
        labelName.setFont(defaultF);
        labelName.setBounds(420, 380, 200,100);

        //ajouts des composants
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
        return "niveau";
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
