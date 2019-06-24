package org.lining.test.design.factory.simplefactorymodel.impl;

import org.lining.test.design.factory.simplefactorymodel.api.MoveActionInterface;

public class WalkActionImpl implements MoveActionInterface{

    private static WalkActionImpl walkAction = null;
    @Override
    public void move() throws Exception {
        System.out.println("m walking");
    }

    private WalkActionImpl(){

    }

    public static WalkActionImpl getNewInstance(){
        if (walkAction == null){
            walkAction = new WalkActionImpl();
        }
        return walkAction;
    }
}
