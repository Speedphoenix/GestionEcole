package com.speedphoenix.ActionListeners;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Modele.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  DeleteEntity implements ActionListener {

    protected JMother elem ;
    protected enum classesType{

        eleve(JInscriptionAff.class.getCanonicalName()),
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
       int index = elem.getMainTable().getTable().getSelectedRow();
       Ecole eco = Ecole.getInstance();


        if (index > elem.getMainTable().getTable().getMaximumSize().getHeight())
           System.err.println("erreur index trop élevé");
       else{
           Connexion conn = Connexion.conn;
           String classType =  elem.getClass().getCanonicalName();
           JMother mot = null;

           //on détecte le type d'objet a effacer, on l'efface puis on met a jour la bdd et la DAO
           if(classType.equals(classesType.eleve.name))
           {
               eco.findInscription((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               mot = new JInscriptionAff(eco.findClasse(elem.getMotherElem().getId()));

           }
           else if(classType.equals(classesType.bulletin.name))
           {
               eco.findBulletin((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               if(elem.getMotherElem().getClass() == Trimestre.class)
               {
                   mot = new JBulletinsAff(eco.findTrimestre(elem.getMotherElem().getId()));
               }
               else
                   mot = new JBulletinsAff(eco.findInscription(elem.getMotherElem().getId()));

           }
           else if(classType.equals(classesType.detBulletin.name))
           {
               eco.findDetailBulletin((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               if(elem.getMotherElem().getClass() == Enseignement.class)
               {
                   mot = new JBulletinsAff(eco.findEnseignement(elem.getMotherElem().getId()));
               }
               else
               {
                   mot = new JBulDetAff(eco.findBulletin(elem.getMotherElem().getId()));
               }

           }
           else if(classType.equals(classesType.trimestre.name))
           {
               eco.findTrimestre((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               mot = new JTrimestresAff();

           }
           else if(classType.equals(classesType.classe.name))
           {
               eco.findClasse((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               mot = new JClasseAff(eco.findNiveau(elem.getMotherElem().getId()));

           }
           else if(classType.equals(classesType.enseignement.name))
           {
               eco.findEnseignement((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               if(elem.getMotherElem().getClass() == Classe.class)
               {
                   mot = new JEnseigmnementsAff(eco.findClasse(elem.getMotherElem().getId()));
               }
               else
                   mot = new JBulletinsAff(eco.findDiscipline(elem.getMotherElem().getId()));
           }
           else if(classType.equals(classesType.niveau.name))
           {
                eco.findNiveau((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               mot = new JNiveauAff();

           }
           //on réaffiche correctement la liste
           GraphicContainer.getInstance().setContentPan(mot);
       }


    }
}
