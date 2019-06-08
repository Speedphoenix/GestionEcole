package com.speedphoenix.Display.ModClasses.Mod;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.ModListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.BaseElem;
import com.speedphoenix.Modele.Discipline;
import com.speedphoenix.Modele.Niveau;

import javax.swing.*;
import java.awt.*;
/**
 * JPanel qui propose de modifier le Discipline
 * On demande d'endtrer: le nom
 */
public class JDisciplineMod extends JMotherMod {
    private JTextField textName;

    private BaseElem motherElem;

    private JButton accept;

    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise

    public JDisciplineMod(BaseElem what) {

        JLabel labelName;

        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(null);
        //composants
        JLabel nomFenetre = new JLabel("MODIFICATION DISCIPLINE "+((Discipline)what).getNom());
        nomFenetre.setBounds(200, 10, 800,200);
        nomFenetre.setFont(new Font("Verdana",3,30));
        motherElem = what;

        accept = new JButton("Modifier");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new ModListener(this));

        textName = new JTextField();
        textName.setText(((Discipline)what).getNom());
        textName.setFont(defaultF);
        textName.setBounds(400, 300, 200,40);

        labelName = new JLabel("Entrez le nom");
        labelName.setFont(defaultF);
        labelName.setBounds(400, 240, 200,100);

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
        return "discipline";
    }

    public JTextField getTextName() {
        return textName;
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
