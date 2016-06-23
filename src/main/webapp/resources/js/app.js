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

	app.controller('ProductListController', ['$http', '$window',  function($http, $window) {
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
	}]);
	
	app.controller('ProductController', ['$http', '$window',  function($http, $window) {
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
	}]);
	
}());