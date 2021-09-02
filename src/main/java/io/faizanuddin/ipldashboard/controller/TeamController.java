package io.faizanuddin.ipldashboard.controller;

import io.faizanuddin.ipldashboard.model.Team;
import io.faizanuddin.ipldashboard.repository.MatchRepository;
import io.faizanuddin.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {


    private TeamRepository teamRepository;

    private MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository ) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){

         Team team = this.teamRepository.findByTeamName(teamName);
         team.setMatches(this.matchRepository.findLatestMatchesByTeam(teamName,4));

         return team;
    }
}
