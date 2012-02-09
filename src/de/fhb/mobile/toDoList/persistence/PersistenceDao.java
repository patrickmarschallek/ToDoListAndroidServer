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
	 */
	protected PersistenceDao() throws SQLException {
		this.connection = DriverManager.getConnection(DATABASEURL, USER,
				PASSWORD);
	}

	public abstract T find(T entity);

	public abstract T findAll();

	public abstract void delete(T entity);

	public abstract void persist(T entity);

	public abstract void update(T entity);
}
