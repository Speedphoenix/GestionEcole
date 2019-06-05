package com.speedphoenix.Display;

import com.speedphoenix.Display.AddClasses.JMotherAdd;
import com.speedphoenix.Modele.Ecole;
import com.speedphoenix.Modele.Inscription;

import javax.swing.*;
import java.awt.*;

public class GraphicContainer extends JFrame {

    private JRightNavPanel sidePanel;
    private JUpNavBar upPanel;
    private JMother contentPan;
    private JMotherAdd contentPanAdd;
    private static GraphicContainer instance = new GraphicContainer();

    private GraphicContainer() {
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

        instance.revalidate();
        instance.repaint();
        instance.getSidePanel().setActionsListeners();
    }
    public static void createInstance(JMotherAdd motAdd) {
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
        // Ecole.getInstance().showTest();
        sidePanel.resetActionsListeners();
    }

    public JMother getContentPan() {
        return contentPan;
    }
}
