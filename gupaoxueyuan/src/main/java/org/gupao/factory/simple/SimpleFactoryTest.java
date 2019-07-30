package org.gupao.factory.simple;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();

        System.out.println(factory.getMilk("telunsu").getName());
    }
}
