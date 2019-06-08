package com.speedphoenix.Display.Affclasses;

import com.speedphoenix.ActionListeners.UpMenu.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * JPanel qui les buttons de navigation initiale: Classes, Niveaux, Disciplines, Annees, Eleves, Enseignants
 */
public class JUpNavBar {
    private JPanel mainPanel;
    private Font defaultF = new Font("Verdana", 1,12);
    private ArrayList<JButton> buttons = new ArrayList<>();


    public JUpNavBar(){
        mainPanel= new JPanel();
        mainPanel.setFont(defaultF);
        mainPanel.setBounds(0,0,1000, 100);
        mainPanel.setBackground(Color.gray);
        mainPanel.setLayout(null);
        final int DECALLAGE =150;
        final int MARGIN = 60;


        JButton b1 = new JButton("Classes");
        b1.setFont(defaultF);
        b1.setBounds(MARGIN, 15, 120,70);
        JButton b2 = new JButton("Niveaux");
        b2.setFont(defaultF);
        b2.setBounds(MARGIN+DECALLAGE*1, 15, 120,70);
        JButton b3 = new JButton("Disciplines");
        b3.setFont(defaultF);
        b3.setBounds(MARGIN+DECALLAGE*2, 15, 120,70);
        JButton b4 = new JButton("Années");
        b4.setFont(defaultF);
        b4.setBounds(MARGIN+DECALLAGE*3, 15, 120,70);
        JButton b5 = new JButton("Eleves");
        b5.setFont(defaultF);
        b5.setBounds(MARGIN+DECALLAGE*4, 15, 120,70);
        JButton b6 = new JButton("Enseignants");
        b6.setFont(defaultF);
        b6.setBounds(MARGIN+DECALLAGE*5, 15, 120,70);

        mainPanel.add(b1);
        mainPanel.add(b2);
        mainPanel.add(b3);
        mainPanel.add(b4);
        mainPanel.add(b5);
        mainPanel.add(b6);

        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
    public void setActionsListeners(){
        buttons.get(0).addActionListener(new ClasseButtonListener());
        buttons.get(1).addActionListener(new NiveauButtonListener());
        buttons.get(2).addActionListener(new DisciplineButtonListener());
        buttons.get(3).addActionListener(new AnneeScolButtonListener());
        buttons.get(4).addActionListener(new EleveButtonListener());
        buttons.get(5).addActionListener(new EnseignantButtonListener());
        }

}
