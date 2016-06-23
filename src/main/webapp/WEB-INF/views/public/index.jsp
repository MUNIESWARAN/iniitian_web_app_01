<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<html lang="en" ng-app="webapp">
<spring:url value="/resources/css" var="css"  />
<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/js" var="js" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%-- include file for header --%>
<jsp:include page="../shared/header.jsp">
	<jsp:param value="iniitian" name="title"/>
	<jsp:param value="${css}" name="css"/>	
</jsp:include>
<%-- ------------------- --%>
<body>
	<%-- include file for menu --%>
	<%@ include file="../shared/menu.jsp" %>	
<%-- 	<jsp:include page="../shared/menu.jsp">
		<jsp:param value="${contextPath}" name="contextPath"/> 
	</jsp:include>
 --%>	<%-- ------------------- --%>
    <!-- Page Content -->
    <div class="container" ng-controller="CategoryController as categoryCtrl">

        <div class="row">
            <div class="col-md-3">
                <p class="lead">iNIITian</p>
                <div class="list-group" >
                    <a ng-href="#/category/{{category.id}}/product" class="list-group-item" ng-repeat="category in categoryCtrl.categories">{{category.name}}</a>
                </div>
            </div>

            <div class="col-md-9">

                <div class="row carousel-holder" ng-non-bindable>
                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="${images}/product_one.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="${images}/product_two.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="${images}/product_three.jpg" alt="">
                                </div>
                            </div>
                            <span class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </span>
                            <span class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </span>
                        </div>
                    </div>

                </div>

                <div class="row">
					<div>{{ categoryCtrl.error }}</div>
                    <div class="col-sm-4 col-lg-4 col-md-4" ng-repeat="category in categoryCtrl.categories">
                        <div class="thumbnail">
                        		<a ng-href="${contextPath}/productList?category={{category.id}}">
                            		<img ng-src="${images}/{{category.imageUrl}}" />
                            	</a>
                            <div class="caption">
                                <h4><a ng-href="${contextPath}/productList?category={{category.id}}">{{ category.name }}</a>
                                </h4>
                                <p>{{category.description | limitTo:50}}{{category.description.length>20 ? ' ...' : ''}}</p>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>

		
    </div>
    <!-- /.container -->

    <div class="container">

    		<hr>
		<%-- include file for footer --%>
		<jsp:include page="../shared/footer.jsp"/>
		<%-- -------------------- --%>
    </div>
    <!-- /.container -->
	<%-- include file for scripts --%>
	<jsp:include page="../shared/scripts.jsp">
		<jsp:param value="${js}" name="js"/>
	</jsp:include>
	<%-- ----------- --%>
    <script src="${js}/app.js"></script>
    <script src="${js}/webapp.js"></script>


</body>

</html>
