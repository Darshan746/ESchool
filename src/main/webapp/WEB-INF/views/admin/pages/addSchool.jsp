<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="col-md-6 col-md-offset-2 content">
	<div class="panel panel-default">
		<div class="panel-heading">
			Admin | Add School Information
		</div>
			<div class="panel-body">
			<c:url value="/admin/school/add" var="addSchool"/>	
             <form:form role="form" action="${addSchool}" method="POST" modelAttribute="school">
                 <div class="form-group">
                     <form:input path="name" class="form-control input-lg" placeholder="School Name" />
                 </div>

                 <div class="form-group">
                     <form:textarea path="about" class="form-control input-lg" placeholder="About School"/>
                 </div>
				
                 <div class="form-group">
                     <form:input path="address.street" class="form-control input-lg" placeholder="Street" />
                 </div>
                 
                 <div class="form-group">
                     <form:input path="address.landmark" class="form-control input-lg" placeholder="Nearest Landmark" />
                 </div>
                 
                 <div class="form-group">
                     <form:input path="address.area" class="form-control input-lg" placeholder="Area" />
                 </div>
                 
                 <div class="row">
	                 <div class="form-group col-xs-6 col-sm-6 col-md-6">
	                     <form:input path="address.city" class="form-control input-lg" placeholder="City" />
	                 </div>
	                 
	                 <div class="form-group col-xs-6 col-sm-6 col-md-6">
	                     <form:input path="address.state" class="form-control input-lg" placeholder="State" />
	                 </div>
                 </div>
                 
                 <div class="row">
	                 <div class="form-group col-xs-6 col-sm-6 col-md-6">
	                     <form:input path="address.country" class="form-control input-lg" placeholder="Country" />
	                 </div>
	                 
	                 <div class="form-group col-xs-6 col-sm-6 col-md-6">
	                     <form:input path="address.pin" class="form-control input-lg" placeholder="PIN" />
	                 </div>
                 </div>
				 <div class="row">
				 	<div class="form-group col-md-6">
				 		<input type="reset" value="Reset" class="btn btn-info sub-button">
				 	</div>
				 	<div class="form-group col-md-6">
				 		<input type="submit" value="Save" class="btn btn-info sub-button">
				 	</div>	
	             </div>
             </form:form>
         </div>
	</div>	
</div>