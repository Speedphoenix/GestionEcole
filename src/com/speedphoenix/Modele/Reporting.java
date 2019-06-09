package com.speedphoenix.Modele;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.Iterator;
import java.util.HashSet;

public class Reporting extends BaseElem {

    /***Moyenne générale selon le TD (HISTOGRAMME)***/
    public Hashtable<Integer,Double> moyenne_par_td() {

        Ecole sc = Ecole.getInstance();

        Hashtable<Integer,Double> all_avrg = new Hashtable<>();

        Set<Integer> keys = sc.getClasses().keySet();

        for (Iterator it = keys.iterator(); it.hasNext();) {
            Integer key = (Integer) it.next();

            //System.out.println("dans la classe" + sc.findClasse(key).getNom());

            //parcours chaque élève du TD
            for (int i = 0 ; i < sc.findClasse(key).getInscriptions().size() ; i++)
            {
                //System.out.println("l'élève " + sc.findClasse(key).getInscriptions().get(i).getEleve().getPrenom());
                double total = 0 ;
                int nb_eval = 0 ;

                //parcours chaque bulletin
                for(int j = 0; j < sc.findClasse(key).getInscriptions().get(i).getBulletins().size() ; j++)
                {
                    //System.out.println("Bulletin numero " + sc.findClasse(key).getInscriptions().get(i).getBulletins().get(j).getId());
                    //année en cours
                    if (sc.findClasse(key).getInscriptions().get(i).getBulletins().get(j).getTrimestre().anneeScolaire.getId() == 1)
                    {
                        //System.out.println("fait bien parti de l'année scolaire actuelle");
                        //parcours chaque détail du bulletin
                        for(int k = 0 ; k < sc.findClasse(key).getInscriptions().get(i).getBulletins().get(j).detailBulletins.size() ; k++ )
                        {
                            //System.out.println(" détail du bulletin num " + sc.findClasse(key).getInscriptions().get(i).getBulletins().get(j).detailBulletins.get(k).getId());
                            //parcours chaques évaluations du bulletins
                            for(int l = 0 ; l < sc.findClasse(key).getInscriptions().get(i).getBulletins().get(j).detailBulletins.get(k).evaluations.size() ; l++)
                            {
                                //System.out.println("la note est :" + sc.findClasse(key).getInscriptions().get(i).getBulletins().get(j).detailBulletins.get(k).evaluations.get(l).getNote());
                                total += sc.findClasse(key).getInscriptions().get(i).getBulletins().get(j).detailBulletins.get(k).evaluations.get(l).getNote();
                                nb_eval ++;
                            }

                        }
                    }
                }

                if(nb_eval != 0)
                {
                    double moyenne = total / nb_eval;

                    all_avrg.put(key,moyenne);
                }

            }
        }

        return all_avrg;

    }

    /***Moyenne générale selon la promo (HISTOGRAMME)***/
    public Hashtable<Integer,Double> moyenne_par_promo(){

        Ecole sc = Ecole.getInstance();

        Hashtable <Integer, Double> avrg_promo = new Hashtable<>();

        Set<Integer> keys = sc.getNiveaux().keySet();

        //Parcours de chaque niveau
        for (Iterator it = keys.iterator(); it.hasNext();) {
            Integer key_1 = (Integer)it.next();

            Set keys_2 = moyenne_par_td().keySet();
            Iterator it2 = keys_2.iterator();

            double total = 0;
            int nb_moy = 0;

            //on retrouve les moyennes de chaques classes
            while(it2.hasNext())
            {
                int key_2 = (Integer)it2.next();

                if(key_1 == sc.findClasse(key_2).getNiveau().getId())
                {
                    total += moyenne_par_td().get(key_2);
                    nb_moy ++;
                }
            }

            if(nb_moy>0)
            {
                double moyenne = total / nb_moy ;
                avrg_promo.put(key_1,moyenne);
            }

        }

        return avrg_promo;
    }

