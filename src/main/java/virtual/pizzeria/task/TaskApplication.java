package virtual.pizzeria.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import virtual.pizzeria.task.dto.Pizza;

@SpringBootApplication
public class TaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    /**
     * Заносим пиццы в БД  // todo
     */
    @Bean
    public CommandLineRunner dataLoader(PizzaRepository repo) {
        return args -> {
            repo.save(new Pizza("1_pizza", "Салями", 550.0));
            repo.save(new Pizza("2_pizza","Сырная", 650.0));
            repo.save(new Pizza("3_pizza","Диетическая", 400.0));
        };
    }
}
