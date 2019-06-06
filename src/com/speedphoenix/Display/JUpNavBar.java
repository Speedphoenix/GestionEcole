package com.speedphoenix.Display;

import javax.swing.*;
import java.awt.*;

public class JUpNavBar {
    private JPanel mainPanel;
    private Font defaultF = new Font("Verdana", 1,12);

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
        JButton b4 = new JButton("Trimestres");
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
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
