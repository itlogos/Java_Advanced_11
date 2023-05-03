package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.SubscribeDao;
import ua.lviv.lgs.dao.impl.SubscribeDaoImpl;
import ua.lviv.lgs.domain.Subscribe;
import ua.lviv.lgs.service.SubscribeService;

public class SubscribeServiceImpl implements SubscribeService {

	private SubscribeDao subscribeDao;

	public SubscribeServiceImpl() {
		try {
			subscribeDao = new SubscribeDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Subscribe create(Subscribe subscribe) {
		return subscribeDao.create(subscribe);
	}

	@Override
	public List<Subscribe> readAll() {
		return subscribeDao.readAll();
	}

	@Override
	public Subscribe read(Integer id) {
		return subscribeDao.read(id);
	}

	@Override
	public Subscribe update(Subscribe subscribe) {
		return subscribeDao.update(subscribe);
	}

	@Override
	public void delete(Integer id) {
		subscribeDao.delete(id);
	}

}