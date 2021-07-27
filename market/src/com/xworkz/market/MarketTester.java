package com.xworkz.market;

import java.util.Collection;

import com.xworkz.market.dao.MarketDAO;
import com.xworkz.market.dao.MarketDAOImpl;
import com.xworkz.market.dto.MarketDTO;
import com.xworkz.market.dto.constants.MarketType;

public class MarketTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarketDTO market1 = new MarketDTO("Super Market", "Chickballapur", 5, MarketType.BUSINESS);
		MarketDTO market2 = new MarketDTO("APMC", "Hoskote", 30, MarketType.PERFECT_COMPETITION);
		MarketDTO market3 = new MarketDTO("Vishal Mart", "Yashwantpur", 10, MarketType.BUSINESS);
		MarketDTO market4 = new MarketDTO("Healthy Harvest", "Banglore", 5, MarketType.AGRICULTURE);
		MarketDTO market5 = new MarketDTO("SunSet", "Devenahalli", 10, MarketType.AGRICULTURE);

		MarketDAO dao = new MarketDAOImpl();

		dao.save(market1);
		dao.save(market2);
		dao.save(market3);
		dao.save(market4);
		dao.save(market5);

		MarketDTO dtoFound = dao.find((a) -> a.getName().equals("APMC"));
		System.out.println("name found:" + dtoFound);

		dtoFound = dao.find((r) -> r.getLocation().equals("Chickballapur"));
		System.out.println("location found:" + dtoFound);

		dtoFound = dao.find((w) -> w.getNoOfShops() >= 10);
		System.out.println("noOfShops found:" + dtoFound);

		dtoFound = dao.find((d) -> d.getType().equals(MarketType.BUSINESS));
		System.out.println("type found:" + dtoFound);

		Collection<MarketDTO> findAll = dao.findAll((s) -> s.getNoOfShops() >= 5);
		for (MarketDTO marketDTO : findAll) {
			System.out.println("found:" + marketDTO);
		}
	}

}
