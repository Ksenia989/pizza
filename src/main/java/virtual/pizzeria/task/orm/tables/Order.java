package virtual.pizzeria.task.orm.tables;

import javax.persistence.*;

@Table(name = "order")
// todo @Entity()
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int specialRequests;
}
