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
<h1> + username + "'s Invoices</h1>

    <form action=\"addPayment.jsp\">
        <button>Add payment</button>
    </form>

    <form method= \"POST\" action=\"editPayment.jsp\">
        <button>Edit expense</button>");
        <input type="number" name="id" placeholder="Expense number">
    </form>

    <form method= "POST" action="/BudgetDucklings_war/payment/delete">
        <button>Delete expense</button>
        <input type="number" name="id" placeholder="Expense Number">
    </form>

    <form method="POST" action="/login/logout">
        <button>Logout</button>
    </form>
</body>
</html>
