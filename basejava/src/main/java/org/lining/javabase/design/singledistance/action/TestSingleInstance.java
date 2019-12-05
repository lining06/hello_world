package org.lining.javabase.design.singledistance.action;

public class TestSingleInstance {

    public static void main(String[] args) {
        MoveAction moveAction = MoveAction.getSingleDistance();
        moveAction.move();
    }
}
