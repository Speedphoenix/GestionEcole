package com.speedphoenix.ActionListeners.ContentPanel;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Display.Affclasses.*;
import com.speedphoenix.Modele.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe détectant le double click sur un élément du tableau et redirigeant vers l'objet cliqué
 */
public class ChangeObjectListener implements MouseListener {

    protected JMother elem ;
    protected enum classesType{

        inscription(JInscriptionAff.class.getCanonicalName()),
        bulletin(JBulletinsAff.class.getCanonicalName()),
        classe(JClasseAff.class.getCanonicalName()),
        enseignement(JEnseigmnementsAff.class.getCanonicalName()),
        niveau(JNiveauAff.class.getCanonicalName()),
        trimestre(JTrimestresAff.class.getCanonicalName()),
        discipline(JDisciplineAff.class.getCanonicalName()),
        anneeScol(JAnneeScolAff.class.getCanonicalName()),
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

    public ChangeObjectListener(JMother elem) {
        this.elem = elem;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 2) {
            Connexion conn = Connexion.conn;
            String classType =  elem.getClass().getCanonicalName();
            Ecole eco = Ecole.getInstance();
            JMother mot = null;
            int index = elem.getMainTable().getTable().getSelectedRow();


            //on détecte le type d'objet a effacer, on l'efface puis on met a jour la bdd et la DAO
             if(classType.equals(classesType.bulletin.name))
            {
                mot = new JBulDetAff(eco.findBulletin((int)elem.getListId().get(index)));
            }
            else if(classType.equals(classesType.detBulletin.name))
            {
                mot = new JEvaluationAff(eco.findDetailBulletin((int)elem.getListId().get(index)));
            }
            else if(classType.equals(classesType.trimestre.name)) {
                 mot = new JBulletinsAff(eco.findTrimestre((int) elem.getListId().get(index)));
             }
            else if(classType.equals(classesType.niveau.name))
            {
                mot = new JClasseAff(eco.findNiveau((int)elem.getListId().get(index)));
            }
            else if(classType.equals(classesType.discipline.name))
             {
                 mot = new JEnseigmnementsAff(eco.findDiscipline((int)elem.getListId().get(index)));
             }
            else if(classType.equals(classesType.inscription.name))
             {
                 mot = new JBulletinsAff(eco.findInscription((int)elem.getListId().get(index)));
             }
             else if(classType.equals(classesType.anneeScol.name))
             {
                 mot = new JTrimestresAff(eco.findAnneeScolaire((int)elem.getListId().get(index)));
             }
            //on réaffiche correctement la liste
            if (mot != null)
                GraphicContainer.getInstance().setContentPan(mot);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}



