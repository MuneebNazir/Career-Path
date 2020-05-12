<%-- 
    Document   : employeeProfile
    Created on : May 11, 2020, 11:08:36 AM
    Author     : Muneeb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Document</title>
    <style>
        .side{
            background-color: greenyellow;
            width:200px;
        }
        .main{
            background-color: indianred;
        }
        .container{
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <table class="container">
        <tr>
            <td class="side">
                <img src="" alt="">
                <ul>
                    <li><a href="employeeHome">Home</a></li>
                    <li><a href="">Profile</a></li>
                    <li><a href="index.html">Logout</a></li>
                </ul>
                <button type="submit">Get Recommendation</button>
            </td>
            <td class="main">
                <h1>Profile</h1>
                <form action="" method="POST">
                    <h3>Personal Information</h3>
                    <table>
                        <tr align="left">
                            <td>Name:</td>
                            <td><input type="text" name="employee_name" id="employee-name"></td>
                            <td><a href="">Edit</a></td>
                        </tr>
                        <tr align="left">
                            <td>Contact:</td>
                            <td><input type="text" name="employee_contact" id="employee-contact"></td>
                            <td><a href="">Edit</a></td>
                        </tr>
                        <tr>
                            <td>Address:</td>
                            <td><input type="text" name="employee_address" id="employee-address"></td>
                            <td><a href="">Edit</a></td>
                        </tr>
                    </table>
                    <h3>Educational Information</h3>
                    <table>
                        <tr>
                            <td>Qualification Level:</td>
                            <td>
                                <select name="employee_qualification" id="employee-qualification">
                                    <option value="">Web dev</option>
                                    <option value=""></option>
                                    <option value=""></option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Major:</td>
                            <td>
                                <select name="employee_major" id="employee-major">
                                    <option value="">Web dev</option>
                                    <option value=""></option>
                                    <option value=""></option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Interest:</td>
                            <td>
                                <select name="employee_interest" id="employee-interest">
                                    <option value="">Web dev</option>
                                    <option value=""></option>
                                    <option value=""></option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Degree Title:
                            </td>
                            <td><input type="text" name="employee_degree" id="employee-degree"></td>
                        </tr>   
                    </table>
                    <h3>Professional Information</h3>
                    <table id="employee-experience-table" border="1" style="border-collapse: collapse;">
                        <tr align="left">
                            <th>Job Title</th>
                            <th>Experience(months)</th>
                            <th>Company</th>
                        </tr>
                        <tr>
                            <td>Jr Dev</td>
                            <td>3mo</td>
                            <td>koi bhi nahi</td>
                        </tr>
                        
                    </table>
                    <input type="submit" value="Update">
                </form>
            </td>
    </table>
</body>
</html>
