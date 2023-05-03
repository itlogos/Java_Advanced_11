package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.MagazineDao;
import ua.lviv.lgs.dao.impl.MagazineDaoImpl;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.service.MagazineService;


public class MagazineServiceImpl implements MagazineService {
	private static Logger LOGGER = Logger.getLogger(MagazineServiceImpl.class);
	private static MagazineService magazineServiceImpl;
	private MagazineDao magazineDao;

	public MagazineServiceImpl() {
		try {
			magazineDao = new MagazineDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}
	public static MagazineService getMagazineService() {
		if (magazineServiceImpl == null) {
			magazineServiceImpl = new MagazineServiceImpl();
		}

		return magazineServiceImpl;
	}
	@Override
	public Magazine create(Magazine magazine) {
		return magazineDao.create(magazine);
	}

	@Override
	public List<Magazine> readAll() {
		return magazineDao.readAll();
	}

	@Override
	public Magazine read(Integer id) {
		return magazineDao.read(id);
	}

	@Override
	public Magazine update(Magazine magazine) {
		return magazineDao.update(magazine);
	}

	@Override
	public void delete(Integer id) {
		magazineDao.delete(id);
	}

}