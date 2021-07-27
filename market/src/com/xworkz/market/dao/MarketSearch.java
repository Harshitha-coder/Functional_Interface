package com.xworkz.market.dao;

import com.xworkz.market.dto.MarketDTO;

@FunctionalInterface
public interface MarketSearch {

	boolean test(MarketDTO marketDTO);
}
