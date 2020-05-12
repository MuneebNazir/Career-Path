/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Muneeb
 */
public class Student extends User {
    private Connection con;
	private Statement stmt;
	private ResultSet re;
        
        int id;
        String gender;
        String uName;
        String interest;

    public void setId(int id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getuName() {
        return uName;
    }

    public String getInterest() {
        return interest;
    }
        
        
        
	public boolean connect() throws Exception
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://localhost:1433;databaseName=CareerCounsellingSystem";
			String name="new_user";
			String password="123";
			con=DriverManager.getConnection(url,name,password);
			stmt=con.createStatement();
			return true;
		  }
		  catch(SQLException e)
		  {
			  System.out.print(e);
			  return false;
	 	  }
	}

    @Override
    public void setProfile(Profile profile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
