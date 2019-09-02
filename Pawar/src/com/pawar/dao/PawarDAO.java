package com.pawar.dao;

import com.pawar.entity.PawarEmployee;

public class PawarDAO implements PawarDAOInterface {

	private PawarDAO() {}
	public static PawarDAOInterface createObjectDAO() {
		// TODO Auto-generated method stub
		return new PawarDAO();
	}
	@Override
	public int createProfileDAO(PawarEmployee pe) {
		// TODO Auto-generated method stub
		return 1;
	}

}
