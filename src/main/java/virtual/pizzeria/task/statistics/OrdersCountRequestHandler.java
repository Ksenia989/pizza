package virtual.pizzeria.task.statistics;

import lombok.AllArgsConstructor;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.dto.Order;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class OrdersCountRequestHandler implements StatisticsRequestHandler {
    private Date timeFrom;
    private Date timeTo;
    private OrderRepository orderRepo;

    @Override
    public BasicResponse handle(StatisticsRequest request) {
        List<Order> orderStream = getStreamFromIterator(orderRepo.findAll().iterator()).
                filter(order ->
                        order.getOrderDate().after(timeFrom) && order.getOrderDate().before(timeTo)
                ).collect(Collectors
                .toList());//toCollection(ArrayList::new));

//        List<Order> orders = new ArrayList<>();
//        for (Order order : orderRepo.findAll()) {
//            if (order.getOrderDate().after(timeFrom)
//                    && order.getOrderDate().before(timeTo)) {
//                orders.add(order);
//            }
//        }
        int result = orderStream.size();
        BasicResponse response = new BasicResponse();
        response.setMessage("Было сделано " + result + " заказов");
        return response;
    }

    // Function to get the Stream
    public static <T> Stream<T>
    getStreamFromIterator(Iterator<T> iterator) {
        // Convert the iterator to Spliterator
        Spliterator<T>
                spliterator = Spliterators
                .spliteratorUnknownSize(iterator, 0);

        // Get a Sequential Stream from spliterator
        return StreamSupport.stream(spliterator, false);
    }
}
