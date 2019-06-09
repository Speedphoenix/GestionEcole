package com.speedphoenix.Display.ModClasses.Add;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.AddListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.AnneeScolaire;
import com.speedphoenix.Modele.BaseElem;
import com.speedphoenix.Modele.Ecole;
import java.util.Calendar;
import java.util.Date;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Properties;
/**
 * JPanel qui prppose de rentrer les informations pour ajouter un Trimestre
 */
public class JTrimestreAdd extends JMotherMod {
    private JPanel mainPanel;
    private JComboBox <BaseElem> choiceBox;

    private JTextPane staticAncestorElement;
    private JTextPane numeroTextArea;
    private JLabel nomFenetre;

    private JButton accept;

    private BaseElem motherElem;

    private JDatePickerImpl startYearPanel;
    private JDatePickerImpl endYearPanel;

    private Font defaultF = new Font("Verdana", 1,14);

    public JTrimestreAdd(BaseElem what){

        motherElem = what;
        AnneeScolaire mot = Ecole.getInstance().findAnneeScolaire(motherElem.getId());
        int AnneeStart = mot.getStartYear();
        int AnneeEnd = mot .getEndYear();
        String periode = " Année "+AnneeStart+"/"+AnneeEnd;
        if(AnneeStart == 0 || AnneeEnd == 0)
            periode = "periode indeterminée";

        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);


        //initialisation des panels de date
        UtilDateModel model = new UtilDateModel();
        model.setDate(2019,06,13);
        UtilDateModel model2 = new UtilDateModel();
        model2.setDate(2019,06,13);
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
         startYearPanel = new JDatePickerImpl(datePanel, new DateLabelFormatter());
         endYearPanel = new JDatePickerImpl(datePanel2, new DateLabelFormatter());

        startYearPanel.setBounds(400,450,200,50);
        startYearPanel.setBorder(BorderFactory.createTitledBorder("Date de début"));
        startYearPanel.setBackground(Color.lightGray);
        endYearPanel.setBounds(400,550,200,50);
        endYearPanel.setBorder(BorderFactory.createTitledBorder("Date de fin"));
        endYearPanel.setBackground(Color.lightGray);

        accept = new JButton("Ajouter");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));

        staticAncestorElement = new JTextPane();
        staticAncestorElement.setBounds(400, 350, 200, 40);
        staticAncestorElement.setName("Période");
        staticAncestorElement.setText(periode+"     Id : "+motherElem.getId());
        staticAncestorElement.setEditable(false);
        staticAncestorElement.setBorder(BorderFactory.createTitledBorder("Période"));

        numeroTextArea = new JTextPane();
        numeroTextArea.setBounds(400, 650, 200, 40);
        numeroTextArea.setName("Numéro du trimestre");
        numeroTextArea.setEditable(true);
        numeroTextArea.setBorder(BorderFactory.createTitledBorder("Numéro du trimestre"));

        nomFenetre = new JLabel("Ajout Trimestre");
        nomFenetre.setBounds(380, 10, 800,200);
        nomFenetre.setFont(new Font("Verdana",3,30));

        mainPanel.add(nomFenetre);
        mainPanel.add(startYearPanel);
        mainPanel.add(endYearPanel);
        mainPanel.add(staticAncestorElement);
        mainPanel.add(accept);
        mainPanel.add(numeroTextArea);


        //creation(what.getId());
    }
/*
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
            listId.add( Ecole.getInstance().findEleve(i).getId());
            counter++;
        }
        boxName = new String("Eleve");
        choiceBox = new JComboBox(boxContent);
        choiceBox.setBounds(400, 500, 200, 40);
        choiceBox.setBorder(BorderFactory.createTitledBorder(boxName));


    }
*/
    public JComboBox<BaseElem> getChoiceBox() {
        return choiceBox;
    }

    public BaseElem getMotherElem() {
        return motherElem;
    }



    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextPane getNumeroTextArea() {
        return numeroTextArea;
    }

    public JDatePickerImpl getStartYearPanel() {
        return startYearPanel;
    }

    public JDatePickerImpl getEndYearPanel() {
        return endYearPanel;
    }

    @Override
    public String getType() {
        return "trimestre";
    }
}
