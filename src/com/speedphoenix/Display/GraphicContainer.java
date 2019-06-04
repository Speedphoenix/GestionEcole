package com.speedphoenix.Display;

import javax.swing.*;

public class GraphicContainer extends JFrame {

    private static GraphicContainer instance = new GraphicContainer();

    private GraphicContainer() {
    }

    public static GraphicContainer getInstance() {
        return instance;
    }
}
