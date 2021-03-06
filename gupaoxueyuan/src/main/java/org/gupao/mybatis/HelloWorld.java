/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.mybatis;

import lombok.Data;
import lombok.ToString;

/**
 * @author lining
 * @version $Id: HelloWorld.java, v 0.1 2019-09-06 4:13 PM lining Exp $
 */

@Data
@ToString
public class HelloWorld {

    private long id;
    private String name;

    @Override
    public String toString(){
        return "HelloWorld:id=" + id + ",name=" + name;
    }
}