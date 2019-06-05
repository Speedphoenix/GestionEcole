package com.speedphoenix.Display;

import com.speedphoenix.Modele.Ecole;
import com.speedphoenix.Modele.Inscription;

import javax.swing.*;
import java.awt.*;

public class GraphicContainer extends JFrame {

    private JRightNavPanel sidePanel;
    private JUpNavBar upPanel;
    private JMother contentPan;
    private static GraphicContainer instance = new GraphicContainer();

    private GraphicContainer() {
    }


    public static void createInstance(JRightNavPanel sidePanel, JUpNavBar upPanel, JMother contentPan) {
        instance.sidePanel = sidePanel;
        instance.upPanel = upPanel;
        instance.contentPan = contentPan;
        getInstance().add(sidePanel.getMainPanel());
        getInstance().add(upPanel.getMainPanel());
        getInstance().add(contentPan.getMainPanel());
        instance.getSidePanel().setActionsListeners();
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
