package org.wangguang.service;

import java.util.List;

import org.wangguang.entity.Production;

public interface ProductionService {
	
	Production findById(Long id);
	
	List<Production> findAll();

   

}
