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
						<strong class="text-center">Sign Up</strong>
						
							<c:if test="${! empty RegisteredStudent }">
								<p class="text-center">the Student ${ RegisteredStudent} added successfully</p>
							</c:if>
							
					</div>
					<div class="panel-body">
						<c:url value="/student/register" var="register" /> 
						<form:form cssClass="form-horizontal" role="form" action="${register}" method="post" modelAttribute="student">
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:input path="student_name" class="form-control" id="inputEmail3"
										placeholder="student_name" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="student_name" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:input path="roll_no" class="form-control" id="inputEmail3"
										placeholder="roll_no" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="roll_no" />
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:input path="standard" class="form-control" id="inputEmail3"
										placeholder="Standard" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="standard" />
								</div>
							</div>
							
							
  									<div class="form-group">
											<div class="col-sm-8 col-sm-offset-2">
														<form:select path="section">  
														<form:option value="NONE" label="----------------Select Section For Student--------------"/>      
						    							<form:options items="${sections}"/>
						  								</form:select> 
	  										</div>
								</div>
							
							<h4 class="text-center">Address Details</h4>
							
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:input path="address.area" class="form-control" id="inputEmail3"
										placeholder="Area" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="section" />
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:input path="address.city" class="form-control" id="inputEmail3"
										placeholder="City" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="address.city" />
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:input path="address.country" class="form-control" id="inputEmail3"
										placeholder="Country" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="address.country" />
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:input path="address.pin" class="form-control" id="inputEmail3"
										placeholder="pin" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="address.pin" />
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:input path="address.state" class="form-control" id="inputEmail3"
										placeholder="State" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="address.state" />
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-2">
									<form:input path="address.street" class="form-control" id="inputEmail3"
										placeholder="Street" />
								</div>
								<div class="col-sm-8 col-sm-offset-2">
									<form:errors path="address.street" />
								</div>
							</div>
							
							
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