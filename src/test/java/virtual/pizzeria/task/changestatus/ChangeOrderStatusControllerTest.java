package virtual.pizzeria.task.changestatus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.dto.Order;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ChangeOrderStatusControllerTest {
    @InjectMocks
    private ChangeOrderStatusController changeOrderStatusController;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ChangeStatus request;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void changeStatusNull() {
        assertThrows(NullPointerException.class, ()->changeOrderStatusController.changeStatus(null));
    }

    @Test
    void changeStatusNoSuchElement() {
        assertThrows(NoSuchElementException.class, ()->changeOrderStatusController.changeStatus(request));
    }

    @Test
    void changeStatusWithEmptyRequest() {
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(new Order()));
        assertThrows(NullPointerException.class, ()->changeOrderStatusController.changeStatus(request));
    }

    @Test
    void changeStatus() {
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(new Order()));
        when(request.getStatusToGo()).thenReturn(OrderStatus.RECEIVED);
        ResponseEntity responseEntity = changeOrderStatusController.changeStatus(request);
        assertNotNull(responseEntity);
        assertEquals("Статус успешно установлен", responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}