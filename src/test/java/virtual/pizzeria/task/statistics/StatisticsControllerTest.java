package virtual.pizzeria.task.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.dto.Order;
import virtual.pizzeria.task.dto.Pizza;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class StatisticsControllerTest {
    @Mock
    OrderRepository repository;

    @BeforeEach
    void beforeClass() {
        MockitoAnnotations.initMocks(this);
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.addPizza(new Pizza());
        order.setOrderDate(new Date());
        orders.add(order);
        when(repository.findAll()).thenReturn(orders);
    }

    @Test
    void getSomeStatistics() {
        StatisticsController controller = new StatisticsController(repository);
        StatisticsRequest request = new StatisticsRequest();
        request.setTimeFrom(new Date(1504113798));
        request.setTimeTo(new Date());
        request.setType(TaskType.ORDERS_COUNT);
        ResponseEntity responseEntity = assertDoesNotThrow(() -> controller.getSomeStatistics(request));
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode().value());

        request.setType(TaskType.PIZZA_COUNT);
        responseEntity = assertDoesNotThrow(() -> controller.getSomeStatistics(request));
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode().value());
    }
}
