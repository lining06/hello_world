package org.lining.javabase.utilTest;

/**
 * Created by lining on 2018/1/20.
 */
public class Heart {


    int highLevel(int wide) {
        int i = 0, j = 0, k = 0, t = 0, m = 0, n = 0, count = 1;// i控制循环内高度，j控制每行前面空格，k控制输出的*数
        // t控制高层星号中间空格，m记录高层最底行的星数，以下逐行增4
        // n记录顶行空个数，以下逐行减4；count记录高层高度，与high无关
        m = (wide - 4) / 2;
        do {
            count++;
            m -= 4;
        } while (m > 4);
        if ((wide - 4) % 2 == 0)// 区别对待奇偶宽度，奇数中间最小空1个，偶数最小空两个
        {
            n = 2 + 4 * (count - 1);
            m--;
        } else{
            n = 1 + 4 * (count - 1);
        }
        for (i = 0; i < count; i++) {
            for (j = (count - i) * 2; j > 0; j--) {
                System.out.print(" ");
            }
            for (k = 0; k < m; k++) {
                System.out.print("*");
            }
            for (t = 0; t < n; t++) {
                System.out.print(" ");
            }
            for (k = 0; k < m; k++) {
                System.out.print("*");
            }
            m += 4;
            n -= 4;
            System.out.print("\n");
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    int lowLevel(int wide) {
        int i = 0, j = 0, k = 0;// i控制输出行，j控制输出每行前的空格，k控制输出*
        int high = 0, tmp = wide;
        do// 计算所需高度
        {
            high++;
            tmp -= 4;
        } while (tmp > 4);
        high += 1;
        for (i = 0; i < high; i++) {
            for (j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            for (k = wide - 4 * i; k > 0; k--) {
                System.out.print("*");
            }
            System.out.print("\n");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private static final String LOVE = "i love you";


    public static void main(String[] args) {
        int wide = 50;
        Heart heart = new Heart();
        heart.highLevel(wide);
        heart.lowLevel(wide);
        System.out.println("");
        System.out.println("");
        System.out.print("                    ");
        System.out.println(LOVE);
        System.out.println("");
        System.out.println("");
    }
}
