package com.example.ssmdemo.Server;

import com.example.ssmdemo.POJO.PageResult;
import com.example.ssmdemo.POJO.QueryPageBean;
import com.example.ssmdemo.POJO.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserServer {
    // 查全部
    public List<User> findAll();
    // 查询
    public User selectById(int id);
    // 新增
    public void insertById(User user);
    // 修改
    public void updateById(User user);
    // 删除
    public void deleteById(int id);
    // 分页查询
    PageResult findPage(QueryPageBean queryPageBean);

}
