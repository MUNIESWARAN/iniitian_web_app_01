<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="row">

	<div class="col-md-6">
		<div class="thumbnail">
			<img ng-src="resources/images/{{productCtrl.product.imageUrl}}" data-alt="{{productCtrl.product.name}}"/>
		</div>
	</div>

	<div class="col-md-6">
		<ul class="list-group">
		  <li class="list-group-item">Brand: {{productCtrl.product.brand}}</li>
		  <li class="list-group-item">Description {{productCtrl.product.description}}</li>
		  <li class="list-group-item">Price per unit: {{productCtrl.product.price | currency}}</li>
		  <li class="list-group-item">Unit available: {{productCtrl.product.quantity}}</li>		  
		</ul>
		<hr/>
		<sec:authorize access="hasRole('ROLE_USER') and (not hasRole('ROLE_ADMIN'))">
			<a ng-href="#/product/{{ productCtrl.product.id }}/show" class="btn btn-primary">Add To Cart</a> &#160;
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<a ng-href="admin/product/edit/{{ productCtrl.product.id }}" class="btn btn-primary">Edit</a></td>
		</sec:authorize>		
		<a ng-href="index" class="btn btn-primary">Back To Home</a></td>
	</div>

</div>