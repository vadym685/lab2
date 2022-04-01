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

<%--@elvariable id="tempPoint" type="java.util.List"--%>

<c:forEach items="${tempPoint}" var="point">
    <form method=post action="saveEditedPoint" modelAttribute="book">
        ID:<input name="id" type="text" value=${point.id} readonly><br>
        NAME:<input name="name" type="text" value=${point.name}><br>
        ADRESS:<input name="adress" type="text" value=${point.adress}><br>
        LATITUDE:<input name="latitude" type="text" value=${point.latitude}><br>
        LONGITUDE:<input name="longitude" type="text" value=${point.longitude}><br>
        CONTACT_PERSON:<input name="contactPerson" type="text" value=${point.contactPerson}><br>
        CONTACT_NUMBER:<input name="contactNumber" type="text" value=${point.contactNumber}><br>
        COMMENT:<input name="comment" type="text" value=${point.comment}><br>
        <input type="submit" value="Save">
    </form>
</c:forEach>

</body>
</html>
