package com.sberbank.app.controller;

import com.sberbank.app.model.Team;
import com.sberbank.app.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/team")
public class TeamController {

    TeamService teamService;

    @Autowired
    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/all")
    private List<Team> findAll() {
        return teamService.getTeams();
    }

    @PostMapping("/save/team")
    private Team saveTeam(Team team) {
        teamService.saveTeam(team);
        return team;
    }


}