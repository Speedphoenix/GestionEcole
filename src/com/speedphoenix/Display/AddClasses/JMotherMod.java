package com.speedphoenix.Display.AddClasses;

import javax.swing.*;

public abstract class JMotherMod {

    protected JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    protected boolean okToAccept = false; //turn on the button accept

    public abstract JPanel getMainPanel();
    public abstract String getType();
}
