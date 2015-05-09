<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %> --%>


<section style="margin-top: 100px;">

			<div class="container">
						<div class="row">
							<div class="col-md-6 col-md-offset-3">
										<div class="panel panel-default">
											<div class="panel-heading">
												<strong class="text-center">Student Physical Info</strong>
											</div>	
										
											<div class="panel-body">
														<c:url value="/physicalinfo?id=${student_id}"   var="physicalInformation" /> 
														<form:form cssClass="form-horizontal" role="form" action="${physicalInformation}"  method="post"  modelAttribute="studentPhysicalInfo">
															
															
																	 <div class="form-group">
																					<div class="col-sm-8 col-sm-offset-2">
																						   <form:input path="dob" class="form-control" id="inputEmail3" placeholder="Date of birth  YYYY-MM-DD" />
																					</div>
																					
																					<div class="col-sm-8 col-sm-offset-2">
																						<form:errors path="dob" />
																					</div>
																					
																		</div> 	
																	
																		<div class="form-group">
																					<div class="col-sm-8 col-sm-offset-2">
																							<form:input path="height" class="form-control" id="inputEmail3"  placeholder="Height" />
																					</div>
																					<div class="col-sm-8 col-sm-offset-2">
																						<form:errors path="Height" />
																					</div>
																		</div>
																		
																		<div class="form-group">
																					<div class="col-sm-8 col-sm-offset-2">
																								<form:input path="weight" class="form-control" id="inputEmail3" placeholder="Weight" />
																					</div>
																					<div class="col-sm-8 col-sm-offset-2">
																								 <form:errors path="weight" />
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