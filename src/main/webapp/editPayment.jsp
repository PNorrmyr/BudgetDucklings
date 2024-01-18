<%--
  Created by IntelliJ IDEA.
  User: Philip
  Date: 2024-01-15
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Expense</title>
</head>
<body>
<h2>Edit Expense number <%= request.getParameter("id") %></h2>
<form method="post" action="${pageContext.request.contextPath}/payment/edit">
    <label>Title</label>
    <input type="text" name="title">
    <br>
    <label>Date</label>
    <input type="date" name="date">
    <br>
    <label>Description</label>
    <input type="text" name="description">
    <br>
    <label>Category </label>
    <select name="category">
        <option value="Travel to/from work">Travel to/from work</option>
        <option value="Lunch meeting">Lunch meeting</option>
        <option value="Overtime">Overtime</option>
        <option value="Other">Other</option>
        <br>
        <label>Amount</label>
        <input type="text" name="amount">
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
        <br>

        <button>Submit changes</button>
</form>
</body>
</html>
