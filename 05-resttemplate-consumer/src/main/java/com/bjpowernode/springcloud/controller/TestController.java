package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/getForEntity01")
    public String getForEntity01() {
        ResponseEntity<User> forEntity = restTemplate.getForEntity("http://localhost:8081/getForEntity01", User.class);
        User body = forEntity.getBody();
        return "第一个springcloud的服务消费者---" + body;
    }

    @RequestMapping("/getForEntity02")
    public String getForEntity02() {
        ResponseEntity<List> forEntity = restTemplate.getForEntity("http://localhost:8081/getForEntity02", List.class);
        List body = forEntity.getBody();
        for (Object o : body) {
            System.out.println(body.getClass());
        }
        return "第一个springcloud的服务消费者---" + body;
    }

    /**
     * 不推荐使用
     * @return
     */
    @RequestMapping("/getForEntityParams01")
    public String getForEntitParams01() {
        String url ="http://localhost:8081/getForEntityParams01?id={0}&name={1}&age={2}";
        Object [] params={2L,"李四",24};
        ResponseEntity<User> forEntity = restTemplate.getForEntity(url, User.class,params);
        User body = forEntity.getBody();

        return "第一个springcloud的服务消费者---" + body;
    }

    @RequestMapping("/getForEntityParams02")
    public String getForEntitParams02() {
        String url ="http://localhost:8081/getForEntityParams02?id={id}&name={name}&age={age}";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id",3L);
        params.put("name","王五");
        params.put("age",15);
        ResponseEntity<User> forEntity = restTemplate.getForEntity(url,User.class,params);
        User body = forEntity.getBody();

        return "第一个springcloud的服务消费者---" + body;
    }


    @RequestMapping("/getForObject")
    public String getForObject() {
        String url ="http://localhost:8081/getForObject";
       User user = restTemplate.getForObject(url,User.class);

        return "第一个springcloud的服务消费者---"+user;
    }

    @RequestMapping("/postForObject")
    public String postForObject() {
        LinkedMultiValueMap params = new LinkedMultiValueMap();
        params.add("name","神奇");
        params.add("id",5L);
        params.add("age",22);
        String url ="http://localhost:8081/postForObject";
        User user = restTemplate.postForObject(url,params,User.class);

        return "服务消费者---"+user;
    }


    @RequestMapping("/put")
    public String put() {
        String url ="http://localhost:8081/put";
        LinkedMultiValueMap params = new LinkedMultiValueMap<>();
        params.add("id",5L);
        params.add("name","鑫");
        params.add("age",11);
        restTemplate.put(url,params);


        return "服务消费者---执行了put的请求";
    }


    @RequestMapping("/delete")
    public String delete() {
        String url ="http://localhost:8081/delete?id={0}";

        restTemplate.delete(url,8L);


        return "服务消费者---执行了delete的请求";
    }
}
