package com.speedphoenix.Display.Affclasses;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
/**
 * Tbale cell renderer qui nous permet d'afficher les informations de la case dans un JTextAres
 */
class TextAreaRenderer extends JScrollPane implements TableCellRenderer
{
    JTextArea textarea;

    public TextAreaRenderer() {
        textarea = new JTextArea();
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBorder(new TitledBorder(""));
        getViewport().add(textarea);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column)
    {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
            textarea.setForeground(table.getSelectionForeground());
            textarea.setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
            textarea.setForeground(table.getForeground());
            textarea.setBackground(table.getBackground());
        }

        textarea.setText((String) value);
        textarea.setCaretPosition(0);

        TextAreaRenderer.centerText(textarea);
        return this;
    }

    /**
     * Permet de centrer le text dans un JTextArea choisie
     * @param ta JTextArea dont on veux centrer le texte
     */
    public static void centerText (JTextArea ta)
    {
        BufferedImage fake1 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D fake2 = fake1.createGraphics();
        FontMetrics fm = fake2.getFontMetrics(ta.getFont());

        int lines = ta.getLineCount();
        ArrayList<String> list = new ArrayList<>();
        try
        {
            for (int i = 0; i < lines; i++)
            {
                int start = ta.getLineStartOffset(i);
                int end = ta.getLineEndOffset(i);

                String line = ta.getText(start, end - start).replace("\n","");
                list.add (line.trim());
            }
        }
        catch (BadLocationException e)
        {
            System.out.println(e);
        }
        alignLines (list, fm, ta);
    }

    private static void alignLines (ArrayList<String> list, FontMetrics fm, JTextArea ta)
    {
        String leading = "      ";
        int longest = -1;
        for (String s : list)
        {
            if (fm.stringWidth(s) > longest)
                longest = fm.stringWidth(s);
        }
        for (int n=0; n<list.size(); n++)
        {
            String s = list.get(n);
            if (fm.stringWidth(s) >= longest)
                continue;
            while (fm.stringWidth(s) < longest)
                s = ' '+s+' ';
            list.set(n, s);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list)
        {
            sb.append(leading).append(s).append('\n');
        }
        ta.setText (sb.toString());
    }
}