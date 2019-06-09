package com.speedphoenix.ActionListeners.UpMenu;

import com.speedphoenix.Display.Affclasses.JAnneeScolAff;
import com.speedphoenix.Display.GraphicContainer;
import com.speedphoenix.Display.Affclasses.JMother;
import com.speedphoenix.Display.Affclasses.JTrimestresAff;
import com.speedphoenix.Modele.Ecole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListenener utilisé pour un des boutons du menu du haut et redirigeant vers les années scolaires
 */
public class AnneeScolButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JMother mot = new JAnneeScolAff();
        //on réaffiche correctement la liste
        GraphicContainer.getInstance().setContentPan(mot);

    }
}
