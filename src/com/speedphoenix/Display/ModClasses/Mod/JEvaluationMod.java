package com.speedphoenix.Display.ModClasses.Mod;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.ModListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.BaseElem;
import com.speedphoenix.Modele.DetailBulletin;
import com.speedphoenix.Modele.Evaluation;

import javax.swing.*;
import java.awt.*;
/**
 * JPanel qui propose de modifier Evaluation
 * On demande d'endtrer: la note et l'appreciation
 */
public class JEvaluationMod extends JMotherMod {
    private JPanel mainPanel;
    private JTextPane appreciation;
    private JTextField note;

    private BaseElem motherElem;
    private JButton accept;

    private Font defaultF = new Font("Verdana", 1,14);

    public JEvaluationMod(BaseElem what){
        /**/
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);

        JLabel nomFenetre = new JLabel("MODIFICATION EVALUATION "+((Evaluation)what).getDetailBulletin().getEnseignement().getDiscipline().getNom());
        nomFenetre.setBounds(100, 10, 900,200);
        nomFenetre.setFont(new Font("Verdana",3,30));

        accept = new JButton("Modifier");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new ModListener(this));

        appreciation = new JTextPane();
        appreciation.setName("Appreciation");
        appreciation.setText(((Evaluation)what).getAppreciation());
        appreciation.setBounds(300, 400, 400, 200);
        appreciation.setBorder(BorderFactory.createTitledBorder("Entrez l'appreciation"));

        note = new JTextField();
        note.setName("note");
        note.setText(String.valueOf(((Evaluation)what).getNote()));
        note.setBounds(400, 300, 200, 40);
        note.setBorder(BorderFactory.createTitledBorder("Entrez la note"));
        motherElem = what;

        mainPanel.add(appreciation);
        mainPanel.add(note);
        mainPanel.add(accept);
        mainPanel.add(nomFenetre);

    }


    public BaseElem getMotherElem() {
        return motherElem;
    }

    public JTextPane getAppreciation() {
        return appreciation;
    }

    public JTextField getNote() {
        return note;
    }

    public String getType() {
        return "evaluation";
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
