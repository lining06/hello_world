package org.lining.test.utilTest;

/**
 * Created by lining on 2018/6/11.
 */
public class ChangeValueTest {

    public static void main(String[] args) {

//        int a = 1;
//        int b = 2;
//        int sum = 0;
//
//        addValue(a,b,sum);
//
//        System.out.println(sum);

        ValueTest valueTest = new ValueTest();

        changGood(valueTest);

    }

    private static void changGood(ValueTest valueTest) {


    }

    private static void addValue(int a, int b, int sum) {

        sum = a+b;

    }




    static class ValueTest{
        public int good;
    }

}
