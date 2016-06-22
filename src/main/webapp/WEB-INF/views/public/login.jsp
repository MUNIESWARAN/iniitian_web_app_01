<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


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
	<%@include file="../shared/menu.jsp" %>
<%-- 	<jsp:include page="../shared/menu.jsp">
		<jsp:param value="${contextPath}" name="contextPath"/> 
	</jsp:include>
 --%>	<%-- -------------------- --%>
	
    <!-- Page Content -->
    <div class="container">
    		<h3>Please Login</h3>
    		<hr/>
        <div class="row">
        		<%-- Login form code --%>
        		<div class="col-md-offset-2 col-md-8">
		    		<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">
					  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
					  <span class="sr-only">Error:</span>
					  	${error}
					</div>
					<div>
						<hr/>
							<a href="${contextPath}/register">Click here</a> to register if you are a new user! 
						<hr/>
					</div>    		
		    		</c:if>
        		   
			   <form class="form-signin" name="f" method="POST" action="${contextPath}/login">
			   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" class="form-control" />
			   <div class="form-group">
		        <label for="inputEmail" class="sr-only">Email address</label>
		        <input type="text" name="username" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>			   
			   </div>
			   <div class="form-group">			   
		        <label for="inputPassword" class="sr-only">Password</label>

		        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
		       </div>
		        <button class="btn btn-sm btn-primary" type="submit">Sign in</button>
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
