package org.wangguang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangguang.dao.ProductionDao;
import org.wangguang.entity.Production;
import org.wangguang.service.ProductionService;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionDao productionDao;

	@Override
	public Production findById(Long id) {
		// TODO Auto-generated method stub
		return productionDao.findOne(id);
	}

	@Override
	public List<Production> findAll() {
		// TODO Auto-generated method stub
		return productionDao.findAll();
	}

 

}
