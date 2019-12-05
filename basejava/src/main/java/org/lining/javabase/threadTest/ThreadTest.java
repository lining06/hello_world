package org.lining.javabase.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lining on 2018/11/7.
 */
public class ThreadTest {


    static class LiftOff implements Runnable{

        int countDown = 10;

        private static int taskCount = 0;

        private final int id = taskCount ++;

        public String status(){
            return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "),";
        }

        @Override
        public void run() {
            while (countDown-- > 0){
                System.out.println(status());
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
//        threadTest.newThread();
//        threadTest.newCachedThread();
//        threadTest.newFixedThread();
//        threadTest.newSingleThread();
//
    }

    //手动创建多线程
    private void newThread(){
        for (int i=0;i<5;i++){
            Thread t = new Thread(new LiftOff());
            t.start();
        }
        System.out.println("are you ready?");

    }

    //Executor创建线程 通常newCachedThreadPool会创建与所需数量相同的线程
    private void newCachedThread(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        System.out.println("i am ready");

    }

    //Executor创建线程 newFixedThreadPool指定线程数
    private void newFixedThread() {
        ExecutorService exectorService = Executors.newFixedThreadPool(500);
        for (int i = 0; i < 5; i++) {
            exectorService.execute(new LiftOff());
        }
    }

    //创建数量为1的FixedThreadPool
    private void newSingleThread() {
        ExecutorService exectorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exectorService.execute(new LiftOff());
        }
    }
}
