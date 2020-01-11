package rkaaya.spring.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import rkaaya.spring.springwebapp.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

}
