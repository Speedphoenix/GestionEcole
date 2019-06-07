package com.speedphoenix.ActionListeners.AddOrModifyPanel;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Display.Affclasses.JClasseAff;
import com.speedphoenix.Display.Affclasses.JRightNavPanel;
import com.speedphoenix.Display.Affclasses.JUpNavBar;
import com.speedphoenix.Display.ModClasses.*;
import com.speedphoenix.Display.ModClasses.Add.*;
import com.speedphoenix.Modele.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AddListener implements ActionListener {

    protected JMotherMod elem ;

    public AddListener(JMotherMod elem) {
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
    @Override
    public void actionPerformed(ActionEvent e) {
        Connexion conn = Connexion.conn;
        Ecole eco = Ecole.getInstance();

        if(elem.getType().equals(typePannel.eleve.type))
        {
            JEleveAdd trueObject = (JEleveAdd) elem;
            String surName = trueObject.getTextSurname().getText() ;
            String name = trueObject.getTextName().getText() ;

            if(!surName.equals("") && !name.equals(""))
                Eleve.createInsertRequest(surName,name,conn);

        }else if(elem.getType().equals(typePannel.enseignant.type))
        {
            JEnseignantAdd trueObject = (JEnseignantAdd) elem;
            String surName = trueObject.getTextSurname().getText() ;
            String name = trueObject.getTextName().getText() ;

            if(!surName.equals("") && !name.equals(""))
                Enseignant.createInsertRequest(surName,name,conn);
        }
        else if(elem.getType().equals(typePannel.bulletin.type))
        {
            JBulletinAdd trueObject = (JBulletinAdd) elem;
            int index = trueObject.getChoiceBox().getSelectedIndex();
            String appreciation = trueObject.getAppreciation().getText();
            if(!appreciation.equals(""))
            {
                if(trueObject.getMotherElem().getClass() == Inscription.class)
                {
                    int idTrimestre =  trueObject.getListId(index);
                    int idInscription = trueObject.getMotherElem().getId();
                    Bulletin.createInsertRequest(appreciation,idInscription,idTrimestre,conn);

                }else if(trueObject.getMotherElem().getClass() == Trimestre.class)
                {
                    int idTrimestre =  trueObject.getMotherElem().getId();
                    int idInscription = trueObject.getListId(index);
                    Bulletin.createInsertRequest(appreciation,idInscription,idTrimestre,conn);

                }
            }

        }
        else if(elem.getType().equals(typePannel.classe.type))
        {
            JClasseAdd trueObject = (JClasseAdd) elem;
            int indexAnnee = trueObject.getFirstChoiceBox().getSelectedIndex();
            int indexNiveau = trueObject.getSecondChoiceBox().getSelectedIndex();
            String nom = trueObject.getNomDeClasse().getText();
            if(!nom.equals(""))
            {
                if(trueObject.getMotherElem().getClass() == Niveau.class)
                {
                    int idNiveau =  trueObject.getMotherElem().getId();
                    int idAnnee = trueObject.getListIdFirstBox(indexAnnee);

                    Classe.createInsertRequest(nom,eco.getId(),idNiveau,idAnnee,conn);
                }else
                {
                    int idNiveau =  trueObject.getListIdSecondBox(indexNiveau);
                    int idAnnee = trueObject.getListIdFirstBox(indexAnnee);
                    Classe.createInsertRequest(nom,eco.getId(),idNiveau,idAnnee,conn);
                }
            }



        }else if(elem.getType().equals(typePannel.detBulletin.type))
        {
            JBulDetAdd trueObject = (JBulDetAdd) elem;
            int index = trueObject.getChoiceBox().getSelectedIndex();
            String appreciation = trueObject.getAppreciation().getText();
            if(!appreciation.equals(""))
            {
                if(trueObject.getMotherElem().getClass() == Enseignement.class)
                {
                    int idNBulletin =  trueObject.getListId(index);
                    int idEnseignement = trueObject.getMotherElem().getId();
                    DetailBulletin.createInsertRequest(appreciation,idNBulletin,idEnseignement,conn);
                }
                else if(trueObject.getMotherElem().getClass() == Bulletin.class)
                {
                    int idNBulletin =  trueObject.getMotherElem().getId();
                    int idEnseignement = trueObject.getListId(index);
                    DetailBulletin.createInsertRequest(appreciation,idNBulletin,idEnseignement,conn);

                }
            }

        }
        else if(elem.getType().equals(typePannel.enseignement.type))
        {
            JEnseignementAdd trueObject = (JEnseignementAdd) elem;
            int indexEnseignant = trueObject.getFirstChoiceBox().getSelectedIndex();
            int index2 = trueObject.getSecondChoiceBox().getSelectedIndex();
            {
                if(trueObject.getMotherElem().getClass() == Classe.class)
                {
                    int idClasse =  trueObject.getMotherElem().getId();
                    int idEnseignant = trueObject.getListIdFirstBox(indexEnseignant);
                    int idDiscipline = trueObject.getListIdSecondBox(index2);

                    Enseignement.createInsertRequest(idClasse,idDiscipline,idEnseignant,conn);
                }else if(trueObject.getMotherElem().getClass() == Discipline.class)
                {
                    int idDiscipline=  trueObject.getMotherElem().getId();
                    int idEnseignant = trueObject.getListIdFirstBox(indexEnseignant);
                    int idClasse = trueObject.getListIdSecondBox(index2);

                    Enseignement.createInsertRequest(idClasse,idDiscipline,idEnseignant,conn);
                }
            }

        }
        else if(elem.getType().equals(typePannel.evaluation.type))
        {
            JEvaluationAdd trueObject = (JEvaluationAdd) elem;
            String appreciation = trueObject.getAppreciation().getText() ;
            int idDetBulletin = trueObject.getMotherElem().getId();
            try{
                int note = Integer.parseInt(trueObject.getNote().getText()) ;
                if(!appreciation.equals(""))
                    Evaluation.createInsertRequest(appreciation,note,idDetBulletin,conn);
            }
            catch(NumberFormatException error){}



        }
        else if(elem.getType().equals(typePannel.discipline.type)) {
            JDisciplineAdd trueObject = (JDisciplineAdd) elem;
            String name = trueObject.getTextName().getText();

            if (!name.equals(""))
                Discipline.createInsertRequest( name, conn);
        }
        else if(elem.getType().equals(typePannel.inscription.type))
        {
            JInscriptionAdd trueObject = (JInscriptionAdd) elem;
            int index = trueObject.getChoiceBox().getSelectedIndex();
            int idClasse = trueObject.getMotherElem().getId();
            int idEleve = trueObject.getListId(index);

                Inscription.createInsertRequest(idClasse,idEleve,conn);
        }
        else if(elem.getType().equals(typePannel.trimestre.type))
        {
            JTrimestreAdd trueObject = (JTrimestreAdd) elem;
            int idAnnee = trueObject.getMotherElem().getId();

            String dateStartYear = trueObject.getStartYearPanel().getJFormattedTextField().getText();
            String dateEndYear = trueObject.getEndYearPanel().getJFormattedTextField().getText();
            try{
                int numero = Integer.parseInt(trueObject.getNumeroTextArea().getText());
                if (!dateEndYear.equals("") && !dateStartYear.equals(""))
                {
                    int annee = Integer.parseInt(dateStartYear.substring(0,4));
                    int mois = Integer.parseInt(dateStartYear.substring(5,7));
                    int jour = Integer.parseInt(dateStartYear.substring(8,10));
                    LocalDate startYear = LocalDate.of(annee,mois,jour);
                    annee = Integer.parseInt(dateEndYear.substring(0,4));
                    mois = Integer.parseInt(dateEndYear.substring(5,7));
                    jour = Integer.parseInt(dateEndYear.substring(8,10));
                    LocalDate endYear = LocalDate.of(annee,mois,jour);

                    Trimestre.createInsertRequest(numero,startYear,endYear,idAnnee,conn);
                }
            }catch(NumberFormatException error){}


        }
        else if(elem.getType().equals(typePannel.niveau.type))
        {
            JNiveauAdd trueObject = (JNiveauAdd) elem;
            String name = trueObject.getTextName().getText() ;

            if( !name.equals(""))
                Niveau.createInsertRequest(name,conn);
        }

        conn.executeAllupdate();
        Ecole.getInstance().refresh();
        GraphicContainer.createInstance(new JRightNavPanel(),new JUpNavBar(),new JClasseAff(eco));

    }
}
