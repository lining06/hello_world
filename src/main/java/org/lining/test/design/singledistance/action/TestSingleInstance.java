package org.lining.test.design.singledistance.action;

public class TestSingleInstance {

    public static void main(String[] args) {
        MoveAction moveAction = MoveAction.getSingleDistance();
        moveAction.move();
    }
}
