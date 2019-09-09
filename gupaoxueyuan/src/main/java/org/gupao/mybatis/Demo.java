/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lining
 * @version $Id: Demo.java, v 0.1 2019-09-06 3:41 PM lining Exp $
 */
public class Demo {

    public static SqlSession getSqlSession() throws FileNotFoundException {
        //配置文件
        String resource = "mybatisConfit.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            return sqlSession;
        } catch (IOException e) {
            System.out.println("get input stream err");
            return null;
        }

    }

    public static SqlSession getSqlSessionFromJava(){
//        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
//        TransactionFactory transactionFactory =
//                new JdbcTransactionFactory();
//        Environment environment =
//                new Environment("development", transactionFactory, dataSource);
//        Configuration configuration = new Configuration(environment);
//        configuration.addMapper(BlogMapper.class);
//        SqlSessionFactory sqlSessionFactory =
//                new SqlSessionFactoryBuilder().build(configuration);
        return null;
    }

    public static void main(String[] args) {

        try {
            SqlSession sqlSession = getSqlSession();

            //第一种方法
            HelloMapper mapper = sqlSession.getMapper(HelloMapper.class);
            String name = mapper.selectHello(1);
            System.out.println(name);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



}