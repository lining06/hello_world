package org.lining.javabase.design.factory.simplefactorymodel.factory;

import org.lining.javabase.design.factory.simplefactorymodel.api.MoveActionInterface;
import org.lining.javabase.design.factory.simplefactorymodel.enums.MoveType;
import org.lining.javabase.design.factory.simplefactorymodel.impl.RunActionImpl;
import org.lining.javabase.design.factory.simplefactorymodel.impl.WalkActionImpl;

/**
 * 简单工厂模式是属于创建型模式，又叫做静态工厂方法（Static Factory Method）模式，但不属于23种GOF设计模式之一。
 * 简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例。简单工厂模式是工厂模式家族中最简单实用的模式，可以理解为是不同工厂模式的一个特殊实现。
 *  简单工厂 配合 反射 + 配置文件 会有更好的效果
 优点
 隐藏了对象创建的细节，将产品的实例化过程放到了工厂中实现。
 客户端基本不用关心使用的是哪个产品，只需要知道用工厂的那个方法(或传入什么参数)就行了.
 方便添加新的产品子类，每次只需要修改工厂类传递的类型值就行了。
 遵循了依赖倒转原则。

 缺点
 适用于产品子类型差不多, 使用的方法名都相同的情况.
 每添加一个产品子类，都必须在工厂类中添加一个判断分支(或一个方法)，这违背了OCP(开放-封闭原则)。
 */
public class MoveFactory {

    public static MoveActionInterface createMoveAction(MoveType moveType){
        //简单工厂模式的工厂类一般是使用静态方法，通过接收的参数的不同来返回不同的对象实例。
        if (moveType == MoveType.WALK){
            return WalkActionImpl.getNewInstance();
        }
        if (moveType == MoveType.RUN){
            return new RunActionImpl();
        }
        return null;
    }
}
