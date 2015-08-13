package cn.solomonqbq.controller;

import cn.solomonqbq.bean.Instance;
import cn.solomonqbq.business.mybatis.InstanceBussiness;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinbaoqi on 15-8-13.
 */
@Controller
public class IntanceController {

    @Resource
    InstanceBussiness instanceBussiness;

    @RequestMapping("/hello")
    @ResponseBody
    public Object test(String param){
        Instance i= null;
        try {
            i = instanceBussiness.getInstanceByKey("88a77e6164a5cc0c8b49535a05f25a44");
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("/world2")
    @ResponseBody
    public Object test2(String param){
        Map<String,String> m = new HashMap<String, String>();
        m.put("name","solo");
        return m;
    }


    @RequestMapping(value = "/instance/{id}" ,method = RequestMethod.GET)
    @ResponseBody
    public Object test3(@PathVariable("id") String id){
        Instance i= null;
        try {
            i = instanceBussiness.getInstanceByKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping(value = "/instance/create" ,method = RequestMethod.POST )
    @ResponseBody
    public Object test4(@RequestBody Map<String,String> param){
        //client test :curl -H "Content-type: application/json" -X POST -d '{"name":"abc"}' http://127.0.0.1:9999/instance/create
        System.out.println(param);
        return null;
    }
}
