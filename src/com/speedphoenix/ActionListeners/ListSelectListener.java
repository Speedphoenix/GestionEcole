package com.speedphoenix.ActionListeners;

import com.speedphoenix.Display.GraphicContainer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListSelectListener implements ListSelectionListener {

    JList list;

    public ListSelectListener(JList list) {
        this.list = list;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() == -1) {
                //No selection, disable buttons.
                GraphicContainer.getInstance().getSidePanel().getButtons().get(0).setEnabled(false);
                GraphicContainer.getInstance().getSidePanel().getButtons().get(1).setEnabled(false);
                GraphicContainer.getInstance().getSidePanel().getButtons().get(2).setEnabled(false);

                //.getButtons. setEnabled(true);
            } else {
                //Selection, enable the buttons.
                GraphicContainer.getInstance().getSidePanel().getButtons().get(0).setEnabled(true);
                GraphicContainer.getInstance().getSidePanel().getButtons().get(1).setEnabled(true);
                GraphicContainer.getInstance().getSidePanel().getButtons().get(2).setEnabled(true);            }
        }
    }
}
