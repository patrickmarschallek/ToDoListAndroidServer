/**
 * 
 */
package de.fhb.mobile.toDoList.controller.marshalling;

import java.text.ParseException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.fhb.mobile.toDoList.entity.User;

/**
 * @author Patrick
 *
 */
public class UserMarshaller {

	public static JSONObject marshall(User user) throws JSONException, ParseException {
		JSONObject json = new JSONObject();
		json.put("username", user.getUsername());
		json.put("id", user.getId());
		return json;
	}
	
	public static JSONArray marshallList(List<User> users) {
		JSONArray jsonArray = new JSONArray();
		for(User u : users)
			jsonArray.put(u);
		return jsonArray;
	}


}
