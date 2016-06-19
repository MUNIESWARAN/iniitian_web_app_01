
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
                                    <img class="slide-image" src="resources/images/product_one.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="resources/images/product_two.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="resources/images/product_three.jpg" alt="">
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
                            <img ng-src="resources/images/{{category.imageUrl}}" />
                            <div class="caption">
                                <h4><a ng-href="#/category/{{category.id}}/product">{{ category.name }}</a>
                                </h4>
                                <p>{{category.description | limitTo:50}}{{category.description.length>20 ? ' ...' : ''}}</p>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>

