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
		<a ng-href="#/product/{{ product.id }}/show" class="btn btn-primary">Add To Cart</a> &#160; 
		<a ng-href="product/edit/{{ product.id }}" class="btn btn-primary">Edit</a></td>
		<a ng-href="index" class="btn btn-primary">Back To Home</a></td>
	</div>

</div>