package com.sberbank.app.service;

import com.sberbank.app.model.Team;
import com.sberbank.app.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeamService {

    TeamRepository teamRepository;

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(long id) {
        return teamRepository.findById(id);
    }

    public void deleteTeamById(long id) {
        teamRepository.deleteById(id);
    }
}
