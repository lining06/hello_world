package org.lining.test.utilTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lining on 2018/7/3.
 */
public class ContainsTest {


    public static void main(String[] args) {
        ContainsTest c = new ContainsTest();
        c.testContains();
    }


    public void testContains(){

        List<Long> productIdsMinos = new ArrayList<>();
        productIdsMinos.add(400076L);
        productIdsMinos.add(400077L);
        productIdsMinos.add(400078L);
        //服务包都有混合送，且不一致时，解绑物流其它标品
        List<Long> remove = new ArrayList<>();
        for (Long productId : productIdsMinos) {
            if (productId == 400076L){
                System.out.println("remove " + productId);
                remove.add(productId);
            }
        }
        productIdsMinos.removeAll(remove);
        for (Long productIdsMino : productIdsMinos) {
            System.out.println("left " + productIdsMino);
        }

    }
}
