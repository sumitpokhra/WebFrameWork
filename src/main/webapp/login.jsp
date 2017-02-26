<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<div class="grid">
		<h1>Smoke Automation</h1>
		<form action="LoginServlet" method="post" class="form login">
			<%
				if (null != request.getAttribute("errorMsg")) {
					out.print("<h2 id='errorMsg'>"+request.getAttribute("errorMsg")+"</h2>");
				}
			%>
			<div class="form__field">
				<input type="text" name="username" placeholder="Username"
					required="required" />
			</div>
			<div class="form__field">
				<input type="password" name="password" placeholder="Password"
					required="required" />
			</div>
			<div class="form__field">
				<input type="submit" value="Sign In">
			</div>
		</form>
	</div>
</body>
</html>