package virtual.pizzeria.task.getstatus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import virtual.pizzeria.task.changestatus.ChangeOrderStatusController;
import virtual.pizzeria.task.changestatus.OrderStatus;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.dto.Order;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class GetStatusControllerTest {
    @InjectMocks
    private GetStatusController getStatusController;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getStatusNoSuchElement() {
        assertThrows(NoSuchElementException.class, ()->getStatusController.getStatus(null));
    }

    @Test
    void getStatusNullId() {
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(new Order()));
        assertThrows(NoSuchElementException.class, ()->getStatusController.getStatus(null));
    }

    @Test
    void getStatusWithEmptyOrder() {
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(new Order()));
        assertThrows(NullPointerException.class, ()->getStatusController.getStatus(11L));
    }

    @Test
    void getStatus() {
        Order order = new Order();
        order.setStatus(OrderStatus.DELIVERED);
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));
        ResponseEntity responseEntity = assertDoesNotThrow(() -> getStatusController.getStatus(11L));
        assertNotNull(responseEntity);
        assertEquals("Статус: доставлен", responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}