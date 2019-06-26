package org.lining.test.design.factory.abstractFactory;

import org.lining.test.design.factory.abstractFactory.api.AbstractRunInterface;
import org.lining.test.design.factory.abstractFactory.api.AbstractWalkInterface;
import org.lining.test.design.factory.abstractFactory.factory.MoveFactory;
import org.lining.test.design.factory.abstractFactory.factoryimpl.KidFactory;

/**
 *
 三种工厂模式区别

 简单工厂 ： 用来生产同一等级结构中的任意产品。（对于增加新的产品，无能为力）

 工厂方法 ：用来生产同一等级结构中的固定产品。（支持增加任意产品）  
 抽象工厂 ：用来生产不同产品族的全部产品。（对于增加新的产品，无能为力；支持增加产品族）  

  

 以上三种工厂 方法在等级结构和产品族这两个方向上的支持程度不同。所以要根据情况考虑应该使用哪种方法。  
 ---------------------
 作者：superbeck
 来源：CSDN
 原文：https://blog.csdn.net/superbeck/article/details/4446177
 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class TestMoveFactory {

    public static void main(String[] args){
        MoveFactory moveFactory = new KidFactory();
//        MoveFactory moveFactory = new SportFactory();

        try {
            AbstractRunInterface run = moveFactory.createRun();
            AbstractWalkInterface walk = moveFactory.createWalk();
            run.runAndSmile();
            run.runAndCry();
            walk.walk();
        }catch (Exception e){
            System.out.println("move err");
        }
    }
}
