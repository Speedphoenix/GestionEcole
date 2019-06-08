package com.speedphoenix.Display.ModClasses;

import javax.swing.*;

/**
 * Classe mere pour les JMod et les JAdd
 */
public abstract class JMotherMod {

    protected JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    protected boolean okToAccept = false; //turn on the button accept

    public abstract JPanel getMainPanel();
    public abstract String getType();
}
