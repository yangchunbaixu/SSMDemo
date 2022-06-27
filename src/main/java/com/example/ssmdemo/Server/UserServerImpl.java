package com.example.ssmdemo.Server;

import com.example.ssmdemo.Mapper.UserMapper;
import com.example.ssmdemo.POJO.PageResult;
import com.example.ssmdemo.POJO.QueryPageBean;
import com.example.ssmdemo.POJO.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServerImpl implements UserServer{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User selectById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public void insertById(User user) {
        userMapper.insertById(user);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void deleteById(int id) {
        userMapper.deleteById(id);
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        //完成分页查询，基于mybatis框架提供的分页助手插件来完成
        PageHelper.startPage(currentPage, pageSize); // 基于本地线程来实现
        Page<User> page = userMapper.selectByCondition(queryString);
        long total = page.getTotal();
        List<User> list = page.getResult();
        return new PageResult(total, list);
    }
}
