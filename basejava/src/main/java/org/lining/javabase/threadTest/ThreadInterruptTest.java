package org.lining.javabase.threadTest;

/**
 * 线程中断测试
 * sleep时被中断，会清除中断标记，导致程序继续执行
 */
public class ThreadInterruptTest {

    Thread thread = new Thread(){

        @Override
        public void run(){
            while (true){
                System.out.println("thread start");
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("i am interrupted");
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                    //需再次中断才会停止，否则一直执行
                    //Thread.currentThread().interrupt();
                }
            }

        }
    };

    public static void main(String[] args) {
        ThreadInterruptTest threadInterruptTest = new ThreadInterruptTest();
        threadInterruptTest.thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadInterruptTest.thread.interrupt();
    }
}
