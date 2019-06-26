package org.lining.test.design.factory.simplefactorymodel;

import org.lining.test.design.factory.simplefactorymodel.api.MoveActionInterface;
import org.lining.test.design.factory.simplefactorymodel.enums.MoveType;
import org.lining.test.design.factory.simplefactorymodel.factory.MoveFactory;

public class TestMoveFactory {

    public static void main(String[] args) {
        MoveActionInterface walkAction = MoveFactory.createMoveAction(MoveType.WALK);
        MoveActionInterface runAction = MoveFactory.createMoveAction(MoveType.RUN);

        try {

            walkAction.move();
            runAction.move();
        }catch (Exception e){
            System.out.println("err");
        }
    }
}
