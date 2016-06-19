<table class="table table-bordered table-striped">
	<tr>
		<th>Name</th>
		<th>Brand</th>
		<th>Price Per Unit</th>
		<th>Available Quantity</th>
		<th></th>
	</tr>
	<tr ng-repeat="product in listCtrl.products">
		<td>{{product.name}}</td>
		<td>{{product.brand}}</td>
		<td>{{product.price}}</td>
		<td>{{product.quantity}}</td>
		<td>
			<a ng-href="#" class="btn btn-primary">View</a> &#160; 
			<a ng-href="#" class="btn btn-primary">Add To Cart</a></td>
	</tr>

</table>