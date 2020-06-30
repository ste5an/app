package com.sberbank.app.service;

import com.sberbank.app.dao.model.Employee;
import com.sberbank.app.dao.model.Team;
import com.sberbank.app.dao.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Transactional
    public void save(Team team) {
        teamRepository.save(team);
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Optional<Team> findById(long id) {
        return teamRepository.findById(id);
    }

    public void deleteById(long id) {
        teamRepository.deleteById(id);
    }

    @Transactional
    public Team update(Team team) {
        Optional<Team> optional = teamRepository.findById(team.getId());
        if (optional.isPresent()) {
            Team teamFromDb = optional.get();
            teamFromDb.setId(team.getId());
            teamFromDb.setName(team.getName());
            teamFromDb.setTag(team.getTag());
            teamFromDb.setType(team.getType());
            return teamRepository.save(teamFromDb);
        } else {
            throw new RuntimeException("Team with id: " + team.getId() + " not found");
        }
    }
}
