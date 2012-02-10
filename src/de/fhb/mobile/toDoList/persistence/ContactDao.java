package de.fhb.mobile.toDoList.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import de.fhb.mobile.toDoList.entity.Contact;
import de.fhb.mobile.toDoList.persistence.mapper.ContactMapper;

/**
 * 
 * @author Patrick
 * 
 */
public class ContactDao extends PersistenceDao<Contact> {

	private static final String TABLE = "contact";
	private static final String JOINTABLE = "todo_contact";

	protected ContactDao() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		super();
	}

	@Override
	public Contact find(Contact entity) throws SQLException {
		String query = "SELECT * FORM " + TABLE + " c WHERE c.id = ?";

		PreparedStatement find = this.connection.prepareStatement(query);
		find.setInt(1, entity.getId());

		return ContactMapper.mapToEntity(find.executeQuery());
	}

	@Override
	public Contact findAll() throws SQLException {
		String query = "SELECT * FORM " + TABLE;
		PreparedStatement find = this.connection.prepareStatement(query);
		return ContactMapper.mapToEntity(find.executeQuery());
	}

	@Override
	public void delete(Contact entity) throws SQLException {
		this.connection.setAutoCommit(false);
		String query = "DELETE FORM " + TABLE + " c WHERE c.id = ?";
		String queryJoin = "DELETE FORM " + JOINTABLE
				+ " tc WHERE tc.contactId = ?";
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
	public void persist(Contact entity) throws SQLException {
		String query = "INSERT INTO " + TABLE + " (`contactId`) VALUES ('?')";
		PreparedStatement persist = this.connection.prepareStatement(query);
		persist.setInt(1, entity.getId());
		persist.execute();
	}

	@Override
	public void update(Contact entity) throws SQLException {
		String query = "UPDATE " + TABLE + " c SET contactId = ? WHERE c.id = ?)";
		PreparedStatement update = this.connection.prepareStatement(query);
		update.setInt(1, entity.getContactId());
		update.setInt(2, entity.getId());
		update.executeUpdate();
	}

	/**
	 * gives a list with contacts they are references a todo.
	 * 
	 * @param id
	 * @return List of Contacts are referenced to todoId
	 * @throws SQLException
	 */
	public List<Contact> findAllByTodoId(int id) throws SQLException {
		String query = "SELECT c.* FORM " + TABLE + " c INNER JOIN "+JOINTABLE+" tc ON tc.todoId = ?";

		PreparedStatement find = this.connection.prepareStatement(query);
		find.setInt(1, id);

		return ContactMapper.mapToEntityList(find.executeQuery());
	}

}
