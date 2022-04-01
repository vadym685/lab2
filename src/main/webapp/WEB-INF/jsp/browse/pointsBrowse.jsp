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
<form method=get action="searchPoint">
    <input type="hidden" name="action" value="Search">

    Search by <select id="searchField" name="searchField">
    <option value="ID">Id</option>
    <option value="NAME">Name</option>
</select>: <input type="text" name="searchString">
</form>

<br>
<table id="table">
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
            <td>
                <a href="edit?pointID=${point.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
<%--<script src="https://code.jquery.com/jquery-2.2.4.js" type="text/javascript">--%>

<%--    $(".approve").click(function(){--%>
<%--        var selecred_btn_id = $(this).attr("id");--%>

<%--        var sel_task_id = $("Task"+selecred_btn_id).attr("id");--%>

<%--        window.alert(sel_task_id);--%>
<%--        // your remaing code goes here--%>

<%--    })--%>

<%--</script>--%>
</html>
