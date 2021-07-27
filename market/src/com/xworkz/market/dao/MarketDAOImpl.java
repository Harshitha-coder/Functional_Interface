package com.xworkz.market.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.xworkz.market.dto.MarketDTO;

public class MarketDAOImpl implements MarketDAO {

	List<MarketDTO> list = new ArrayList<MarketDTO>();

	@Override
	public boolean save(MarketDTO dto) {
		boolean added = this.list.add(dto);
		return added;
	}

	@Override
	public MarketDTO find(MarketSearch marketSearch) {
		MarketDTO find = null;
		Iterator<MarketDTO> iterator = list.iterator();
		while (iterator.hasNext()) {
			MarketDTO dto = iterator.next();
			if (marketSearch.test(dto)) {
				find = dto;
				break;
			}
		}

		return find;
	}

	@Override
	public Collection<MarketDTO> findAll(MarketSearch marketSearch) {
		Iterator<MarketDTO> iterator = list.iterator();
		Collection<MarketDTO> findAll = new ArrayList<MarketDTO>();
		while (iterator.hasNext()) {
			MarketDTO dto = iterator.next();
			if (marketSearch.test(dto)) {
				findAll.add(dto);
			}

		}
		return findAll;
	}
}