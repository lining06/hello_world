package org.gupao.design.factory.abstr;

public class AbstractFactryTest {

    public static void main(String[] args) {
        MilkFactory milkFactory = new MilkFactory();

        System.out.println(milkFactory.getTelunsuMilk().getName());
    }
}
