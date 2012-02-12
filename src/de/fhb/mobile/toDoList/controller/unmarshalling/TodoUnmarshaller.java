/**
 * 
 */
package de.fhb.mobile.toDoList.controller.unmarshalling;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.fhb.mobile.toDoList.entity.Todo;

/**
 * @author Patrick
 * 
 */
public class TodoUnmarshaller {

	public static Todo unmarshall(JSONObject todoJson) throws JSONException, ParseException {
		Todo todo = new Todo();
		int i = 0;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		todo.setDescription(todoJson.getString("description"));System.out.println(i++);
		todo.setFavourite(todoJson.getBoolean("favourite"));System.out.println(i++);
		todo.setFinished(todoJson.getBoolean("finished"));System.out.println(todoJson.getString("expire"));
		todo.setExpires(new Date(todoJson.getLong("expire")));System.out.println(i++);
		todo.setLastChange(new Date(todoJson.getLong("lastChange")));System.out.println(i++);
		todo.setName(todoJson.getString("name"));System.out.println(i++);
		todo.setUser(UserUnmarshaller.unmarshall(todoJson.getJSONObject("user")));System.out.println(i++);
		todo.setContacts(ContactUnmarshaller.unmarshallList(todoJson.getJSONArray("contacts")));System.out.println(i++);
		
		return todo;
	}

	public static List<Todo> unmarshallList(JSONArray list)
			throws JSONException, ParseException {
		List<Todo> listTodo = new ArrayList<Todo>();
		for (int i = 0; i < list.length(); i++) {
			listTodo.add(unmarshall(list.getJSONObject(i)));
		}
		return listTodo;
	}
}
