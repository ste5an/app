package com.sberbank.app.controller;

import com.sberbank.app.controller.dto.NewEmployeeInfoDto;
import com.sberbank.app.dao.model.Employee;
import com.sberbank.app.dao.model.Team;
import com.sberbank.app.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/team")
public class TeamController {

    @Autowired
    private TeamService teamService;


    @GetMapping("/teams")
    private List<Team> findAll() {
        return teamService.findAll();
    }

    @PostMapping("/save")
    public void createTeam(@RequestBody Team team){
        teamService.save(team);
    }






}