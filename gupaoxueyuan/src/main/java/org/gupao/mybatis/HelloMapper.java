/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.mybatis;

import org.apache.ibatis.annotations.Select;

/**
 * @author lining
 * @version $Id: HelloMapper.java, v 0.1 2019-09-09 5:40 PM lining Exp $
 */
public interface HelloMapper {

//    @Select("select * from helloworld where id = #{id}")
    HelloWorld selectHello(long id);
}