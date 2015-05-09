<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-10 content">
	<div class="panel panel-default">
		<div class="panel-heading">
			Dashboard
		</div>
		<div class="panel-body">
			Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
			tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
			consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
			cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
			proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
		</div>
	</div>
	
	<!--Info Modal Templates-->
    <div id="modal-info" class="modal modal-message modal-info fade" style="display: none;" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <i class="fa fa-envelope"></i>
                </div>
                <div class="modal-title">Reminder</div>

                <div class="modal-body no-school"></div>
                <div class="modal-footer">
                    <c:url value="/admin/school/add" var="addSchool"/>
                    <a href="${addSchool}" class="btn btn-info">Add School</a>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Not Now</button>
                </div>
            </div> <!-- / .modal-content -->
        </div> <!-- / .modal-dialog -->
    </div>
    <!--End Info Modal Templates-->
	
</div>