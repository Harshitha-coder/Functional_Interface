package com.xworkz.market.dao;

import java.util.Collection;

import com.xworkz.market.dto.MarketDTO;

public interface MarketDAO {

	boolean save(MarketDTO dto);

	MarketDTO find(MarketSearch marketSearch);

	Collection<MarketDTO> findAll(MarketSearch marketSearch);
}
