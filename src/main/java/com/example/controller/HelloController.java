package com.example.controller;

import com.entity.Blacklist;
import com.repository.BlackListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/1/14.
 */
@RestController
public class HelloController {

    @Value(value = "${study.secret}")
    private String secret;

    @Value(value = "${study.number}")
    private int id;

    @Value(value = "${study.number}")
    private int age;

    @Value(value = "${study.desc}")
    private String desc;

    @Autowired
    private BlackListRepository blackListRepository;


    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String hello(){
        //return "hello,sprintboot demo.";
        String contextId1 = "auxo-specialty:c9f62ea6-0f59-40ea-99f3-98713480b351_439134f0-9a0a-4cce-9d58-737f5ee04672_3dcf341e-895b-431e-85e9-4d77b295d20e__2079431224.online_exam:84a103f7-e8e4-4ff3-8b60-5fb2b53b85c3";
        String[] keys = contextId1.split("\\.");
        if(keys.length>0){
            //return keys[0];
        }

        String contextId = keys[0];
        contextId = contextId.substring(contextId.indexOf(":")+1);
        String[] ids = contextId.split("_");
        String specialtyId = ids[0];
        String termId = ids[1];
        String couContainerId = ids[2];
        String couModuleId = ids[3];
        String userId = ids[4];
        return specialtyId+"\r\n"+termId+"\r\n"+couContainerId+"\r\n"+couModuleId+"\r\n"+userId;
    }

    // @RequestParam 简单类型的绑定，可以出来get和post
    @RequestMapping(value = "/get")
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "hello zhenqi");
        map.put("name", name);
        map.put("age",age);
        map.put("secret", secret);
        map.put("id", id);
        map.put("desc", desc);
        return map;
    }

    @RequestMapping(value = "/gzip/{src_str}")
    public String gzip(@PathVariable("src_str") String name) {
            return "";
    }


    @RequestMapping(value = "/blacklists/actions/add",method=RequestMethod.POST)
    public String addBlackList(@RequestBody Blacklist blackList) {

        blackListRepository.save(blackList);
        return "done";
    }

    @RequestMapping(value = "/blacklists/actions/search")
    public List<Blacklist> search(@RequestParam Blacklist blackList) {

        return blackListRepository.findByTenantIdAndSchoolId(blackList.getTenantId(),blackList.getSchoolId());
    }

}
