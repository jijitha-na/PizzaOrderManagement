package pizza.order.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import pizza.order.model.Order;
import pizza.order.service.OrderService;

@WebMvcTest
public class OrderControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderService orderService;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testPostExample() throws Exception {
		Order order = new Order();
		order.setId(1L);
		order.setName("PizzaA");
		order.setQuantity(2);
		order.setPrice(10.00);
		Mockito.when(orderService.addOrder(ArgumentMatchers.any())).thenReturn(order);
		String json = mapper.writeValueAsString(order);
		mockMvc.perform(post("/order/add").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", Matchers.equalTo(1)))
				.andExpect(jsonPath("$.name", Matchers.equalTo("PizzaA")))
				.andExpect(jsonPath("$.quantity", Matchers.equalTo(2)))
				.andExpect(jsonPath("$.price", Matchers.equalTo(10.00)));
	}

}
