<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="./fragments/head.jsp"%>
</head>
<body style="background-color: #E9ECEB;">
<%@include file="./fragments/menu.jsp"%>
<div class="container m-2">
	<div class="container-sm" style="background-color: #FCFCFC;">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h4 class="text-center mb-3 mt-3 text-warning">Add User</h4>
				<!-- form -->
				<!-- В атрибутах for, id, name прописуємо так, як прописані змінні в Entity-класі,
                оскільки Hibernate розуміє саме такий напис -->
				<form action="${pageContext.request.contextPath}/add-user" method="post">
					<div>
						<label for="firstName"><span style="font-size:12px;">First name</span></label>
						<input type="text" class="form-control fw-light" id="firstName" name="firstName"
							   placeholder="First name..." required>
					</div>
					<div>
						<label for="lastName"><span style="font-size:12px;">Last name</span></label>
						<input type="text" class="form-control fw-light" id="lastName" name="lastName"
							   placeholder="Last name..." required>
					</div>
					<div>
						<label for="phone"><span style="font-size:12px;">Phone</span></label>
						<input type="text" class="form-control fw-light" id="phone" name="phone"
							   placeholder="Phone..." required pattern="^\+?\d{10,15}$" title="Please enter a valid phone number">
					</div>
					<div class="container text-center mb-4"><br>
						<a href="${pageContext.request.contextPath}/users" class="btn btn-outline-primary btn-sm">Back</a>
						&nbsp;&nbsp;
						<button type="submit" class="btn btn-primary btn-sm">Add</button>
					</div>
				</form>
				<!-- end form -->
			</div>
		</div>
	</div>
</div>
<%@include file="./fragments/js_inc.jsp"%>
</body>
</html>