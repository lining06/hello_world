package org.lining.javabase.socket;

import java.io.*;
import java.net.*;

/**
 * Created by lining on 2019/2/18.
 * socket server
 */
public class TalkClient {


    public static void main(String[] args) {
        
        try{
	        Socket socket = new Socket("127.0.0.1", 1011);
	        System.out.println("i am connected");
	        //获取键盘输入的流
	        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

	        //获取服务端输入的流
	        BufferedReader sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	        //获取输出到服务端的流
	        PrintWriter pw = new PrintWriter(socket.getOutputStream());

            while (true){

                //听话
                String serverWords = sin.readLine();
                System.out.println("[server say]:" + serverWords);

                //组织语言
                pw.println(cin.readLine());

                //说话
                pw.flush();

                if (serverWords.equals("shutdown")){
                    break;
                }
            }

	        pw.close();
	        sin.close();
	        cin.close();
	        socket.close();

    	}catch(Exception e){
    		System.out.println("err" + e.getMessage());
    	}

    }
}
