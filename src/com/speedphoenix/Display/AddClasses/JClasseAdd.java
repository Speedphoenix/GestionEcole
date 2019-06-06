package com.speedphoenix.Display.AddClasses;

import com.speedphoenix.ActionListeners.SideMenu.AddListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;

public class JClasseAdd extends JMotherMod {

    private JPanel mainPanel;
    private JTextField nomDeClasse;
    private JComboBox <BaseElem> firstChoiceBox;
    private JComboBox <BaseElem> secondChoiceBox;
    private JTextPane staticAncestorElement;

    private JButton accept;

    private String buffName;
    private String firstBoxName;
    private String bufferTextAr;
    private String [] firstBoxContent;
    private String [] secondBoxContent;

    private Class buffClass;

    private Font defaultF = new Font("Verdana", 1,14);

    public JClasseAdd(BaseElem what){
        /**/
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);

        nomDeClasse = new JTextField();
        nomDeClasse.setName("nomDeClasse");
        nomDeClasse.setText("");
        nomDeClasse.setBounds(400, 600, 200, 40);
        nomDeClasse.setBorder(BorderFactory.createTitledBorder("Entrez l'appreciation"));

        firstChoiceBox = new JComboBox<>();
        secondChoiceBox = new JComboBox<>();

        /**/

        bufferTextAr = new String("");

        buffClass=what.getClass();
        creation(what.getId());
    }

    public void creation(int id){
        int counter =0;

        buffName = new String("Niveau");
        //choice box de niveau ou text area de niveau choisi
        if(buffClass== Niveau.class){
            bufferTextAr = Ecole.getInstance().getNiveaux().get(id).getNom();
            staticAncestorElement = new JTextPane();
            staticAncestorElement.setBounds(400, 500, 200, 40);
            staticAncestorElement.setName(buffName);
            staticAncestorElement.setText(bufferTextAr);
            staticAncestorElement.setEditable(false);
            staticAncestorElement.setBorder(BorderFactory.createTitledBorder(buffName));

            mainPanel.add(staticAncestorElement);
        }
        else{
            secondBoxContent= new String [Ecole.getInstance().getAnneeScolaires().size()];
            counter=0;
            for (Integer i : Ecole.getInstance().getNiveaux().keySet())
            {
                secondBoxContent [counter] = "Niveau : " + Ecole.getInstance().getNiveaux().get(i).getNom();
                counter++;
            }
            secondChoiceBox = new JComboBox(secondBoxContent);
            secondChoiceBox.setBounds(400, 500, 200, 40);
            secondChoiceBox.setBorder(BorderFactory.createTitledBorder(buffName));

            mainPanel.add(secondChoiceBox);
        }

        //choice box de l'annee scolaire
        firstBoxContent= new String [Ecole.getInstance().getAnneeScolaires().size()];
        counter=0;
        for (Integer i : Ecole.getInstance().getAnneeScolaires().keySet())
        {
            firstBoxContent [counter] = "Debut : " + Ecole.getInstance().getAnneeScolaires().get(i).getStartYear()+ "  Fin : "+
                    Ecole.getInstance().getAnneeScolaires().get(i).getEndYear();

            counter++;
        }
        firstBoxName = new String("Année scolaire");
        firstChoiceBox = new JComboBox(firstBoxContent);
        firstChoiceBox.setBounds(400, 450, 200, 40);
        firstChoiceBox.setBorder(BorderFactory.createTitledBorder(firstBoxName));

        accept = new JButton("Ajouter");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));


        mainPanel.add(firstChoiceBox);
        mainPanel.add(nomDeClasse);
        mainPanel.add(accept);
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public String getType() {
        return "detailbulletin";
    }
}
