<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
  <h1>My First Bootstrap Page</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <h3>Column 1</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    <div class="col-sm-4">
<sf:form method="post" action="/add" modelAttribute="employee" >
Id: <select>
	<c:forEach var="e" items="${employees }">
		<option>${e.id }</option>
	</c:forEach>
</select>
Id: <sf:input type="number" path="id" class="form-control"  />
<sf:errors path="id">
<span class="alert-danger">Id must be a positive integer
</span>
</sf:errors>
<br/>
First Name: <sf:input path="firstName" class="form-control" />
<sf:errors path="firstName"><span class="alert-danger">The first Name must be 3-10 characters</span></sf:errors>
<br/>
Last Name: <sf:input path="lastName" class="form-control" /><br/>
Salary: <sf:input type="text" path="salary" class="form-control" /><br/>
<input type="submit" name="add" value="Add" class="btn btn-success" />&nbsp;
<input type="submit" name="update" value="Update" class="btn btn-warning" />&nbsp;
<input type="submit" name="delete" value="Delete" class="btn btn-danger" />
</sf:form>
    </div>
    <div class="col-sm-4">
      <h3>Column 3</h3>        
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
  </div>
</div>

<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-8">

<table class="table table-bordered table-striped table-hover">
	<thead>
		<tr>
			<th>Id</th><th>First Name</th><th>Last Name</th><th>Salary</th><th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${employees }">
			<tr>
				<td>${e.id}</td>
				<input type="hidden" name="id" value="${e.id }" />
				<td>${e.firstName }</td>
				<td>${e.lastName}</td>
				<td>${e.salary }</td>
				<td><a class="btn btn-info" href="/select/${e.id }">Select</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</div>
<div class="col-sm-2"></div>
</div>









</body>
</html>