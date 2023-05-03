package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.utils.ConnectionUtils;

public class UserDaoImpl implements UserDao {

	private static String READ_ALL = "select * from user";
	private static String CREATE = "insert into user(`first_name`,`last_name`,`email`,`password`,`access_level`) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from user where id=?";
	private static String UPDATE_BY_ID = "update user set first_name=?, last_name=?, email=?, password=?, access_level=? where id=?";
	private static String DELETE_BY_ID = "delete from user where id=?";
	private static String READ_BY_EMAIL = "select * from user where email=?";

	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	private Connection connection;
	private PreparedStatement statement;

	public UserDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public User create(User user) {
		try {
			statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getAccessLevel());
			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();
			rs.next();
			user.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return user;
	}

	@Override
	public List<User> readAll() {
		List<User> listOfUsers = new ArrayList<>();
		try {
			statement = connection.prepareStatement(READ_ALL);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Integer userId = result.getInt("id");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String email = result.getString("email");
				String password = result.getString("password");
				String accessLevel = result.getString("access_level");

				listOfUsers.add(new User(userId, firstName, lastName, email, password, accessLevel));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return listOfUsers;
	}

	@Override
	public User read(Integer id) {
		User user = null;
		try {
			statement = connection.prepareStatement(READ_BY_ID);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Integer userId = result.getInt("id");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String email = result.getString("email");
				String password = result.getString("password");
				String accessLevel = result.getString("access_level");

				user = new User(userId, firstName, lastName, email, password, accessLevel);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return user;
	}

	@Override
	public User update(User user) {
		try {
			statement = connection.prepareStatement(UPDATE_BY_ID);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getAccessLevel());
			statement.setInt(6, user.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return user;
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

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		LOGGER.info("Getting user by email from database...");
		try {
			statement = connection.prepareStatement(READ_BY_EMAIL);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			result.next();

			Integer userId = result.getInt("id");
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			String password = result.getString("password");
			String accessLevel = result.getString("access_level");
			user = new User(userId, firstName, lastName, email, password, accessLevel);

		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return user;

	}

}