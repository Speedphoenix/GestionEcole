package com.speedphoenix.Display;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayPannel {
    private ArrayList<JComponent> panelList;

    DisplayPannel(){
        panelList= new ArrayList<JComponent>();
    }

    public void addReadyComponent(JComponent panel){
        panelList.add(panel);
    }

    /*public void addNewPanel(int posX, int posY, int height, int width, ){

    }
    */

    public void clearDisplayPanel(){
        panelList.clear();
    }

    public ArrayList<JComponent> getPanelList(){
        return panelList;
    }

}
