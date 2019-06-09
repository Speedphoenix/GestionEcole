package com.speedphoenix.ActionListeners.AddOrModifyPanel;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.GraphicContainer;
import com.speedphoenix.Display.Affclasses.JClasseAff;
import com.speedphoenix.Display.Affclasses.JRightNavPanel;
import com.speedphoenix.Display.Affclasses.JUpNavBar;
import com.speedphoenix.Display.ModClasses.*;
import com.speedphoenix.Display.ModClasses.Add.JNiveauAdd;
import com.speedphoenix.Display.ModClasses.Add.JTrimestreAdd;
import com.speedphoenix.Display.ModClasses.Mod.*;
import com.speedphoenix.Modele.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
/**
 * Actionlistener pour un bouton de modification d'une classe JMotherMod
 */
public class ModListener implements ActionListener {

    protected JMotherMod elem ;

    public ModListener(JMotherMod elem) {
        this.elem = elem;
    }

    private enum typePannel{
        eleve("eleve"),
        enseignant("enseignant"),
        detBulletin("detBulletin"),
        evaluation("evaluation"),
        classe("classe"),
        discipline("discipline"),
        niveau("niveau"),
        bulletin("bulletin"),
        inscription("inscription"),
        trimestre("trimestre"),
        enseignement("enseignement");

        private String type = "";

        //Constructeur
        typePannel(String name){
            this.type = name;
        }
        //Constructeur
        typePannel(){
            this.type = "classesType";
        }

        public String toString(){
            return type;
        }
    }
    /**
     * A la detection d'un évènement, on cherche le panneau de modfication dont il provient et on effectue la requete sql adéquate
     * @param e non utilisé (ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Connexion conn = Connexion.conn;
        Ecole eco = Ecole.getInstance();

        if(elem.getType().equals(typePannel.eleve.type))
        {
            JEleveMod trueObject = (JEleveMod) elem;
            Eleve motElem = (Eleve) trueObject.getMotherElem();
            String surName = trueObject.getTextSurname().getText() ;
            String name = trueObject.getTextName().getText() ;
            if(surName.equals(""))
                surName = motElem.getNom();
            if(name.equals(""))
                name = motElem.getPrenom();
            motElem.createUpdateRequest(surName,name,conn);


        }
        else if(elem.getType().equals(typePannel.enseignant.type))
        {

            JEnseignantMod trueObject = (JEnseignantMod) elem;
            Enseignant motElem = (Enseignant) trueObject.getMotherElem();

            String surName = trueObject.getTextSurname().getText() ;
            String name = trueObject.getTextName().getText() ;
            if(surName.equals(""))
                surName = motElem.getNom();
            if(name.equals(""))
                name = motElem.getPrenom();
            motElem.createUpdateRequest(surName,name,conn);

        }
        else if(elem.getType().equals(typePannel.evaluation.type))
        {

            JEvaluationMod trueObject = (JEvaluationMod) elem;
            Evaluation motElem = (Evaluation) trueObject.getMotherElem();
            Double note;
            String appreciation = trueObject.getAppreciation().getText() ;
            try{
                 note = Double.parseDouble(trueObject.getNote().getText());

            }catch(NumberFormatException error ){
                 note = motElem.getNote();
            }

            if(appreciation.equals(""))
                appreciation = motElem.getAppreciation();
            motElem.createUpdateRequest(appreciation,note,conn);
        }
        else if(elem.getType().equals(typePannel.detBulletin.type))
        {
            JBulDetMod trueObject = (JBulDetMod) elem;
            DetailBulletin motElem = (DetailBulletin) trueObject.getMotherElem();
            String appreciation = trueObject.getAppreciation().getText() ;

            if(appreciation.equals(""))
                appreciation = motElem.getAppreciation();
            motElem.createUpdateRequest(appreciation,conn);
        }
        else if(elem.getType().equals(typePannel.classe.type))
        {
            JClasseMod trueObject = (JClasseMod) elem;
            Classe motElem = (Classe) trueObject.getMotherElem();
            String name = trueObject.getTextName().getText() ;

            if(name.equals(""))
                name = motElem.getNom();
            motElem.createUpdateRequest(name,conn);
        }
        else if(elem.getType().equals(typePannel.niveau.type))
        {

            JNiveauMod trueObject = (JNiveauMod) elem;
            Niveau motElem = (Niveau) trueObject.getMotherElem();
            String name = trueObject.getTextName().getText() ;

            if(name.equals(""))
                name = motElem.getNom();
            motElem.createUpdateRequest(name,conn);
        }
        else if(elem.getType().equals(typePannel.bulletin.type))
        {
            JBulletinMod trueObject = (JBulletinMod) elem;
            Bulletin motElem = (Bulletin) trueObject.getMotherElem();
            String appreciation = trueObject.getAppreciation().getText() ;
            if(appreciation.equals(""))
                appreciation = motElem.getAppreciation();

            motElem.createUpdateRequest(appreciation,conn);
        }
        else if(elem.getType().equals(typePannel.trimestre.type))
        {
            JTrimestreMod trueObject = (JTrimestreMod) elem;
            Trimestre motElem = (Trimestre) trueObject.getMotherElem();
            String dateStartYear = trueObject.getStartYearPanel().getJFormattedTextField().getText();
            String dateEndYear = trueObject.getEndYearPanel().getJFormattedTextField().getText();
            LocalDate startYear;
            LocalDate endYear;
            try{
                int numero = Integer.parseInt( trueObject.getNumeroTextArea().getText()) ;
                if (!dateEndYear.equals(""))
                     endYear = Trimestre.changeInLocaldate(dateEndYear);
                else
                    endYear = motElem.getFin();

                if (!dateStartYear.equals("")) {
                    startYear = Trimestre.changeInLocaldate(dateStartYear);
                }else
                    startYear = motElem.getDebut();

                motElem.createUpdateRequest(numero,startYear,endYear,conn);


            }catch(NumberFormatException error){}

        conn.executeAllupdate();
        Ecole.getInstance().refresh();
        GraphicContainer.createInstance(new JRightNavPanel(),new JUpNavBar(),new JClasseAff(eco));

    }
        else if(elem.getType().equals(typePannel.discipline.type))
        {
            JDisciplineMod trueObject = (JDisciplineMod) elem;
            Discipline motElem = (Discipline) trueObject.getMotherElem();
            String name = trueObject.getTextName().getText() ;

            if(name.equals(""))
                name = motElem.getNom();
            motElem.createUpdateRequest(name,conn);

        }

        conn.executeAllupdate();
        Ecole.getInstance().refresh();
        GraphicContainer.createInstance(new JRightNavPanel(),new JUpNavBar(),new JClasseAff(eco));
}
}
