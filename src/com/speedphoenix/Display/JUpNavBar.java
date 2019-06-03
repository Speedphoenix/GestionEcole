package com.speedphoenix.Display;

import javax.swing.*;
import java.awt.*;

public class JUpNavBar {
    JPanel mainPanel;
    Font defaultF = new Font("Verdana", 1,20);

    public JUpNavBar(){
        mainPanel= new JPanel();
        mainPanel.setFont(defaultF);
        mainPanel.setBounds(0,0,1000, 100);
        mainPanel.setBackground(Color.gray);
        mainPanel.setLayout(null);


        JButton b1 = new JButton("Classes");
        b1.setFont(defaultF);
        b1.setBounds(50, 15, 200,70);
        JButton b2 = new JButton("Niveaux");
        b2.setFont(defaultF);
        b2.setBounds(275, 15, 200,70);
        JButton b3 = new JButton("Disciplines");
        b3.setFont(defaultF);
        b3.setBounds(500, 15, 200,70);
        JButton b4 = new JButton("Trimestres");
        b4.setFont(defaultF);
        b4.setBounds(725, 15, 200,70);

        mainPanel.add(b1);
        mainPanel.add(b2);
        mainPanel.add(b3);
        mainPanel.add(b4);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
