/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.rmi_myclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author lining
 * @version $Id: TCPTransport.java, v 0.1 2019-10-16 6:10 PM lining Exp $
 */
public class TCPTransport {

    private String host;

    private int port;

    public TCPTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocket(){
        System.out.println("创建一个新的连接");
        Socket socket = null;

        try {
            socket = new Socket(host, port);
        }catch (Exception e){
            System.out.println("连接建立失败");
            e.printStackTrace();
        }
        return socket;
    }

    public Object send(RPCRequest rpcRequest){
        try {
            Socket socket = newSocket();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Object result = inputStream.readObject();

            inputStream.close();
            objectOutputStream.close();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}