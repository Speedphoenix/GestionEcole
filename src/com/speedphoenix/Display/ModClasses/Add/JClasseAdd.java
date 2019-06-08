package com.speedphoenix.Display.ModClasses.Add;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.AddListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * JPanel qui propose de rentrer les informations pour ajouter un Classe
 */
public class JClasseAdd extends JMotherMod {

    private JPanel mainPanel;
    private JTextField nomDeClasse;
    private JComboBox <BaseElem> firstChoiceBox;
    private JComboBox <BaseElem> secondChoiceBox;
    private JTextPane staticAncestorElement;
    private JLabel nomFenetre;

    private JButton accept;

    private String buffName;
    private String firstBoxName;
    private String bufferTextAr;
    private String [] firstBoxContent;
    private String [] secondBoxContent;

    protected ArrayList<Integer> listIdFirstBox = new ArrayList<Integer>();
    protected ArrayList<Integer> listIdSecondBox = new ArrayList<Integer>();

    private BaseElem motherElem;

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
        nomDeClasse.setBounds(400, 450, 200, 40);
        nomDeClasse.setBorder(BorderFactory.createTitledBorder("Entrez le nom de la classe"));

        firstChoiceBox = new JComboBox<>();
        secondChoiceBox = new JComboBox<>();

        motherElem = what;


        bufferTextAr = new String("");

        buffClass=what.getClass();
        creation(what.getId());
    }
    /**
     * va initialiser les champs de recuperation des donnees necessaires pour creation de Detail Bulletin
     * et ensuite va ajoutes les elements necesaires sur le JPanel
     * On demande d'entrer: le nom de la classe
     * On offre a choisir: un niveau
     * @param id de BaseElement (Niveau), on ne peut pas le changer, si on cree la classe en ayant choisi le niveau avant; si non on a un JCombobox avec le choix des niveaux
     */
    private void creation(int id){
        int counter =0;

        buffName = new String("Niveau");
        //choice box de niveau ou text area de niveau choisi
        if(buffClass== Niveau.class){
            bufferTextAr = Ecole.getInstance().getNiveaux().get(id).getNom();
            staticAncestorElement = new JTextPane();
            staticAncestorElement.setBounds(400, 350, 200, 40);
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
                listIdSecondBox.add(Ecole.getInstance().findNiveau(i).getId());

                counter++;
            }
            secondChoiceBox = new JComboBox(secondBoxContent);
            secondChoiceBox.setBounds(400, 350, 200, 40);
            secondChoiceBox.setBorder(BorderFactory.createTitledBorder(buffName));

            mainPanel.add(secondChoiceBox);
        }

        //choice box de l'annee scolaire
        firstBoxContent= new String [Ecole.getInstance().getAnneeScolaires().size()];
        counter=0;
        for (Integer i : Ecole.getInstance().getAnneeScolaires().keySet())
        {
            int startYear = Ecole.getInstance().getAnneeScolaires().get(i).getStartYear();
            int endYear = Ecole.getInstance().getAnneeScolaires().get(i).getEndYear();
            int idYear = Ecole.getInstance().getAnneeScolaires().get(i).getId();
            if(startYear == 0 || endYear == 0)
            {
                firstBoxContent [counter] = "Année inconnue, Id : " +idYear ;
            }
            else
                firstBoxContent [counter] = "Debut : " + startYear+ "  Fin : "+ endYear;
            listIdFirstBox.add(Ecole.getInstance().findAnneeScolaire(i).getId());

            counter++;
        }
        firstBoxName = new String("Année scolaire");
        firstChoiceBox = new JComboBox(firstBoxContent);
        firstChoiceBox.setBounds(400, 300, 200, 40);
        firstChoiceBox.setBorder(BorderFactory.createTitledBorder(firstBoxName));

        accept = new JButton("Ajouter");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));

        nomFenetre = new JLabel("Ajout Classe");
        nomFenetre.setBounds(200, 10, 800,200);
        nomFenetre.setFont(new Font("Verdana",3,30));

        mainPanel.add(nomFenetre);
        mainPanel.add(firstChoiceBox);
        mainPanel.add(nomDeClasse);
        mainPanel.add(accept);
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }


    public JComboBox<BaseElem> getFirstChoiceBox() {
        return firstChoiceBox;
    }

    public JComboBox<BaseElem> getSecondChoiceBox() {
        return secondChoiceBox;
    }

    public JTextField getNomDeClasse() {
        return nomDeClasse;
    }

    public JTextPane getStaticAncestorElement() {
        return staticAncestorElement;
    }

    public BaseElem getMotherElem() {
        return motherElem;
    }

    public int getListIdFirstBox(int index) {
        return listIdFirstBox.get(index);
    }

    public int getListIdSecondBox(int index) {
        return listIdSecondBox.get(index);
    }

    @Override
    public String getType() {
        return "classe";
    }
}
