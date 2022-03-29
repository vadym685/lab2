<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Welcome</title>
</head>
<body>

<h1>Welcome</h1>

<nav>
    <a href="/">Home</a>
    <a href="/tasksBrowse">Tasks</a>
    <a href="/pointsBrowse">Points</a>
    <a href="/personsBrowse">Persons</a>
    <a href="/consumablesBrowse">Consumables</a>
    <a href="/contact">Contact</a>
    <div class="# start-home"></div>
</nav>
<br>
<form method = get action="searchPointByID" >
    <input type="hidden" name="action" value = "Search">

    Enter ID: <input type="text" name="search_string">
</form>
<br>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>ADRESS</th>
        <th>LATITUDE</th>
        <th>LONGITUDE</th>
        <th>CONTACT_PERSON</th>
        <th>CONTACT_NUMBER</th>
        <th>COMMENT</th>
    </tr>

    <%--@elvariable id="tempPointsMap" type="java.util.List"--%>
    <c:forEach items="${tempPointsMap}" var="point">

        <tr>
            <td>${point.id}</td>
            <td>${point.name}</td>
            <td>${point.adress}</td>
            <td>${point.latitude}</td>
            <td>${point.longitude}</td>
            <td>${point.contactPerson}</td>
            <td>${point.contactNumber}</td>
            <td>${point.comment}</td>
        </tr>
    </c:forEach>

</table>


</body>

</html>