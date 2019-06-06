package com.speedphoenix.Display.ModClasses;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.AddListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JEnseignementAdd extends JMotherMod {
    private JPanel mainPanel;
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

    protected ArrayList<Integer> listIdFirstBox = new ArrayList<Integer>();
    protected ArrayList<Integer> listIdSecondBox = new ArrayList<Integer>();

    private BaseElem motherElem;

    public JEnseignementAdd(BaseElem what){
        /**/
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);

        firstChoiceBox = new JComboBox<>();
        secondChoiceBox = new JComboBox<>();

        /**/

        bufferTextAr = new String("");

        motherElem = what;
        buffClass=what.getClass();
        creation(what.getId());
    }

    public void creation(int id){
        int counter =0;

        //choice box de niveau ou text area de niveau choisi
        if(buffClass== Discipline.class){
            buffName = new String("Discipline");
            bufferTextAr = Ecole.getInstance().getDisciplines().get(id).getNom();

            secondBoxContent= new String [Ecole.getInstance().getClasses().size()];
            counter=0;
            for (Integer i : Ecole.getInstance().getClasses().keySet())
            {
                secondBoxContent [counter] =  Ecole.getInstance().getClasses().get(i).getNom() + " Niveau : "+
                Ecole.getInstance().getClasses().get(i).getNiveau().getNom();
                listIdSecondBox.add(Ecole.getInstance().findClasse(i).getId());

                counter++;
            }
            secondChoiceBox = new JComboBox(secondBoxContent);
            secondChoiceBox.setBounds(400, 500, 200, 40);
            secondChoiceBox.setBorder(BorderFactory.createTitledBorder("Classe"));

        }
        else if (buffClass==Classe.class){
            buffName = new String("Classe");
            bufferTextAr = Ecole.getInstance().getClasses().get(id).getNom()+" Niveau : "+Ecole.getInstance().getClasses().get(id).getNiveau().getNom();

            secondBoxContent= new String [Ecole.getInstance().getDisciplines().size()];
            counter=0;
            for (Integer i : Ecole.getInstance().getDisciplines().keySet())
            {
                secondBoxContent [counter] = Ecole.getInstance().getDisciplines().get(i).getNom();
                listIdSecondBox.add(Ecole.getInstance().findDiscipline(i).getId());

                counter++;
            }
            secondChoiceBox = new JComboBox(secondBoxContent);
            secondChoiceBox.setBounds(400, 500, 200, 40);
            secondChoiceBox.setBorder(BorderFactory.createTitledBorder("Discipline"));
        }

        //element statique (Classe ou Discipline)
        staticAncestorElement = new JTextPane();
        staticAncestorElement.setBounds(400, 400, 200, 40);
        staticAncestorElement.setName("Discipline");
        staticAncestorElement.setText(bufferTextAr);
        staticAncestorElement.setEditable(false);
        staticAncestorElement.setBorder(BorderFactory.createTitledBorder(buffName));

        //choice box des enseignants
        firstBoxContent= new String [Ecole.getInstance().getEnseignants().size()];
        counter=0;
        for (Integer i : Ecole.getInstance().getEnseignants().keySet())
        {
            firstBoxContent [counter] =  Ecole.getInstance().getEnseignants().get(i).getPrenom()+ " " +
                    Ecole.getInstance().getEnseignants().get(i).getNom();
            listIdFirstBox.add(Ecole.getInstance().findEnseignant(i).getId());

            counter++;
        }
        firstBoxName = new String("Enseignant");
        firstChoiceBox = new JComboBox(firstBoxContent);
        firstChoiceBox.setBounds(400, 450, 200, 40);
        firstChoiceBox.setBorder(BorderFactory.createTitledBorder(firstBoxName));

        accept = new JButton("Ajouter");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));


        mainPanel.add(firstChoiceBox);
        mainPanel.add(secondChoiceBox);
        mainPanel.add(staticAncestorElement);
        mainPanel.add(accept);

    }

    public JComboBox<BaseElem> getFirstChoiceBox() {
        return firstChoiceBox;
    }

    public JComboBox<BaseElem> getSecondChoiceBox() {
        return secondChoiceBox;
    }

    public int getListIdFirstBox(int index) {
        return listIdFirstBox.get(index);
    }

    public int getListIdSecondBox(int index) {
        return listIdSecondBox.get(index);
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
        return "enseignement";
    }
}
