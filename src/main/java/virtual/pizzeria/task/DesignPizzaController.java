package virtual.pizzeria.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignPizzaController {
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> salamiPizzaIngredients = Arrays.asList(
                new Ingredient("салями"),
                new Ingredient("сыр")
        );
        List<Ingredient> cheesePizzaIngredients = Arrays.asList(
                new Ingredient("сыр1"),
                new Ingredient("сыр2"),
                new Ingredient("сыр3")
        );
        List<Ingredient> dietPizzaIngredients = Arrays.asList(
                new Ingredient("огурцы"),
                new Ingredient("томаты"),
                new Ingredient("сыр")
        );
        List<Pizza> pizzas = Arrays.asList(
                new Pizza("Салями", 550.0, salamiPizzaIngredients),
                new Pizza("Сырная", 650.0, cheesePizzaIngredients),
                new Pizza("Диетическая", 400.0, dietPizzaIngredients)
        );
        // todo тут дублирование
        List<Pizza> pizzasSalamyCheese = Arrays.asList(
                new Pizza("Салями", 550.0, salamiPizzaIngredients),
                new Pizza("Сырная", 650.0, cheesePizzaIngredients)
        );
        List<PizzaCombo> pizzaCombo = Arrays.asList(
                new PizzaCombo("Комбо салями сыр", 600.0, pizzasSalamyCheese),
                new PizzaCombo("Комбо все в одном", 800.0, pizzas)
        );
        // todo брать это из БД???
        model.addAttribute("pizzas", pizzas);
        model.addAttribute("pizzasCombo", pizzaCombo);
        model.addAttribute("design", new Order());
        return "design";
    }
}
