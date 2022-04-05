<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Welcome</title>
    <style>
        input[type=text], input[type=hidden], input[type=date], input[type=checkbox], table {
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
    <div class="# start-home"></div>
</nav>
<br>

<%--@elvariable id="tempPersonMap" type="java.util.List"--%>
<c:forEach items="${tempPersonMap}" var="persons">
    <form method=post action="saveEditedPersons?taskID=${taskID}" modelAttribute="persons">
        ID:<input name="id" type="text" value=${persons.id} readonly><br>
        NAME:<input name="name" type="text" value=${persons.name}><br>
        FULL_NAME:<input name="fullName" type="text" value=${persons.fullName}><br>
        PHONE_NUMBER:<input name="phoneNumber" type="text" value=${persons.phoneNumber}><br>
        ADMIN:<input name="admin" type="checkbox" ${persons.admin  ? "checked":""} ><br>
        MANAGER_ID:<input name="manager" type="text" value=${persons.manager.id}><br>
        <input type="submit" value="Save">
    </form>
</c:forEach>

</body>
</html>
