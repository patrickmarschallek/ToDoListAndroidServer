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
	
	protected ContactDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Contact find(Contact entity) throws SQLException {
		String query = "SELECT * FORM "+TABLE+" c WHERE c.id = ?";
		
		PreparedStatement find = this.connection.prepareStatement(query);
		find.setInt(1, entity.getId());
				
		return ContactMapper.mapToEntity(find.executeQuery());
	}

	@Override
	public Contact findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Contact entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void persist(Contact entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Contact entity) {
		// TODO Auto-generated method stub

	}

	public List<Contact> findAllByTodo() {
		// TODO Auto-generated method stub
		return null;
	}

}
