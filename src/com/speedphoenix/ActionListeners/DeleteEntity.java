package com.speedphoenix.ActionListeners;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Modele.Bulletin;
import com.speedphoenix.Modele.Ecole;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class  DeleteEntity implements ActionListener {

    protected JMother elem ;
    protected enum classesType{

        eleve(JElevesAff.class.getCanonicalName()),
        bulletin(JBulletinsAff.class.getCanonicalName()),
        classe(JClasseAff.class.getCanonicalName()),
        enseignement(JEnseigmnementsAff.class.getCanonicalName()),
        niveau(JNiveauAff.class.getCanonicalName()),
        trimestre(JTrimestresAff.class.getCanonicalName()),
        detBulletin(JBulDetAff.class.getCanonicalName());

        private String name = "";

        //Constructeur
        classesType(String name){
            this.name = name;
        }
        //Constructeur
        classesType(){
            this.name = "classesType";
        }

        public String toString(){
            return name;
        }

    }

    public DeleteEntity(JMother elem)
    {
        this.elem = elem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       int index = elem.getMainList().getSelectedIndex();
       Connexion conn = Connexion.conn;
       String classType =  elem.getClass().getCanonicalName();
       System.out.println(elem.getClass().getCanonicalName());
       System.out.println(elem.getListId().get(index));

        if(classType.equals(classesType.eleve.name))
        {
            Ecole.getInstance().findInscription((int)elem.getListId().get(index)).createDeleteRequest(conn);
        }
        else if(classType.equals(classesType.bulletin.name))
        {
            Ecole.getInstance().findBulletin((int)elem.getListId().get(index)).createDeleteRequest(conn);
        }
        else if(classType.equals(classesType.trimestre.name))
        {
            Ecole.getInstance().findTrimestre((int)elem.getListId().get(index)).createDeleteRequest(conn);
        }
        else if(classType.equals(classesType.classe.name))
        {
            Ecole.getInstance().findClasse((int)elem.getListId().get(index)).createDeleteRequest(conn);
        }
        else if(classType.equals(classesType.enseignement.name))
        {
            Ecole.getInstance().findEnseignement((int)elem.getListId().get(index)).createDeleteRequest(conn);
        }
        else if(classType.equals(classesType.niveau.name))
        {
            Ecole.getInstance().findNiveau((int)elem.getListId().get(index)).createDeleteRequest(conn);
        }

        conn.executeAllupdate();
        Ecole.getInstance().refresh();





    }
}
