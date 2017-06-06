package org.wangguang.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.wangguang.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

   @Query("select id,name,age,datetime from User  where name = ?1")
   public  List<User> selectByName(String name);

}
