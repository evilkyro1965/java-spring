<%@ page import="java.util.List" %>
<%@ page import="com.kyrosoft.domain.Country" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/29/15
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="FormHelper" uri="/WEB-INF/tlds/ch07.tld" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    List<Country> countries = new ArrayList<Country>();
    Country country = new Country();
    country.setName("Indonesia");
    country.setId(1);
    Country country1 = new Country();
    country1.setName("USA");
    country1.setId(2);

    countries.add(country);
    countries.add(country1);
    pageContext.setAttribute("countries", countries);
%>
<FormHelper:select name="countrySelect" label="name" value="id" items="${countries}" size="3"></FormHelper:select>
</body>
</html>
