package com.speedphoenix.Modele;

import com.speedphoenix.Connexion.Connexion;

import java.util.ArrayList;

public abstract class BaseElem {
    protected int id;
    private ArrayList<ArrayList> tableChildren = new ArrayList<>();

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

    public void addTableChildren(ArrayList what) {
        tableChildren.add(what);
    }
    public abstract String getTableName();

    private void deleteRow(Connexion conn) {
        String sql = "DELETE FROM "+getTableName()+"  WHERE id = "+getId()+";";
        conn.ajouterRequeteMaj(sql);
    }

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
