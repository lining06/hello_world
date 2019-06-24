package org.lining.test.socket;

import java.io.*;
import java.net.*;

/**
 * Created by lining on 2019/2/18.
 * socket server
 */
public class TalkServer {


    public static void main(String[] args) {
        int prot = 1011;
    	try{
			ServerSocket server = new ServerSocket(prot);

			Socket socket = server.accept();

			//获取客户端输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			//获取键盘输入流
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

			//获取客户端的输出流
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			while (true){

				//组织语言
				String keyBoard = sin.readLine();
				pw.println(keyBoard);

				//说话
				pw.flush();

				//听话
				System.out.println("[client say]:" + br.readLine());

				if (keyBoard.equals("shutdown")){

					//将键盘输入推到客户端
					pw.println(keyBoard);
					pw.flush();
					break;
				}
			}


			br.close();
			pw.close();
			sin.close();
			socket.close();
			server.close();

    	}catch(Exception e){
    		System.out.println("err" + e.getMessage());
    	}

    }
}
