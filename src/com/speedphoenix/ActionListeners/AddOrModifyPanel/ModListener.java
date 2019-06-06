package com.speedphoenix.ActionListeners.AddOrModifyPanel;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.GraphicContainer;
import com.speedphoenix.Display.Affclasses.JClasseAff;
import com.speedphoenix.Display.Affclasses.JRightNavPanel;
import com.speedphoenix.Display.Affclasses.JUpNavBar;
import com.speedphoenix.Display.ModClasses.*;
import com.speedphoenix.Display.ModClasses.Mod.JBulletinMod;
import com.speedphoenix.Display.ModClasses.Mod.JEleveMod;
import com.speedphoenix.Display.ModClasses.Mod.JEnseignantMod;
import com.speedphoenix.Modele.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            JEleveMod trueObject = (JEleveMod) elem;
            Eleve motElem = (Eleve) trueObject.getMotherElem();
            String surName = trueObject.getTextSurname().getText() ;
            String name = trueObject.getTextName().getText() ;
            if(surName.equals(""))
                surName = motElem.getNom();
            if(name.equals(""))
                name = motElem.getPrenom();
            motElem.createUpdateRequest(surName,name,conn);


        }else if(elem.getType().equals(typePannel.enseignant.type))
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
        else if(elem.getType().equals(typePannel.bulletin.type))
        {
            JBulletinMod trueObject = (JBulletinMod) elem;
            Bulletin motElem = (Bulletin) trueObject.getMotherElem();
            String appreciation = trueObject.getAppreciation().getText() ;
            if(appreciation.equals(""))
                appreciation = motElem.getAppreciation();

            motElem.createUpdateRequest(appreciation,conn);


        }

        conn.executeAllupdate();
        Ecole.getInstance().refresh();
        GraphicContainer.createInstance(new JRightNavPanel(),new JUpNavBar(),new JClasseAff(eco));

    }
}
