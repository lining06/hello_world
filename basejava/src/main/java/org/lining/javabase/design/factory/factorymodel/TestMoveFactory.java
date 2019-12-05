package org.lining.javabase.design.factory.factorymodel;

import org.lining.javabase.design.factory.factorymodel.api.MoveActionInterface;
import org.lining.javabase.design.factory.factorymodel.factory.MoveFactory;
import org.lining.javabase.design.factory.factorymodel.factoryimpl.WalkFactory;

public class TestMoveFactory {

    public static void main(String[] args) throws Exception{
        MoveFactory walkFactory = new WalkFactory();
        MoveFactory runFactory = (MoveFactory)Class.forName("org.lining.javabase.design.factory.factorymodel.factoryimpl.RunFactory").newInstance();

        try {
            MoveActionInterface walk = walkFactory.createMoveAction();
            MoveActionInterface run = runFactory.createMoveAction();
            walk.move();
            run.move();
        }catch (Exception e){
            System.out.println("move err");
        }
    }
}
