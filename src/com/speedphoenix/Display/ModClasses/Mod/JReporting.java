package com.speedphoenix.Display.ModClasses.Mod;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.ModListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.BaseElem;
import com.speedphoenix.ActionListeners.AddOrModifyPanel.ReportingListener;
import com.speedphoenix.Modele.Ecole;
import com.speedphoenix.Modele.Reporting;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.Iterator;

public class JReporting extends JMotherMod {

    private JPanel mainPanel;//JPanel qu'on va envoyer sur mainframe
    private JPanel upPanel;
    private JPanel graphicPanel;

    private BaseElem motherElem;
    private JButton retour_menu;
    public JComboBox menu;
    private JButton accepter;

    JFreeChart chart;

    String categorie, donnee;
    ArrayList<String> liste;

    private Font defaultF = new Font("Verdana", 1,17);//font par defaut qu'on utilise


    /** Constructeur */
    public JReporting(BaseElem what)
    {
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(null);

        upPanel = new JPanel();
        upPanel.setBounds(0,0,1000,200);
        upPanel.setBackground(Color.lightGray);
        upPanel.setLayout(null);

        graphicPanel = new JPanel();
        graphicPanel.setBounds(0,200,1000,800);
        graphicPanel.setBackground(Color.lightGray);
        graphicPanel.setLayout(null);

        //composants
        JLabel nomFenetre = new JLabel(" STATISTIQUES " );
        nomFenetre.setBounds(360, 10, 360,80);
        nomFenetre.setFont(new Font("Verdana",3,30));
        motherElem = what;

        String[] liste_reporting = {"Moyennes par TD","Moyennes par matières","Moyennes par promo","Nombre d'élèves par promo","Nombre de profs par discipline"};
        menu = new JComboBox(liste_reporting);
        menu.setBounds(400,100,200,30);

        retour_menu = new JButton("Retour menu");
        retour_menu.setFont(defaultF);
        retour_menu.setBounds(5, 80, 180,40);
        // A CHANGER
        //retour_menu.addActionListener(new ReportingListener(this));

        accepter = new JButton("accepter");
        accepter.setFont(defaultF);
        accepter.setBounds(620,100,120,25);
        accepter.addActionListener(new ReportingListener(this));

        //ajouts des composants
        upPanel.add(nomFenetre);
        upPanel.add(retour_menu);
        upPanel.add(menu);
        upPanel.add(accepter);

        mainPanel.add(upPanel);
        mainPanel.add(graphicPanel);

        liste = new ArrayList<>();
    }

    public JPanel getGraphicPanel() {
        return graphicPanel;
    }

    public void choix()
    {
        Reporting r = new Reporting();

        if(menu.getSelectedItem().toString().equals("Moyennes par TD"))
        {
            histogramme(r.moyenne_par_td());
            categorie = "TD";
            donnee = "Moyennes";
        }
        else if(menu.getSelectedItem().toString().equals("Moyennes par matières"))
        {
            histogramme(r.moyenne_par_matiere());
            categorie = "Matières";
            donnee = "Moyennes";
        }
        else if(menu.getSelectedItem().toString().equals("Moyennes par promo"))
        {
            histogramme(r.moyenne_par_promo());
            categorie = "Promo";
            donnee = "Moyennes";
        }
        else if(menu.getSelectedItem().toString().equals("Nombre d'élèves par promo"))
        {
            camembert(r.repartition_eleve_par_promo());
            categorie = "Promo";
            donnee = "Nombre d'élèves";
        }
        else if(menu.getSelectedItem().toString().equals("Nombre de profs par discipline"))
        {
            camembert(r.repartition_prof_par_discipline());
            categorie = "Matières";
            donnee = "Nombre de profs";
        }
    }

    public void histogramme(Hashtable<Integer,Double> a)
    {
        System.out.println("histo");

        /**
         * **créa du dataset***
         */
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Set keys = a.keySet();
        Iterator it = keys.iterator();

        int key = 0;

        //on ajoute la hashtable dans une liste de string
        while (it.hasNext())
        {
            key = (int)it.next();

            System.out.println(a.get(key).toString());

            liste.add(a.get(key).toString());
        }

        /// LA LA DATASET EST PAS CORRECT, JE RECUPERE PAS LE BON TRUC ET CA FAIT UNE ERREUR

        for (int i = 0; i < liste.size(); i++) {
            String[] tab;
            tab = liste.get(i).split(",");
            dataset.addValue(Float.parseFloat(tab[0]), tab[1], tab[1]);
        }

         //créa de la chart
        chart = ChartFactory.createBarChart(
                "Nombre de " + donnee + " par " + categorie, // chart title
                donnee, // domain axis label
                categorie, // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
        );

        //  Couleur bordure
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.pink);
        //lignes
        plot.setRangeGridlinePaint(Color.black);

        //Couleur des barres
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.pink);
        renderer.setSeriesPaint(1, Color.pink);
        renderer.setSeriesPaint(2, Color.pink);
        renderer.setDrawBarOutline(false);
        renderer.setItemLabelsVisible(true);
        //couleur de fond
        plot.setBackgroundPaint(Color.gray);

        /**
         * **création et affichage d'un frame***
         */
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        frame.setVisible(true);
        graphicPanel.add(frame);



    }

    public void camembert(Hashtable<Integer,Integer> a)
    {
        System.out.println("cam");
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
        return null;
    }

}
