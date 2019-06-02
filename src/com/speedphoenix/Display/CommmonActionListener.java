package com.speedphoenix.Display;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommmonActionListener implements ActionListener {


    String actionToPerfrom;
    JPanel referencedDisplayPanel;
    String referencePosition = new String();

    public CommmonActionListener(String act, JPanel J, String actPos){
        //Rsuper();
        actionToPerfrom = new String(act);
        referencedDisplayPanel=J;
        referencePosition=actPos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.handMadeActionPerformed();
    }

    public void handMadeActionPerformed(){


        switch (actionToPerfrom){
            case "Etudiants":
                referencedDisplayPanel.setBounds(0,85,1000,900);
                referencedDisplayPanel.setBackground(Color.red);
                referencePosition=Position.ETUDIANTS;
                break;
            case "Enseignants":
                referencedDisplayPanel.setBounds(0,85,1000,900);
                referencedDisplayPanel.setBackground(Color.blue);
                referencePosition=Position.ENSEIGNANTS;
                break;
            case "Trimestres":
                referencedDisplayPanel.setBounds(0,85,1000,900);
                referencedDisplayPanel.setBackground(Color.green);
                referencePosition=Position.TRIMESTRES;
                break;
            case "Classes":
                referencedDisplayPanel.setBounds(0,85,1000,900);
                referencedDisplayPanel.setBackground(Color.black);
                referencePosition=Position.CLASSES;
                break;
            case "Disciplines":
                referencedDisplayPanel.setBounds(0,85,1000,900);
                referencedDisplayPanel.setBackground(Color.darkGray);
                referencePosition=Position.DISCIPLINES;
                break;
            case "Bulletins":
                referencedDisplayPanel.setBounds(0,85,1000,900);
                referencedDisplayPanel.setBackground(Color.YELLOW);
                referencePosition=Position.BULLETINS;
                break;
            case "Bulletin":
                referencedDisplayPanel.setBounds(0,85,1000,900);
                referencedDisplayPanel.setBackground(Color.black);
                referencePosition=Position.BULLETIN;
                break;
            case "Etudiant":
                referencedDisplayPanel.setBounds(0,85,1000,900);
                referencedDisplayPanel.setBackground(Color.orange);
                referencePosition=Position.ETUDIANT;
                break;
            case "Enseignant":
                referencedDisplayPanel.setBounds(0,85,1000,900);
                referencedDisplayPanel.setBackground(Color.gray);
                referencePosition=Position.ENSEIGNANT;
                break;
            case "ModifierEtudiant":
                break;
            case "ModifierEnseignant":
                break;
            case "ModifierBulletin":
                break;



            /*case "Enseignants":
                break;*/
        }
    }
}
