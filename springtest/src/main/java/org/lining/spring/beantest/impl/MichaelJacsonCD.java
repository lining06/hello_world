package org.lining.spring.beantest.impl;

import org.lining.spring.beantest.interfaces.CD;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackageClasses = {CD.class})
@Component
public class MichaelJacsonCD implements CD {
    private String title = "Beat it";

    private String content = "oh, beat it!";

    @Override
    public void play() {
        System.out.println("**************************************************");
        System.out.println(title + " is playing:" + content);
        System.out.println("**************************************************");
    }
}
