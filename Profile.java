/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;
import java.io.IOException;
import java.sql.*;

/**
 *
 * @author Muneeb
 */
public class Profile {
    
    private Connection con;
    private Statement stmt;
    private ResultSet re;
        
    protected String userName;
    protected String userType;
    protected String name;
    protected String address;
    protected String email;
    protected String password;
    protected String phone;

    public Profile() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserType() {
        return userType;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
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
    
    Profile(String _username, String _userType, String _name, String _address, String _email, String _password, String _phone){
    this.userName = _username;
    this.userType= _userType;
    this.name = _name;
    this.address = _address;
    this.email = _email;
    this.password = _password;
    this.phone = _phone;
    
    }
    
    public Profile displayProfile(String userName) throws SQLException
    {
        String collect="Select * from [Profile]";
        Profile temp=new Profile();
        
        re=stmt.executeQuery(collect);
        
        while(re.next())
        {
            String a=re.getString("userName");
            if(userName.equals(a))
            {
                temp.userName=a;
                temp.name=re.getString("name");
                temp.email=re.getString("email");
                temp.phone=re.getString("phone");
                temp.password=re.getNString("password");
                temp.address=re.getString("address");
                temp.userType=re.getNString("userType");
            }
        }
        
        return temp;
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
}
