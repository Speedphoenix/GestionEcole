package com.speedphoenix.Display;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class JPanTable extends JPanel {

    JTable table;

    public JPanTable(Object [] [] data, String [] title, int x , int y, int width, int height) {

        super();

        DefaultTableModel dtm = new DefaultTableModel()
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };

        dtm.setDataVector(data, title);

        table = new JTable(dtm);
        table.setDefaultRenderer(String.class, new TextAreaRenderer());
        //table.setFont(new Font("Verdana", 1,14));
        setBounds(x,y,width, height);
        table.setRowHeight(80);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0,0,this.getWidth(), this.getHeight());
        add(scroll);
        setLayout(null);



    }

    public JTable getTable() {
        return table;
    }
}

/*
super( );

        DefaultTableModel dtm = new DefaultTableModel() {
            // make first cell uneditable
            public boolean isCellEditable(int row, int column)
            {
                return !(column == 0);
            }
        };

        dtm.setDataVector(new Object[][]{{ "JTextArea1", "This is a testnon long linesn" },
                        { "JTextArea2", "Hello, world!" }},
                new Object[]{ "String","JTextArea"});

        JTable table = new JTable(dtm);
        table.getColumn("JTextArea").setCellRenderer(new TextAreaRenderer());
        //table.getColumn("JTextArea").setCellEditor(new TextAreaEditor());

        table.setRowHeight(80);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0,0,400, 250);
        add(scroll);
        setLayout(null);
        setBounds(100,100, 400, 250 );

 */