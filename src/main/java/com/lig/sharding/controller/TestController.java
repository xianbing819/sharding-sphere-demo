package com.lig.sharding.controller;

import com.lig.sharding.dao.UserMapper;
import com.lig.sharding.entity.UserModel;
import com.lig.sharding.utils.AutoNameUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @className: com.lig.sharding.controller-> TestController
 * @description:
 * @author: lig
 * @createDate: 2022-06-20 20:11
 * @version: 1.0
 * @todo:
 */
@RestController
@AllArgsConstructor
public class TestController {

    private final UserMapper userMapper;

    @GetMapping("/add")
    public Object add(){

        UserModel model = new UserModel();
        model.setName(AutoNameUtil.autoName());
        model.setAge(new Random().nextInt(101));
        model.setSex(new Random().nextInt(2));
        userMapper.insert(model);
        return "ok";
    }



    @GetMapping("/list")
    public Object list(){

        return userMapper.selectAll();
    }


    @GetMapping("/like")
    public Object like(){

        return userMapper.selectLike("%2%");
    }

    @GetMapping("/page")
    public Object page(){

        return userMapper.selectLikePage("%2%");
    }


}
