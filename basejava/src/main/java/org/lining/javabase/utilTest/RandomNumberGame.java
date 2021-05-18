package org.lining.javabase.utilTest;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lining on 2018/11/12.
 */
public class RandomNumberGame {

    private static final int RANDOM_NUMBER = new Random().nextInt(1000);


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        RandomNumberGame randomNumberGame = new RandomNumberGame();
        int times = 0;
        while (true){
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            times ++;
            if (randomNumberGame.judge(next, times)){
                return;
            }
        }
    }

    /**
     * 是否正确
     * @param next
     * @param times
     * @return
     */
    private boolean judge(String next, int times) {
        try {
            int inputNumber = Integer.valueOf(next);
            if (inputNumber < RANDOM_NUMBER){
                System.out.println("【小】了，再大一点哦");
                return false;
            }

            if (inputNumber > RANDOM_NUMBER){
                System.out.println("【大】了，再小一点哦");
                return false;
            }

            if (inputNumber == RANDOM_NUMBER){
                System.out.println("太棒了，用了"+ times + "次就猜中了，可以去买彩票了");
                return true;
            }

            return false;
        }catch (Exception e){
            System.out.println("请输入正确的数字");
            return false;
        }
    }
}
