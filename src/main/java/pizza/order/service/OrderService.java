package pizza.order.service;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.order.model.Order;
import pizza.order.repository.OrderRepository;

@Service
public class OrderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	OrderRepository orderRepository;

	@Transactional
	public Order addOrder(Order order) {
		LOGGER.info("Creating order init");

		order.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		order.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		Order createdOrder = orderRepository.save(order);
		LOGGER.info("Order created");

		return createdOrder;
	}

}
