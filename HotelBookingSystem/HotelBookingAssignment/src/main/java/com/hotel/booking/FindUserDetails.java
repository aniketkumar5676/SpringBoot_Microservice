package com.hotel.booking;

import java.util.Set;

public class FindUserDetails extends UserData {

	int k;

	int findUserDetail(String useriddata) {

		Set<Integer> set = userid.keySet();
		for (Integer k : set) {

			if (userid.get(k).equalsIgnoreCase(useriddata)) {
				this.k = k;
				break;
			}

		}

		return k;
	}

}
