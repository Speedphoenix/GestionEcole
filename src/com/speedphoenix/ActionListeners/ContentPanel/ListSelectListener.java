package com.speedphoenix.ActionListeners.ContentPanel;

import com.speedphoenix.Display.GraphicContainer;
import com.speedphoenix.Display.JClasseAff;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListSelectListener implements ListSelectionListener {

    JTable table;

    public ListSelectListener(JTable table) {
        this.table = table;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (table.getSelectedRow() == -1) {
                //No selection, disable buttons.
                GraphicContainer.getInstance().getSidePanel().getButtons().get(0).setEnabled(false);
                GraphicContainer.getInstance().getSidePanel().getButtons().get(1).setEnabled(false);
                GraphicContainer.getInstance().getSidePanel().getButtons().get(2).setEnabled(false);

                //.getButtons. setEnabled(true);
            } else {
                //Selection, enable the buttons.
                GraphicContainer.getInstance().getSidePanel().getButtons().get(0).setEnabled(true);
                GraphicContainer.getInstance().getSidePanel().getButtons().get(1).setEnabled(true);
                GraphicContainer.getInstance().getSidePanel().getButtons().get(2).setEnabled(true);
                if(GraphicContainer.getInstance().getContentPan().getClass() == JClasseAff.class)
                {
                    JClasseAff jClasseAff = (JClasseAff) GraphicContainer.getInstance().getContentPan();
                    jClasseAff.getEleveButton().setEnabled(true);
                    jClasseAff.getEnseignantButton().setEnabled(true);
                }
            }
        }
    }
}
