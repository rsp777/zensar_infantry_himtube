package com.pawar.service;

import com.pawar.dao.PawarDAO;
import com.pawar.dao.PawarDAOInterface;
import com.pawar.entity.PawarEmployee;

public class PawarService implements PawarServiceInterface {

	private PawarService() {}
	public static PawarServiceInterface createServiceObject() {
		// TODO Auto-generated method stub
		return new PawarService();
	}

	@Override
	public int createProfile(PawarEmployee pe) {
		PawarDAOInterface pd = PawarDAO.createObjectDAO();
		return pd.createProfileDAO(pe);
	}

}
