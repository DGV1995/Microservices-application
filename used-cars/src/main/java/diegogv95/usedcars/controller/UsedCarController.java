package diegogv95.usedcars.controller;

import diegogv95.usedcars.entity.UsedCar;
import diegogv95.usedcars.service.UsedCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/used-cars")
public class UsedCarController {

    private UsedCarService service;

    @Autowired
    public UsedCarController(UsedCarService service) {
        this.service = service;
    }

    @GetMapping("")
    public String index(Model model) {
        UsedCar car = new UsedCar();

        model.addAttribute("title", "Used cars");
        model.addAttribute("car", car);

        return "index";
    }

    @GetMapping("/find")
    public String find(@RequestParam String brand, @RequestParam double km, @RequestParam double price, Model model) {
        List<UsedCar> cars = service.findByQuery(brand, km, price);

        model.addAttribute("title", brand.concat(" used cars"));
        model.addAttribute("cars", cars);

        return "cars";
    }

    @GetMapping("/find/{id}")
    public String findById(@PathVariable Long id, Model model) {
        UsedCar car = service.findById(id);

        model.addAttribute("title", "Used car with ID: " + car.getId());
        model.addAttribute("car", car);

        return "car";
    }

}
