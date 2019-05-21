package com.speedphoenix;
import com.jcraft.jsch.*;
import com.speedphoenix.Connexion.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World !");
        Connexion conn = null;
        ArrayList<ArrayList<String>> result = null;
        try {
            conn = new Connexion("bdd_amazon_ece", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        conn.displayRemplirChampsTables("products");
        conn.displayRemplirChampsRequete("Select * from products");
        

    }
}
