package com.xworkz.habba.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.xworkz.habba.dto.HabbaDTO;
import com.xworkz.market.dto.MarketDTO;

public class HabbaDAOImpl implements HabbaDAO {

	Collection<HabbaDTO> collection = new ArrayList<HabbaDTO>();

	@Override
	public boolean ulisu(HabbaDTO dto) {
		boolean added = this.collection.add(dto);
		return added;
	}

	@Override
	public HabbaDTO ondunaHuduku(HabbaSearch search) {
		HabbaDTO find = null;
		List<HabbaDTO> list = new ArrayList<HabbaDTO>();
		collection.forEach((a) -> {
			if (search.huduku(a)) {
				list.add(a);
			}
		});
		return list.get(0);
	}

	@Override
	public Collection<HabbaDTO> yellavanuHuduku(HabbaSearch search) {
		Collection<HabbaDTO> findAll = new ArrayList<HabbaDTO>();
		collection.forEach((s) -> {
			if (search.huduku(s)) {
				findAll.add(s);
				return;
			}
		});

		return findAll;
	}
}
