/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.mybatis;

/**
 * @author lining
 * @version $Id: HelloMapper.java, v 0.1 2019-09-09 5:40 PM lining Exp $
 */
public interface HelloMapper {

    HelloWorld selectHello(long id);
}