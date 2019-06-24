package org.lining.test.design.singledistance.action;

/**
 * 单例模式
 */
public class MoveAction {

    private static final MoveAction singleDistance = new MoveAction();

    public static MoveAction getSingleDistance(){

        return singleDistance;
    }

    public void move(){
        System.out.println("m moving");
    }

    private MoveAction(){

    }
}
