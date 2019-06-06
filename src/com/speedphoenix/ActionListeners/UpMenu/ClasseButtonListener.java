package com.speedphoenix.ActionListeners.UpMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.speedphoenix.Display.*;
import com.speedphoenix.Display.Affclasses.JClasseAff;
import com.speedphoenix.Display.Affclasses.JMother;
import com.speedphoenix.Modele.Ecole;

public class ClasseButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        JMother mot = new JClasseAff(Ecole.getInstance());
        //on réaffiche correctement la liste
        GraphicContainer.getInstance().setContentPan(mot);



    }
}
