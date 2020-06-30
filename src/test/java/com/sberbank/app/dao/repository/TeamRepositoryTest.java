package com.sberbank.app.dao.repository;

import com.sberbank.app.dao.model.Team;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
@Transactional
@AutoConfigureEmbeddedDatabase
class TeamRepositoryTest {


    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void successfullySaveNewEmployee() {
        Team team = new Team();
        team.setName("Name");
        team.setTag("Agile");
        team.setType("new");
        Team savedTeam = teamRepository.save(team);
        assertNotNull(savedTeam.getId());

    }
}