package com.speedphoenix.Display;

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

    public JPanel getContentPan() {
        return contentPan;
    }
}
