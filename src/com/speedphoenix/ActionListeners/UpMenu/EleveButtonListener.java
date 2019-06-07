package com.speedphoenix.ActionListeners.UpMenu;

import com.speedphoenix.Display.GraphicContainer;
import com.speedphoenix.Display.Affclasses.JElevesAff;
import com.speedphoenix.Display.Affclasses.JMother;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EleveButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        JMother mot = new JElevesAff();
        //on réaffiche correctement la liste
        GraphicContainer.getInstance().setContentPan(mot);



    }
}
