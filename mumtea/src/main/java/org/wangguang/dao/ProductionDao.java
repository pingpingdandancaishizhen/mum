package org.wangguang.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.wangguang.entity.Production;
import org.wangguang.entity.User;

@Repository
public interface ProductionDao extends JpaRepository<Production, Long> {

   

}
