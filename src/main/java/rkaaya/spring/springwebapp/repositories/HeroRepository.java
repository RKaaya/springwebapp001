package rkaaya.spring.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import rkaaya.spring.springwebapp.model.Hero;

public interface HeroRepository extends CrudRepository<Hero, Long> {

}
