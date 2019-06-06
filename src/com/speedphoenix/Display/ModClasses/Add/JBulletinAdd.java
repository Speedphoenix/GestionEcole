package com.speedphoenix.Display.ModClasses.Add;

import javax.swing.*;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.AddListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.*;

import java.awt.*;
import java.util.ArrayList;

public class JBulletinAdd extends JMotherMod {

    private JPanel mainPanel;
    private JTextPane appreciation;
    private JComboBox <BaseElem> choiceBox;
    private JTextPane staticAncestorElement;

    private String staticElName;
    private String boxName;
    private String bufferTextAr;
    private String [] boxContent;
    private BaseElem motherElem;
    protected ArrayList<Integer> listId = new ArrayList<Integer>();
    private Class buffClass;
    private JButton accept;

    private Font defaultF = new Font("Verdana", 1,14);

    public JBulletinAdd(BaseElem what){
        /**/
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);

        accept = new JButton("Ajouter");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));

        appreciation = new JTextPane();
        appreciation.setName("Appreciation");
        appreciation.setText("");
        appreciation.setBounds(300, 600, 400, 200);
        appreciation.setBorder(BorderFactory.createTitledBorder("Entrez l'appreciation"));

        choiceBox = new JComboBox<>();

        staticAncestorElement = new JTextPane();
        staticAncestorElement.setBounds(300, 300, 400, 70);

        motherElem = what;
        bufferTextAr = new String("");

        buffClass=what.getClass();
        creation(what.getId());
    }

    public void creation(int id){

        if(buffClass==Trimestre.class){
            staticElName = new String("Trimestre");
            boxName = new String("Inscription");
            bufferTextAr += "Numero : " + Ecole.getInstance().getTrimestres().get(id).getNumero()+ "  Debut: "+
                    Ecole.getInstance().getTrimestres().get(id).getDebut() + "  Fin : " +
                    Ecole.getInstance().getTrimestres().get(id).getFin();

            boxContent= new String [Ecole.getInstance().getInscriptions().size()];
            int counter=0;

            for (Integer i : Ecole.getInstance().getInscriptions().keySet())
            {
                boxContent [counter] =  Ecole.getInstance().getInscriptions().get(i).getEleve().getPrenom()+" "+
                        Ecole.getInstance().getInscriptions().get(i).getEleve().getNom() + "  Classe : " +
                        Ecole.getInstance().getInscriptions().get(i).getClasse().getNom() + "  Nv : " +
                        Ecole.getInstance().getInscriptions().get(i).getClasse().getNiveau().getNom();
                        listId.add(Ecole.getInstance().getInscriptions().get(i).getId());
                counter++;
            }

        }
        else if (buffClass==Inscription.class){
            staticElName = new String("Inscription");
            boxName = new String("Trimestre");
            bufferTextAr += Ecole.getInstance().getInscriptions().get(id).getEleve().getPrenom()+" "+
                    Ecole.getInstance().getInscriptions().get(id).getEleve().getNom() + "  Classe : " +
                    Ecole.getInstance().getInscriptions().get(id).getClasse().getNom() + "  Nv : " +
                    Ecole.getInstance().getInscriptions().get(id).getClasse().getNiveau().getNom();


            boxContent= new String [Ecole.getInstance().getTrimestres().size()];
            int counter=0;

            for (Integer i : Ecole.getInstance().getTrimestres().keySet())
            {
                boxContent [counter] = "  Debut: "+
                        Ecole.getInstance().getTrimestres().get(i).getDebut() + "  Fin : " +
                        Ecole.getInstance().getTrimestres().get(i).getFin();
                        listId.add(Ecole.getInstance().getTrimestres().get(i).getId());


                counter++;
            }
        }

        staticAncestorElement.setName(staticElName);
        staticAncestorElement.setText(bufferTextAr);
        staticAncestorElement.setEditable(false);
        staticAncestorElement.setBorder(BorderFactory.createTitledBorder(staticElName));

        choiceBox = new JComboBox(boxContent);
        choiceBox.setBounds(300, 450, 400, 40);
        choiceBox.setBorder(BorderFactory.createTitledBorder(boxName));


        mainPanel.add(staticAncestorElement);
        mainPanel.add(choiceBox);
        mainPanel.add(appreciation);
        mainPanel.add(accept);


    }

    public BaseElem getMotherElem() {
        return motherElem;
   }

    public JTextPane getAppreciation() {
        return appreciation;
    }

    public JComboBox<BaseElem> getChoiceBox() {
        return choiceBox;
    }

    public int getListId(int index) {
        return listId.get(index);
    }
    public  String getType(){
        return "bulletin";

    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

}
