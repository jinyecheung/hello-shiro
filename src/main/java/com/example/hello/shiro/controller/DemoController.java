package com.example.hello.shiro.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * http://localhost:8080/demo/test
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/test")
    public Object demotest(){
        Map<String,Object> map = new HashMap();
        map.put("ak",123321);
        map.put("bk",456789);
        map.put("ck",678900);
        map.put("dk",890981);
        return map;
    }
}
