package rkaaya.spring.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import rkaaya.spring.springwebapp.repositories.HeroRepository;

@Controller
public class HeroController {

    private HeroRepository heroRepository;

    public HeroController(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @RequestMapping("/heroes")
    public String getHeroes(Model model) {
        model.addAttribute("heroes", heroRepository.findAll());

        return "heroes";
    }
}
