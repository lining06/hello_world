package org.gupao.design.factory.func;

import org.gupao.design.factory.Milk;
import org.gupao.design.factory.Telunsu;

public class TelunsuFactory implements Factory {

    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
