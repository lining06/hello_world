package org.gupao.factory.func;

import org.gupao.factory.Milk;
import org.gupao.factory.Telunsu;

public class TelunsuFactory implements Factory {

    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
