<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nandula
  Date: 5/23/2021
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Landing Page</title>
</head>
<body>
<div class="d-flex" style="margin-top: 50px;">
    <div class="container flex-grow-3" style="margin-top: 20px;">
        <table class="table table-dark table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Job Title</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope['employees']}" var="e">
                    <tr>
                        <td><c:out value="${e.id}"></c:out></td>
                        <td><c:out value="${e.username}"></c:out></td>
                        <td><c:out value="${e.name}"></c:out></td>
                        <td><c:out value="${e.contactNo}"></c:out> </td>
                        <td><c:out value="${e.email}"></c:out> </td>
                        <td><c:out value="${e.jobTitle}"></c:out></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


    <div class="container" style=" width: 800px;">

        <form method="post" action="employee">

            <div class="form-group">
                <label for="id">ID:</label>
                <input type="number" class="form-control" id="id" placeholder="Enter id" name="id">
            </div>

            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
            </div>

            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
            </div>

            <div class="form-group">
                <label for="phone">Phone</label>
                <input type="tel" class="form-control" id="phone" placeholder="Enter phone number" name="phone">
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
            </div>

            <div class="form-group">
                <label for="jobTitle">Job Title</label>
                <input type="text" class="form-control" id="jobTitle" placeholder="Enter Job Title" name="job">
            </div>

            <div class="form-group">
                <label for="imageUrl">Image URL</label>
                <input type="text" class="form-control" id="imageUrl" placeholder="Enter Image URL" name="imageUrl">
            </div>

            <div style="text-align: center; margin-top: 10px;">
                <input type="submit" class="btn btn-primary"/>
            </div>

        </form>

    </div>

</div>


</body>
</html>
