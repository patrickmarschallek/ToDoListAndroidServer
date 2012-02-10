/**
 * 
 */
package de.fhb.mobile.toDoList.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Patrick
 * 
 */
public abstract class PersistenceDao<T> {

	/**
	 * connection to the DBMS.
	 */
	protected Connection connection;
	/**
	 * database user.
	 */
	private final static String USER = "root";
	/**
	 * database user password.
	 */
	private final static String PASSWORD = "";
	private static final String SERVER = "localhost";
	private static final String PORT = "3306";
	private static final String DATABASE = "androidtodo";
	private static final String DATABASEURL = "jdbc:mysql://" + SERVER + ":"
			+ PORT + "/" + DATABASE;

	/**
	 * constructor create the database connection.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	protected PersistenceDao() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.connection = DriverManager.getConnection(DATABASEURL, USER,
				PASSWORD);
	}

	public abstract T find(T entity) throws SQLException;

	public abstract T findAll() throws SQLException;

	public abstract void delete(T entity) throws SQLException;

	public abstract void persist(T entity) throws SQLException;

	public abstract void update(T entity) throws SQLException;
}
