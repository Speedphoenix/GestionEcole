package com.speedphoenix.ActionListeners.UpMenu;

import com.speedphoenix.Display.GraphicContainer;
import com.speedphoenix.Display.JEnseignantsAff;
import com.speedphoenix.Display.JMother;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnseignantButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        JMother mot = new JEnseignantsAff();
        //on réaffiche correctement la liste
        GraphicContainer.getInstance().setContentPan(mot);



    }
}
