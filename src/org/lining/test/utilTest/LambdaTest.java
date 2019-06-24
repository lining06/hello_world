package org.lining.test.utilTest;

/**
 * Created by lining on 2018/11/8.
 */
public class LambdaTest {

    public static void workerTest(WorkerInterface workerInterface){
        workerInterface.testWorker();
    }
    public static void main(String[] args) {

        LambdaTest.workerTest(new WorkerInterface(){
            @Override
            public void testWorker(){
                System.out.println("good");
            }
        });

        workerTest(() -> System.out.println("very good"));
    }

    //函数式接口
    @FunctionalInterface
    interface WorkerInterface{
        void testWorker();
    }


}
