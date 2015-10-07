<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/7/15
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="/spitter/register" method="POST">
        <p>Name<input type="text" name="username" /></p>
        <p>Password<input type="text" name="password" /></p>
        <p>First Name<input type="text" name="firstName" /></p>
        <p>Last Name<input type="text" name="lastName" /></p>
        <p>Email<input type="text" name="email" /></p>
        <p><input type="submit" value="Submit" /></p>
    </form>
</body>
</html>
