package com.cogent.GreatOutdoors.controller;

import java.util.ArrayList;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.GreatOutdoors.dto.Cart;
import com.cogent.GreatOutdoors.dto.CustomerQuery;
import com.cogent.GreatOutdoors.dto.DeliveryAddress;
import com.cogent.GreatOutdoors.dto.Orders;
import com.cogent.GreatOutdoors.dto.Product;
import com.cogent.GreatOutdoors.dto.User;
import com.cogent.GreatOutdoors.repository.UserRepository;
import com.cogent.GreatOutdoors.security.config.JwtTokenUtil;
import com.cogent.GreatOutdoors.security.model.JwtResponse;
import com.cogent.GreatOutdoors.security.model.LoginRequest;
import com.cogent.GreatOutdoors.security.model.MessageResponse;
import com.cogent.GreatOutdoors.security.model.SignupRequest;
import com.cogent.GreatOutdoors.security.service.JwtUserDetailsImpl;
import com.cogent.GreatOutdoors.service.CartService;
import com.cogent.GreatOutdoors.service.CustomerQueryService;
import com.cogent.GreatOutdoors.service.DeliveryAddressService;
import com.cogent.GreatOutdoors.service.OrdersService;
import com.cogent.GreatOutdoors.service.ProductService;
import com.cogent.GreatOutdoors.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@Api(value="Swagger GreatOutdoors", 
		description="Rest API for GreatOutDoors entities")
@RestController
@RequestMapping("/greatOutdoors")
public class MainController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CustomerQueryService queryService;
	
	@Autowired
	private DeliveryAddressService daService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenUtil jwtUtils;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserRepository userRepository;
	
	@ApiOperation(value="Get list of products in the database", response=Iterable.class, tags="getProducts")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping(value="/getProducts")
	public List<Product> getProducts(){
		return productService.getAllProducts();
	}
	
	@ApiOperation(value="Get Products by category", response=Iterable.class, tags="getProductsByCategory")
	@GetMapping(value="/getProducts/{category}")
	public List<Product> getProductsByCategory(@PathVariable(value="category") String category){
		List<Product> pList = new ArrayList<Product>();
		pList = productService.getAllProducts();
		
		List<Product> productsByCategory = pList.stream().filter(x->x.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
		return productsByCategory;
	}
	
	@PostMapping("/addProduct")
	 public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>(product.getName() + " was added.", HttpStatus.OK);
    }
	
	@PostMapping("/addAddress")
    public ResponseEntity<String> addAddress(@RequestBody DeliveryAddress address) {
        daService.saveAddress(address);
        return new ResponseEntity<>("Delivery address #" + address.getAddressId() + " was added.", HttpStatus.OK);
    }
	
	@PostMapping("/placeOrder")
    public ResponseEntity<String> addOrder(@RequestBody Orders order) {
        ordersService.addOrder(order);
        return new ResponseEntity<>("Order " + order.getOrderId() + " was placed.", HttpStatus.OK);
    }
	
	@PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(user.getFirstName() + " was added.", HttpStatus.OK);
    }
	
	@PostMapping("/createQuery")
    public ResponseEntity<String> addQuery(@RequestBody CustomerQuery query) {
        queryService.addQuery(query);
        return new ResponseEntity<>("Query from Customer " + query.getId() + " was created.", HttpStatus.OK);
    }
	
	@PostMapping("/saveCart")
    public ResponseEntity<String> addCart(@RequestParam("productId") int productId,
    		@RequestParam("price") float price, @RequestParam("userId") int userId) {
		Product product = productService.getProductById(productId).get(0);
		User user = userService.getUserbyId(userId);
		Cart cart = new Cart(user, product, 1, price);
        cartService.addCart(cart);
        return new ResponseEntity<>("Cart #" + cart.getCartId() + " was saved.", HttpStatus.OK);
    }
	
	@PostMapping("/changeCart")
    public ResponseEntity<String> changeCart(@RequestParam("cartId") int cartId, @RequestParam("quantity")int quantity, @RequestParam("productId")int productId) {
		List<Cart> cart_list = cartService.getCartById(cartId);
		if(cart_list != null) {
			Cart cart = cart_list.get(0);
			Product product = productService.getProductById(productId).get(0);
			cart.setProduct(product);
			cart.setQuantity(quantity);
			cart.setPrice(quantity*product.getPrice());
			cartService.addCart(cart);
			return new ResponseEntity<>("Cart #" + cart.getCartId() + " changes were saved.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Cart #" + cartId + " was not found!", HttpStatus.NOT_FOUND);
		
    }
	
	@DeleteMapping("/deleteCart")
	public ResponseEntity<String> deleteCart(@RequestParam("cartId") int cartId){
		Cart cart = cartService.getCartById(cartId).get(0);
		cartService.deleteCart(cart);
		return new ResponseEntity<>("Cart #" + cartId + " was deleted.", HttpStatus.OK);
	}
	
	@GetMapping("/getCartByUser")
	public List<Cart> getCart(@RequestParam("userId") int userId)
	{
		List<Cart> cartContents = cartService.getCartByUserId(userId);
		return cartContents;
	}
	
	@GetMapping("/findAllCarts")
	public List<Cart> getCartList(){
		return cartService.getAllCarts();
	}
	@GetMapping("/getCartById")
	public List<Cart> getCartById(@RequestParam("cartId") int cartId){
		return cartService.getCartById(cartId);
	}
	
	
	@GetMapping("/findAllProducts")
	public List<Product> getProductList(){
		return productService.getAllProducts();
	}
	@GetMapping("/findProductsByCategory")
	public List<Product> getProductByCategory(@RequestParam("category") String category){
		return productService.getProductsByCategory(category);
	}
	@GetMapping("/findProductsById")
	public List<Product> getProductsById(@RequestParam("id") int id){

		return productService.getProductById(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		JwtUserDetailsImpl userDetails = (JwtUserDetailsImpl) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(),
												 userDetails.getEmail()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.findByEmail(signUpRequest.getEmail()).isPresent()) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username/email is already taken!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getPhoneNumber(),
							signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()),
							signUpRequest.getAddressLine1(), signUpRequest.getAddressLine2(), signUpRequest.getState(),
							signUpRequest.getPincode());

		userService.addUser(user);
		// mail service to send plain text mail to user's email account about successful
		// registration
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		
		}
	

}