    /***Moyenne générale selon la discipline (HISTOGRAMME)***/
    public Hashtable<Integer,Double> moyenne_par_matiere(){

        Ecole sc = Ecole.getInstance();

        Hashtable<Integer,Double> avrg_matieres = new Hashtable<>();

        Set<Integer> keys = sc.getDisciplines().keySet();

        //parcours de chaque matières
        for (Iterator it = keys.iterator(); it.hasNext();) {

            double total = 0;
            int nb = 0;

            Integer key = (Integer) it.next();

            //chacun des enseignements
            for (int i = 0 ; i < sc.findDiscipline(key).getEnseignements().size() ; i++)
            {
                //chacun des élèves
                for(int j = 0 ; j < sc.findDiscipline(key).getEnseignements().get(i).getClasse().getInscriptions().size() ; j++)
                {
                    //chacun des bulletins
                    for(int k = 0 ; k <sc.findDiscipline(key).getEnseignements().get(i).getClasse().getInscriptions().get(j).getBulletins().size() ; k++)
                    {
                        //chacun des detail
                        for(int l = 0 ; l <sc.findDiscipline(key).getEnseignements().get(i).getClasse().getInscriptions().get(j).bulletins.get(k).detailBulletins.size() ; l++)
                        {
                            //chacune des évaluations
                            for(int m = 0 ; m < sc.findDiscipline(key).getEnseignements().get(i).getClasse().getInscriptions().get(j).bulletins.get(k).detailBulletins.get(l).evaluations.size() ; m++)
                            {
                                if(sc.findDiscipline(key).getEnseignements().get(i).getClasse().getInscriptions().get(j).bulletins.get(k).detailBulletins.get(l).getEnseignement().discipline.getId() == key)
                                {
                                    total += sc.findDiscipline(key).getEnseignements().get(i).getClasse().getInscriptions().get(j).bulletins.get(k).detailBulletins.get(l).evaluations.get(m).note;
                                    nb ++;
                                }
                            }
                        }
                    }
                }
            }

            if(nb > 0)
            {
                double moyenne = total / nb;
                avrg_matieres.put(key,moyenne);
            }
        }

        return avrg_matieres;
    }

    /***Répartition des élèves selon les promos (CAMEMBERT)***/
    public Hashtable<Integer, Integer> repartition_eleve_par_promo() {

        Ecole sc = Ecole.getInstance();

        Hashtable<Integer, Integer> rep_el = new Hashtable<>();

        Set<Integer> keys = sc.getNiveaux().keySet();

        //parcours de chaque promo
        for (Iterator it = keys.iterator(); it.hasNext(); ) {

            int total = 0 ;
            Integer key = (Integer) it.next();

            for (int i = 0; i < sc.findNiveau(key).classes.size(); i++) {
                total += sc.findNiveau(key).classes.get(i).getInscriptions().size();
            }

            if(total > 0) {
                rep_el.put(key, total);
            }
            //System.out.println(sc.findNiveau(key).getNom() + " " + total);
        }

        return rep_el;
    }

    /***Cb de prof par matière (CAMEMBERT)***/
    public Hashtable<Integer, Integer> repartition_prof_par_discipline () {

        Ecole sc = Ecole.getInstance();

        Hashtable<Integer, Integer> rep_prof = new Hashtable<>();

        ArrayList<Integer> temp_prof = new ArrayList<>();

        Set<Integer> keys = sc.getDisciplines().keySet();

        int nb_prof = 0 ;

        //parcours de chaque disciplines
        for (Iterator it = keys.iterator(); it.hasNext(); ) {

            Integer key = (Integer) it.next();

            for(int i = 0 ; i < sc.findDiscipline(key).getEnseignements().size() ; i++)
            {
                if(sc.findDiscipline(key).getEnseignements().get(i).getDiscipline().getId() == key)
                {
                    nb_prof ++;
                }
            }

            if(nb_prof > 0)
            {
                rep_prof.put(key,nb_prof);
                //System.out.println( sc.findDiscipline(key).getNom() + " a " + nb_prof + " profs");
            }

            nb_prof = 0;
        }
        return rep_prof;
    }

    @Override
    public String getTableName() {
        return null;
    }
}
