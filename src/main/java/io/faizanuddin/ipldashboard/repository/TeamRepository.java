package io.faizanuddin.ipldashboard.repository;

import io.faizanuddin.ipldashboard.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {


    Team findByTeamName(String teamName);

}
