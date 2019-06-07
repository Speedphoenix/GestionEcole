package com.speedphoenix.Display;

import com.speedphoenix.ActionListeners.ContentPanel.ListSelectListener;
import com.speedphoenix.Display.AddClasses.JMotherMod;
import com.speedphoenix.Modele.Ecole;
import com.speedphoenix.Modele.Enseignant;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JReporting extends JMotherMod {

    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanTable mainTable; //Panel contenant le tableau d'affichage des donnees



    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public String getType() {
        return null;
    }

}
