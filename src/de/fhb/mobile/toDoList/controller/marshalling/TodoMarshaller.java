/**
 * 
 */
package de.fhb.mobile.toDoList.controller.marshalling;

import java.text.ParseException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.fhb.mobile.toDoList.entity.Todo;

/**
 * @author Patrick
 *
 */
public class TodoMarshaller {
	public static JSONObject marshall(Todo todo) throws JSONException, ParseException {
		JSONObject json = new JSONObject();
		json.put("description", todo.getDescription());
		json.put("favourite", todo.isFavourite());
		json.put("finished", todo.isFinished());
		json.put("expire", todo.getExpires());
		json.put("lastChange", todo.getLastChange());
		json.put("name",todo.getName());
		json.put("id", todo.getId());
		json.put("user", UserMarshaller.marshall(todo.getUser()));
		json.put("contacts", ContactMarshaller.marshallList(todo.getContacts()));
		return json;
	}

	public static JSONArray marshallList(List<Todo> list)
			throws JSONException, ParseException {
		JSONArray jsonArray = new JSONArray();
		for(Todo t:list)
			jsonArray.put(TodoMarshaller.marshall(t));
		return jsonArray;
	}
}
