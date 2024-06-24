package com.southwind.repository;

import com.southwind.entity.User;

import java.util.List;

public interface UserRepository {

    /**
     *这里使用动态sql直接保存到数据库
     */
    public List<User> findAll(int index, int limit);
    public int count();
    public void save(User user);
    public void deleteById(long id);
}
