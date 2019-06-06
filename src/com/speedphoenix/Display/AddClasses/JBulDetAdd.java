package com.speedphoenix.Display.AddClasses;

import com.speedphoenix.Modele.*;

import javax.swing.*;

public class JBulDetAdd extends JMotherMod{

    private JPanel mainPanel;
    private JTextPane appreciation;
    private JComboBox <BaseElem> choiceBox;
    private JTextPane staticAncestorElement;

    private String staticElName;
    private String boxName;
    private String bufferTextAr;
    private String [] boxContent;

    private Class buffClass;

    //private Font defaultF = new Font("Verdana", 1,14);

    public JBulDetAdd(BaseElem what){
        /**/
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);

        appreciation = new JTextPane();
        appreciation.setName("Appreciation");
        appreciation.setText("");
        appreciation.setBounds(300, 600, 400, 200);
        appreciation.setBorder(BorderFactory.createTitledBorder("Entrez l'appreciation"));

        choiceBox = new JComboBox<>();

        staticAncestorElement = new JTextPane();
        staticAncestorElement.setBounds(300, 300, 400, 90);
        /**/

        bufferTextAr = new String("");

        buffClass=what.getClass();
        creation(what.getId());
    }

    public void creation(int id){

        if(buffClass== Bulletin.class){
            staticElName = new String("Bulletin");
            boxName = new String("Enseignement");
            bufferTextAr += "Prenom : " + Ecole.getInstance().getBulletins().get(id).getInscription().getEleve().getPrenom()+ "  Nom: "+
                    Ecole.getInstance().getBulletins().get(id).getInscription().getEleve().getNom()+"                                 " + "  Appreciation : " +
                    Ecole.getInstance().getBulletins().get(id).getAppreciation();

            boxContent= new String [Ecole.getInstance().getEnseignements().size()];
            int counter=0;

            for (Integer i : Ecole.getInstance().getEnseignements().keySet())
            {
                boxContent [counter] = "Discipline : " + Ecole.getInstance().getEnseignements().get(i).getDiscipline().getNom()+ "  Professeur: "+
                        Ecole.getInstance().getEnseignements().get(i).getEnseignant().getPrenom()+ " " +
                        Ecole.getInstance().getEnseignements().get(i).getEnseignant().getNom()
                        + "  Classe : " + Ecole.getInstance().getEnseignements().get(i).getClasse().getNom();

                counter++;
            }

        }
        else if (buffClass== Enseignement.class){
            staticElName = new String("Enseignement");
            boxName = new String("Bulletin");
            bufferTextAr += "Discipline : " + Ecole.getInstance().getEnseignements().get(id).getDiscipline().getNom()+ "  Professeur: "+
                    Ecole.getInstance().getEnseignements().get(id).getEnseignant().getPrenom()+ " " +
                    Ecole.getInstance().getEnseignements().get(id).getEnseignant().getNom()
                    + "  Classe : " + Ecole.getInstance().getEnseignements().get(id).getClasse().getNom();

            boxContent= new String [Ecole.getInstance().getBulletins().size()];
            int counter=0;

            for (Integer i : Ecole.getInstance().getBulletins().keySet())
            {
                boxContent [counter] = "Prenom : " + Ecole.getInstance().getBulletins().get(i).getInscription().getEleve().getPrenom()+ "  Nom: "+
                        Ecole.getInstance().getBulletins().get(i).getInscription().getEleve().getNom() + "  Appreciation : " +
                        Ecole.getInstance().getBulletins().get(i).getAppreciation();

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
