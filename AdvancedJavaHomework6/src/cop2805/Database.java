package cop2805;

import java.sql.*;

public class Database {

	public static void main(String[] args) {
		Connection connection;
		try {
			ResultSet results = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
					"root","cop2805");
			Statement statement = connection.createStatement();
			results = statement.executeQuery("SELECT * FROM Employees;");

			while(results.next())
			{
				System.out.print(results.getInt(1));
				System.out.print(": ");
				System.out.print(results.getString("lastName"));
				System.out.print(", ");
				System.out.print(results.getString("firstName"));
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
