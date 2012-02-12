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
		todo.setDescription(todoJson.getString("description"));
		todo.setFavourite(todoJson.getBoolean("favourite"));
		todo.setId(todoJson.getInt("id"));
		todo.setFinished(todoJson.getBoolean("finished"));
		todo.setExpires(new Date(todoJson.getLong("expire")));
		todo.setLastChange(new Date(todoJson.getLong("lastChange")));
		todo.setName(todoJson.getString("name"));
		//todo.setUser(UserUnmarshaller.unmarshall(todoJson.getJSONObject("user")));System.out.println(i++);
		todo.setContacts(ContactUnmarshaller.unmarshallList(todoJson.getJSONArray("contacts")));
		
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
