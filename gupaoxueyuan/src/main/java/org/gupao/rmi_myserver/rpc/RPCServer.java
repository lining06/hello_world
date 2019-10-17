/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.rmi_myserver.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lining
 * @version $Id: RPCServer.java, v 0.1 2019-10-16 5:40 PM lining Exp $
 */
public class RPCServer {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(final Object service, int port){
        ServerSocket serverSocket = null;

        try {
            //启动一个服务监听
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(socket, service));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }
        }
    }
}