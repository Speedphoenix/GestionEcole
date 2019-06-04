package com.speedphoenix.ActionListeners;

import com.speedphoenix.Display.JMother;
import com.speedphoenix.Modele.Ecole;

import javax.swing.*;
import java.awt.event.*;

public class  DeleteEntity implements ActionListener {

    JMother elem ;

    public DeleteEntity(JMother elem)
    {
        this.elem = elem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       int index = elem.getMainList().getSelectedIndex();
       //System.out.println(elem.getMainList().getSelectedIndex());
       System.out.println(Ecole.getInstance().findClasse(elem.motherElem.getId()).getInscriptions().get(index).getEleve().getNom());
       System.out.println(elem.getClass());


    }
}
