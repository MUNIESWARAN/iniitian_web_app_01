package com.khozema.iniitian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khozema.iniitian.dao.CardDetailDAO;
import com.khozema.iniitian.entity.CardDetail;

@Service
public class CardDetailServiceImpl implements CardDetailService {

	@Autowired
	private CardDetailDAO cardDetailDAO;
	
	public void setCardDetailDAO(CardDetailDAO cardDetailDAO) {
		this.cardDetailDAO = cardDetailDAO;
	}
	
	
	@Override
	@Transactional
	public void add(CardDetail card) {
		this.cardDetailDAO.add(card);
	}
}
