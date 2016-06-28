package com.khozema.iniitian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khozema.iniitian.dao.OrderedItemDAO;
import com.khozema.iniitian.entity.OrderedItem;

@Service
public class OrderedItemServiceImpl implements OrderedItemService {

	@Autowired
	private OrderedItemDAO orderedItemDAO;
	public void setOrderedItemDAO(OrderedItemDAO orderedItemDAO) {
		this.orderedItemDAO = orderedItemDAO;
	}
	
	@Override
	@Transactional
	public void add(OrderedItem orderedItem) {
		this.orderedItemDAO.add(orderedItem);
	}

}
