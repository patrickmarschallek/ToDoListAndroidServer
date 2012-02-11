/**
 * 
 */
package de.fhb.mobile.toDoList.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * @author Patrick
 * 
 */
@Path("/")
public interface ITodoListService {

	/**
	 * get all your todos.
	 * 
	 * @return
	 */
	@GET
	@Path("/getAll")
	@Produces("application/json")
	public String getAllTodo();

	/**
	 * get all your todos.
	 * 
	 * @return
	 */
	@PUT
	@Path("/add")
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public String addTodo(@FormParam("todoListJson") String todoListJson);

	
	/**
	 * delete a todo with given id.
	 * 
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces("application/json")
	public String deleteTodo(int id);

	/**
	 * authenticate a user.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@POST
	@Path("/authenticate")
	@Produces("application/json")
	public String authentificate(@QueryParam("username") String username,
			@QueryParam("password") String password);
	
	/**
	 * synchronize local todolist with server todolist.
	 * 
	 * @param todoListJson
	 * @return
	 */
	@POST
	@Path("/synchronize")
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public String synchronize(@FormParam("todoListJson") String todoListJson);
}
