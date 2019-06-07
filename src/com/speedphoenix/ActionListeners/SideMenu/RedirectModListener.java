package com.speedphoenix.ActionListeners.SideMenu;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Display.Affclasses.*;
import com.speedphoenix.Display.ModClasses.*;
import com.speedphoenix.Display.ModClasses.Mod.*;
import com.speedphoenix.Modele.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedirectModListener implements ActionListener {

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

    public RedirectModListener(JMother elem) {
        this.elem = elem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int index = elem.getMainTable().getTable().getSelectedRow();
        Ecole eco = Ecole.getInstance();
        Connexion conn = Connexion.conn;
        String classType =  elem.getClass().getCanonicalName();
        JMotherMod mot = null;
        //on détecte le type d'objet a effacer, on l'efface puis on met a jour la bdd et la DAO
        if(classType.equals(classesType.bulletin.name))
        {
                Bulletin baseElem = eco.findBulletin((int)elem.getListId().get(index));
                mot = new JBulletinMod(baseElem);
        }
        else if(classType.equals(classesType.detBulletin.name))
        {
            DetailBulletin baseElem = eco.findDetailBulletin((int)elem.getListId().get(index));
            mot = new JBulDetMod(baseElem);

        }
        else if(classType.equals(classesType.trimestre.name))
        {
            Trimestre baseElem = eco.findTrimestre((int)elem.getListId().get(index));
            mot = new JTrimestreMod(baseElem);
        }
        else if(classType.equals(classesType.classe.name))
        {
            Classe baseElem = eco.findClasse((int)elem.getListId().get(index));
            mot = new JClasseMod(baseElem);
        }
        else if(classType.equals(classesType.niveau.name))
        {
            Niveau baseElem = eco.findNiveau((int)elem.getListId().get(index));
            mot = new JNiveauMod(baseElem);

        }
        else if(classType.equals(classesType.discipline.name))
        {
            Discipline baseElem = eco.findDiscipline((int)elem.getListId().get(index));
            mot = new JDisciplineMod(baseElem);

        }
        else if(classType.equals(classesType.enseignant.name))
        {
            Enseignant baseElem = eco.findEnseignant((int)elem.getListId().get(index));
            mot = new JEnseignantMod(baseElem);
        }
        else if(classType.equals(classesType.eleve.name))
        {
            Eleve baseElem = eco.findEleve((int)elem.getListId().get(index));
            mot = new JEleveMod(baseElem);
        }
        else if(classType.equals(classesType.evaluation.name))
        {

            Evaluation baseElem = eco.findEvaluation((int)elem.getListId().get(index));
            mot = new JEvaluationMod(baseElem);
        }

        //on réaffiche correctement la liste
        if(mot != null)
            GraphicContainer.createInstance(mot);

    }
}
