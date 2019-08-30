package virtual.pizzeria.task.statistics;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IteratorUtils {
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
