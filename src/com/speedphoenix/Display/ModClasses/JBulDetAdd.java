package com.speedphoenix.Display.ModClasses;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.AddListener;
import com.speedphoenix.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JBulDetAdd extends JMotherMod{

    private JPanel mainPanel;
    private JTextPane appreciation;
    private JComboBox <BaseElem> choiceBox;
    private JTextPane staticAncestorElement;

    private JButton accept;

    private String staticElName;
    private String boxName;
    private String bufferTextAr;
    private String [] boxContent;

    private Class buffClass;

    private Font defaultF = new Font("Verdana", 1,14);

    private BaseElem motherElem;

    protected ArrayList<Integer> listId = new ArrayList<Integer>();


    public JBulDetAdd(BaseElem what){
        /**/
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);

        appreciation = new JTextPane();
        appreciation.setName("Appreciation");
        appreciation.setText("");
        appreciation.setBounds(300, 600, 400, 220);
        appreciation.setBorder(BorderFactory.createTitledBorder("Entrez l'appreciation"));

        choiceBox = new JComboBox<>();

        motherElem = what;
        staticAncestorElement = new JTextPane();
        staticAncestorElement.setBounds(380, 300, 230, 70);

        /**/

        bufferTextAr = new String("");

        buffClass=what.getClass();
        creation(what.getId());
    }

    public void creation(int id){

        if(buffClass== Bulletin.class){
            staticElName = new String("Bulletin");
            boxName = new String("Enseignement");
            bufferTextAr += "                   "+Ecole.getInstance().getBulletins().get(id).getInscription().getEleve().getPrenom()+ " "+
                    Ecole.getInstance().getBulletins().get(id).getInscription().getEleve().getNom()+"\n Trimestre n°"+
                    Ecole.getInstance().getBulletins().get(id).getTrimestre().getNumero() + " de l'année "
                    + Ecole.getInstance().getBulletins().get(id).getTrimestre().getAnneeScolaire().getStartYear() + " à " +
                    Ecole.getInstance().getBulletins().get(id).getTrimestre().getAnneeScolaire().getEndYear();
            boxContent= new String [Ecole.getInstance().getEnseignements().size()];
            int counter=0;

            for (Integer i : Ecole.getInstance().getEnseignements().keySet())
            {
                boxContent [counter] = Ecole.getInstance().getEnseignements().get(i).getDiscipline().getNom()+ "  Professeur: "+
                        Ecole.getInstance().getEnseignements().get(i).getEnseignant().getPrenom()+ " " +
                        Ecole.getInstance().getEnseignements().get(i).getEnseignant().getNom()
                        + "  Classe : " + Ecole.getInstance().getEnseignements().get(i).getClasse().getNom();
                listId.add(Ecole.getInstance().findEnseignement(i).getId());

                counter++;
            }

        }
        else if (buffClass== Enseignement.class){
            staticElName = new String("Enseignement");
            boxName = new String("Bulletin");
            bufferTextAr +=  Ecole.getInstance().getEnseignements().get(id).getDiscipline().getNom()+ "\nProfesseur: "+
                    Ecole.getInstance().getEnseignements().get(id).getEnseignant().getPrenom()+ " " +
                    Ecole.getInstance().getEnseignements().get(id).getEnseignant().getNom()
                    + "\nClasse : " + Ecole.getInstance().getEnseignements().get(id).getClasse().getNom();

            boxContent= new String [Ecole.getInstance().getBulletins().size()];
            int counter=0;

            for (Integer i : Ecole.getInstance().getBulletins().keySet())
            {
                boxContent [counter] = "    Trimestre n°"+
                    Ecole.getInstance().getBulletins().get(id).getTrimestre().getNumero()+
                    "   Année "+Ecole.getInstance().getBulletins().get(id).getTrimestre().getAnneeScolaire().getStartYear() + "/" +
                    Ecole.getInstance().getBulletins().get(id).getTrimestre().getAnneeScolaire().getEndYear()
                    +"  "+Ecole.getInstance().getBulletins().get(i).getInscription().getEleve().getPrenom()+ " "+
                    Ecole.getInstance().getBulletins().get(i).getInscription().getEleve().getNom() ;;
                    listId.add(Ecole.getInstance().findBulletin(i).getId());

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
        if( buffClass== Enseignement.class)
            choiceBox.setBounds(325, 450, 350, 40);
        accept = new JButton("Ajouter");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new AddListener(this));

        mainPanel.add(staticAncestorElement);
        mainPanel.add(choiceBox);
        mainPanel.add(appreciation);
        mainPanel.add(accept);


    }


    public BaseElem getMotherElem() {
        return motherElem;
    }

    public int getListId(int index) {
        return listId.get(index);
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public String getType() {
        return "detBulletin";
    }

    public JTextPane getAppreciation() {
        return appreciation;
    }


    public JComboBox<BaseElem> getChoiceBox() {
        return choiceBox;
    }
}
