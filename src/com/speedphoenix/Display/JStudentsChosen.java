package com.speedphoenix.Display;

import com.speedphoenix.Modele.Inscription;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class JStudentsChosen {

    JPanel mainPanel;
    JList<String> studentList;
    DefaultListModel <String> listModel;
    TreeMap<Integer, Inscription> students;
    //String student;
    Font defaultF = new Font("Verdana", 1,20);

    public JStudentsChosen(int id, int clasORniv, TreeMap<Integer, Inscription> students) {//clasOrniv =1 si on cherche selon TD et = 2 si on cherche selon niveau
        mainPanel = new JPanel();
        mainPanel.setBounds(200,100,800,900);
        listModel = new DefaultListModel<>();
        //studentList = new JList<String>();
        //student = new String();
        this.students=students;
        this.creation(clasORniv, id);

    }

    private void creation(int clasORniv, int id){
        switch (clasORniv){
            case 1:
                for(Integer i: students.keySet())
                {
                    if(students.get(i).getClasse().getId()==id)
                    {
                        addStringToListModel(i);
                    }
                }
                break;
            case 2:
                for(Integer i: students.keySet())
                {
                    if(students.get(i).getClasse().getNiveau().getId()==id)
                    {
                        addStringToListModel(i);
                    }
                }
                break;
        }
        studentList = new JList<>(listModel);
        studentList.setFont(defaultF);
        //mainPanel.add(studentList);
        mainPanel.add(new JScrollPane(studentList));
        mainPanel.setBackground(Color.darkGray);
    }

    public void addStringToListModel(Integer i){
        String student = new String("");
        student+= "  Nom: "+ students.get(i).getEleve().getNom();
        student+= "  Prenom: "+ students.get(i).getEleve().getPrenom();
        student+= "  ID: "+ students.get(i).getEleve().getId();
        student+= "  Classe: "+ students.get(i).getClasse().getNom();
        student+= "  Niveau: "+ students.get(i).getClasse().getNiveau().getNom();

        listModel.addElement(student);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
