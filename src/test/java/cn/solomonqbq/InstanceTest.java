package cn.solomonqbq;

import cn.solomonqbq.bean.Instance;
import cn.solomonqbq.bean.InstanceParam;
import cn.solomonqbq.business.mybatis.InstanceBussiness;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
* Created by qinbaoqi on 15-8-13.
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/ApplicationContext.xml")
public class InstanceTest {
    @Autowired
    InstanceBussiness instanceBussiness = null;

    @Test
    public void test(){
        try{
//            InstanceParam instanceParam = new InstanceParam();
//            List<Instance> instances = instanceBussiness.selectInstanceList(instanceParam);
//            for (Instance i : instances){
//                System.out.println(i.getName());
//            }

            Instance instance=instanceBussiness.getInstanceByKey("88a77e6164a5cc0c8b49535a05f25a44");
            System.out.println(instance.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
