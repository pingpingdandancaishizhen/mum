package org.wangguang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangguang.dao.UserDao;
import org.wangguang.entity.User;
import org.wangguang.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findByName(String name) {
        // TODO Auto-generated method stub
        return userDao.selectByName(name);
    }

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        userDao.save(user);
    }

}
