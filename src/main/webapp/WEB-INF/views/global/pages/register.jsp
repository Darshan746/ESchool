<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %> --%>

<!-- Add School Section -->
<section style="margin-top: 100px;">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong class=""><center>Sign Up</center></strong>

					</div>
					<div class="panel-body">
						<c:url value="/register" var="register" /> 
						<form:form cssClass="form-horizontal" role="form" action="${register}" method="post" modelAttribute="user">
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:input path="name" class="form-control" id="inputEmail3"
										placeholder="Full Name" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="name" />
								</div>
							</div>
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
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:password path="confirmPassword" class="form-control" id="inputEmail3"
										placeholder="Confirm password" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="confirmPassword" />
								</div>
							</div>
							<%-- <div class="" id="captcha_paragraph">
								<c:if test="${invalidRecaptcha == true}">
									<span class="error_form_validation"><spring:message code="invalid.captcha" text="Invalid captcha please try again"/></span>
								</c:if>
							    <%
							        ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LcW3OASAAAAAKEJTHMmp_bo5kny4lZXeDtgcMqC", 
							        					"6LcW3OASAAAAAKVX2duVsSy2uMMHL105-jPDrHMD", false);
							        out.print(c.createRecaptchaHtml(null, null));
							    %>			    
							</div> --%>
							
							<div class="form-group last">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-success">Sign Up</button>
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