<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<div class="grid">
	<h1>
			Welcome<span id="user"> <i><b><%=session.getAttribute("userName") %></b></i></span>
		</h1>
		<h1>Create New Account</h1>
			<div class="form__field">
		<form action="LogoutServlet" method="post" class="form logout">
				<input type="submit" value="Log Out" />
			</form>
			</div>
		<form action="RegisterServlet" method="post" class="form login">
			<div class="form__field">
				<input type="text" name="firstname" placeholder="Enter First Name"
					required="required" />
			</div>
			<div class="form__field">
				<input type="text" name="middlename" placeholder="Enter Middle Name"
					required="required" />
			</div>
			<div class="form__field">
				<input type="text" name="lastname" placeholder="Enter Last Name"
					required="required" />
			</div>
			<div class="form__field">
				<input type="text" name="username" placeholder="Enter Username"
					required="required" />
			</div>
			<div class="form__field">
				<input type="text" name="email" placeholder="Enter Valid Email"
					required="required" />
			</div>
			<div class="form__field">
				<input type="number" name="mobile" placeholder="Enter Mobile No."
					required="required" />
			</div>
			<div class="form__field">
				<input type="text" name="address" placeholder="Enter Address"
					required="required" />
			</div>
			<div class="form__field">
				<input type="password" name="password" placeholder="Enter Valid Password"
					required="required" />
			</div>
			<div class="form__field">
				<input type="submit" value="Create Account">
			</div>
		</form>
	</div>



</body>
</html>

