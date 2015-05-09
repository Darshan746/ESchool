<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>




<section style="margin-top: 70px">

<!--  Add Section  -->
<c:if test="${ sectionId eq 0 }">

					<div class="container">
									<div class="row">
											<div class="col-md-6 col-md-offset-3">
													<div class="panel panel-default">
															<div class="panel-heading">
																<strong class="text-center">Add Section</strong>
															</div>
													
														<div class="panel-body">
																<c:url value="/section/addSection"   var="section" /> 
																<form:form cssClass="form-horizontal" role="form" action="${ section}"  method="post"  modelAttribute="section">
																
																			<div class="form-group">
																					<div class="col-sm-8 col-sm-offset-2">
																							<form:input path="sectionName" class="form-control" id="inputEmail3" placeholder="section" />
																					</div>
																					<div class="col-sm-8 col-sm-offset-2">
																							<form:errors path="sectionName" />
																					</div>
																			</div>
																			<div class="form-group last">
																					<div class="col-sm-offset-3 col-sm-9">
																							<button type="submit" class="btn btn-primary">add</button>
																							<button type="reset" class="btn btn-danger">cancel</button>
																					</div>
																			</div>
																</form:form>
														</div>
												</div>
										</div>
							</div>
					</div>
			</c:if>	
			<!--  Add Section Ends Here -->
			
			
			
			
			<!--  Edit Section  Starts here-->
			
			<c:if test="${sectionId  gt 0 }">	
			<div class="container">
									<div class="row">
											<div class="col-md-6 col-md-offset-3">
													<div class="panel panel-default">
															<div class="panel-heading">
																<strong class="text-center">Edit Section</strong>
															</div>
													
														<div class="panel-body">
																<c:url value="/section/updateSection?section_id=${sectionId}"   var="updateSection" /> 
																<form:form cssClass="form-horizontal" role="form" action="${updateSection}"  method="post"  modelAttribute="section">
																
																			<div class="form-group">
																					<div class="col-sm-8 col-sm-offset-2">
																							<form:input path="sectionName" class="form-control" id="inputEmail3" value="${sectionObject.sectionName}"/>
																					</div>
																					<div class="col-sm-8 col-sm-offset-2">
																							<form:errors path="sectionName" />
																					</div>
																			</div>
																			<div class="form-group last">
																					<div class="col-sm-offset-3 col-sm-9">
																							<button type="submit" class="btn btn-primary">add</button>
																							<button type="reset" class="btn btn-danger">cancel</button>
																					</div>
																			</div>
																</form:form>
														</div>
												</div>
										</div>
							</div>
					</div>
			</c:if>	
			<!-- Edit section Ends here -->
			
			
			
					<!-- Section Display Starts Here -->
					<div class="container">
							<div class="row">
						  			<h2 class=" col-md-offset-2">Sections</h2>
						          
									  <table class="table table-bordered col-md-offset-2">
											    <thead>
											      <tr>
											        <th ">Section_Id</th>
											        <th>Section_Name</th>
											         <th>Edit</th>
											          <th>Delete</th>
											        
											      </tr>
											    </thead>
											    <tbody>
													     	<c:forEach items="${sectionList}" var="sections">
																						<tr>
																								<td>${sections.id}</td>
																								<td>${sections.sectionName}</td>
																								<c:url value="editSection?section_id=${sections.id}" var="sectionId"></c:url>
																								<c:url value="deleteSection?section_id=${sections.id}" var="deleteId"></c:url>
																								<td><a href="${sectionId}">Edit</a></td>
																								<td><a href="${deleteId}">Delete</a></td>
																						</tr>
														</c:forEach>
											    </tbody>
								     </table>
					</div>
				</div>
	
</section> 