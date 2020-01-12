package rkaaya.spring.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import rkaaya.spring.springwebapp.repositories.TeamRepository;

@Controller
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @RequestMapping("/teams")
    public String getTeams(Model model) {
        model.addAttribute("teams", teamRepository.findAll());

        return "teams";
    }
}
