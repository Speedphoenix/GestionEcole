package com.speedphoenix.Display.Affclasses;

import com.speedphoenix.ActionListeners.SideMenu.DeleteEntityListener;
import com.speedphoenix.ActionListeners.SideMenu.RedirectAddListener;
import com.speedphoenix.ActionListeners.SideMenu.RedirectModListener;
import com.speedphoenix.ActionListeners.SideMenu.RedirectReportingListener;
import com.speedphoenix.Display.GraphicContainer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * JPanel qui contient les buttons d'action principales: ajout, modification et suppression
 */
public class JRightNavPanel {
    private JPanel mainPanel;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private DeleteEntityListener actionDel;
    private RedirectAddListener actionAdd;
    private RedirectModListener actionMod;
    private RedirectReportingListener actionReporting;



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
        JButton b4 = new JButton("Reporting");
        b4.setFont(defaultF);
        b4.setBounds(0, 700, 200,100);


        mainPanel.add(b1);
        mainPanel.add(b2);
        mainPanel.add(b3);
        mainPanel.add(b4);

        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);

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
        actionAdd = new RedirectAddListener(GraphicContainer.getInstance().getContentPan());
        actionMod = new RedirectModListener(GraphicContainer.getInstance().getContentPan());
        actionReporting = new RedirectReportingListener();
        buttons.get(0).addActionListener(actionAdd);
        buttons.get(1).addActionListener(actionDel);
        buttons.get(2).addActionListener(actionMod);
        buttons.get(3).addActionListener(actionReporting);

        buttons.forEach((value)->value.setEnabled(false));
        buttons.get(0).setEnabled(true);
        buttons.get(3).setEnabled(true);

    }
    public void resetActionsListeners(){
        //on enleve l'action listeners de supprimer et on en met un nouveau
        buttons.get(0).removeActionListener(actionAdd);
        buttons.get(1).removeActionListener(actionDel);
        buttons.get(2).removeActionListener(actionMod);
        buttons.get(4).removeActionListener(actionReporting);

        actionAdd = new RedirectAddListener(GraphicContainer.getInstance().getContentPan());
        buttons.get(0).addActionListener(actionAdd);
        actionDel = new DeleteEntityListener(GraphicContainer.getInstance().getContentPan());
        buttons.get(1).addActionListener(actionDel);
        actionMod = new RedirectModListener(GraphicContainer.getInstance().getContentPan());
        buttons.get(2).addActionListener(actionMod);
        actionReporting = new RedirectReportingListener();
        buttons.get(4).addActionListener(actionReporting);


        buttons.forEach((value)->value.setEnabled(false));
        buttons.get(0).setEnabled(true);
        buttons.get(3).setEnabled(true);


    }
}
