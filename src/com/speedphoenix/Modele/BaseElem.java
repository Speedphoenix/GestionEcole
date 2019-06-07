package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

/**
 * The super class of all classes that mirror an SQL table
 * Contains genereic things like the ID
 */
public abstract class BaseElem {
    protected int id;
    private ArrayList<ArrayList> tableChildren = new ArrayList<>();

    /**
     *
     * @param id the id of the entry in the SQL table
     */
    public BaseElem(int id) {
        this.id = id;
    }

    public BaseElem() {
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    public ArrayList<ArrayList> getTableChildren() {
        return tableChildren;
    }

    /**
     * Adds an ArrayList of the instance's children to the internal ArrayList of ArrayLists.
     * That internal double list is used later for generic operations
     *
     * @param what The ArrayList to add
     */
    public void addTableChildren(ArrayList what) {
        tableChildren.add(what);
    }

    /**
     * Returns the name of the SQL table this element is taken from
     *
     * @return The name of the SQL table this element is taken from
     */
    public abstract String getTableName();

    private void deleteRow(Connexion conn) {
        String sql = "DELETE FROM "+getTableName()+"  WHERE id = "+getId()+";";
        conn.ajouterRequeteMaj(sql);
    }

    /**
     * Adds an SQL query to remove this element to the Connection's internal list of queries, to be executed later
     * This will make sure all children do the same before,
     * so removing this object will also remove all those with it as a foreign key
     *
     * @param conn The connection to the SQL database that will do the query
     */
    public final void createDeleteRequest(Connexion conn) {

        for(ArrayList listEl : tableChildren) {
            for (Object el : listEl) {
                BaseElem el1 = (BaseElem) el;
                el1.createDeleteRequest(conn);
            }
        }
        this.deleteRow(conn);
    }
}
