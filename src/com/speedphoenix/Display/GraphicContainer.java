package com.speedphoenix.Display;

import com.speedphoenix.ActionListeners.ContentPanel.ChangeObjectListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;

import javax.swing.*;

public class GraphicContainer extends JFrame {

    private JRightNavPanel sidePanel;
    private JUpNavBar upPanel;
    private JMother contentPan;
    private JMotherMod contentPanAdd;
    private static GraphicContainer instance = new GraphicContainer("Gestion Ecole");

    private GraphicContainer(String name) {
        super.setTitle(name);
    }


    public static void createInstance(JRightNavPanel sidePanel, JUpNavBar upPanel, JMother contentPan) {
        //on réanitialise

        instance.sidePanel = null;
        instance.upPanel = null;
        instance.contentPan = null;
        instance.contentPanAdd = null;
        instance.getContentPane().removeAll();

        instance.sidePanel = sidePanel;
        instance.upPanel = upPanel;
        instance.contentPan = contentPan;
        getInstance().add(sidePanel.getMainPanel());
        getInstance().add(upPanel.getMainPanel());
        getInstance().add(contentPan.getMainPanel());
        instance.contentPan.getMainTable().getTable().addMouseListener(new ChangeObjectListener(instance.contentPan));

        instance.revalidate();
        instance.repaint();
        instance.getSidePanel().setActionsListeners();
        instance.getUpPanel().setActionsListeners();
    }
    public static void createInstance(JMotherMod motAdd) {
        instance.sidePanel = null;
        instance.upPanel = null;
        instance.contentPan = null;
        instance.contentPanAdd = null;

        instance.getContentPane().removeAll();
        instance.contentPanAdd = motAdd;
        instance.revalidate();
        instance.repaint();

        getInstance().add(motAdd.getMainPanel());

    }
    public static GraphicContainer getInstance() {
        return instance;
    }

    public JRightNavPanel getSidePanel() {
        return sidePanel;
    }

    public JUpNavBar getUpPanel() {
        return upPanel;
    }

    public void setContentPan(JMother contPan) {
        instance.contentPan.getMainPanel().setVisible(false);
        instance.remove(instance.contentPan.getMainPanel());
        this.contentPan = contPan;
        //instance.revalidate();
        instance.add(instance.contentPan.getMainPanel());
        instance.contentPan.getMainPanel().setVisible(true);
        instance.contentPan.getMainTable().getTable().addMouseListener(new ChangeObjectListener(instance.contentPan));
        // Ecole.getInstance().showTest();
        sidePanel.resetActionsListeners();
    }

    public JMother getContentPan() {
        return contentPan;
    }
}
