<%-- 
    Document   : signup
    Created on : May 8, 2020, 8:56:21 PM
    Author     : Muneeb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>$(document).ready (function(){
                
                    console.log("page is ready...")})    
                        </script>
    <script>
        function newRegisterForm(form_type){
            
            if(form_type.value==="institution"){
                var html="<tr id='row_campus'><td align=\"left\">Campus Name: </td><td align=\"right\"><input name='inst_name' type=\"text\"></td></tr><tr id='row_inst_type'><td align=\"left\">Institution Type: </td><td align=\"left\"><select name=\"instituition_name\"><option selected value=\"university\">University</option><option value=\"college\">College</option></select></td></tr>";
                $("#form_data").append(html);
            }else{
                $("#row_campus").remove();
                $("#row_inst_type").remove();
            }
        }
    </script>
    <style>
        .container{
            width: 600px;
            height: 220px;
            background-color: darkgray;
            margin: 0 auto;
            text-align: center;
        }
        .row{
            background-color: lightseagreen;
            width: 70%;
            margin: 0 auto;
        }
        .row input{
            margin-right:0% ;
        }
    </style>

</head>
<body style="background: url(image/books-in-black-wooden-book-shelf-159711.jpg); background-size: cover; background-attachment: fixed;">
    <div class="container">
        <form action="Register" method="post" id="reg_form">
            <h2>Register</h2>

            <label for="reg_as">Register As: </label>
            <select name="reg_as" id="" onchange="newRegisterForm(this)">
                <option selected value="student">Student</option>
                <option value="employee">Employee</option>
                <option value="institution">Institution</option>
            </select>
            
            <table class="row" id="form_data">
                <tr>
                    <td align="left">User Name: </td>
                    <td align="right"><input name="user_name" type="text"></td>
                </tr>
                <tr>
                    <td align="left">Email: </td>
                    <td align="right"><input name="email" type="email"></td>
                </tr>
                <tr>
                    <td align="left">Password: </td>
                    <td align="right"><input name="pass" type="password"></td>
                </tr>
                <tr></tr>
                <tr></tr>
            </table>
            <input type="submit" value="Register">  
        </form>
    </div>
    
        
    
    
    
</body>
</html>
