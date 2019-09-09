package org.gupao.design.factory.func;

import org.gupao.design.factory.Milk;
import org.gupao.design.factory.YiLi;

public class YiliFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new YiLi();
    }
}
