package com.speedphoenix.ActionListeners.AddOrModifyPanel;

import com.speedphoenix.Display.ModClasses.JMotherMod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportingListener implements ActionListener {

    protected JMotherMod elem;

    public ReportingListener(JMotherMod elem) {
        this.elem = elem;
    }

    private enum typePannel{
        reporting("reporting");


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



    }
}
