package rkaaya.spring.springwebapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import rkaaya.spring.springwebapp.model.Hero;
import rkaaya.spring.springwebapp.model.Team;
import rkaaya.spring.springwebapp.repositories.HeroRepository;
import rkaaya.spring.springwebapp.repositories.TeamRepository;

@Component
public class DebBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private HeroRepository heroRepository;
    private TeamRepository teamRepository;

    public DebBootstrap(HeroRepository heroRepository, TeamRepository teamRepository) {
        this.heroRepository = heroRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Hero flash = new Hero("Flash", "Barry Alan");
        Team teamFlash = new Team("Team Flash", 001);
        flash.getTeams().add(teamFlash);
        teamFlash.getHeroes().add(flash);

        heroRepository.save(flash);
        teamRepository.save(teamFlash);

        Hero superMan = new Hero("Superman", "Clark Ken");
        Team superTeam = new Team("S team", 002);
//        superMan.getTeams().add(superTeam);
        superTeam.getHeroes().add(superMan);

        heroRepository.save(superMan);
        teamRepository.save(superTeam);
    }
}
