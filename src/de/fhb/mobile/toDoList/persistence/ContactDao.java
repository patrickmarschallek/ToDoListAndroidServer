package de.fhb.mobile.toDoList.persistence;

import java.sql.SQLException;

import de.fhb.mobile.toDoList.entity.Contact;

/**
 * 
 * @author Patrick
 *
 */
public class ContactDao extends PersistenceDao<Contact> {

	protected ContactDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Contact find(Contact entity) {
		// TODO Auto-generated method stub
		return null;
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

}
