package com.speedphoenix.Modele;

public abstract class BaseElem {
    protected int id;

    public BaseElem(int id) {
        this.id = id;
    }
    public BaseElem() {
        this.id = 0;
    }

    public int getId() {
        return id;
    }
}
