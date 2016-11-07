<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Personal Details .....</title>
</head>
<body>
<form:form modelAttribute="personalVO" action="/FormValidationUsingAnnotation/addPersonalInfo">
<table>
<tr>
<td><form:label path="firstName">First Name</form:label><td><form:input path="firstName"/></td> <td><form:errors path="firstName" cssClass="error"/></td> 
</tr>
<tr>
<td><form:label path="middleName">Middle Name</form:label></td><td><form:input path="middleName"/></td><td><form:errors path="middleName" cssClass="error"/></td>
</tr>
<tr>
<td><form:label path="lastName"> Last Name</form:label></td> <td><form:input path="lastName"/></td> <td><form:errors path="lastName" cssClass="error"/></td>
</tr>
<td colspan="2"><input type="submit" value="add personal Detail">   </td>
</table>
</form:form>

</body>
</html>