package org.lining.test.design.factory.simplefactorymodel.enums;

public enum MoveType {
    RUN("跑"),
    WALK("走")
    ;


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    MoveType(String name){
        this.name = name;
    }
}
