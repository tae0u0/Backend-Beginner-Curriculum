package com.example.jpa.domain.repository;

import com.example.jpa.domain.Member;
import com.example.jpa.domain.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TeamRepository {

    @PersistenceContext
    private EntityManager em;

    public Team findById(Long teamId) {
        Team team = em.find(Team.class, teamId);
        return team;
    }

    @Transactional(readOnly = true)
    public List<Member> findByTeamId(Long teamId) {

        String jpql = "SELECT t FROM Team t WHERE t.id = :teamId";
        Team team = em.createQuery(jpql, Team.class)
                .setParameter("teamId", teamId)
                .getSingleResult();

        return team.getMembers();
    }
}
