/**
 * 
 */
package de.fhb.mobile.toDoList.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.fhb.mobile.toDoList.controller.marshalling.TodoMarshaller;
import de.fhb.mobile.toDoList.controller.unmarshalling.TodoUnmarshaller;
import de.fhb.mobile.toDoList.entity.Todo;
import de.fhb.mobile.toDoList.entity.User;
import de.fhb.mobile.toDoList.manager.TodoListBusinessLogic;
import de.fhb.mobile.toDoList.manager.UserAuthenticationBusinessLogic;

/**
 * @author Patrick
 * 
 */
public class TodoListServiceImpl implements ITodoListService {

	private static final String SESSION_USER = "ich@fhb.de";
	private static final String SESSION_USER_PASSWORD = "1";

	private UserAuthenticationBusinessLogic userManager;
	private TodoListBusinessLogic todoManager;

	public TodoListServiceImpl() {
		try {
			this.userManager = new UserAuthenticationBusinessLogic();
			this.todoManager = new TodoListBusinessLogic();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getAllTodo() {
		JSONObject json = new JSONObject();
		// SessionUser normally but its not implemanted session handling
		// instead of we use fix user
		User user = new User();
		try {
			user = this.userManager.findUser(SESSION_USER,
					SESSION_USER_PASSWORD);

			List<Todo> todoList = this.todoManager.findAllTodo(user);
			json.put("todoList", todoList);
		} catch (SQLException e) {
			e.printStackTrace();
			json = this.exceptionJson(e);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}

	@Override
	public String deleteTodo(int id) {
		// TODO Auto-generated method stub
		return "{}";
	}

	@Override
	public String authentificate(String username, String password) {
		JSONObject json = new JSONObject();
		if (username == null || password == null) {
			json = this.exceptionJson(new Exception("Empty Inputfields."));
		} else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			try {
				if (this.userManager.authenticate(user)) {
					json.put("mesasge", "you are logged in.");
					json.put("isAuthenticate", true);
				} else {
					json.put("mesasge", "access denied.");
					json.put("isAuthenticate", false);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				json = this.exceptionJson(e);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return json.toString();
	}

	@SuppressWarnings("finally")
	@Override
	public String synchronize(String todoListJson) {
		JSONObject json = null;
		JSONArray jsonArray;
		List<Todo> todoList = new ArrayList<Todo>();
		System.out.println(todoListJson);
		try {
			json = new JSONObject(todoListJson);

			todoList = TodoUnmarshaller.unmarshallList(json
					.getJSONArray("list"));
			todoList = this.todoManager.synchronize(todoList);
			jsonArray = TodoMarshaller.marshallList(todoList);
			json.put("list", jsonArray);
			json.put("isSynchronize", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json = this.exceptionJson(e);
			json.put("isSynchronize", false);
		} finally {
			System.out.println(json);
			return json.toString();
		}
	}

	@Override
	public String addTodo(String todoListJson) {
		// TODO Auto-generated method stub
		return "{}";
	}

	private JSONObject exceptionJson(Exception e) {
		JSONObject json = new JSONObject();
		try {
			json.put("exception", e.getMessage());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return json;
	}
}
