/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     2018/6/8 15:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.controller;

import com.entity.Type;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/6/8
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser" , method = RequestMethod.GET)
    public void getUser(@RequestParam("id") Integer id){
        System.out.println(id);

        User userById = userService.getUserById(1);
        System.out.println(userById);
    }

    @RequestMapping("/getUser1/{id}")
    public String getUser1(@PathVariable("id") Integer id){
        System.out.println(id);
        return "user/getUser";
    }

    //返回json格式数据
    @ResponseBody

    //映射url路径
    @RequestMapping("/setUser")

    //@ModelAttribute 请求数据绑定
    public Map<String, Object> setUser(@ModelAttribute User user){

        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("k", "ss");
        stringObjectHashMap.put("kd", "sss");
        stringObjectHashMap.put("user", user);

        return stringObjectHashMap;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("config/spring-config.xml");
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");
        User userById = userService.getUserById(1);
        System.out.println(userById);
    }
}