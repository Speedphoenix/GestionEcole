package com.speedphoenix.ActionListeners.SideMenu;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Display.Affclasses.*;
import com.speedphoenix.Modele.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Actionlistener pour le bouton de suppression du menu de gauche
 */
public class DeleteEntityListener implements ActionListener {

    protected JMother elem ;
    protected enum classesType{

        Inscription(JInscriptionAff.class.getCanonicalName()),
        bulletin(JBulletinsAff.class.getCanonicalName()),
        classe(JClasseAff.class.getCanonicalName()),
        enseignement(JEnseigmnementsAff.class.getCanonicalName()),
        niveau(JNiveauAff.class.getCanonicalName()),
        trimestre(JTrimestresAff.class.getCanonicalName()),
        discipline(JDisciplineAff.class.getCanonicalName()),
        eleve(JElevesAff.class.getCanonicalName()),
        enseignant(JEnseignantsAff.class.getCanonicalName()),
        evaluation(JEvaluationAff.class.getCanonicalName()),
        anneescol(JAnneeScolAff.class.getCanonicalName()),
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

    public DeleteEntityListener(JMother elem)
    {
        this.elem = elem;
    }

    /**
     * A la detection d'un évènement, on cherche le panneau d'ajout dont il provient et on effectue la requete sql adéquate
     * @param e non utilisé (ActionEvent)
     */
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
           if(classType.equals(classesType.Inscription.name))
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
               System.out.println("hihi"+eco.findAnneeScolaire(elem.getMotherElem().getId()));
               mot = new JTrimestresAff(eco.findAnneeScolaire(elem.getMotherElem().getId()));

           }
           else if(classType.equals(classesType.classe.name))
           {
               eco.findClasse((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               mot = new JClasseAff(eco);

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
           else if(classType.equals(classesType.discipline.name))
           {
               eco.findDiscipline((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               mot = new JDisciplineAff();

           }
           else if(classType.equals(classesType.enseignant.name))
           {
               eco.findEnseignant((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               mot = new JEnseignantsAff();
           }
           else if(classType.equals(classesType.eleve.name))
           {
               eco.findEleve((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               mot = new JElevesAff();
           }
           else if(classType.equals(classesType.evaluation.name))
           {
               eco.findEvaluation((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               mot = new JEvaluationAff(eco.findDetailBulletin(elem.getMotherElem().getId()));
           }
           else if(classType.equals(classesType.anneescol.name))
           {
               eco.findAnneeScolaire((int)elem.getListId().get(index)).createDeleteRequest(conn);
               conn.executeAllupdate();
               eco.refresh();
               mot = new JAnneeScolAff();
           }
           //on réaffiche correctement la liste
           GraphicContainer.getInstance().setContentPan(mot);
       }


    }
}
