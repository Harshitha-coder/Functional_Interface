package com.xworkz.habba;

import java.util.Collection;

import com.xworkz.habba.dao.HabbaDAO;
import com.xworkz.habba.dao.HabbaDAOImpl;
import com.xworkz.habba.dto.HabbaDTO;
import com.xworkz.habba.dto.constants.Religion;

public class HabbaTester {

	public static void main(String[] args) {

		HabbaDTO habba1 = new HabbaDTO("Holi", "Nam Maneli", 2, Religion.HINDU, "Kheer", true, true);
		HabbaDTO habba2 = new HabbaDTO("Ganesha Chaturthi", "Ella Kade", 10, Religion.HINDU, "Kadubu", true, false);
		HabbaDTO habba3 = new HabbaDTO("Bakrid", "Muslim iro kade", 2, Religion.MUSLIM, "Bakra", false, false);
		HabbaDTO habba4 = new HabbaDTO("Easter Day", "Christian iro kade", 50, Religion.CHRISTIANS, "Mutton", false,
				false);
		HabbaDTO habba5 = new HabbaDTO("Deepavali", "Ella kade", 5, Religion.HINDU, "Kajjaya", true, false);

		HabbaDAO dao = new HabbaDAOImpl();
		dao.ulisu(habba1);
		dao.ulisu(habba2);
		dao.ulisu(habba3);
		dao.ulisu(habba4);
		dao.ulisu(habba5);

		HabbaDTO dtofound = dao.ondunaHuduku((a) -> a.getName().equals("Holi"));
		System.out.println(" found name:" + dtofound);

		dtofound = dao.ondunaHuduku((r) -> r.getNoOfDays() > 5);
		System.out.println(" found noOfDays:" + dtofound);

		dtofound = dao.ondunaHuduku((s) -> s.getRegion().equals("Ella Kade"));
		System.out.println(" found region:" + dtofound);

		dtofound = dao.ondunaHuduku((g) -> g.getReligion().equals(Religion.HINDU));
		System.out.println(" found religion:" + dtofound);

		dtofound = dao.ondunaHuduku((z) -> z.getSpecialFood().equals("Mutton"));
		System.out.println(" found specialFood:" + dtofound);

		Collection<HabbaDTO> temp = dao.yellavanuHuduku((o) -> o.getNoOfDays() >= 2);
		for (HabbaDTO habbaDTO : temp) {
			System.out.println("found all:" + habbaDTO);
		}
	}

}
