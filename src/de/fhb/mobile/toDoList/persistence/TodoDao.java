/**
 * 
 */
package de.fhb.mobile.toDoList.persistence;

import java.sql.SQLException;

import de.fhb.mobile.toDoList.entity.Todo;

/**
 * @author Patrick
 *
 */
public class TodoDao extends PersistenceDao<Todo> {

	protected TodoDao() throws SQLException {
		super();
		
	}

	@Override
	public Todo find(Todo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Todo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persist(Todo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Todo entity) {
		// TODO Auto-generated method stub
		
	}

}
