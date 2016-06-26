package com.khozema.iniitian.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.khozema.iniitian.entity.Cart;
import com.khozema.iniitian.entity.CartItem;
import com.khozema.iniitian.entity.Product;
import com.khozema.iniitian.entity.User;
import com.khozema.iniitian.service.CartItemService;
import com.khozema.iniitian.service.CartService;
import com.khozema.iniitian.service.ProductService;
import com.khozema.iniitian.service.UserService;

@RestController
public class CartController {

	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private UserService userService;
	@Autowired 
	private ProductService productService;
	@Autowired
	private CartService cartService;
	
    @RequestMapping("/user/cartItems")
    public @ResponseBody
    Cart getCart (Principal principal) {
    		User user = userService.getUserByEmailAddress(principal.getName());
        return cartService.get(user.getCart().getId());
    }	
	
	@RequestMapping(value = "/user/addToCart/{id}" , method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addToCart(@PathVariable("id") Long id, Principal principal) {		
		// 1. get the user 
		User user = userService.getUserByEmailAddress(principal.getName());
		System.out.println("I was here!!");
		// 2. get the cart
		Cart cart = user.getCart();
		
		// 3. get the product
		Product product = productService.get(id);
		
		// 4. get the cart items
		List<CartItem> cartItems = cart.getCartItems();
		
		// 5. check if the item is already added inside the cart
		// if so increase the quantity
		for (int i = 0; i < cartItems.size() ; i++) {
			if(product.getId() == cartItems.get(i).getProduct().getId()) {
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
				cartItemService.add(cartItem);
				return;
			}
		}
		
		
		// if a new cart item add it to the database
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getPrice());
		cartItem.setCart(cart);
		cartItemService.add(cartItem);		
		
	}
	
	
	@RequestMapping(value = "/user/removeFromCart/{id}" , method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeFromCart(@PathVariable("id") Long id, Principal principal) {
		CartItem cartItem = cartItemService.get(id);
		cartItemService.remove(cartItem);		
	}		
	
	
}
