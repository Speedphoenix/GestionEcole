package com.speedphoenix.Display.ModClasses.Mod;

import com.speedphoenix.ActionListeners.AddOrModifyPanel.ModListener;
import com.speedphoenix.Display.ModClasses.JMotherMod;
import com.speedphoenix.Modele.BaseElem;
import com.speedphoenix.Modele.Bulletin;
import com.speedphoenix.Modele.DetailBulletin;

import javax.swing.*;
import java.awt.*;

/**
 * JPanel qui propose de modifier Detail Bulletin
 * On demande d'endtrer: l'appreciation
 */
public class JBulDetMod extends JMotherMod {
    private JPanel mainPanel;
    private JTextPane appreciation;
    private BaseElem motherElem;
    private JButton accept;

    private Font defaultF = new Font("Verdana", 1,14);

    public JBulDetMod(BaseElem what){
        /**/
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);

        JLabel nomFenetre = new JLabel("MODIFICATION DETAIL BULLETIN "+((DetailBulletin)what).getBulletin().getInscription().getEleve().getPrenom()
                +" "+((DetailBulletin)what).getBulletin().getInscription().getEleve().getNom());
        nomFenetre.setBounds(200, 10, 800,200);
        nomFenetre.setFont(new Font("Verdana",3,30));

        accept = new JButton("Modifier");
        accept.setFont(defaultF);
        accept.setBounds(800, 800, 120,50);
        accept.addActionListener(new ModListener(this));

        appreciation = new JTextPane();
        appreciation.setName("Appreciation");
        appreciation.setText(((DetailBulletin)what).getAppreciation());
        appreciation.setBounds(300, 400, 400, 200);
        appreciation.setBorder(BorderFactory.createTitledBorder("Entrez l'appreciation"));
        motherElem = what;

        mainPanel.add(appreciation);
        mainPanel.add(accept);
        mainPanel.add(nomFenetre);

    }


    public BaseElem getMotherElem() {
        return motherElem;
    }

    public JTextPane getAppreciation() {
        return appreciation;
    }



    public String getType() {
        return "detBulletin";
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
