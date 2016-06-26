/*
 * Angular JS Application
 * 
 */
// closure to write angular js code
(function(){
	
	var app = angular.module('webapp', []);
	
//	app.config(['$locationProvider', function($locationProvider){
//		$locationProvider.html5Mode(true);
//	}]);
//		$routeProvider
//		.when("/category/:id/product", {
//			templateUrl : 'productList',
//			controller: 'ProductListController',
//			controllerAs: 'productListCtrl'	
//		})
//		.when("/product/all", {
//			templateUrl : 'productList',
//			controller: 'ProductListController',
//			controllerAs: 'productListCtrl'	
//		})
//		.when("/product/:id/show", {
//			templateUrl : 'productView',
//			controller: 'ProductController',
//			controllerAs: 'productCtrl'	
//		})
//		.otherwise({
//			redirectTo: '/'
//		})				
//	})
	
	app.controller('CategoryController', ['$http', function($http) {
		var self = this;
		self.categories = [];
		self.error = '';
		
		$http.get('/iniitianWebApp01/category/all')
			.then(function mySuccess(response){
				self.categories = response.data;
			}, function myError(response) {
				self.error = response.statusText;
			}
		)
	}]);

	app.controller('ProductListController', ['$http', '$window', '$scope',  function($http, $window, $scope) {
		var self = this;
		self.products = [];
		self.error = '';
		self.url = '';
		self.categoryId = $window.location.search.slice($window.location.search.indexOf("=") + 1)
		
		if(self.categoryId === undefined || self.categoryId === null || self.categoryId === '') {			
			self.url = '/iniitianWebApp01/product/all';
		}
		else {
			self.url = '/iniitianWebApp01/category/' + self.categoryId + '/product';
		}
		
		$http.get(self.url)
			.then(function mySuccess(response){
				self.products = response.data;
			}, function myError(response) {
				self.error = response.statusText;
			}
		)
		
		$scope.addToCart = function(id) {
			$http.put('/iniitianWebApp01/user/addToCart/'+id)
			.then(function mySuccess(response){
				alert('Item successfully added inside the cart!');
			}) 		
		}
		
		
	}]);
	
	app.controller('ProductController', ['$http', '$window', '$scope',  function($http, $window, $scope) {
		var self = this;
		self.product = {};
		self.error = '';
		self.productId = $window.location.search.slice($window.location.search.indexOf("=") + 1)
		self.url = '/iniitianWebApp01/product/' + self.productId;		
		$http.get(self.url)
			.then(function mySuccess(response){
				self.product = response.data;
			}, function myError(response) {
				self.error = response.statusText;
			}
		)
		
		$scope.addToCart = function(id) {
			$http.put('/iniitianWebApp01/user/addToCart/'+id)
			.then(function mySuccess(response){
				alert('Item successfully added inside the cart!');
			}) 		
		}
		
	}]);
	
	
	/*
	 * Handles the viewCart page along with the RestController i.e. CartController
	 * */
	
	app.controller('CartController', ['$http', '$scope', function($http, $scope){
				
		var self = this;
		self.hasItems = false;
		self.cart = {};		
		self.grandTotal = 0;
				
		$scope.refreshCartItems = function() { 		
			$http.get('/iniitianWebApp01/user/cartItems')
			.then(function mySuccess(response) {
				self.cart = response.data;
				self.grandTotal = $scope.grandTotalOfItems();				
			});			
		}			
		
		$scope.grandTotalOfItems = function() {
			var temp = 0;
			for(var i = 0; i < self.cart.cartItems.length; i++) {				
				temp += self.cart.cartItems[i].totalPrice;
			}
			if(temp > 0) {
				self.hasItems = true;
			}
			else {
				self.hasItems = false;
			}
			return temp;
		}
		
						
		$scope.refreshCartItems();
		
				
		$scope.removeFromCart = function(id) {
			if(confirm('Are you sure you want to remove this item?')) {
					$http["delete"]('/iniitianWebApp01/user/removeFromCart/'+id)
					.then(function mySuccess(response){
						alert('Item successfully removed from the cart!');
						$scope.refreshCartItems();
					});
			}
		}
		
		
	}]);	
	
}());