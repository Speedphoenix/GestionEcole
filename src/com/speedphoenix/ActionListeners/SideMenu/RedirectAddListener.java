package com.speedphoenix.ActionListeners.SideMenu;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Display.ModClasses.*;
import com.speedphoenix.Modele.*;

import javax.swing.*;
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
            }
            else
            {
            }

        }
        else if(classType.equals(classesType.trimestre.name))
        {


        }
        else if(classType.equals(classesType.classe.name))
        {

        }
        else if(classType.equals(classesType.enseignement.name))
        {

            if(elem.getMotherElem().getClass() == Classe.class)
            {
                //mot = new JEnseigmnementsAff(eco.findClasse(elem.getMotherElem().getId()));
            }
            //else
                //mot = new JBulletinsAff(eco.findDiscipline(elem.getMotherElem().getId()));
        }
        else if(classType.equals(classesType.niveau.name))
        {


        }
        else if(classType.equals(classesType.discipline.name))
        {


        } else if(classType.equals(classesType.enseignant.name))
        {
            mot = new JEnseignantAdd();
        }
        else if(classType.equals(classesType.eleve.name))
        {
            mot = new JEleveAdd();
        }
        //on réaffiche correctement la liste
        GraphicContainer.createInstance(mot);

    }
}
