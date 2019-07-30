package org.gupao.factory.abstr;

import org.gupao.factory.Milk;
import org.gupao.factory.Telunsu;
import org.gupao.factory.YiLi;

public class MilkFactory extends AbstractFactory {
    @Override
    Milk getTelunsuMilk() {
        return new Telunsu();
    }

    @Override
    Milk getYiliMulk() {
        return new YiLi();
    }
}
