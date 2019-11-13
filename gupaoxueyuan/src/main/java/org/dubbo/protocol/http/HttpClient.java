/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.dubbo.protocol.http;

import org.apache.commons.io.IOUtils;
import org.dubbo.framework.Invocation;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author lining
 * @version $Id: HttpClient.java, v 0.1 2019-11-12 3:57 PM lining Exp $
 */
public class HttpClient {

    public String post(String hostName, Integer port, Invocation invocation){

        try {
            URL url = new URL("http", hostName, port, "/");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(invocation);
            objectOutputStream.flush();
            objectOutputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();

            return IOUtils.toString(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}