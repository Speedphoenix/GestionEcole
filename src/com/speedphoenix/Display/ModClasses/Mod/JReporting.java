package com.speedphoenix.Display.ModClasses.Mod;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.ModListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.BaseElem;
import com.speedphoenix.ActionListeners.AddOrModifyPanel.ReportingListener;
import com.speedphoenix.ActionListeners.UpMenu.RetourListener;
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
        retour_menu.addActionListener(new RetourListener(this));

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

    public void setCategorie(String a)
    {
        this.categorie = a;
    }

    public void setDonnee(String a)
    {
        this.donnee = a;
    }

    public String getCategorie(){
        return categorie;
    }

    public String getDonnee(){
        return donnee;
    }

    public void choix()
    {
        Reporting r = new Reporting();

        if(menu.getSelectedItem().toString().equals("Moyennes par TD"))
        {
            setCategorie("TD");
            setDonnee("Moyennes");
            histogramme(r.moyenne_par_td(),1);
        }
        else if(menu.getSelectedItem().toString().equals("Moyennes par matières"))
        {
            setCategorie("Matières");
            setDonnee("Moyennes");
            histogramme(r.moyenne_par_matiere(),2);
        }
        else if(menu.getSelectedItem().toString().equals("Moyennes par promo"))
        {
            setCategorie("Promo");
            setDonnee("Moyennes");
            histogramme(r.moyenne_par_promo(),3);
        }
        else if(menu.getSelectedItem().toString().equals("Nombre d'élèves par promo"))
        {
            setCategorie("Promo");
            setDonnee("Nombre d'élèves");
            camembert(r.repartition_eleve_par_promo(),1);
        }
        else if(menu.getSelectedItem().toString().equals("Nombre de profs par discipline"))
        {
            setCategorie("Matières");
            setDonnee("Nombre de profs");
            camembert(r.repartition_prof_par_discipline(),2);
        }
    }

    public void histogramme(Hashtable<Integer,Double> a, int c)
    {
        Ecole sc = Ecole.getInstance();

        System.out.println("histo");

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Set keys = a.keySet();
        Iterator it = keys.iterator();

        int key = 0;

        //ajout dans la dataset
        while (it.hasNext())
        {
            key = (int)it.next();

            if(c == 1)
            {
                dataset.addValue((Number)a.get(key),1, sc.findClasse(key).getNom() );
            }
            else if(c == 2)
            {
                dataset.addValue((Number)a.get(key),1, sc.findDiscipline(key).getNom() );
            }
            else if(c == 3)
            {
                dataset.addValue((Number)a.get(key),1, sc.findNiveau(key).getNom() );
            }
        }

         //créa de la chart
        chart = ChartFactory.createBarChart(
                getDonnee() + " par " + getCategorie(), // chart title
                getDonnee(), // domain axis label
                getCategorie(), // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
        );

        //  Couleur bordure
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.yellow);
        //lignes
        plot.setRangeGridlinePaint(Color.black);

        //Couleur des barres
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.yellow);
        renderer.setSeriesPaint(1, Color.yellow);
        renderer.setSeriesPaint(2, Color.yellow);
        renderer.setDrawBarOutline(false);
        //couleur de fond
        plot.setBackgroundPaint(Color.gray);

        /**
         * **création et affichage d'un frame***
         */
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        frame.setVisible(true);
        //graphicPanel.add(frame);



    }

    public void camembert(Hashtable<Integer,Integer> a, int c)
    {

        Ecole sc = Ecole.getInstance();

        DefaultPieDataset dataset_2 = new DefaultPieDataset();

        Set keys = a.keySet();
        Iterator it = keys.iterator();

        int key = 0;

        //ajout dans la dataset
        while (it.hasNext())
        {
            key = (int)it.next();

            if(c == 1)
            {
                dataset_2.setValue(sc.findNiveau(key).getNom(),a.get(key));
            }
            else if(c == 2)
            {
                dataset_2.setValue(sc.findDiscipline(key).getNom(),a.get(key));
            }

        }

        /**
         * **création d'un char***
         */
        chart = ChartFactory.createPieChart(
                getDonnee() + " par " + getCategorie(), // chart title
                dataset_2, // data
                false, // include legend
                true, // tooltips
                false // URLs
        );

        //Couleur bordure
        chart.setBackgroundPaint(Color.white);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setSectionOutlinesVisible(false);

        plot.setSectionPaint(0, Color.YELLOW);
        plot.setSectionPaint(1, Color.GRAY);
        plot.setSectionPaint(2, Color.BLACK);

        //label des parties de la pie chart
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1} ({2})"));

        /**
         * **création et affichage d'un frame***
         */
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        frame.setVisible(true);

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
