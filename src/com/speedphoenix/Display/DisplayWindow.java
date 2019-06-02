package com.speedphoenix.Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;




public class DisplayWindow {
    public enum Positio{

    }


    private JFrame mainFrame;
    private DisplayPannel dispPan;

    Position allPositions;
    String position;
    String newPosition;

    public DisplayWindow(){
        mainFrame= new JFrame();
        mainFrame.setSize(1000, 1000);
        mainFrame.setLayout(null);
        dispPan = new DisplayPannel();
    }

    public void turnOn(){
        mainFrame.setVisible(true);
    }

    public void setPanel(){

        String buffer= new String();
        JPanel J = new JPanel();
        JPanel School = new JPanel();
        School.setBackground(new Color(16, 184, 222));
        School.setBounds(0,0,1000,50);
        dispPan.addReadyComponent(School);


        /*String [] anneescolaires ={"Trimestres","Classes"};
        JComboBox anneeScolaire = new JComboBox(anneescolaires);
        anneeScolaire.setBounds(0,0,300,30);
        //anneeScolaire.setSelectedItem("Classes");

        String [] personnes ={"Etudiants","Enseignants"};
        JComboBox personne = new JComboBox(personnes);
        personne.setBounds(330, 0, 300, 30);
        //personne.setSelectedItem("Etudiants");
        */

        JButton trimestre = new JButton("Trimestres");
        trimestre.setBounds(5,50,190,30);

        JButton classe = new JButton("Classes");
        classe.setBounds(205,50,190,30);

        JButton etudiant = new JButton("Etudiants");
        etudiant.setBounds(405,50,190,30);

        JButton enseignant = new JButton("Enseignants");
        enseignant.setBounds(605,50,190,30);

        JButton discipline = new JButton("Disciplines");
        discipline.setBounds(805, 50, 190, 30);

       /* anneeScolaire.addActionListener(new CommmonActionListener((String) anneeScolaire.getItemAt(anneeScolaire.getSelectedIndex()), J, buffer));
        personne.addActionListener(new CommmonActionListener((String) personne.getItemAt(personne.getSelectedIndex()), J, buffer));*/




        //System.out.println(buffer);


        trimestre.addActionListener(new CommmonActionListener("Trimestres", J, buffer));
        classe.addActionListener(new CommmonActionListener("Classes", J, buffer));
        etudiant.addActionListener(new CommmonActionListener("Etudiants", J, buffer));
        enseignant.addActionListener(new CommmonActionListener("Enseignants", J, buffer));
        discipline.addActionListener(new CommmonActionListener("Disciplines", J, buffer));


        dispPan.addReadyComponent(trimestre);
        dispPan.addReadyComponent(classe);
        dispPan.addReadyComponent(etudiant);
        dispPan.addReadyComponent(enseignant);
        dispPan.addReadyComponent(discipline);
        //System.out.println(buffer);



        if(buffer!=null)
            newPosition=new String(buffer);
        if(J!=null)
            dispPan.addReadyComponent(J);

        /*buffer = new String();
        J = new JPanel();

        this.possibleModificationPosition(J, buffer);

        if(buffer!=null)
            newPosition=new String(buffer);
        if(J!=null)
            dispPan.addReadyComponent(J);
*/



    }

    public void possibleModificationPosition(JPanel J, String buffer){
        //System.out.println("asdasdasdasd");
        if (newPosition.equals(Position.ETUDIANTS))
        {
            JButton etudiant = new JButton("Choisir l'etudiant");
            etudiant.setBounds(500, 500, 190, 30);
            etudiant.addActionListener(new CommmonActionListener("Etudiant",J, buffer));
            dispPan.getPanelList().get(dispPan.getPanelList().size()-1).add(etudiant);
            System.out.println("asdasdasdfgdfher");
        }
        if (newPosition.equals(Position.ENSEIGNANTS))
        {
            JButton enseignant = new JButton("Choisir l'enseignant");
            enseignant.setBounds(500, 500, 190, 30);
            enseignant.addActionListener(new CommmonActionListener("Enseignant",J, buffer));
            dispPan.getPanelList().get(dispPan.getPanelList().size()-1).add(enseignant);
        }
        if (newPosition.equals(Position.BULLETINS))
        {
            JButton bulletin = new JButton("Choisir le bulletin");
            bulletin.setBounds(500, 500, 190, 30);
            bulletin.addActionListener(new CommmonActionListener("Bulletin",J, buffer));
            dispPan.getPanelList().get(dispPan.getPanelList().size()-1).add(bulletin);
        }
        if (newPosition.equals(Position.ETUDIANT))
        {
            JButton etudiantMod = new JButton("Modifier Etudiant");
            etudiantMod.setBounds(500, 500, 190, 30);
            etudiantMod.addActionListener(new CommmonActionListener("ModifierEtudiant",J, buffer));
            dispPan.getPanelList().get(dispPan.getPanelList().size()-1).add(etudiantMod);
        }
        if (newPosition.equals(Position.ENSEIGNANT))
        {
            JButton enseignantMod = new JButton("Modifier Enseignant");
            enseignantMod.setBounds(500, 500, 190, 30);
            enseignantMod.addActionListener(new CommmonActionListener("ModifierEnseignant",J, buffer));
            dispPan.getPanelList().get(dispPan.getPanelList().size()-1).add(enseignantMod);
        }
        if (newPosition.equals(Position.BULLETIN))
        {
            JButton enseignantMod = new JButton("Modifier Bulletin");
            enseignantMod.setBounds(500, 500, 190, 30);
            enseignantMod.addActionListener(new CommmonActionListener("ModifierBulletin",J, buffer));
            dispPan.getPanelList().get(dispPan.getPanelList().size()-1).add(enseignantMod);
        }
    }






    public void updateMainFrame(){

        this.turnOn();
        boolean work =true;

         allPositions = new Position();

         position = new String(Position.ECOLE);
         newPosition = new String(Position.ECOLE);



            while(work){

                System.out.println(newPosition);
                this.setPanel();

                //System.out.println(newPosition);

                if(!newPosition.equals(position))
                {
                    //System.out.println(newPosition);
                    //this.setPanel();
                    //on netoit le main frame
                    mainFrame.getContentPane().removeAll();

                    for (JComponent adder: dispPan.getPanelList())
                        mainFrame.add(adder);

                    //on vide la liste des pannels
                    dispPan.clearDisplayPanel();

                    //on update le main frame
                    mainFrame.revalidate();
                    mainFrame.repaint();

                    position=new String(newPosition);
                    //System.out.println("asdasdasd");

                }

            }

    }

}