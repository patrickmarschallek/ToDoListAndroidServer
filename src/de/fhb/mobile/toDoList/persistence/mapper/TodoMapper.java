/**
 * 
 */
package de.fhb.mobile.toDoList.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.fhb.mobile.toDoList.entity.Contact;
import de.fhb.mobile.toDoList.entity.Todo;
import de.fhb.mobile.toDoList.persistence.ContactDao;
import de.fhb.mobile.toDoList.persistence.UserDao;

/**
 * @author Patrick
 *
 */
public class TodoMapper{

	private static ContactDao contactDao;
	private static UserDao userDao;
	
	/**
	 * map a single Object
	 * 
	 * @param result
	 * @return Contact from database
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Todo mapToEntity(ResultSet result) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		TodoMapper.contactDao = new ContactDao();
		TodoMapper.userDao = new UserDao();
		Todo todo = new Todo();
		while(result.next()){
			todo.setId(result.getInt("id"));
			todo.setFinished(result.getBoolean("finished"));
			todo.setName(result.getString("name"));
			todo.setExpires(result.getDate("expire"));
			todo.setLastChange(result.getDate("lastChange"));
			todo.setDescription(result.getString("description"));
			todo.setContacts(TodoMapper.contactDao.findAllByTodoId(todo.getId()));
			todo.setUser(TodoMapper.userDao.findById(result.getInt("userId")));
		}
		return todo;
	}

	/**
	 * map a list object
	 * 
	 * @param result
	 * @return a contact list
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static List<Todo> mapToEntityList(ResultSet result) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Todo> todoList = new ArrayList<Todo>();
		TodoMapper.contactDao = new ContactDao();
		TodoMapper.userDao = new UserDao();
		while(result.next()){
			Todo todo = new Todo();
			todo.setId(result.getInt("id"));
			todo.setFinished(result.getBoolean("finished"));
			todo.setName(result.getString("name"));
			todo.setExpires(result.getDate("expire"));
			todo.setLastChange(result.getDate("lastChange"));
			todo.setDescription(result.getString("description"));
			List<Contact> contacts = TodoMapper.contactDao.findAllByTodoId(todo.getId());
			todo.setContacts(contacts);
			todo.setUser(TodoMapper.userDao.findById(result.getInt("userId")));
			todoList.add(todo);
		}
		return todoList;
	}
}
