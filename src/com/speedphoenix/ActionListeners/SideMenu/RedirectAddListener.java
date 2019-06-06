package com.speedphoenix.ActionListeners.SideMenu;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Display.Affclasses.*;
import com.speedphoenix.Display.ModClasses.*;
import com.speedphoenix.Display.ModClasses.Add.*;
import com.speedphoenix.Modele.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedirectAddListener implements ActionListener {

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

    public RedirectAddListener(JMother elem) {
        this.elem = elem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Ecole eco = Ecole.getInstance();
        Connexion conn = Connexion.conn;
        String classType =  elem.getClass().getCanonicalName();
        JMotherMod mot = null;

        //on détecte le type d'objet a effacer, on l'efface puis on met a jour la bdd et la DAO
        if(classType.equals(classesType.Inscription.name))
        {
            Classe baseElem = eco.findClasse((int)elem.getMotherElem().getId());
            mot = new JInscriptionAdd(baseElem);
        }
        else if(classType.equals(classesType.bulletin.name))
        {
            if(elem.getMotherElem().getClass() == Trimestre.class)
            {
                Trimestre baseElem = eco.findTrimestre((int)elem.getMotherElem().getId());
                mot = new JBulletinAdd(baseElem);
            }
            else if(elem.getMotherElem().getClass() == Inscription.class)
            {
                Inscription baseElem = eco.findInscription((int)elem.getMotherElem().getId());
                mot = new JBulletinAdd(baseElem);
            }

        }
        else if(classType.equals(classesType.detBulletin.name))
        {
            if(elem.getMotherElem().getClass() == Enseignement.class)
            {
                Enseignement baseElem = eco.findEnseignement((int)elem.getMotherElem().getId());
                mot = new JBulDetAdd(baseElem);
            }
            else
            {
                Bulletin baseElem = eco.findBulletin((int)elem.getMotherElem().getId());
                mot = new JBulDetAdd(baseElem);
            }

        }
        else if(classType.equals(classesType.trimestre.name))
        {
            AnneeScolaire baseElem = eco.findAnneeScolaire((int)elem.getMotherElem().getId());
            mot = new JTrimestreAdd(baseElem);

        }
        else if(classType.equals(classesType.classe.name))
        {
            if(elem.getMotherElem().getClass() == Niveau.class)
            {
                Niveau baseElem = eco.findNiveau((int)elem.getMotherElem().getId());
                mot = new JClasseAdd(baseElem);
            }
            else
            {
                mot = new JClasseAdd(eco);
            }
        }
        else if(classType.equals(classesType.enseignement.name))
        {

            if(elem.getMotherElem().getClass() == Classe.class)
            {
                Classe baseElem = eco.findClasse((int)elem.getMotherElem().getId());
                mot = new JEnseignementAdd(baseElem);
            }
            else
            {
                Discipline baseElem = eco.findDiscipline((int)elem.getMotherElem().getId());
                mot = new JEnseignementAdd(baseElem);
            }

        }
        else if(classType.equals(classesType.niveau.name))
        {


        }else if(classType.equals(classesType.anneeScol.name))
        {


        }
        else if(classType.equals(classesType.discipline.name))
        {
            mot = new JDisciplineAdd();

        } else if(classType.equals(classesType.enseignant.name))
        {
            mot = new JEnseignantAdd();
        }
        else if(classType.equals(classesType.eleve.name))
        {
            mot = new JEleveAdd();
        }
        else if(classType.equals(classesType.evaluation.name))
        {
            DetailBulletin baseElem = eco.findDetailBulletin((int)elem.getMotherElem().getId());
            mot = new JEvaluationAdd(baseElem);
        }
        //on réaffiche correctement la liste
        if( mot != null)
            GraphicContainer.createInstance(mot);

    }
}
