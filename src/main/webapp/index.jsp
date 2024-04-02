<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.javarush.berezovskiy.constants.Constants" %>


<!doctype html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quests</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<h1>Quest World</h1>
<h3>Hello! You'll be able to find here a lot of quests in the future</h3>


<form action ="quest" method="post">
<label for="name">Enter your name:</label>
<input  type="text" id="name" name="name" placeholder="${Constants.DEFAULT_USERNAME}" required>
<input type="submit" value="Start the story">
</form>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        var nameInput = document.getElementById('name');
        nameInput.addEventListener('blur', function() {
            if (nameInput.value.trim() === '') {
                nameInput.value = "${Constants.DEFAULT_USERNAME}";
            }
        });
    });
</script>
</body>
</html>
