<%--
  Created by IntelliJ IDEA.
  User: Philip
  Date: 2024-01-15
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add Payment</h1>
<form method="post" action="/payment">
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
        <option value="cat1">Category 1</option>
        <option value="cat2">Category 2</option>
        <option value="cat3">Category 3</option>
        <option value="cat4">Category 4</option>
    <br>
    <label>Amount</label>
    <input type="text" name="amount">
    <br>

    <button>Add Expense</button>
</form>



</body>
</html>
