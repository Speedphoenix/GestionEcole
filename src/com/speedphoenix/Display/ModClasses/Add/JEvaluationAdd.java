package com.speedphoenix.Display.ModClasses.Add;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.AddListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.BaseElem;
import com.speedphoenix.Modele.Ecole;

import javax.swing.*;
import java.awt.*;

public class JEvaluationAdd extends JMotherMod {
    private JPanel mainPanel;


    private JTextPane staticAncestorElement;
    private JTextField note;
    private JTextPane appreciation;

    private JButton accept;

    private String buffName;
    private String bufferTextAr;


    private BaseElem motherElem;



    private Font defaultF = new Font("Verdana", 1,14);

    public JEvaluationAdd(BaseElem what){

        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);
        motherElem = what;

        bufferTextAr = new String("");


        creation(what.getId());
    }

    public void creation(int id){
        int counter =0;

        buffName = new String("Evaluation de:");
        //choice box de niveau ou text area de niveau choisi

        bufferTextAr = Ecole.getInstance().getDetailBulletins().get(id).getEnseignement().getDiscipline().getNom();
        staticAncestorElement = new JTextPane();
        staticAncestorElement.setBounds(400, 300, 200, 40);
        staticAncestorElement.setName(buffName);
        staticAncestorElement.setText(bufferTextAr);
        staticAncestorElement.setEditable(false);
        staticAncestorElement.setBorder(BorderFactory.createTitledBorder(buffName));

        mainPanel.add(staticAncestorElement);


        note = new JTextField();
        note.setName("note");
        note.setText("");
        note.setBounds(400, 400, 200, 40);
        note.setBorder(BorderFactory.createTitledBorder("Entrez la note"));

        mainPanel.add(note);

        appreciation = new JTextPane();
        appreciation.setName("Appreciation");
        appreciation.setText("");
        appreciation.setBounds(300, 500, 400, 200);
        appreciation.setBorder(BorderFactory.createTitledBorder("Entrez l'appreciation"));

        mainPanel.add(appreciation);




        accept = new JButton("Ajouter");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));


        mainPanel.add(accept);
    }

    public JTextField getNote() {
        return note;
    }

    public JTextPane getAppreciation() {
        return appreciation;
    }

    public BaseElem getMotherElem() {
        return motherElem;
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public String getType() {
        return "evaluation";
    }
}