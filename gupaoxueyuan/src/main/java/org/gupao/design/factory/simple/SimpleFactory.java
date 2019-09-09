package org.gupao.design.factory.simple;

import org.gupao.design.factory.Milk;
import org.gupao.design.factory.Telunsu;
import org.gupao.design.factory.YiLi;

/**
 * 小作坊式的工厂模型
 */
public class SimpleFactory {

    public Milk getMilk(String name){

        if ("telunsu".equals(name)){
            return new Telunsu();
        }
        if ("yili".equals(name)){
            return new YiLi();
        }
        return null;
    }
}
