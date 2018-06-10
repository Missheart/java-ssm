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

import com.entity.Data;
import com.entity.Type;
import com.entity.User;
import com.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@Api("用户登录接口")
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;


    /*@RequestMapping(value = "/getUser" , method = RequestMethod.GET)
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
    }*/

    /**
     * 登录
     * @param username
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @ApiOperation("用户登录")
    @ResponseBody
    @PostMapping(value = "/login")
    public Data login(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @ApiParam(value = "用户名字", required = false) @RequestParam String username
    ) throws Exception{
        //查询用户是否登录
        Object username1 = httpServletRequest.getSession().getAttribute("username");
        if( username != null && username.equals(username1) ){
            return data.setCode(1).setMsg("用户"+username1+"已经登陆");
        }
        //查询用户
        User userByNamePass = userService.getUserByUsername(username);
        if ( userByNamePass == null ) {
            return data.setCode(1).setMsg("用户账号有误");
        }
        httpServletRequest.getSession().setAttribute("username", username);
        return data.setMsg("用户已经登陆成功");
    }

    /*public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("config/spring-config.xml");
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");
        User userById = userService.getUserById(1);
        System.out.println(userById);
    }*/
}