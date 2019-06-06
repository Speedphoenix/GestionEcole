package com.speedphoenix.ActionListeners.UpMenu;

import com.speedphoenix.Display.GraphicContainer;
import com.speedphoenix.Display.JDisciplineAff;
import com.speedphoenix.Display.JMother;
import com.speedphoenix.Display.JNiveauAff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisciplineButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        JMother mot = new JDisciplineAff();
        //on réaffiche correctement la liste
        GraphicContainer.getInstance().setContentPan(mot);



    }
}
