package com.speedphoenix.Display.Affclasses;

import com.speedphoenix.Modele.BaseElem;

import javax.swing.*;
import java.util.ArrayList;
/**
 * une classe abstraite dont toutes les classes JAff heritent
 */
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
