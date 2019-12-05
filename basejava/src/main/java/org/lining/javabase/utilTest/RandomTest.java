package org.lining.javabase.utilTest;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lining on 2018/11/12.
 */
public class RandomTest {

    private static final int RANDOM_NUMBER = new Random().nextInt(1000);


    public static void main(String[] args) {
        RandomTest randomTest = new RandomTest();
        while (true){
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            if (randomTest.judge(next)){
                return;
            }
        }
    }

    /**
     * 是否正确
     * @param next
     * @return
     */
    private boolean judge(String next) {
        try {
            int inputNumber = Integer.valueOf(next);
            if (inputNumber < RANDOM_NUMBER){
                System.out.println("太小了，再大一点哦");
                return false;
            }

            if (inputNumber > RANDOM_NUMBER){
                System.out.println("太大了，再小一点哦");
                return false;
            }

            if (inputNumber == RANDOM_NUMBER){
                System.out.println("太棒了，可以去买彩票了");
                return true;
            }

            return false;
        }catch (Exception e){
            System.out.println("请输入正确的数字");
            return false;
        }
    }
}
