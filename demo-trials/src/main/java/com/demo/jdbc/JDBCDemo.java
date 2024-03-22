package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JDBCDemo {

	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=EMPLOYEE;encrypt=true;trustServerCertificate=true";
	private String userName = "sa";
	private String password = "sreedhar@9950";
	
	//SQL Queries
	private String insertQuery = "INSERT INTO emp(Id,Name,Gender) values(?,?,?);";
	//private String selectQuery = "SELECT * FROM emp WHERE Id = ?;";
	private String updateQuery = "UPDATE emp SET Name = ?,Gender = ? WHERE Id = ?;";
	private String deleteQuery = "DELETE FROM emp WHERE Id = ?;";
	private String listQuery = "SELECT * FROM emp;";
	
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(jdbcUrl, userName, password);
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(SQLException s) {
			System.out.println(s);
		}
		return con;
	}
	public void insertEmp(Employee e) {
		try (Connection con = getConnection();PreparedStatement pst = con.prepareStatement(insertQuery);) {
			pst.setInt(1, e.getEid());
			pst.setString(2, e.getEname());
			pst.setString(3, e.getGender());
			pst.executeUpdate();
		}catch(Exception a) {
			System.out.println(a);
		}
	}
	/**
	public Employee readEmp(int id) {
		Employee e = new Employee();
		try (Connection con = getConnection();PreparedStatement pst = con.prepareStatement(selectQuery);) {
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				e.setEid(rs.getInt("Id"));
				e.setEname(rs.getString("Name"));
				e.setGender(rs.getString("Gender"));
			}
		}catch(SQLException s) {
			System.out.println(s);
		}
		return e;
	}
	*/
	public void updateEmp(int id, Employee e) {
		try (Connection con = getConnection();PreparedStatement pst = con.prepareStatement(updateQuery);) {
			pst.setString(1,e.getEname());
			pst.setString(2, e.getGender());
			pst.setInt(3, id);
			pst.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se);
		}
	}
	
	public void deleteEmp(int id) {
		try (Connection con = getConnection();PreparedStatement pst = con.prepareStatement(deleteQuery);) {
			pst.setInt(1,id);
			pst.executeUpdate();
		}catch(SQLException s) {
			System.out.println(s);
		}
	}
	
	public List<Employee> listOfEmp() {
		List<Employee> elist = new ArrayList<>();
		
		try (Connection con = getConnection();PreparedStatement pst = con.prepareStatement(listQuery);){
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				e.setEid(rs.getInt("Id"));
				e.setEname(rs.getString("Name"));
				elist.add(e);
			}
			
		}catch(SQLException se) {
			System.out.println(se);
		}
	return elist;
	}
	
}
