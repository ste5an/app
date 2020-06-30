package com.sberbank.app.controller;

import com.sberbank.app.dao.model.Employee;
import com.sberbank.app.dao.model.Team;
import com.sberbank.app.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/team")
public class TeamController {

    @Autowired
    private TeamService teamService;


    @GetMapping("/teams")
    private List<Team> findAll() {
        return teamService.findAll();
    }

    @GetMapping("/find/{id}")
    private Optional<Team> getTeam(@PathVariable("id") long id) {
        return teamService.findById(id);
    }

    @PostMapping("/save")
    public void createTeam(@RequestBody Team team){
        teamService.save(team);
    }

    @PutMapping("/update")
    private Team update(@RequestBody Team team) {
        teamService.update(team);
        return team;
    }


    @DeleteMapping("/delete/{id}")
    private void deleteTeam(@PathVariable("id") long id) {
        teamService.deleteById(id);
    }






}