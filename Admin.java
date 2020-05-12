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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muneeb
 */
public class Admin {
    
    private Connection con;
	private Statement stmt;
	private ResultSet re;
        
    protected String userName;
    protected String name;
    protected String email;
    protected String password;
    protected String phone;
    
    
        
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
    
    
    public List<Profile> viewUsers(){
    List<Profile> result = new ArrayList<Profile>();
    try{

    String create = "select * from [Profile]";

        
        re = stmt.executeQuery(create);
        while(re.next()){
            String usrName =re.getString("userName");
            String usrType = re.getString("userType");
            Profile user = new Profile(); // Creating a user object to fill with user data (I imagine that you have a user class in your model)
            user.setUserName(usrName);
            user.setUserType(usrType);
            //Add the retrived user to the list
            result.add(user);

        }
        //Returning the list of users.
        return result;
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }

}
}
