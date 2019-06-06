package com.speedphoenix.ActionListeners.AddOrModifyPanel;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Display.ModClasses.JBulletinAdd;
import com.speedphoenix.Display.ModClasses.JEleveAdd;
import com.speedphoenix.Display.ModClasses.JEnseignantAdd;
import com.speedphoenix.Display.ModClasses.JMotherMod;
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
        classe("classse"),
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
            Eleve.createInsertRequest(trueObject.getTextSurname().getText(),trueObject.getTextName().getText(),conn);
        }else if(elem.getType().equals(typePannel.enseignant.type))
        {
            JEnseignantAdd trueObject = (JEnseignantAdd) elem;
            Enseignant.createInsertRequest(trueObject.getTextSurname().getText(),trueObject.getTextName().getText(),conn);
        }
        else if(elem.getType().equals(typePannel.bulletin.type))
        {
            JBulletinAdd trueObject = (JBulletinAdd) elem;
            int index = trueObject.getChoiceBox().getSelectedIndex();
            if(trueObject.getMotherElem().getClass() == Inscription.class)
            {
                int idTrimestre =  trueObject.getListId(index);
                int idInscription = trueObject.getMotherElem().getId();
                Bulletin.createInsertRequest(trueObject.getAppreciation().getText(),idInscription,idTrimestre,conn);

            }else if(trueObject.getMotherElem().getClass() == Trimestre.class)
            {
                int idTrimestre =  trueObject.getMotherElem().getId();
                int idInscription = trueObject.getListId(index);
                Bulletin.createInsertRequest(trueObject.getAppreciation().getText(),idInscription,idTrimestre,conn);

            }
        }

        conn.executeAllupdate();
        Ecole.getInstance().refresh();
        GraphicContainer.createInstance(new JRightNavPanel(),new JUpNavBar(),new JClasseAff(eco));

    }
}
