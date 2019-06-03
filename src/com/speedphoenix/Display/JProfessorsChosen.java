package com.speedphoenix.Display;

import com.speedphoenix.Modele.Enseignement;


import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JProfessorsChosen {
    JPanel mainPanel;
    JList<String> profList;
    DefaultListModel <String> listModel;
    TreeMap<Integer, Enseignement> professors;
    Font defaultF = new Font("Verdana", 1,17);

    public JProfessorsChosen(int id, TreeMap<Integer, Enseignement> professors) {
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        listModel = new DefaultListModel<>();
        this.professors=professors;
        this.creation(id);
    }

    private void creation( int id){

                for(Integer i: professors.keySet())
                {
                    if(professors.get(i).getDiscipline().getId()==id)
                    {
                        addStringToListModel(i);
                    }
                }

        profList = new JList<>(listModel);
        profList.setFont(defaultF);
        //mainPanel.add(studentList);
        mainPanel.add(new JScrollPane(profList));
        mainPanel.setBackground(Color.darkGray);
    }

    public void addStringToListModel(Integer i){
        String professor = new String("");
        professor+= "  Nom: "+ professors.get(i).getEnseignant().getNom();
        professor+= "  Prenom: "+ professors.get(i).getEnseignant().getPrenom();
        professor+= "  ID: "+ professors.get(i).getEnseignant().getId();
        professor+= "  Classe: "+ professors.get(i).getClasse().getNom();
        professor+= "  Discipline: "+ professors.get(i).getDiscipline().getNom();

        listModel.addElement(professor);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
