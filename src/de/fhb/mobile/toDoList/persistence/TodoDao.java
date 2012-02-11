/**
 * 
 */
package de.fhb.mobile.toDoList.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import de.fhb.mobile.toDoList.entity.Todo;
import de.fhb.mobile.toDoList.entity.User;
import de.fhb.mobile.toDoList.persistence.mapper.TodoMapper;

/**
 * @author Patrick
 * 
 */
public class TodoDao extends PersistenceDao<Todo> {

	/**
	 * table name.
	 */
	private static final String TABLE = "todo";
	/**
	 * join table name.
	 */
	private static final String JOINTABLE = "todo_contact";

	/**
	 * 
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public TodoDao() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		super();

	}

	@Override
	public Todo find(Todo entity) throws SQLException {
		String query = "SELECT * FROM " + TABLE + " c WHERE c.id = ?";

		PreparedStatement find = this.connection.prepareStatement(query);
		find.setInt(1, entity.getId());

		return TodoMapper.mapToEntity(find.executeQuery());
	}

	@Override
	public Todo findAll() throws SQLException {
		String query = "SELECT * FROM " + TABLE;
		PreparedStatement find = this.connection.prepareStatement(query);
		return TodoMapper.mapToEntity(find.executeQuery());
	}

	@Override
	public void delete(Todo entity) throws SQLException {
		this.connection.setAutoCommit(false);
		String query = "DELETE FROM " + TABLE + " t WHERE t.id = ?";
		String queryJoin = "DELETE FROM " + JOINTABLE
				+ " tc WHERE tc.todoId = ?";
		PreparedStatement delete = this.connection.prepareStatement(query);
		delete.setInt(1, entity.getId());
		delete.execute();
		delete = this.connection.prepareStatement(queryJoin);
		delete.setInt(1, entity.getId());
		delete.execute();
		this.connection.commit();
		this.connection.setAutoCommit(true);
	}

	@Override
	public void persist(Todo entity) throws SQLException {
		String query = "INSERT INTO "
				+ TABLE
				+ " (`name`,`description`,`finished`,`favourite`,`expire`,`lastChange`,`userId`)"
				+ " VALUES (?,?,?,?,?,?,?)";
		PreparedStatement persist = this.connection.prepareStatement(query);
		persist.setString(1, entity.getName());
		persist.setString(2, entity.getDescription());
		persist.setBoolean(3, entity.isFinished());
		persist.setBoolean(4, entity.isFavourite());
		persist.setDate(5, new java.sql.Date(entity.getExpires().getTime()));
		persist.setDate(6, new java.sql.Date(System.currentTimeMillis()));
		persist.setInt(7, entity.getUser().getId());
		persist.execute();
	}

	@Override
	public void update(Todo entity) throws SQLException {
		String query = "UPDATE "
				+ TABLE
				+ " c SET name = ?,SET description = ?,SET finished = ?,SET favourite = ?,SET expire = ?,SET lastChange = ?,SET userId = ? "
				+ "WHERE c.id = ?)";
		PreparedStatement update = this.connection.prepareStatement(query);
		update.setString(1, entity.getName());
		update.setString(2, entity.getDescription());
		update.setBoolean(3, entity.isFinished());
		update.setBoolean(4, entity.isFavourite());
		update.setDate(5, new java.sql.Date(entity.getExpires().getTime()));
		update.setDate(6, new java.sql.Date(System.currentTimeMillis()));
		update.setInt(7, entity.getUser().getId());
		update.setInt(8, entity.getId());
		update.executeUpdate();
	}

	/**
	 * give all todos from the user.
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<Todo> findAllByUser(User user) throws SQLException {
		String query = "SELECT * FROM " + TABLE + " c WHERE c.userId = ?";
		PreparedStatement find = this.connection.prepareStatement(query);
		find.setInt(1, user.getId());
		return TodoMapper.mapToEntityList(find.executeQuery());
	}

}
