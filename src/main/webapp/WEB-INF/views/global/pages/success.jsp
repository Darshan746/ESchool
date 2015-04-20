<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!-- Add School Section -->
<section style="margin-top: 100px;">
	<div class="container">
		<div class="row">
			Welcome ${loggedInUser}
			<p>
				<a href="<c:url value="/j_spring_security_logout"></c:url>">Logout</a>
			</p>
		</div>
	</div>
</section>