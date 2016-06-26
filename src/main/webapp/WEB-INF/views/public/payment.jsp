<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
    		<h3>Please enter payment details!</h3>
    		<hr/>
        <div class="row">
        		<div class="col-md-offset-3 col-md-6">
        		<form:form modelAttribute="cardDetail" method="POST">
	        		<fieldset class="form-group">
				    <label for="cardType">Select Card Type</label>
				    <form:select path="cardType" cssClass="form-control" id="ddlCity">
				    		<form:option value="0">Select card</form:option>
						<form:option value="visa">Visa</form:option>
						<form:option value="master">Master</form:option>								    		
				    </form:select>		        
				    <form:errors path="cardType" cssClass="error"/>
			  	</fieldset>
				  <fieldset class="form-group">
				    <label for="cardNumber">Enter Card Number</label>
				    <form:input path="cardNumber" id="cardNumber" placeholder="Card Number" cssClass="form-control"/>
				  </fieldset>
	        		<fieldset class="form-group">
				    <label>Select Expiry Month and Year</label>
				    <div class="row">
					    <div class="col-md-2">
					    <form:select path="expiryMonth" cssClass="form-control" id="expiryMonth">
					    		<form:option value="0">MM</form:option>
							<form:option value="1">JAN</form:option>
							<form:option value="2">FEB</form:option>
							<form:option value="3">MAR</form:option>
							<form:option value="4">APR</form:option>
							<form:option value="5">MAY</form:option>
							<form:option value="6">JUN</form:option>
							<form:option value="7">JUL</form:option>
							<form:option value="8">AUG</form:option>
							<form:option value="9">SEP</form:option>
							<form:option value="10">OCT</form:option>
							<form:option value="11">NOV</form:option>
							<form:option value="12">DEC</form:option>														    		
					    </form:select>				    				    
					    </div>
					    <div class="col-md-2">
					    <form:select path="expiryYear" cssClass="form-control" id="expiryMonth">
					    		<form:option value="0">YY</form:option>
							<form:option value="16">16</form:option>
							<form:option value="17">17</form:option>
							<form:option value="18">18</form:option>
							<form:option value="19">19</form:option>
							<form:option value="20">20</form:option>
							<form:option value="21">21</form:option>
							<form:option value="22">22</form:option>
							<form:option value="23">23</form:option>
							<form:option value="24">24</form:option>
							<form:option value="25">25</form:option>
					    </form:select>				    
						    <form:errors path="expiryMonth" cssClass="error"/>
						    <form:errors path="expiryYear" cssClass="error"/>
					    </div>
				    </div>
			  	</fieldset>
				  <fieldset class="form-group">
				    <label for="cvNumber">Enter CVV Number</label>				    
				    <form:password path="cvNumber" id="cardNumber" placeholder="XXX" cssClass="form-control"/>
				  </fieldset>
				  <fieldset class="form-group">
				    <label for="nameOnCard">Name on card</label>				    
				    <form:password path="nameOnCard" id="nameOnCard" placeholder="Name on card" cssClass="form-control"/>
				  </fieldset>
				  <fieldset class="form-group">
				    <label for="atmPin">Enter ATM Pin</label>				    
				    <form:password path="atmPin" id="atmPin" placeholder="XXXX" cssClass="form-control"/>
				  </fieldset>
				  <fieldset class="form-group">
			        <button class="btn btn-success" name="_eventId_paymentConfirm" type="submit">Confirm Payment</button>
			        <button class="btn btn-danger" name="_eventId_cancelOrder" type="submit">Cancel Order</button>				  	
				  </fieldset>
				  
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
