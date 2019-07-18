package diegogv95.cars.controller;

import diegogv95.cars.entity.Car;
import diegogv95.cars.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("")
    public String index(Model model) {
        Car car = new Car();

        model.addAttribute("title", "Search cars");
        model.addAttribute("car", car);

        return "index";
    }

    /*@GetMapping("/all")
    public String findAll(Model model) {
        List<Car> cars = service.findAll();

        model.addAttribute("title", "List of cars");
        model.addAttribute("cars", cars);

        return "cars";
    }*/

    @GetMapping("/{id}")
    public String findOne(@PathVariable Long id, Model model, RedirectAttributes flash) {
        Car car = service.findById(id);

        if (car == null || id <= 0) {
            flash.addFlashAttribute("error", "Car does not exist");
            model.addAttribute("title", "List of cars");
            return "redirect:/cars";
        }

        model.addAttribute("title", "Car with ID: " + car.getId());
        model.addAttribute("car", car);

        return "car";
    }

    @GetMapping("/find")
    public String find(@RequestParam String brand, @RequestParam String gas, @RequestParam double price, Model model) {
        List<Car> foundCars = service.findByQuery(brand, gas, price);

        model.addAttribute("title", brand + " cars");
        model.addAttribute("cars", foundCars);

        return "cars";
    }

}
