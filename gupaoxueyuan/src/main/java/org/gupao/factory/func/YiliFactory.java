package org.gupao.factory.func;

import org.gupao.factory.Milk;
import org.gupao.factory.YiLi;

public class YiliFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new YiLi();
    }
}
