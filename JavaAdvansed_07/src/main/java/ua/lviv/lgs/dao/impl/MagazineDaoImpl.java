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

import ua.lviv.lgs.dao.MagazineDao;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.utils.ConnectionUtils;

public class MagazineDaoImpl implements MagazineDao {

	private static String READ_ALL = "select * from magazine";
	private static String CREATE = "insert into magazine(`name`,`publish_date`,`subscribe_price`) values (?,?,?)";
	private static String READ_BY_ID = "select * from magazine where id=?";
	private static String UPDATE_BY_ID = "update magazine set name=?, publish_date=?, subscribe_price=? where id=?";
	private static String DELETE_BY_ID = "delete from magazine where id=?";

	private static Logger LOGGER = Logger.getLogger(MagazineDaoImpl.class);
	
	private Connection connection;
	private PreparedStatement statement;

	public MagazineDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Magazine create(Magazine magazine) {
		try {
			statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, magazine.getName());
			statement.setDate(2,Date.valueOf(magazine.getPublishDate()));
			statement.setDouble(3, magazine.getSubscribePrice());
			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();
			rs.next();
			magazine.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		
		return magazine;
	}

	@Override
	public List<Magazine> readAll() {
		List<Magazine> listOfMagazines = new ArrayList<>();
		try {
			statement = connection.prepareStatement(READ_ALL);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Integer magazineId = result.getInt("id");
				String magazineName = result.getString("name");
				LocalDate publishDate = result.getDate("publish_date").toLocalDate();
				Double subscribePrice = result.getDouble("subscribe_price");

				listOfMagazines.add(new Magazine(magazineId, magazineName, publishDate, subscribePrice));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return listOfMagazines;
	}

	@Override
	public Magazine read(Integer id) {
		Magazine magazine = null;
		try {
			statement = connection.prepareStatement(READ_BY_ID);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Integer magazineId = result.getInt("id");
				String magazineName = result.getString("name");
				LocalDate publishDate = result.getDate("publish_date").toLocalDate();
				Double subscribePrice = result.getDouble("subscribe_price");

				magazine = new Magazine(magazineId, magazineName, publishDate, subscribePrice);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return magazine;
	}

	@Override
	public Magazine update(Magazine magazine) {
		try {
			statement = connection.prepareStatement(UPDATE_BY_ID);
			statement.setString(1, magazine.getName());
			statement.setDate(2, Date.valueOf(magazine.getPublishDate()));
			statement.setDouble(3, magazine.getSubscribePrice());
			statement.setInt(4, magazine.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		
		return magazine;
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