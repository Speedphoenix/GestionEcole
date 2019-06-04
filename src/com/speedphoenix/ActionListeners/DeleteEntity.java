package com.speedphoenix.ActionListeners;

import javax.swing.*;
import java.awt.event.*;

public class  DeleteEntity implements ActionListener {

    JList list = new JList();

    public DeleteEntity(JList list)
    {
        this.list = list;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //list.getSelectedIndex()


    }
}
