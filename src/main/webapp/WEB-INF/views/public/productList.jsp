<div class="row">
    		<h3>{{productListCtrl.error}}</h3>
    		<h3>Products</h3>
    		<hr/>
    			
    			<label>Search Product :</label>
			<input type="text" class="form-control" ng-model="searchBy.name" placeholder="Type here" />
			
			<hr/>
    			
			<table class="table table-bordered table-striped">
				<tr>
					<th>Name</th>
					<th>Brand</th>
					<th>Price Per Unit</th>
					<th>Available Quantity</th>
					<th></th>
				</tr>
				<tr ng-repeat="product in productListCtrl.products | filter:searchBy">
					<td>{{product.name}}</td>
					<td>{{product.brand}}</td>
					<td>{{product.price}}</td>
					<td>{{product.quantity}}</td>
					<td>
						<a ng-href="#/product/{{ product.id }}/show" class="btn btn-primary">View</a> &#160; 
						<a ng-href="product/edit/{{ product.id }}" class="btn btn-primary">Edit</a>
						<a ng-href="#" class="btn btn-primary">Add To Cart</a>
					</td>
				</tr>			
			</table>        		
        </div>

</div>