/**
 * 
 */
package de.fhb.mobile.toDoList.controller;

/**
 * @author Patrick
 *
 */
public class TodoListServiceImpl implements ITodoListService{

	@Override
	public String getAllTodo() {
		// TODO Auto-generated method stub
		return "[1,2,3]";
	}

	@Override
	public String deleteTodo(int id) {
		// TODO Auto-generated method stub
		return "{}";
	}

	@Override
	public String authentificate(String username, String password) {
		// TODO Auto-generated method stub
		return "{\"mesasge\": \"access denied\"}";
	}

	@Override
	public String synchronize(String todoListJson) {
		// TODO Auto-generated method stub
		return "{\"mesasge\": \"can not synchronize\"}";
	}

}
