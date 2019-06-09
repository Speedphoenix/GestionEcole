package com.speedphoenix.ActionListeners.UpMenu;

import com.speedphoenix.Display.Affclasses.JClasseAff;
import com.speedphoenix.Display.Affclasses.JMother;
import com.speedphoenix.Display.Affclasses.JRightNavPanel;
import com.speedphoenix.Display.Affclasses.JUpNavBar;
import com.speedphoenix.Display.GraphicContainer;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Display.ModClasses.Mod.JReporting;
import com.speedphoenix.Modele.Ecole;
import com.speedphoenix.Modele.Reporting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourListener implements ActionListener {

    protected JMotherMod elem;

    public RetourListener(JMotherMod elem) {
        this.elem = elem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        GraphicContainer.createInstance(new JRightNavPanel(),new JUpNavBar(),new JClasseAff(Ecole.getInstance()));

    }






}
