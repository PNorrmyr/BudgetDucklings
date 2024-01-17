<%--
  Created by IntelliJ IDEA.
  User: Philip
  Date: 2024-01-15
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>invoice</title>
</head>
<body>
<h2>Invoice</h2>
<form action="addPayment.jsp">
    <button >Add payment</button>
</form>

<form action="editPayment.jsp">
    <button>Edit payments</button>
</form>

<c:forEach var="entry" items="${paymentEntries}">
    <p>Title: ${entry.title}</p>
    <p>Date: ${entry.date}</p>
    <p>Description: ${entry.description}</p>
    <p>Category: ${entry.category}</p>
    <p>Amount: ${entry.amount}</p>
</c:forEach>

</body>
</html>