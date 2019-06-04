package com.speedphoenix.Display;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JRightNavPanel {
    private JPanel mainPanel;
    //ArrayList<JButton> buttons;

    private Font defaultF = new Font("Verdana", 1,20);

    public JRightNavPanel(){
        mainPanel= new JPanel();
        mainPanel.setFont(defaultF);
        mainPanel.setBounds(0,100,200, 900);
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(null);
        //JPanel bufferpanel = new JPanel();
        //bufferpanel.setSize(200, 50);
        //bufferpanel.setBackground(Color.red);

        JButton b1 = new JButton("Ajouter");
        b1.setFont(defaultF);
        b1.setBounds(0, 100, 200,100);
        JButton b2 = new JButton("Supprimer");
        b2.setFont(defaultF);
        b2.setBounds(0, 300, 200,100);
        JButton b3 = new JButton("Choisir");
        b3.setFont(defaultF);
        b3.setBounds(0, 500, 200,100);
        JButton b4 = new JButton("Modifier");
        b4.setFont(defaultF);
        b4.setBounds(0, 700, 200,100);

        mainPanel.add(b1);
        //mainPanel.add(bufferpanel);
        mainPanel.add(b2);
        mainPanel.add(b3);
        mainPanel.add(b4);


        /*mainPanel.add(new JButton("Ajouter"));
        mainPanel.add(new JButton("Supprimer"));
        mainPanel.add(new JButton("Choisir"));
        mainPanel.add(new JButton("Modifier"));*/
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
