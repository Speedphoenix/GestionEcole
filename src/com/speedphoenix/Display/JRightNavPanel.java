package com.speedphoenix.Display;

import com.speedphoenix.ActionListeners.SideMenu.DeleteEntityListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JRightNavPanel {
    private JPanel mainPanel;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private DeleteEntityListener actionDel;
    //private AddEntity actionAdd;
    //private ModifEntity actionMod;


    private Font defaultF = new Font("Verdana", 1,20);

    public JRightNavPanel(){
        mainPanel= new JPanel();
        mainPanel.setFont(defaultF);
        mainPanel.setBounds(0,100,200, 900);
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(null);


        JButton b1 = new JButton("Ajouter");
        b1.setFont(defaultF);
        b1.setBounds(0, 100, 200,100);
        JButton b2 = new JButton("Supprimer");
        b2.setFont(defaultF);
        b2.setBounds(0, 300, 200,100);
        JButton b3 = new JButton("Modifier");
        b3.setFont(defaultF);
        b3.setBounds(0, 500, 200,100);


        mainPanel.add(b1);
        mainPanel.add(b2);
        mainPanel.add(b3);

        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);

    }

    public ArrayList<JButton> getButtons() {
        return buttons;
    }
    public Font getDefaultF() {
        return defaultF;
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * set les actions listeners de tout les boutons et les rend inaccessibles tant que l'on a pas cliqué
     * sur un élément de la ligne.
     */
    public void setActionsListeners(){
        actionDel = new DeleteEntityListener(GraphicContainer.getInstance().getContentPan());
        buttons.get(1).addActionListener(actionDel);
        buttons.forEach((value)->value.setEnabled(false));
        buttons.get(0).setEnabled(true);

    }
    public void resetActionsListeners(){
        //on enleve l'action listeners de supprimer et on en met un nouveau
        buttons.get(1).removeActionListener(actionDel);
        actionDel = new DeleteEntityListener(GraphicContainer.getInstance().getContentPan());
        buttons.get(1).addActionListener(actionDel);

        buttons.forEach((value)->value.setEnabled(false));
        buttons.get(0).setEnabled(true);

    }
}
