<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Person List</title>

</head>
<body>
<h1>Person List</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Question</th>
            <th>Answer</th>
            <th>Points</th>
        </tr>
        <c:forEach items="${questions}" var="questions">
            <tr>
                <td>${questions.id}</td>
                <td>${questions.question}</td>
                <td>${questions.answer}</td>
                <td>${questions.points}</td>
            </tr>
        </c:forEach>
    </table>

    <a href="${pageContext.request.contextPath}/">EndTest</a>
    <a href="${pageContext.request.contextPath}/">NextQuestion</a>
    <a href="${pageContext.request.contextPath}/">EndTest</a>
</div>
</body>

</html>