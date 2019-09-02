package com.himtube.service;

import com.himtube.dao.HimTubeDAO;
import com.himtube.dao.HimTubeDAOInterface;
import com.himtube.entity.HimTubeUser;

public class HimTubeService implements HimTubeServieInterface{

	public static HimTubeServieInterface createServiceObject(String string) {
		// TODO Auto-generated method stub
		return new HimTubeService();
	}

	@Override
	public int createProfile(HimTubeUser htu) {
		HimTubeDAOInterface hdi = HimTubeDAO.createDAOobject("hdi");
		return hdi.createProfileDAO(htu);
	}

}
