package com.example.ssmdemo.Controller;

import com.example.ssmdemo.Mapper.UserMapper;
import com.example.ssmdemo.POJO.*;
import com.example.ssmdemo.Server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserServer userServer;

    /**
     * 查询所用用户信息
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll() {
        try {
            userServer.findAll();
            return new Result(true,Message.QUEUE_USER_SUCCESS);
        }catch (Exception e){
            return new Result(false,Message.QUEUE_USER_FAIL);
        }
    }

    /**
     * 查询单个用户信息
     * @param id
     * @return
     */
    @RequestMapping("/selectById")
    public Result selectById(Integer id) {
        try {
            User user = userServer.selectById(id);
            return new Result(true,Message.INSERT_USER_SUCCESS,user);
        }catch (Exception e){
            return new Result(false,Message.INSERT_USER_FAIL);
        }
    }

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    @RequestMapping("/insertById")
    public Result insertById(@RequestBody  User user) {
        try {
            userServer.insertById(user);
            return new Result(true, Message.INSERT_USER_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, Message.INSERT_USER_FAIL);
        }
    }

    /**
     * 更改用户信息
     * @param user
     * @return
     */
    @RequestMapping("/updateById")
    public Result updateById(@RequestBody User user) {
        try {
            userServer.updateById(user);
            return new Result(true,Message.EDIT_USER_SUCCESS);
        }catch (Exception e){
            return new Result(false,Message.EDIT_USER_FAIL);
        }

    }

    /**
     * 删除单个用户
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public Result deleteById(int id) {
       try {
           userServer.deleteById(id);
           return new Result(true,Message.DELETE_USER_SUCCESS);
       }catch (Exception e){
           return new Result(false,Message.DELETE_USER_FAIL);
       }
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult result =userServer.findPage(queryPageBean);
        return result;
    }


}
