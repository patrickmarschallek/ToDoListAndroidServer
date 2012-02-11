/**
 * 
 */
package de.fhb.mobile.toDoList.controller.marshalling;

import java.text.ParseException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.fhb.mobile.toDoList.entity.Contact;

/**
 * @author Patrick
 *
 */
public class ContactMarshaller {

	public static JSONObject marshall(Contact contact) throws JSONException, ParseException {
		JSONObject json = new JSONObject();
		json.put("contactId", contact.getContactId());
		return json;
	}
	
	public static JSONArray marshallList(List<Contact> contacts) {
		JSONArray jsonArray = new JSONArray();
		for(Contact c : contacts)
			jsonArray.put(c);
		return jsonArray;
	}

}
