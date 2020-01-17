/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package org.lining.javabase.lambda;

/**
 * @author lining 函数式接口
 * @version $Id: TestInterface.java, v 0.1 2020-01-15 5:28 PM lining Exp $
 */
@FunctionalInterface
public interface TestInterface {


    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    void accept(Integer t);
}