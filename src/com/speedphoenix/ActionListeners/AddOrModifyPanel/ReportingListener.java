package com.speedphoenix.ActionListeners.AddOrModifyPanel;

import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Display.ModClasses.Mod.JReporting;
import com.speedphoenix.Modele.Ecole;
import com.speedphoenix.Modele.Reporting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportingListener implements ActionListener {

    protected JMotherMod elem;

    public ReportingListener(JMotherMod elem) {
        this.elem = elem;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Ecole sc = Ecole.getInstance();

        JReporting trueObject = (JReporting) elem;

        ((JReporting) elem).getGraphicPanel().removeAll();

        ((JReporting) elem).choix();

        ((JReporting) elem).getGraphicPanel().revalidate();
        ((JReporting) elem).getGraphicPanel().repaint();

        }

    }

