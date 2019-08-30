package virtual.pizzeria.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import virtual.pizzeria.task.db.PizzaRepository;
import virtual.pizzeria.task.dto.Pizza;

/**
 * entry point приложения
 */
@SpringBootApplication
public class TaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    /**
     * Заносим пиццы в БД
     */
    @Bean
    public CommandLineRunner dataLoader(PizzaRepository repo) {
        return args -> {
            repo.save(new Pizza(1, "Салями", 550.0));
            repo.save(new Pizza(2, "Сырная", 650.0));
            repo.save(new Pizza(3, "Диетическая", 400.0));
        };
    }
}
