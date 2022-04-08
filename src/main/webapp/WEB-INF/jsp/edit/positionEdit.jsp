<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Welcome</title>
    <style>
        input[type=text], input[type=hidden], input[type=date],table {
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
<h1>Position</h1>

<nav>
    <a href="/">Home</a>
    <a href="/tasksBrowse">Tasks</a>
    <a href="/pointsBrowse">Points</a>
    <a href="/personsBrowse">Persons</a>

    <div class="# start-home"></div>
</nav>
<br>

<%--@elvariable id="tempPosition" type="java.util.List"--%>
<c:forEach items="${tempPosition}" var="position">
    <form method=post action="saveEditedPosition?taskID=${taskID}" modelAttribute="position">
        ID:<input name="id" type="text" value=${position.id} readonly><br>
        DESCRIPTION:<input name="description" type="text" value=${position.description}><br>
        COMMENT:<input name="comment" type="text" value=${position.comment}><br>

        <input name="saveClose" type="submit" value="Save&Close">
        <input name="close" type="submit" value="Close">

    </form>
</c:forEach>

</body>
</html>
