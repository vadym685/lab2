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
<h1>Point</h1>

<nav>
    <a href="/">Home</a>
    <a href="/tasksBrowse">Tasks</a>
    <a href="/pointsBrowse">Points</a>
    <a href="/personsBrowse">Persons</a>
    <div class="# start-home"></div>
</nav>
<br>

<%--@elvariable id="tempPoint" type="java.util.List"--%>
<c:forEach items="${tempPoint}" var="point">
    <form method=post action="saveEditedPoint" modelAttribute="point">
        ID:<input name="id" type="text" value=${point.id} readonly><br>
        NAME:<input name="name" type="text" value=${point.name}><br>
        ADRESS:<input name="adress" type="text" value=${point.adress}><br>
        LATITUDE:<input name="latitude" type="text" value=${point.latitude}><br>
        LONGITUDE:<input name="longitude" type="text" value=${point.longitude}><br>
        CONTACT_PERSON:<input name="contactPerson" type="text" value=${point.contactPerson}><br>
        CONTACT_NUMBER:<input name="contactNumber" type="text" value=${point.contactNumber}><br>
        COMMENT:<input name="comment" type="text" value=${point.comment}><br>

        <input name="save" type="submit" value="Save">
        <input name="saveClose" type="submit" value="Save&Close">
        <input name="close" type="submit" value="Close">

    </form>
</c:forEach>

</body>
</html>
