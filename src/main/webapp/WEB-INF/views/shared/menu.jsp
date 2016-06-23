    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${contextPath}">iNIITian Shop</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li id="about">
                        <a href="${contextPath}/about">About</a>
                    </li>
                    <li id="contact">
                        <a href="${contextPath}/contact">Contact</a>
                    </li>
                    <li id="products">
                        <a href="${contextPath}/productList">View All</a>
                    </li>
                    <sec:authorize access="isAnonymous()">
	                    <li id="login">
	                        <a href="${contextPath}/login">
	                        <span class="glyphicon glyphicon-log-in"></span> Login
	                        	</a>
	                    </li>
	                    <li id="register">
	                        <a href="${contextPath}/register"><span class="glyphicon glyphicon-user"></span> Register</a>
	                    </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
						<li>
							 <a href="" class="dropdown-toggle" data-toggle="dropdown">Admin <b class="caret"></b></a>
				              <ul class="dropdown-menu">
				                <li><a href="${contextPath}/admin/product/add">Add Product</a></li>
			                  </ul>
		                  </li>                    
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
	                    <li id="logout">
	                        <a href="${contextPath}/logout"><span class="glyphicon glyphicon-off"></span> Logout</a>
	                    </li>
                    </sec:authorize>
                 </ul>                 
                 <sec:authorize access="isAuthenticated()">
					<ul class="nav navbar-nav pull-right">
						<li><a><sec:authentication property="principal.username" /></a></li>		                                  
    		             </ul>
                 </sec:authorize>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
