package com.speedphoenix.ActionListeners.AddOrModifyPanel;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Display.ModClasses.*;
import com.speedphoenix.Modele.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        bulletin("bulletin");

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
            System.out.println("passée par la");
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



        }

        conn.executeAllupdate();
        Ecole.getInstance().refresh();
        GraphicContainer.createInstance(new JRightNavPanel(),new JUpNavBar(),new JClasseAff(eco));

    }
}
