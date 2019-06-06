package com.speedphoenix.ActionListeners.SideMenu;

import com.speedphoenix.Connexion.Connexion;
import com.speedphoenix.Display.*;
import com.speedphoenix.Display.AddClasses.JBulletinAdd;
import com.speedphoenix.Display.AddClasses.JEleveAdd;
import com.speedphoenix.Display.AddClasses.JEnseignantAdd;
import com.speedphoenix.Display.AddClasses.JMotherMod;
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


        if(elem.getType().equals(typePannel.eleve.type))
        {
            JEleveAdd trueObject = (JEleveAdd) elem;
            Eleve.createInsertRequest(trueObject.getTextSurname().getText(),trueObject.getTextName().getText(),conn);
        }else if(elem.getType().equals(typePannel.enseignant.type))
        {
            System.out.println("ba ui qyoi");
            JEnseignantAdd trueObject = (JEnseignantAdd) elem;
            Enseignant.createInsertRequest(trueObject.getTextSurname().getText(),trueObject.getTextName().getText(),conn);
        }
        else if(elem.getType().equals(typePannel.bulletin.type))
        {
            System.out.println("ba ui qyoi");
            JBulletinAdd trueObject = (JBulletinAdd) elem;
           // Bulletin.createInsertRequest(trueObject.getTextSurname().getText(),trueObject.getTextName().getText(),conn);
        }

        conn.executeAllupdate();
        Ecole.getInstance().refresh();
        GraphicContainer.createInstance(new JRightNavPanel(),new JUpNavBar(),new JTrimestresAff());

    }
}
