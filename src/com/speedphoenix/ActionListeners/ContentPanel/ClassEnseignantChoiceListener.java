package com.speedphoenix.ActionListeners.ContentPanel;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Modele.Ecole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassEnseignantChoiceListener implements ActionListener {

    protected JMother elem ;
    public ClassEnseignantChoiceListener(JMother elem) {
        this.elem = elem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Connexion conn = Connexion.conn;
        String classType =  elem.getClass().getCanonicalName();
        Ecole eco = Ecole.getInstance();
        JMother mot = null;
        int index = elem.getMainTable().getTable().getSelectedRow();


        mot = new JEnseigmnementsAff(eco.findClasse((int)elem.getListId().get(index)));        //on réaffiche correctement la liste
        GraphicContainer.getInstance().setContentPan(mot);



    }
}
