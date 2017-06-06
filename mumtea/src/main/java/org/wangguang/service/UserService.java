package org.wangguang.service;

import java.util.List;

import org.wangguang.entity.User;

public interface UserService {

    List<User> findByName(String name);

    public void save(User user);

}
