package org.cdx.ssm.controller;

import org.cdx.ssm.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cdx on 2018/1/28.
 */
// Controller注解,标识此类为Controller
@Controller
public class HelloWorldController {
    // Autowired注解：自动装配Spring IOC容器中对象到成员变量
    @Autowired
    private UserMapper userMapper;

    //RequestMapping里面的值用于指定这个方法的访问路径,当url中request过来时会与RequestMapping的值进行匹配,匹配成功则交由对应的方法处理
    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {
        System.out.println("hello"); //打印信息,证明进行了当前方法
        // 返回ModelAndView对象交由Spring MVC处理,第一个参数标识跳转的页面,第二个参数是设置的属性,第三个参数是属性的值
        return new ModelAndView("welcome", "message", "Hello World!");
    }

    @RequestMapping("/userCount")
    public ModelAndView userCount() {
        int userCount = userMapper.getUserCount(); // 调用Mapper方法

        // 返回ModelAndView对象交由Spring MVC处理,第一个参数标识跳转的页面,第二个参数是设置的属性,第三个参数是属性的值
        return new ModelAndView("result", "userCount", userCount);
    }
}
