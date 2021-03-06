/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.dubbo.framework;

import lombok.Data;

/**
 * @author lining
 * @version $Id: Url.java, v 0.1 2019-11-08 5:41 PM lining Exp $
 */
@Data
public class Url {

    private String hostName;

    private Integer port;

    public Url(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
    }

    public static Url getUrl(){
        return new Url("localhost", 8080);
    }
}