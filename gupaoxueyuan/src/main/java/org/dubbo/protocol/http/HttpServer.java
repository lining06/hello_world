/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.dubbo.protocol.http;

import org.apache.catalina.Context;
import org.apache.catalina.Engine;
import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;

/**
 * @author lining
 * @version $Id: HttpServer.java, v 0.1 2019-11-12 11:08 AM lining Exp $
 */
public class HttpServer {

    public void start(String hostName, Integer port){
        Tomcat tomcat = new Tomcat();
        Server server = tomcat.getServer();

        Service service = server.findService("Tomcat");
        Connector connector = new Connector();
        connector.setPort(port);
        connector.setURIEncoding("UTF-8");

        Engine engine = new StandardEngine();
        engine.setName("Catalina");
        engine.setDefaultHost(hostName);

        Host host = new StandardHost();
        host.setName(hostName);

        Context context = new StandardContext();
        context.setPath("");
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        //添加servlet
        tomcat.addServlet(context, "dispatcher", new DispatcherServlet());
        context.addServletMappingDecoded("/*", "dispatcher");

        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}