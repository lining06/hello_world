package org.lining.javabase.threadTest;

import java.util.Random;

/**
 * Thread的stop方法可以丢失数据一致性 验证
 * 点外卖 送错地址模拟
 */
public class ThreadStopTest {

    public static User user = new User();

    public static class User{
        private String name;
        private String address;

        public User(){
            name = "同学_0";
            address = "地址_0";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString(){
            return "[name= " + name + ",address= " + address + "]";
        }
    }

    //订单系统：不停的产生用户订单
    public static class ChangeUserThread extends Thread{

        volatile boolean stopped = false;
        public void setStopped(){
            stopped = true;
        }

        @Override
        public void run(){
            while (true){
//                if (stopped){
//                    System.out.println("exit");
//                    break;
//                }
                synchronized (user){
                    //确定id和name
                    int num = new Random().nextInt(100000);
                    String name = "同学_" + num;
                    user.setName(name);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setAddress("地址_" + num);
                }
                Thread.yield();
            }
        }
    }

    //不停地读取user信息并打印出来
    public static class ReadUserThread extends Thread{

        @Override
        public void run(){
            while (true){
                synchronized (user){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //验证user的地址是否正确
                    if (validateUser(user.getName(), user.getAddress())){
                        System.out.println("(good)" + user.toString());
                    }else {
                        System.out.println("(wrong)" + user.toString());
                    }

                }
                Thread.yield();
            }
        }

        //验证user的地址是否正确
        private boolean validateUser(String name, String address) {
            int nameNum = Integer.valueOf(name.substring(name.indexOf("_") + 1, name.length()));
            int addressNum = Integer.valueOf(address.substring(address.indexOf("_") + 1, address.length()));
            if (nameNum != addressNum){
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadUserThread().start();

        while (true){

            ChangeUserThread changeThread = new ChangeUserThread();
            changeThread.start();
            Thread.sleep(1000);

            //调用stop
            changeThread.stop();

            //逻辑控制停止
//            changeThread.setStopped();
        }
    }
}
