package com.speedphoenix.Display;

import com.speedphoenix.Modele.BaseElem;

import javax.swing.*;

public abstract class JMother {

    public BaseElem motherElem;

    public JMother() {
    }
    public abstract JPanel getMainPanel();
    //pour avoir access au tableau ajoute .getTable() apres
    public abstract JPanTable getMainTable();
}
