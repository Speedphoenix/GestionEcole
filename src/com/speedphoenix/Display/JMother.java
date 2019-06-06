package com.speedphoenix.Display;

import com.speedphoenix.Modele.BaseElem;

import javax.swing.*;
import java.util.ArrayList;

public abstract class JMother {

    protected BaseElem motherElem;
    protected ArrayList<Integer> listId = new ArrayList<Integer>();
    public JMother() {
    }
    public abstract JPanel getMainPanel();

    public BaseElem getMotherElem() {
        return motherElem;
    }

    public ArrayList getListId() {
        return listId;
    }
    //pour avoir access au tableau ajoute .getTable() apres
    public abstract JPanTable getMainTable();

}
