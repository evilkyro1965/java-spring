package com.wiley.beginningspring.ch6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class AccountServiceJdbcTxImpl implements AccountService {

	public void transferMoney(long sourceAccountId, long targetAccountId,
			double amount) {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jpatest", "root", "12345");
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			statement.executeUpdate("update account set balance = balance - " + amount + " where id = " + sourceAccountId);
			statement.executeUpdate("update account set balance = balance + " + amount + " where id = " + targetAccountId);
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException ex) {}
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {}
		}

	}

}
