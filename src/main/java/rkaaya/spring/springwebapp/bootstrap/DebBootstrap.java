package rkaaya.spring.springwebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import rkaaya.spring.springwebapp.model.Hero;
import rkaaya.spring.springwebapp.model.HeroDetails;
import rkaaya.spring.springwebapp.model.Team;
import rkaaya.spring.springwebapp.repositories.HeroDetailsRepository;
import rkaaya.spring.springwebapp.repositories.HeroRepository;
import rkaaya.spring.springwebapp.repositories.TeamRepository;

@Component
public class DebBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private HeroRepository heroRepository;
    private TeamRepository teamRepository;
    private HeroDetailsRepository heroDetailsRepository;

    public DebBootstrap(HeroRepository heroRepository, TeamRepository teamRepository, HeroDetailsRepository heroDetailsRepository) {
        this.heroRepository = heroRepository;
        this.teamRepository = teamRepository;
        this.heroDetailsRepository = heroDetailsRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Hero flash = new Hero("Flash");
        HeroDetails flashDetails = new HeroDetails("Barry Alan");

        flash.setHeroDetails(flashDetails);

        Team teamFlash = new Team("Team Flash", 001);
        flash.getTeams().add(teamFlash);
        teamFlash.getHeroes().add(flash);

        heroDetailsRepository.save(flashDetails);
        heroRepository.save(flash);
        teamRepository.save(teamFlash);

        Hero superMan = new Hero("Superman");
        HeroDetails superManDetails = new HeroDetails("Clark Ken");

        superMan.setHeroDetails(superManDetails);

        Team superTeam = new Team("S team", 002);
        superTeam.getHeroes().add(superMan);

        heroDetailsRepository.save(superManDetails);
        heroRepository.save(superMan);
        teamRepository.save(superTeam);
    }
}
