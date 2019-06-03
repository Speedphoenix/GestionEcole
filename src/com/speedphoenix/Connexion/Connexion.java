/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.speedphoenix.Connexion;

/*
 * 
 * Librairies importées
 */
import java.sql.*;
import java.util.ArrayList;

/**
 * 
 * Connexion a votre BDD locale ou à distance sur le serveur de l'ECE via le tunnel SSH
 * 
 * @author segado
 */
public class Connexion {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    public static Connexion conn;
    private Connection connection;
    private Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    /**
     * ArrayList public pour les tables
     */
    public ArrayList<String> tables = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de sélection
     */
    public ArrayList<String> requetes = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de MAJ
     */
    public ArrayList<String> requetesMaj = new ArrayList<>();

    /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://remotemysql.com/" + nameDatabase;

        //création d'une connexion JDBC à la base 
        connection = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = connection.createStatement();
        //on peux acceder à la connexion depuis n'importe ou (conn variable statique)
        conn=this;
    }

    /**
     * Constructeur avec 4 paramètres : username et password ECE, login et
     * password de la BDD à distance sur le serveur de l'ECE
     * @param usernameECE
     * @param passwordECE
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Connexion(String usernameECE, String passwordECE, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // Connexion via le tunnel SSH avec le username et le password ECE
        SSHTunnel ssh = new SSHTunnel(usernameECE, passwordECE);

        if (ssh.connect()) {
            System.out.println("Connexion reussie");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3305/" + usernameECE;

            //création d'une connexion JDBC à la base
            connection = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

            // création d'un ordre SQL (statement)
            stmt = connection.createStatement();
            //on peux acceder à la connexion depuis n'importe ou (conn variable statique)
            conn=this;
        }
    }

    /**
     * Méthode qui ajoute la table en parametre dans son ArrayList
     *
     * @param table
     */
    public void ajouterTable(String table) {
        tables.add(table);
    }

    /**
     * Méthode qui ajoute la requete de selection en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequete(String requete) {
        requetes.add(requete);
    }

    /**
     * Méthode qui ajoute la requete de MAJ en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequeteMaj(String requete) {
        requetesMaj.add(requete);
    }

    /**
     * Méthode qui retourne l'ArrayList des champs de la table en parametre
     *
     * @param table
     * @return
     * @throws java.sql.SQLException
     */
    @SuppressWarnings("Duplicates")
    public ArrayList remplirChampsTable(String table) throws SQLException {
        // récupération de l'ordre de la requete

        rset = stmt.executeQuery("select * from " + table);
        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        rset.last();
        int size = rset.getRow();
        rset.beforeFirst();
        rset.next();

        // creation d'une ArrayList dans lequel on placera les lignes une par une
        ArrayList liste;
        // creation d'une ArrayList de String
        ArrayList<String> ligne;
        liste = new ArrayList<ArrayList<String>>();
        ligne = new ArrayList<String>();

            // Ajouter tous les noms des colonnes du resultat dans l'ArrayList
            for (int i = 0; i < nbColonne; i++) {
                ligne.add(rsetMeta.getColumnLabel(i + 1));
            }

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(ligne);

            //tant qu'on peut aller à la ligne suivante
        if (size > 0)
        {
            do {
                ligne = new ArrayList<String>();

                for (int i = 0; i < nbColonne; i++) {
                    ligne.add(rset.getString(i + 1));
                }
                liste.add(ligne);

            }while(rset.next());
        }


        // Retourner l'ArrayList
        return liste;
    }

    /**
     * Methode qui retourne l'ArrayList des champs de la requete en parametre
     * @param requete
     * @return 
     * @throws java.sql.SQLException
     */
    @SuppressWarnings("Duplicates")
    public ArrayList remplirChampsRequete(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        rset.last();
        int size = rset.getRow();
        rset.beforeFirst();
        rset.next();

        // creation d'une ArrayList dans lequel on placera les lignes une par une
        ArrayList liste;
        // creation d'une ArrayList de String
        ArrayList<String> ligne;
        liste = new ArrayList<ArrayList<String>>();
        ligne = new ArrayList<String>();

        // Ajouter tous les noms des colonnes du resultat dans l'ArrayList
        for (int i = 0; i < nbColonne; i++) {
            ligne.add(rsetMeta.getColumnLabel(i + 1));
        }

        // ajouter les champs de la ligne dans l'ArrayList
        liste.add(ligne);

        //tant qu'on peut aller à la ligne suivante
        if (size > 0)
        {
            do {
                ligne = new ArrayList<String>();

                for (int i = 0; i < nbColonne; i++) {
                    ligne.add(rset.getString(i + 1));
                }
                liste.add(ligne);

            }while(rset.next());
        }

        // Retourner l'ArrayList
        return liste;
    }

    /**
     * Méthode qui execute une requete de MAJ en parametre
     * @param requeteMaj
     * @throws java.sql.SQLException
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        int toto;
        toto =  stmt.executeUpdate(requeteMaj);
        if(toto != 1)
        {
            System.err.println("Erreur à la mise à jour de la bdd pour la requete : ");
            System.err.println(requeteMaj);
        }
    }
    public void executeAllupdate(){
        for(int i = 0; i < requetesMaj.size(); i++)
        {
            try {
                executeUpdate(requetesMaj.get(i));
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
           requetesMaj.clear();
    }

    public boolean testExistanceId(int id,String table)
    {
        ArrayList<ArrayList<String>> result = null;
        int occurence = 0;
        try {
            result = this.remplirChampsRequete("Select id from "+table);
            if(result.size() > 0)
            {
                for(int i = 1;i < result.size() ; i++)
                {
                    if (Integer.parseInt(result.get(i).get(0))  == id )
                    {
                        return true;
                    }

                }
            }
            return false;
        } catch (SQLException e) {
            e.getErrorCode();
            e.printStackTrace();

        }
        return true;

    }
    public int findColomnIndex(ArrayList<ArrayList<String>> result, String colomn)
    {
        for(int i = 0; i < result.get(0).size(); i++)
        {
            if(colomn.equals( result.get(0).get(i)))
            {
                return i;
            }
        }
        return -1;
    }
    //affiche dans la console le résultat d'une requete SQL demandant d'afficher toute les tables
    public void displayRemplirChampsTables(String Table) {
        ArrayList<ArrayList<String>> result = null;

        try {
            result = this.remplirChampsTable(Table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        displayResult(result);

    }
    public void displayRemplirChampsRequete(String requete) {
        ArrayList<ArrayList<String>> result = null;

        try {
            result = this.remplirChampsRequete(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        displayResult(result);

    }
    public static void displayResult(ArrayList<ArrayList<String>> result)
    {
        if(result != null){
            for(int row = 0; row < result.size() ; row++)
            {
                for(int col = 0; col < result.get(row).size() ; col++)
                {
                    System.out.print(result.get(row).get(col) +" ");
                }
                System.out.println("");
            }
        }

    }
}
