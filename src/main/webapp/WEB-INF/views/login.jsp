<%@ include file="../template/header.jsp"%>
<p>${error}</p>
<div class="col-4">
	<form name='loginForm'
		action="<c:url value='/j_spring_security_check' />" method='POST'>
		<div class="form-group">
			<input type="text" class="form-control" name="email"
				placeholder="Email Address" />
		</div>
		<div class="form-group">
			<input type="password" class="form-control" name="password"
				placeholder="Password" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="Login"
			class="btn btn-primary" />
	</form>
</div>
<%@ include file="../template/footer.jsp"%>