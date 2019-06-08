package com.speedphoenix.Display.ModClasses.Mod;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.AddListener;
import com.speedphoenix.ActionListeners.AddOrModifyPanel.ModListener;
import com.speedphoenix.Display.ModClasses.Add.DateLabelFormatter;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.*;
import org.jdatepicker.impl.*;
import javax.swing.*;
import java.awt.*;
import java.util.Properties;
/**
 * JPanel qui propose de modifier
 * On propose a choisir: les dates
 */
public class JTrimestreMod extends JMotherMod {
    private JPanel mainPanel;
    private JComboBox <BaseElem> choiceBox;

    private JTextPane numeroTextArea;

    private JButton accept;

    private BaseElem motherElem;

    private JDatePickerImpl startYearPanel;
    private JDatePickerImpl endYearPanel;

    private Font defaultF = new Font("Verdana", 1,14);

    public JTrimestreMod(BaseElem what){

        motherElem = what;
        Trimestre mot = Ecole.getInstance().findTrimestre(motherElem.getId());


        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);

        JLabel nomFenetre = new JLabel("MODIFICATION TRIMESTRE "+((Trimestre)what).getNumero());
        nomFenetre.setBounds(240, 10, 800,200);
        nomFenetre.setFont(new Font("Verdana",3,30));

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

        startYearPanel.setBounds(400,400,200,50);
        startYearPanel.setBorder(BorderFactory.createTitledBorder("Date de début"));
        startYearPanel.setBackground(Color.lightGray);
        endYearPanel.setBounds(400,500,200,50);
        endYearPanel.setBorder(BorderFactory.createTitledBorder("Date de fin"));
        endYearPanel.setBackground(Color.lightGray);

        accept = new JButton("Modifier");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new ModListener(this));


        numeroTextArea = new JTextPane();
        numeroTextArea.setBounds(400, 600, 200, 40);
        numeroTextArea.setName("Numéro du trimestre");
        numeroTextArea.setEditable(true);
        numeroTextArea.setText(""+((Trimestre) what).getNumero()+"");
        numeroTextArea.setBorder(BorderFactory.createTitledBorder("Numéro du trimestre"));

        mainPanel.add(startYearPanel);
        mainPanel.add(endYearPanel);
        mainPanel.add(accept);
        mainPanel.add(nomFenetre);
        mainPanel.add(numeroTextArea);

    }

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
