package com.speedphoenix.ActionListeners.UpMenu;

import com.speedphoenix.Display.GraphicContainer;
import com.speedphoenix.Display.Affclasses.JDisciplineAff;
import com.speedphoenix.Display.Affclasses.JMother;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  ActionListenener utilisé pour un des boutons du menu du haut et redirigeant vers les Disciplines
 */
public class DisciplineButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        JMother mot = new JDisciplineAff();
        //on réaffiche correctement la liste
        GraphicContainer.getInstance().setContentPan(mot);



    }
}
