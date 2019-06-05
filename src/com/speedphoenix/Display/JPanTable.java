package com.speedphoenix.Display;

import javax.swing.table.*;
import javax.swing.*;

public class JPanTable extends JPanel {

    public JPanTable(Object [] [] data, String [] title, int x , int y, int width, int height) {

        super();

        DefaultTableModel dtm = new DefaultTableModel();

        dtm.setDataVector(data, title);

        JTable table = new JTable(dtm);
        table.setDefaultRenderer(String.class, new TextAreaRenderer());
        //table.getColumn("JTextArea").setCellRenderer(new TextAreaRenderer());
        //table.getColumn("JTextArea").setCellEditor(new TextAreaEditor());
        setBounds(x,y,width, height);
        setLayout(null);

        table.setRowHeight(40);
        table.setBounds(0,0,this.getWidth(),this.getHeight());
        //JScrollPane scroll = new JScrollPane(table);
        //scroll.setLocation(0,0);
        add(table);
        //setBackground(Color.red);


    }
}