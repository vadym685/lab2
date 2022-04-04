<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h1>Welcome</h1>

<nav>
    <a href="/">Home</a>
    <a href="/tasksBrowse">Tasks</a>
    <a href="/pointsBrowse">Points</a>
    <a href="/personsBrowse">Persons</a>
    <div class="# start-home"></div>
</nav>

<br>

<form method=get action="searchTask">
    <input type="hidden" name="action" value="Search">

    Search by <select id="searchField" name="searchField">
    <option value="ID">Id</option>
</select>: <input type="text" name="searchString">
</form>

<form method=get action="addTask">
    <input type="submit" value="Add new">
</form>
<br>
<table id="table">
    <tr>
        <th>ID</th>
        <th>DATE</th>
        <th>POINT_ID</th>
    </tr>

    <%--@elvariable id="tempTasksMap" type="java.util.List"--%>
    <c:forEach items="${tempTasksMap}" var="task">

        <tr>
            <td>${task.id}</td>
            <td><fmt:formatDate value="${task.date}" pattern="yyyy-MM-dd" /></td>
            <td>${task.point.id}</td>
            <td>
                <a href="editTask?taskID=${task.id}">Edit</a>
            </td>
            <td>
                <a href="deleteTask?taskID=${task.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>

</html>
