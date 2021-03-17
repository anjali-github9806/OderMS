package com.infy.order;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.order.repository.OrderRepository;
import com.infy.order.service.OrderService;

@SpringBootTest
public class OrderTestCases {
	@Mock
	OrderRepository orderRepo;
	
	@InjectMocks
	OrderService orderService;
	
	@Test
	public void getSpecificOrder() throws Exception{
		
	}

}
