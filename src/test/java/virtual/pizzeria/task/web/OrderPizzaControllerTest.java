package virtual.pizzeria.task.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.Errors;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.db.PizzaRepository;
import virtual.pizzeria.task.dto.Order;
import virtual.pizzeria.task.dto.Pizza;
import virtual.pizzeria.task.web.OrderPizzaController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OrderPizzaControllerTest {
    private static final String DESIGN = "design";
    @InjectMocks
    private OrderPizzaController orderPizzaController;
    @Mock
    private OrderRepository orderRepo;
    @Mock
    private PizzaRepository pizzaRepo;
    @Mock
    private Errors errors;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        List<Pizza> pizzas = new ArrayList<>();
        Pizza p1 = new Pizza(1, "Салями", 550.0);
        Pizza p2 = new Pizza(2, "Сырная", 650.0);
        Pizza p3 = new Pizza(3, "Диетическая", 400.0);
        pizzas.add(p1);
        pizzas.add(p2);
        pizzas.add(p3);
        when(pizzaRepo.findAll()).thenReturn(pizzas);
    }

    @Test
    void processOrderAllNull() {
        assertThrows(NullPointerException.class, () -> orderPizzaController.processOrder(null, null, null));
    }

    @Test
    void processOrderWithError() {
        when(errors.hasErrors()).thenReturn(true);
        String design = assertDoesNotThrow(() -> orderPizzaController.processOrder(null, errors, null));
        assertEquals(DESIGN, design);
    }

    @Test
    void processOrderNullIdsAndOrder() {
        assertThrows(NullPointerException.class, () -> orderPizzaController.processOrder(null, errors, null));
    }

    @Test
    void processOrderNullIds() {
        Order order = new Order();
        String success = assertDoesNotThrow(() -> orderPizzaController.processOrder(order, errors, null));
        assertEquals("success", success);
    }

    @Test
    void design() {
        Order design = assertDoesNotThrow(() -> orderPizzaController.design());
        assertNotNull(design);
        assertEquals(3, design.getPizzas().size());
    }

    @Test
    void showDesignForm() {
        assertEquals(DESIGN, orderPizzaController.showDesignForm(null));
    }
}