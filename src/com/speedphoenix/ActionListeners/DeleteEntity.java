package com.speedphoenix.ActionListeners;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Modele.Ecole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
       Ecole eco = Ecole.getInstance();


        if (index > elem.getMainList().getMaxSelectionIndex())
           System.err.println("erreur index trop élevé");
       else{
           Connexion conn = Connexion.conn;
           String classType =  elem.getClass().getCanonicalName();
           JMother mot = null;


           if(classType.equals(classesType.eleve.name))
           {
               eco.findInscription((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               mot = new JElevesAff(eco.findClasse(elem.getMotherElem().getId()));

           }
           else if(classType.equals(classesType.bulletin.name))
           {
               eco.findBulletin((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               mot = new JBulletinsAff(eco.findBulletin(elem.getMotherElem().getId()));

           }
           else if(classType.equals(classesType.trimestre.name))
           {
               eco.findTrimestre((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();

           }
           else if(classType.equals(classesType.classe.name))
           {
               eco.findClasse((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();

           }
           else if(classType.equals(classesType.enseignement.name))
           {
               eco.findEnseignement((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
           }
           else if(classType.equals(classesType.niveau.name))
           {
               // eco.findNiveau((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
           }

           GraphicContainer.getInstance().setContentPan(mot);




       }


    }
}
