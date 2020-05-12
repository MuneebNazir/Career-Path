<%-- 
    Document   : employeeHome
    Created on : May 11, 2020, 10:34:46 AM
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
        table,th{
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }
        td{
            padding: 3px;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td class="side">
                <img src="" alt="">
                <ul>
                    <li><a href="">Home</a></li>
                    <li><a href="emlpoyeeProfile.jsp">Profile</a></li>
                    <li><a href="index.html">Logout</a></li>
                </ul>
                <button type="submit">Get Job Recommendation</button>
            </td>
            <td class="main">
                <h1>Jobs</h1>
                <table>
                    <tr>
                        <td><i class="fa fa-search"></i></td>
                        <td><input type="search" name="searchbar" id=""></td>
                        <td>Sort By:</td>
                        <td>
                            <select name="sortby_university" id="sort-university">
                                <option value="name">Field</option>
                                <option value="type">Position</option>
                            </select>
                        </td>
                    </tr>
                </table>

                <table id="University-table">
                    <tr align="left" id="heading-row">
                        <th>Job Title</th>
                        <th>Position</th>
                        <th>Average Salary</th>
                        <th>Minimum Qualification</th>
                    </tr>
                    <tr>
                        <td>University name</td>
                        <td>Lahore</td>
                        <td>1</td>
                        <td>Private</td>
                    </tr>
                    <tr>
                        <td>University name</td>
                        <td>Lahore</td>
                        <td>1</td>
                        <td>Private</td>
                    </tr>
                    <tr>
                        <td>University name</td>
                        <td>Lahore</td>
                        <td>1</td>
                        <td>Private</td>
                    </tr>
                    <tr>
                        <td>University name</td>
                        <td>Lahore</td>
                        <td>1</td>
                        <td>Private</td>
                    </tr>
                </table>
    </body>
</html>
