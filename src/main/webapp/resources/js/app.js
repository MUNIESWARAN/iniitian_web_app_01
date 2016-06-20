/*
 * Angular JS Application
 * 
 */
// closure to write angular js code
(function(){
	
	var app = angular.module('webapp', ['ngRoute']);
	
	app.config(function($routeProvider, $locationProvider){
		$routeProvider
		.when("/", {
			templateUrl : 'default',
			controller: 'CategoryController',
			controllerAs: 'categoryCtrl'	
		})
		.when("/category/:id/product", {
			templateUrl : 'productList',
			controller: 'ProductListController',
			controllerAs: 'productListCtrl'	
		})
		.when("/product/all", {
			templateUrl : 'productList',
			controller: 'ProductListController',
			controllerAs: 'productListCtrl'	
		})
		.when("/product/:id/show", {
			templateUrl : 'productView',
			controller: 'ProductController',
			controllerAs: 'productCtrl'	
		})
		.otherwise({
			redirectTo: '/'
		})				
	})
	
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

	app.controller('ProductListController', ['$http', '$routeParams',  function($http, $routeParams) {
		var self = this;
		self.products = [];
		self.error = '';
		self.url = "";
		if($routeParams.id === undefined || $routeParams.id === null) {
			self.url = '/iniitianWebApp01/product/all';
		}
		else {
			self.url = '/iniitianWebApp01/category/' + $routeParams.id + '/product';
		}
		
		$http.get(self.url)
			.then(function mySuccess(response){
				self.products = response.data;
			}, function myError(response) {
				self.error = response.statusText;
			}
		)
	}]);
	
	app.controller('ProductController', ['$http', '$routeParams',  function($http, $routeParams) {
		var self = this;
		self.product = {};
		self.error = '';
		self.url = '/iniitianWebApp01/product/' + $routeParams.id;		
		$http.get(self.url)
			.then(function mySuccess(response){
				self.product = response.data;
			}, function myError(response) {
				self.error = response.statusText;
			}
		)
	}]);
	
	
	
}());