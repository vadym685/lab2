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
<h1>Welcome</h1>

<nav>
    <a href="/">Home</a>
    <a href="/tasksBrowse">Tasks</a>
    <a href="/pointsBrowse">Points</a>
    <a href="/personsBrowse">Persons</a>
    <div class="# start-home"></div>
</nav>
<br>

<%--@elvariable id="tempConsumables" type="java.util.List"--%>
<c:forEach items="${tempConsumables}" var="consumables">
    <form method=post action="saveEditedConsumables?taskID=${taskID}" modelAttribute="consumables">
        ID:<input name="id" type="text" value=${consumables.id} readonly><br>
        NAME:<input name="name" type="text" value=${consumables.name}><br>
        DESCRIPTION:<input name="description" type="text" value=${consumables.description}><br>
        COMMENT:<input name="comment" type="text" value=${consumables.comment}><br>

        <input name="saveClose" type="submit" value="Save&Close">
        <input name="close" type="submit" value="Close">

    </form>
</c:forEach>

</body>
</html>
