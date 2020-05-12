<%-- 
    Document   : jspLogIn
    Created on : May 11, 2020, 1:48:02 AM
    Author     : Muneeb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <style>
        .container{
            width: 500px;
            height: fit-content;
            background-color: darkblue;
            margin: 0 auto;
            text-align: center;
        }
        .row{
            background-color: green;
            width: 70%;
            margin: 0 auto;
        }
        .row input{
            margin-right:0% ;
        }
    </style>

</head>
<body>
    <div class="container">
        <form action="Login" method="post" id="login_form">
            <h2 center-aligned>Login</h2>

            <label for="login_as">Login As: </label>
            <select name="login_as">
                <option value="student">Student</option>
                <option value="employee">Employee</option>
                <option value="institute">Educational Institute</option>
                <option value="admin">Admin</option>
            </select>
            
            <table class="row" id="form_data">
                <tr>
                    <td align="left">User Name: </td>
                    <td align="right"><input name="userName" type="text"></td>
                </tr>
                <tr>
                    <td align="left">Password: </td>
                    <td align="right"><input name="pass" type="password"></td>
                </tr>
            </table>
            <input type="submit" value="Login">  
        </form>
    </div>
</body>
</html>
