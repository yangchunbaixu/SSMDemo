package com.example.ssmdemo.Mapper;

import com.example.ssmdemo.POJO.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface UserMapper {
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
    // 条件查询
    Page<User> selectByCondition(String queryString);

}
