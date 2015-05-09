<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!-- Add School Section -->
<section style="margin-top: 100px;">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				
				<c:if test="${! empty logout}">
					<div class="alert alert-success text-center">
						${logout}
					</div>
				</c:if>
				
				<c:if test="${! empty sessionExp}">
					<div class="alert alert-success text-center">
						${sessionExp}
					</div>
				</c:if>
				
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong class=""><center>Sign In</center></strong>

					</div>
					<div class="panel-body">
						<c:url value="/processLogin" var="login" /> 
						<form:form cssClass="form-horizontal" role="form" action="${login}" method="post" modelAttribute="user">
							
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:input path="email" class="form-control" id="inputEmail3"
										placeholder="Email" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="email" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:password path="password" class="form-control" id="inputEmail3"
										placeholder="Password" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="password" />
								</div>
							</div>
							
							<div class="form-group last">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-success">Sign In</button>
									<button type="reset" class="btn btn-default">Reset</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>