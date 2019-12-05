package org.lining.javabase.utilTest;

import java.util.*;

/**
 * Created by lining on 2018/5/6.
 */
public class ListCompareTest {


    public static void main(String args[]){
        System.out.print(Boolean.TRUE.toString());
    }

    //判断实体List的Id是否全部相同
    public boolean compareIds(){
        List<AEntity> aEntities = this.getAEntities();
        List<BEntity> bEntities = this.getBEntities();

        Set set = new HashSet();
        set.add(1);


        return true;
    }

    //获取A实体List
    private List<AEntity> getAEntities(){
        List<AEntity> aEntities = new ArrayList<>();

        AEntity aEntity1 = new AEntity();
        aEntity1.setaId(123L);
        aEntities.add(aEntity1);

        AEntity aEntity2 = new AEntity();
        aEntity2.setaId(1234L);
        aEntities.add(aEntity2);

        return aEntities;
    }

    //获取B实体系列
    private List<BEntity> getBEntities(){
        List<BEntity> bEntities = new ArrayList<>();

        BEntity bEntity1 = new BEntity();
        bEntity1.setbId(123L);
        bEntities.add(bEntity1);

        BEntity bEntity2 = new BEntity();
        bEntity2.setbId(1234L);
        bEntities.add(bEntity2);

        return bEntities;
    }


    //A实体类
    class AEntity{
        private Long aId;

        public Long getaId() {
            return aId;
        }

        public void setaId(Long aId) {
            this.aId = aId;
        }
    }

    //B实体类
    class BEntity{
        private Long bId;

        public Long getbId() {
            return bId;
        }

        public void setbId(Long bId) {
            this.bId = bId;
        }
    }


}
