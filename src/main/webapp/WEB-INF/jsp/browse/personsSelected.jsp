<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Welcome</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
        }

        table#alter tr:nth-child(even) {
            background-color: #eee;
        }

        table#alter tr:nth-child(odd) {
            background-color: #fff;
        }

        table#alter th {
            color: white;
            background-color: gray;
        }

        a:link, a:visited {
            background-color: #2ae133;
            color: #000000;
            padding: 8px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        input[type=text], input[type=hidden] {
            background-color: white;
            background-position: 10px 10px;
            background-repeat: no-repeat;
            padding-left: 40px;
            border: 1px solid black;
            margin: 5px;
        }

        input[type=button], input[type=submit], input[type=reset] {
            background-color: #2ae133;
            border: 1px solid black;
            color: #000000;
            padding: 8px 32px;
            text-decoration: none;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>

<body>
<h1>Persons browse</h1>

<nav>
    <a href="/">Home</a>
    <a href="/tasksBrowse">Tasks</a>
    <a href="/pointsBrowse">Points</a>
    <a href="/personsBrowse">Persons</a>
    <div class="# start-home"></div>
</nav>

<br>

<form method=get action="searchPerson">
    <input type="hidden" name="action" value="Search">

    Search by <select id="searchField" name="searchField">
    <option value="ID">Id</option>
    <option value="NAME">Name</option>
</select>: <input type="text" name="searchString">
</form>

<form method=get action="addPerson">
    <input type="submit" value="Add new">
</form>
<br>
<table id="table">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>FULL_NAME</th>
        <th>PHONE_NUMBER</th>
        <th>ADMIN</th>
        <th>MANAGER_ID</th>
    </tr>

    <%--@elvariable id="tempPersonMap" type="java.util.List"--%>
    <c:forEach items="${tempPersonMap}" var="person">

        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.fullName}</td>
            <td>${person.phoneNumber}</td>
            <td>${person.admin}</td>
            <td>${person.manager.id}</td>
            <td>
                <a href="selectPerson?personID=${person.id}&taskID=${taskID}">Select</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>

</html>
