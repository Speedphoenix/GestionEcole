package com.speedphoenix.Display;

import com.speedphoenix.ActionListeners.ContentPanel.ChangeObjectListener;
import com.speedphoenix.Display.Affclasses.JMother;
import com.speedphoenix.Display.Affclasses.JRightNavPanel;
import com.speedphoenix.Display.Affclasses.JUpNavBar;
import com.speedphoenix.Display.ModClasses.JMotherMod;

import javax.swing.*;

/**
 * Classe qui contient tout l'affichage du programme
 * elle peut afficher 2 types de contenus :
 * - soit une table contenant toutes les données de la BDD avec un menu à gauche et un menu au dessus
 * (contentPan,sidePanel,upPanel)
 * - soit une page proposant à l'utisateur la modification ou l'ajout d'un objet (contentPanAdd)
 */
public class GraphicContainer extends JFrame {

    private JRightNavPanel sidePanel;
    private JUpNavBar upPanel;
    private JMother contentPan;
    private JMotherMod contentPanAdd;
    private static GraphicContainer instance = new GraphicContainer("Gestion Ecole");

    private GraphicContainer(String name) {
        super.setTitle(name);
    }

    /**
     * Crée une instance de Graphic container et affiche une table contenant les données d'un objet de la BDD avec un menu
     * à gauche et un menu au dessus (contentPan,sidePanel,upPanel)
     * @param sidePanel menu à gauche
     * @param upPanel un menu du dessus
     * @param contentPan  table contenant les données d'un objet de la BDD
     */
    public static void createInstance(JRightNavPanel sidePanel, JUpNavBar upPanel, JMother contentPan) {
        //on réanitialise

        instance.sidePanel = null;
        instance.upPanel = null;
        instance.contentPan = null;
        instance.contentPanAdd = null;
        instance.getContentPane().removeAll();

        instance.sidePanel = sidePanel;
        instance.upPanel = upPanel;
        instance.contentPan = contentPan;
        getInstance().add(sidePanel.getMainPanel());
        getInstance().add(upPanel.getMainPanel());
        getInstance().add(contentPan.getMainPanel());
        instance.contentPan.getMainTable().getTable().addMouseListener(new ChangeObjectListener(instance.contentPan));

        instance.revalidate();
        instance.repaint();
        instance.getSidePanel().setActionsListeners();
        instance.getUpPanel().setActionsListeners();
    }

    /**
     * Crée une instance de Graphic container et affiche une page proposant à l'utisateur la modification ou l'ajout d'un objet
     * @param motAdd page de modification ou d'ajout
     */
    public static void createInstance(JMotherMod motAdd) {
        instance.sidePanel = null;
        instance.upPanel = null;
        instance.contentPan = null;
        instance.contentPanAdd = null;

        instance.getContentPane().removeAll();
        instance.contentPanAdd = motAdd;
        instance.revalidate();
        instance.repaint();

        getInstance().add(motAdd.getMainPanel());

    }
    public static GraphicContainer getInstance() {
        return instance;
    }

    public JRightNavPanel getSidePanel() {
        return sidePanel;
    }

    public JUpNavBar getUpPanel() {
        return upPanel;
    }

    /**
     * Change la table contenant les données d'un objet de la BDD pour une nouvelle passée en paramêtre
     * @param contPan nouvelle table
     */
    public void setContentPan(JMother contPan) {
        instance.contentPan.getMainPanel().setVisible(false);
        instance.remove(instance.contentPan.getMainPanel());
        this.contentPan = contPan;
        //instance.revalidate();
        instance.add(instance.contentPan.getMainPanel());
        instance.contentPan.getMainPanel().setVisible(true);
        instance.contentPan.getMainTable().getTable().addMouseListener(new ChangeObjectListener(instance.contentPan));
        // Ecole.getInstance().showTest();
        sidePanel.resetActionsListeners();
    }

    public JMother getContentPan() {
        return contentPan;
    }
}
