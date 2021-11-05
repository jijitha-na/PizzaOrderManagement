package pizza.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pizza.order.model.Order;
import pizza.order.service.OrderService;
import pizza.order.utility.ValidatorException;
import pizza.order.validator.OrderValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/order")
public class OrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/add", consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity addOrder(@RequestBody Order order) throws ValidatorException {

		LOGGER.info("add order init");
		OrderValidator.validateCreateOrder(order);
		Order createdOrder = orderService.addOrder(order);
		if (createdOrder != null) {
			LOGGER.info("order created successfully!");
		}
		return new ResponseEntity<>(createdOrder, HttpStatus.OK);
	}

}
