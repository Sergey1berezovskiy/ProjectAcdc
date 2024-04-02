<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quests</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<c:choose>
    <c:when test="${stepOfQuest eq -1}">
        <h1>Chose a quest:</h1>
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
    </c:when>

    <c:otherwise>
        <c:choose>
            <c:when test="${empty validAnswer}">
                <h1>${story}</h1>
                <form action="restart" method="post">
                    <input type="submit" value="Restart">
                </form>
            </c:when>
            <c:otherwise>
                <h1>${story}</h1>
                <form action="quest" method="get">
                    <input type="hidden" name="validAnswer" value="${validAnswer}">
                    <input type="submit" value="${validAnswer}">
                </form>
                <form action="restart" method="get">
                    <input type="hidden" name="invalidAnswer" value="${invalidAnswer}">
                    <input type="hidden" name="invalidStory" value="${invalidStory}">
                    <input type="submit" value="${invalidAnswer}">
                </form>
            </c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>

</body>
</html>
