/**
 * 
 */
package de.fhb.mobile.toDoList.controller.unmarshalling;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.fhb.mobile.toDoList.entity.Contact;

/**
 * @author Patrick
 *
 */
public class ContactUnmarshaller {

	public static Contact unmarshall(JSONObject contactJson) throws JSONException {
		Contact contact = new Contact();
		contact.setContactId(contactJson.getInt("contactId"));
		//contact.setId(contactJson.getInt("id"));
		return contact;
	}

	public static List<Contact> unmarshallList(JSONArray list)
			throws JSONException {
		List<Contact> listContact = new ArrayList<Contact>();
		for (int i = 0; i < list.length(); i++) {
			listContact.add(unmarshall(list.getJSONObject(i)));
		}
		return listContact;
	}
}
