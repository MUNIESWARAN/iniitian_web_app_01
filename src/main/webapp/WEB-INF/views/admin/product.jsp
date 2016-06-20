<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


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
    		<h3>Add Product</h3>
    		<hr/>
        <div class="row">
        		<%-- Add Product Code --%>
        		<div class="col-xs-12">
		<form:form modelAttribute="product" action="${contextPath}/admin/product/add" method="POST" enctype="multipart/form-data">
		  <form:hidden path="id"/>
		  <fieldset class="form-group">
		    <label for="name">Enter Product Name</label>
		    <form:input  path="name" id="name" placeholder="Enter name" cssClass="form-control"/>
		    <form:errors path="name" cssClass="error"/>
		  </fieldset>
		  <fieldset class="form-group">
		    <label for="brand">Enter Brand Name</label>
		    <form:input  path="brand" id="brand" placeholder="Enter brand" cssClass="form-control"/>
		    <form:errors path="brand" cssClass="error"/>
		  </fieldset>
		  <fieldset class="form-group">
			<label for="category">Select Category</label>
			    <form:select path="categoryId" cssClass="form-control" id="category">
			    		<form:option value="0">Select a category</form:option>
					<form:options items="${categories}"/>		    		
			    </form:select>
	    		  	<form:errors path="categoryId" cssClass="error"/>
		    </fieldset>
		  <fieldset class="form-group">
		    <label for="price">Enter Price</label>
		    <form:input path="price" id="price" placeholder="0" cssClass="form-control"/>
		  </fieldset>
		  <fieldset class="form-group">
		    <label for="quantity">Enter Quantity</label>
		    <form:input path="quantity" id="quantity" placeholder="0" type="number" cssClass="form-control"/>
		  </fieldset>
		  <fieldset class="form-group">
		    <label for="description">Enter Description</label>
		    <form:textarea path="description" id="description" type="number" cols="50" rows="3" cssClass="form-control"/>
		    <form:errors path="description" cssClass="error"/>
		  </fieldset>
		  <fieldset class="form-group">
		  	<div class="row">
		  		<div class="col-md-6">
				    <label for="uploadImage">Upload Image for Product</label>
			    		<form:input type="file" class="form-control-file" id="uploadImage" path="file" />
	    		  		<%-- <form:errors path="file"/>  --%>
	    		  		<form:hidden path="imageUrl"/>	    		  		
		  		</div>
		  		<div class="col-md-6">
		  			<div id="imgContainer">
		  				<img src="${images}/${product.imageUrl}" width="200px" alt=""/>
		  			</div>		  			
		  		</div>
		  	</div>
		  </fieldset>			

		  <button type="submit" class="btn btn-primary">Save</button>
		  
		</form:form>
		
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
