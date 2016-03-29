<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter address info</title>
</head>
<body>

<center>

<h2>Enter Address</h2>
<form action="<%=request.getContextPath()%>/AddressController" method="post">

<input type="hidden" name="action" value="save"/>
Enter Address Line One<input type="text" name = "addressLineOne"/>
Enter Address Line Two<input type="text" name = "addressLineTwo"/><br>
Enter Pin-code <input type="text" name = "pincode"/><br>

<input type="submit" value="Save Address"/>
</form>

</center>
</body>
</html>