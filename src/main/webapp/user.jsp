<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="grid">
		<h1>
			Welcome <span id="user"><i><b><%=session.getAttribute("userName") %></b></i></span>
		</h1>
		<div class="form__field">
		<form action="LogoutServlet" method="post" class="form logout">
				<input type="submit" value="Log Out" />
			</form>
			</div>
			<div class="form__field">
		<input type="button" value="Check Balance" 
					onclick="location.href='checkBalance.jsp'" />
		</div>
			<div class="form__field">
		<input type="button" value="Deposit Amount" 
					onclick="location.href='depositMoney.jsp'" />
		</div>
			<div class="form__field">
		<input type="button" value="Withdraw Amount" 
					onclick="location.href='withdrawMoney.jsp'" />
		</div>
		<div class="form__field">
		<input type="button" value="Transfer Amount" 
					onclick="location.href='transferMoney.jsp'" />
		</div>
	</div>
</body>
</html>