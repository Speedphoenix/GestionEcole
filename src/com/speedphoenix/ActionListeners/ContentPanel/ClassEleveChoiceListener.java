package com.speedphoenix.ActionListeners.ContentPanel;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.GraphicContainer;
import com.speedphoenix.Display.Affclasses.JInscriptionAff;
import com.speedphoenix.Display.Affclasses.JMother;
import com.speedphoenix.Modele.Ecole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListenener utilisé pour un des boutons du panneau d'affichage des classes et redirigeant vers les enseignements de cette classe
 */
public class ClassEleveChoiceListener implements ActionListener {

    protected JMother elem ;
    public ClassEleveChoiceListener(JMother elem) {
        this.elem = elem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Connexion conn = Connexion.conn;
        String classType =  elem.getClass().getCanonicalName();
        Ecole eco = Ecole.getInstance();
        JMother mot = null;
        int index = elem.getMainTable().getTable().getSelectedRow();


        mot = new JInscriptionAff(eco.findClasse((int)elem.getListId().get(index)));        //on réaffiche correctement la liste
        GraphicContainer.getInstance().setContentPan(mot);



    }
}
