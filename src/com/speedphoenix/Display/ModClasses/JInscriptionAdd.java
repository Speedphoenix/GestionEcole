package com.speedphoenix.Display.AddClasses;

import com.speedphoenix.ActionListeners.SideMenu.AddListener;
import com.speedphoenix.Modele.BaseElem;
import com.speedphoenix.Modele.Ecole;
import com.speedphoenix.Modele.Niveau;

import javax.swing.*;
import java.awt.*;

public class JInscriptionAdd extends JMotherMod {
    private JPanel mainPanel;
    private JComboBox <BaseElem> choiceBox;

    private JTextPane staticAncestorElement;

    private JButton accept;

    private String buffName;
    private String boxName;
    private String bufferTextAr;
    private String [] boxContent;




    private Font defaultF = new Font("Verdana", 1,14);

    public JInscriptionAdd(BaseElem what){
        /**/
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);

        choiceBox = new JComboBox<>();

        /**/

        bufferTextAr = new String("");


        creation(what.getId());
    }

    public void creation(int id){
        int counter =0;

        buffName = new String("Class");
        //choice box de niveau ou text area de niveau choisi

        bufferTextAr = Ecole.getInstance().getClasses().get(id).getNom();
        staticAncestorElement = new JTextPane();
        staticAncestorElement.setBounds(400, 400, 200, 40);
        staticAncestorElement.setName(buffName);
        staticAncestorElement.setText(bufferTextAr);
        staticAncestorElement.setEditable(false);
        staticAncestorElement.setBorder(BorderFactory.createTitledBorder(buffName));

        mainPanel.add(staticAncestorElement);



        //choice box de l'annee scolaire
        boxContent= new String [Ecole.getInstance().getEleves().size()];
        counter=0;
        for (Integer i : Ecole.getInstance().getEleves().keySet())
        {
            boxContent [counter] = Ecole.getInstance().getEleves().get(i).getPrenom()+ " " +
                    Ecole.getInstance().getEleves().get(i).getNom();

            counter++;
        }
        boxName = new String("Eleve");
        choiceBox = new JComboBox(boxContent);
        choiceBox.setBounds(400, 500, 200, 40);
        choiceBox.setBorder(BorderFactory.createTitledBorder(boxName));

        accept = new JButton("Ajouter");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));


        mainPanel.add(choiceBox);

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
