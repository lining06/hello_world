package org.lining.javabase.threadTest;

/**
 * Created by lining on 2019/1/12.
 */
public class RunableTest implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("我正在run！第" + i + "次");
            Thread.yield();
        }
        System.out.println("我run完了,我要关闭了");
    }

    public RunableTest(String personName){
        System.out.println(personName + ": 任务已经被创建了");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            RunableTest runableTest = new RunableTest("工号" + i);
            Thread thread = new Thread(runableTest);
            thread.start();

        }
    }
}
