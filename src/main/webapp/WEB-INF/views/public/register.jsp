<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<html lang="en">
<spring:url value="/resources/css" var="css"  />
<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/js" var="js" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%-- include file for header --%>
<jsp:include page="../shared/header.jsp">
	<jsp:param value="iniitian" name="title"/>
	<jsp:param value="${css}" name="css"/>	
</jsp:include>
<%-- -------------------- --%>
<body>

	<%--include file to display the menu --%>
	<jsp:include page="../shared/menu.jsp">
		<jsp:param value="${contextPath}" name="contextPath"/> 
	</jsp:include>
	<%-- -------------------- --%>
	
    <!-- Page Content -->
    <div class="container">
    		<h3>Register</h3>
    		<hr/>
        <div class="row">
        		<%-- Registration form code --%>
        		<div class="col-md-offset-2 col-md-8">
        		   
			   <form class="form-signin">
			   <div class="form-group">
		        <label for="inputEmail" class="sr-only">Email address</label>
		        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>			   
			   </div>
			   <div class="form-group">			   
		        <label for="inputPassword" class="sr-only">Choose Password</label>
		        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
		       </div>
			   <div class="form-group">			   
		        <label for="inputPassword" class="sr-only">Confirm Password</label>
		        <input type="password" id="inputConfirmPassword" class="form-control" placeholder="Confirm Password" required>
		       </div>
		        <button class="btn btn-sm btn-primary" type="submit">Register</button>
		      </form>
	      </div>        		                		
        
        
        </div>
     </div>

     <!-- /.container -->

    <div class="container">

	    <hr>
		<%--include file to add the footer --%>
		<jsp:include page="../shared/footer.jsp"/>
		<%-- -------------------- --%>
    </div>
    <!-- /.container -->
	
	<%-- include file for the scripts --%>
	<jsp:include page="../shared/scripts.jsp">
		<jsp:param value="${js}" name="js"/>
	</jsp:include>
	<%-- -------------------- --%>
    
    <script src="${js}/webapp.js"></script>


</body>

</html>
