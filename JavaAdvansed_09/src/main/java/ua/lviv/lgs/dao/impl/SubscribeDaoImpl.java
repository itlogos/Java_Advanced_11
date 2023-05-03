package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.SubscribeDao;
import ua.lviv.lgs.domain.Subscribe;
import ua.lviv.lgs.utils.ConnectionUtils;

public class SubscribeDaoImpl implements SubscribeDao {

	private static String READ_ALL = "select * from subscribe";
	private static String CREATE = "insert into subscribe(`user_id`,`magazine_id`, `subscribe_date`) values (?,?,?)";
	private static String READ_BY_ID = "select * from subscribe where id=?";
	private static String UPDATE_BY_ID = "update subscribe set user_id=?, magazine_id=?, subscribe_date=? where id=?";
	private static String DELETE_BY_ID = "delete from subscribe where id=?";

	private static Logger LOGGER = Logger.getLogger(SubscribeDaoImpl.class);
	
	private Connection connection;
	private PreparedStatement statement;

	public SubscribeDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Subscribe create(Subscribe subscribe) {
		try {
			statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, subscribe.getUserId());
			statement.setInt(2, subscribe.getMagazineId());
			statement.setDate(3, new Date(subscribe.getSubscribeDate().getTime()));
			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();
			rs.next();
			subscribe.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return subscribe;
	}

	@Override
	public List<Subscribe> readAll() {
		List<Subscribe> listOfSubscribes = new ArrayList<>();
		try {
			statement = connection.prepareStatement(READ_ALL);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Integer subscribeId = result.getInt("id");
				Integer userId = result.getInt("user_id");
				Integer magazineId = result.getInt("magazine_id");
				Date subscribeDate = result.getDate("subscribe_date");

				listOfSubscribes.add(new Subscribe(subscribeId, userId, magazineId, subscribeDate));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return listOfSubscribes;
	}

	@Override
	public Subscribe read(Integer id) {
		Subscribe subscribe = null;
		try {
			statement = connection.prepareStatement(READ_BY_ID);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Integer subscribeId = result.getInt("id");
				Integer userId = result.getInt("user_id");
				Integer magazineId = result.getInt("magazine_id");
				Date subscribeDate = result.getDate("subscribe_date");

				subscribe = new Subscribe(subscribeId, userId, magazineId, subscribeDate);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return subscribe;
	}

	@Override
	public Subscribe update(Subscribe subscribe) {
		try {
			statement = connection.prepareStatement(UPDATE_BY_ID);
			statement.setInt(1, subscribe.getUserId());
			statement.setInt(2, subscribe.getMagazineId());
			statement.setDate(3, new Date(subscribe.getSubscribeDate().getTime()));
			statement.setInt(4, subscribe.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return subscribe;
	}

	@Override
	public void delete(Integer id) {
		try {
			statement = connection.prepareStatement(DELETE_BY_ID);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

}