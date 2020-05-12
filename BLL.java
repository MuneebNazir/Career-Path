/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muneeb
 */
public class BLL {
       private Connection con;
	private Statement stmt;
	private ResultSet re;
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
     public boolean login(String userName,String pass) throws SQLException
	{
		String sql="Select * from [Profile]";
		re=stmt.executeQuery(sql);
		while(re.next())
		{
			String a=re.getString("userName");
			String b=re.getString("password");
                        int c=re.getInt("profID");
			if(userName.equals(a))
			{
				if(pass.equals(b))
				{
                                    String query="Insert into LoggedIn (usrID) values(?)";
                                    PreparedStatement prst=con.prepareStatement(query);
                                    prst.setInt(1, c);
                                    prst.executeUpdate();
					return true;
				}
			}
		}
		return false;
        } 
     public boolean logOut(String userName) throws SQLException
        {
            String temp="Select * from LoggedIn";
            
            re=stmt.executeQuery(temp);
            
            while(re.next())
            {
                String a=re.getString("usrName");
                if(userName.equals(a))
                {
                    String query= "Delete from LoggedIn Where usrName=?";
                            
                            PreparedStatement prst=con.prepareStatement(query);
                                
                            prst.setString(1, userName);
                            prst.executeUpdate();
                            return true;
                }
            }
            return false;
        }
     public boolean changeUserName(String curUsrName, String newUsrName) throws SQLException
        {
            String type1="student";
            String type2="employee";
            String type3="institution";
            String usrNam="Select * from [Profile]";
            re=stmt.executeQuery(usrNam);
            while(re.next())
		{
			String a=re.getString("userName");
                        String b=re.getString("userType");
			if(curUsrName.equals(a) && type1.equals(b))
			{
                                String query= "Update [Profile] Set userName=? Where userName=?";
                                String query2="Update Student Set uName=? where uName=?";
                                PreparedStatement prst=con.prepareStatement(query);
                                PreparedStatement prst2=con.prepareStatement(query2);
                                prst.setString(1, newUsrName);
                                prst.setString(2, curUsrName);
                                prst.executeUpdate();
                                prst2.setString(1, newUsrName);
                                prst2.setString(2, curUsrName);
                                prst2.executeUpdate();
				return true;
				
			}
                        
                        else if(curUsrName.equals(a) && type2.equals(b))
			{
                                String query= "Update [Profile] Set userName=? Where userName=?";
                                String query2="Update Employee Set usrName=? where usrName=?";
                                PreparedStatement prst=con.prepareStatement(query);
                                PreparedStatement prst2=con.prepareStatement(query2);
                                prst.setString(1, newUsrName);
                                prst.setString(2, curUsrName);
                                prst.executeUpdate();
                                prst2.setString(1, newUsrName);
                                prst2.setString(2, curUsrName);
                                prst2.executeUpdate();
				return true;
				
			}
                        else if(curUsrName.equals(a) && type3.equals(b))
			{
                                String query= "Update [Profile] Set userName=? Where userName=?";
                                String query2="Update EducationalInstitution Set userName=? where userName=?";
                                PreparedStatement prst=con.prepareStatement(query);
                                PreparedStatement prst2=con.prepareStatement(query2);
                                prst.setString(1, newUsrName);
                                prst.setString(2, curUsrName);
                                prst.executeUpdate();
                                prst2.setString(1, newUsrName);
                                prst2.setString(2, curUsrName);
                                prst2.executeUpdate();
				return true;
				
			}
		}
            return false;
        }
     
     
     public boolean changePassword(String UserName, String curUsrPass, String newUsrPass) throws SQLException
        {
            
            String usrPas="Select * from [Profile]";
            re=stmt.executeQuery(usrPas);
            while(re.next())
		{
			String a=re.getString("password");
                        String b=re.getString("userName");
			if(curUsrPass.equals(a) && UserName.equals(b))
			{
                                String query= "Update [Profile] Set password=? Where userName=?";
                                
                                PreparedStatement prst=con.prepareStatement(query);
                               
                                prst.setString(1, newUsrPass);
                                prst.setString(2, UserName);
                                prst.executeUpdate();
				return true;
				
			}
                        
                        
		}
            return false;
        }
     
     public boolean changeName(String UserName, String curName, String newName) throws SQLException
        {
            
            String Nam="Select * from [Profile]";
            re=stmt.executeQuery(Nam);
            while(re.next())
		{
			String a=re.getString("name");
                        String b=re.getString("userName");
			if(curName.equals(a) && UserName.equals(b))
			{
                                String query= "Update [Profile] Set name=? Where userName=?";
                                
                                PreparedStatement prst=con.prepareStatement(query);
                               
                                prst.setString(1, newName);
                                prst.setString(2, UserName);
                                prst.executeUpdate();
				return true;
				
			}
                        
                        
		}
            return false;
        }
     
     public boolean changeEmail(String UserName, String curMail, String newMail) throws SQLException
        {
            
            String mail="Select * from [Profile]";
            re=stmt.executeQuery(mail);
            while(re.next())
		{
			String a=re.getString("email");
                        String b=re.getString("userName");
			if(curMail.equals(a) && UserName.equals(b))
			{
                                String query= "Update [Profile] Set email=? Where userName=?";
                                
                                PreparedStatement prst=con.prepareStatement(query);
                               
                                prst.setString(1, newMail);
                                prst.setString(2, UserName);
                                prst.executeUpdate();
				return true;
				
			}
                        
                        
		}
            return false;
        }
     
     public boolean changePhone(String UserName, String curPhone, String newPhone) throws SQLException
        {
            
            String Nam="Select * from [Profile]";
            re=stmt.executeQuery(Nam);
            while(re.next())
		{
			String a=re.getString("phone");
                        String b=re.getString("userName");
			if(curPhone.equals(a) && UserName.equals(b))
			{
                                String query= "Update [Profile] Set phone=? Where userName=?";
                                
                                PreparedStatement prst=con.prepareStatement(query);
                               
                                prst.setString(1, newPhone);
                                prst.setString(2, UserName);
                                prst.executeUpdate();
				return true;
				
			}
                        
                        
		}
            return false;
        }
     
     public boolean changeAddress(String UserName, String curAddr, String newAddr) throws SQLException
        {
            
            String Nam="Select * from [Profile]";
            re=stmt.executeQuery(Nam);
            while(re.next())
		{
			String a=re.getString("address");
                        String b=re.getString("userName");
			if(curAddr.equals(a) && UserName.equals(b))
			{
                                String query= "Update [Profile] Set phone=? Where userName=?";
                                
                                PreparedStatement prst=con.prepareStatement(query);
                               
                                prst.setString(1, newAddr);
                                prst.setString(2, UserName);
                                prst.executeUpdate();
				return true;
				
			}
                        
                        
		}
            return false;
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
     
     public void storeEduInfo(String username, float percentage,String specialization, String degree,String field) throws SQLException
	{
		String query="INSERT INTO userposts (username,postdesc,usermail,postpath)"+"VALUES (?,?,?,?)";
		PreparedStatement prst=con.prepareStatement(query);
		prst.setString(1, username);
		prst.setString(2, degree);
		prst.setString(3, field);
		//prst.setString(4, picpath);
		prst.executeUpdate();
	}
      
}

