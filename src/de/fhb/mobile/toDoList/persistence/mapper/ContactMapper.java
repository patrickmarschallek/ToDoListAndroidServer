/**
 * 
 */
package de.fhb.mobile.toDoList.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.fhb.mobile.toDoList.entity.Contact;

/**
 * @author Patrick
 *
 */
public class ContactMapper {

	/**
	 * map a single Object
	 * 
	 * @param result
	 * @return Contact from database
	 * @throws SQLException
	 */
	public static Contact mapToEntity(ResultSet result) throws SQLException {
		Contact contact = new Contact();
		while(result.next()){
			contact.setId(result.getInt("id"));
			contact.setContactId(result.getInt("contactId"));
		}
		return contact;
	}

	/**
	 * map a list object
	 * 
	 * @param result
	 * @return a contact list
	 * @throws SQLException
	 */
	public static List<Contact> mapToEntityList(ResultSet result) throws SQLException {
		List<Contact> contactList = new ArrayList<Contact>();
		
		while(result.next()){
			Contact contact = new Contact();
			contact.setId(result.getInt("id"));
			contact.setContactId(result.getInt("contactId"));
			contactList.add(contact);
		}
		return contactList;
	}
}
