package de.fhb.mobile.toDoList.manager;

import java.sql.SQLException;
import java.util.List;

import de.fhb.mobile.toDoList.entity.Todo;
import de.fhb.mobile.toDoList.entity.User;
import de.fhb.mobile.toDoList.persistence.ContactDao;
import de.fhb.mobile.toDoList.persistence.TodoDao;

public class TodoListBusinessLogic {

	private static final User USER = new User(1,"","");

	/**
	 * datacces to contact table.
	 */
	private ContactDao contactDao;

	/**
	 * dataaccess to todo table.
	 */
	private TodoDao todoDao;

	/**
	 * construct all dataaccess classes.
	 * 
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public TodoListBusinessLogic() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		this.contactDao = new ContactDao();
		this.todoDao = new TodoDao();
	}

	/**
	 * synchronize local android todolist with server todos.
	 * 
	 * @param todoList
	 * @return synchronized list.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public List<Todo> synchronize(List<Todo> todoList) throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		// TODO nicht vorhandene prüfen local and remote
		if (todoList.size() == 0) {
			todoList = this.todoDao.findAllByUser(USER);
		} else {
			for (Todo t : todoList) {
				Todo databaseTodo = this.todoDao.find(t);
				System.out.println(databaseTodo);
				if (databaseTodo.getId() == 0) {
					System.out.println("try persist");
					this.todoDao.persist(t);
					System.out.println("after persist");
				} else {
					if (databaseTodo.getLastChange().getTime() <= t
							.getLastChange().getTime()) {
						System.out.println("try update");
						this.todoDao.update(t);
						System.out.println("after update");
					} else {
						t = databaseTodo;
					}
				}
			}
		}
		return todoList;
	}

	public List<Todo> findAllTodo(User user) throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		return this.todoDao.findAllByUser(user);
	}

}
