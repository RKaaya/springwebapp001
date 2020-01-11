package rkaaya.spring.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import rkaaya.spring.springwebapp.model.HeroDetails;

public interface HeroDetailsRepository extends CrudRepository<HeroDetails, Long> {
}
