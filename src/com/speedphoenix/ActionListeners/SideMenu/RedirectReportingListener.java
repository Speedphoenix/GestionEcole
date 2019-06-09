package com.speedphoenix.ActionListeners.SideMenu;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.Affclasses.*;
import com.speedphoenix.Display.GraphicContainer;
import com.speedphoenix.Display.ModClasses.Add.*;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Display.ModClasses.Mod.JReporting;
import com.speedphoenix.Modele.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Actionlistener pour le bouton d'ajout du menu de gauche
 */
public class RedirectReportingListener implements ActionListener {

    protected JMother elem ;

    public RedirectReportingListener(){

    }

    /**
     * A la detection d'un évènement, on cherche le type objet sélectionner et on redirige vers la page d'ajout adéquate
     * @param e non utilisé (ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {


            JMotherMod mot = new JReporting();

        if( mot != null)
            GraphicContainer.createInstance(mot);



    }
}
