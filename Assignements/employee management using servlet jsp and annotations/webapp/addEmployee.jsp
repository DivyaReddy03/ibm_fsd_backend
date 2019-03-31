<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<form action="add.do">
<label>Name:</label><input type="text" name="name"/><br><br>
<label>EmpID:</label><input type="number" name="id"/><br><br>

<label>Age:</label><input type="number" name="age"/><br><br>
<label>Designation:</label><input type="text" name="designation"/><br><br>
<label>Department:</label><input type="text" name="department"/><br><br>
<label>Salary:</label><input type="text" name="salary"/><br><br>
<input type="submit" value="Add Employee"/>
</form>
</body>
</html>