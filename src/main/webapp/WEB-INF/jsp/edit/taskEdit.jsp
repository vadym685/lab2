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

        input[type=text], input[type=hidden], input[type=date] {
            font-size: 1rem;
            font-family: sans-serif;
            margin: 5px;
        }

        a:link, a:visited {
            background-color: #2ae133;
            color: #000000;
            padding: 8px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border: 1px solid black;
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
    <a href="/consumablesBrowse">Consumables</a>
    <div class="# start-home"></div>
</nav>
<br>

<%--@elvariable id="tempTask" type="java.util.List"--%>
<c:forEach items="${tempTask}" var="task">
    <form method=post action="saveEditedTask" modelAttribute="task">
        ID:<input name="id" type="text" value=${task.id} readonly><br>
        DATE:<input name="date" type="date" value=${task.date}><br>
        POINT:<input name="point" type="text" value=${task.point.id}><br>

        <a href="addPosition?taskID=${task.id}">Add new position</a>

        <table id="table">
            <tr>
                <th>ID</th>
                <th>DESCRIPTION</th>
                <th>COMMENT</th>
            </tr>
            <c:forEach items="${task.positions}" var="taskPositions">
                <tr>
                    <td>${taskPositions.id}</td>
                    <td>${taskPositions.description}</td>
                    <td>${taskPositions.comment}</td>
                    <td>
                        <a href="editPosition?positionID=${taskPositions.id}&taskID=${task.id}">Edit</a>
                    </td>
                    <td>
                        <a href="deletePosition?positionID=${taskPositions.id}&taskID=${task.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <input type="submit" value="Save">
    </form>
</c:forEach>

</body>
</html>
