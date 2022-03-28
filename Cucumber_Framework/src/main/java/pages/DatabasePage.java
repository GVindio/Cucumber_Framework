package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage {

	public String getData(String columnName) {
		Connection connection = null;
		Statement statement;
		ResultSet rs = null;
		String columnValue = null;
// setting properties for mySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sqlUrl = "jdbc:mysql://localhost:3306/september2021";
			String sqlUsername = "root";
			String sqlPassword = "root";
			String query = "Select * from users";

// create connection to local DB
			connection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);

// Empower the connection reference to execute queries
			statement = connection.createStatement();

// Delivering the query
			rs = statement.executeQuery(query);

			while (rs.next()) {
				columnValue = rs.getString(columnName);
				return columnValue;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return columnValue;

	}
}
