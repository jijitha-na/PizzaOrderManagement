package pizza.order.validator;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import pizza.order.controller.OrderController;
import pizza.order.model.Order;
import pizza.order.utility.MessageUtil;
import pizza.order.utility.ValidatorException;

@Component
public class OrderValidator {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	public static void validateCreateOrder(Order order) throws ValidatorException {

		LOGGER.info("validate order details init");

		if (order == null) {
			LOGGER.info("validate order details: order is null");
			throw new ValidatorException(MessageUtil.INVALID_ORDER);
		}
		if (StringUtils.isBlank(order.getName())) {
			LOGGER.info("validate order details: item is missing");
			throw new ValidatorException(MessageUtil.ITEM_NAME_MISSING);
		}
		if (order.getQuantity() == null || order.getQuantity() == 0 || order.getQuantity() < 0) {

			LOGGER.info("validate order details: quantity is invalid");
			throw new ValidatorException(MessageUtil.INVALID_QUANTITY);
		}
		if (order.getPrice() == null || order.getPrice() == 0 || order.getPrice() < 0) {

			LOGGER.info("validate order details: price is invalid");
			throw new ValidatorException(MessageUtil.INVALID_PRICE);
		}

	}
}
