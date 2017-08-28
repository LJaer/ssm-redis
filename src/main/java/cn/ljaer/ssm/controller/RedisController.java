package cn.ljaer.ssm.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ljaer.ssm.redis.UtilJedis;

@Controller
@RequestMapping("/redis")
public class RedisController {
    
    @Autowired
    private UtilJedis utilJedis;

    @RequestMapping("getRedis")
    public void selectByPrimaryKey(HttpServletResponse response) throws  Exception{
    	System.out.println("redis设置为："+utilJedis.set("name1", "zhangsan"));
    	System.out.println("redis读取为："+utilJedis.get("name1"));
    	
    	response.getWriter().write(utilJedis.get("name1"));
    }
	
}
