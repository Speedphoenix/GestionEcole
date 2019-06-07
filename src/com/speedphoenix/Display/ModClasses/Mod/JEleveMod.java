package com.speedphoenix.Display.ModClasses.Mod;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.AddListener;
import com.speedphoenix.ActionListeners.AddOrModifyPanel.ModListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.BaseElem;
import com.speedphoenix.Modele.Bulletin;
import com.speedphoenix.Modele.Eleve;

import javax.swing.*;
import java.awt.*;

public class JEleveMod extends JMotherMod {

    private JTextField textName;
    private JTextField textSurname;
    private BaseElem motherElem;

    private JButton accept;



    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    public JEleveMod(BaseElem what) {

         JLabel labelName;
         JLabel labelSurname;

        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(null);
        //composants
        JLabel nomFenetre = new JLabel("MODIFICATION ELEVE "+((Eleve)what).getPrenom()
                +" "+((Eleve)what).getNom());
        nomFenetre.setBounds(200, 10, 800,200);
        nomFenetre.setFont(new Font("Verdana",3,30));
        motherElem = what;

        accept = new JButton("Modifier");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new ModListener(this));

        textName = new JTextField();
        textName.setText(((Eleve)what).getPrenom());
        textName.setFont(defaultF);
        textName.setBounds(400, 300, 200,40);

        textSurname = new JTextField();
        textSurname.setFont(defaultF);
        textSurname.setBounds(400, 500, 200,40);
        textSurname.setText(((Eleve)what).getNom());

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


    public BaseElem getMotherElem() {
        return motherElem;
    }

    public JButton getAccept() {
        return accept;
    }

    public Font getDefaultF() {
        return defaultF;
    }
}
