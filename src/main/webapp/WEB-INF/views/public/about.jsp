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
    		<h3>About Us</h3>
    		<hr/>
        <div class="row">
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Veniam a, eum illum temporibus voluptatibus libero, fugiat nam corporis, debitis numquam aperiam ratione minus rerum incidunt dolorem obcaecati quia, nulla adipisci.</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad expedita non optio tenetur voluptatum, veniam animi quae fugit. Quos hic, et repellat consequatur, veritatis voluptatibus enim veniam expedita soluta assumenda!</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo, adipisci inventore aspernatur atque, consequatur veniam laudantium expedita placeat repellat explicabo magnam beatae eligendi. Illum, dicta eum hic officia obcaecati magnam.</p>     		
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
