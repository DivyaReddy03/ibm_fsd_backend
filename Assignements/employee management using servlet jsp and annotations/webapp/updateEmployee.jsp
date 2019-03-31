<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
    <h1 align="center">Update Employee Form</h1>
    <div align="center">
        <form action="update.do" >
<div>
                <input type="text" name="name"
                    placeholder="Enter EmployeeName" value="<%=request.getParameter("name")%>" />
            </div>
            <br>
            <div>
                <input type="text" name="empid" placeholder="Enter Emp Id" value="<%=request.getParameter("id")%>" />
            </div>
            <br>
            <div>
                <input type="text" name="age" placeholder="Enter age" value="<%=request.getParameter("age")%>" />
            </div>
            <br>
            <div>
                <input type="text" name="designation"
                    placeholder="Enter Designation" value="<%=request.getParameter("designation")%>"/>
            </div>
            <br>
            <div>
                <input type="text" name="department" placeholder="Enter Department" value="<%=request.getParameter("department")%>" />
            </div>
            <br><div>
                <input type="number" name="salary" placeholder="Enter salary" value="<%=request.getParameter("salary")%>"/>
            </div>
            <br>
            <div>
            
                
            <br> <input type="submit" value="update" class="button"/>
            <button type="reset" class="button">RESET</button>

        </form>
    </div>

</body>
</html>



