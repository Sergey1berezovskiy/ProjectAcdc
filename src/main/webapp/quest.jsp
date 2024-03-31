<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="questNames" scope="request" type="java.util.List"/>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quests</title>
</head>
<body>
<h1>Chose a quest:</h1>
<td onclick="window.location='/start'">${questNames.get(0)}</td>

<form action="quest" method="get">
    <label>
        <select name="questNames">
            <c:forEach items="${questNames}" var="questName">
                <option value="${questName}">${questName}</option>
            </c:forEach>
        </select>
    </label>
    <input type="submit" value="Begin the quest">
</form>
</body>
</html>
