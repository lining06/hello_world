package org.lining.javabase.utilTest;

/**
 * 数组(初始化、排序算法、数三减一算法)
 */
public class ArrayTest {

    public static void main(String[] args) {

//        initType();

//        System.out.println(sequenceOrderBy(args));

        count3Reduct1();
    }

    //数三减一算法实现
    private static void count3Reduct1(){
        //100个人 全在圈里
        boolean[] all = new boolean[500];
        for (int i = 0; i < all.length; i++) {
            all[i] = true;
        }

        //计数器（当前数到几）
        int current = 1;
        //当前位置
        int index = 0;
        //圈内剩余的人
        int leftCount = all.length;

        while (leftCount > 1){
            if (all[index] == true){
                if (current == 3){
                    all[index] = false;
                    leftCount --;
                    current = 0;
                }
                current ++;
            }
            index ++;
            if (index == all.length){
                index = 0;
            }
        }

        for (int i = 0; i < all.length; i++) {
            if (all[i] == true){
                System.out.println(i);
            }
        }

    }


    //排序算法
    private static String sequenceOrderBy(String[] arrays){
        //转换为int[]
        if (arrays == null){
            return "";
        }
        int[] arraysInt = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            arraysInt[i] = Integer.valueOf(arrays[i]);
        }

        //排序
        for (int i = 0; i < arraysInt.length; i++){
            for (int j = i+1; j < arraysInt.length; j++){
                if (arraysInt[j] < arraysInt[i]){
                    int tmp = arraysInt[i];
                    arraysInt[i] = arraysInt[j];
                    arraysInt[j] = tmp;
                }
            }
        }

        //转换为String
        String out = "";
        for (int i : arraysInt) {
            out += i;
        }

        return out;
    }

    //数据初始化的2种方式
    private static void initType(){

        //动态初始化
        int a[] = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        System.out.println(a[2]);

        //静态初始化
        int b[] = {1,2,3};
        System.out.println(b[2]);

    }
}
