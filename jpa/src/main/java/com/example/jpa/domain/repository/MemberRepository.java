package com.example.jpa.domain.repository;

import com.example.jpa.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public Member findById(Long memberId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Member member = em.createQuery(
                            "SELECT m FROM Member m JOIN FETCH m.team WHERE m.id = :id", Member.class)
                    .setParameter("id", memberId)
                    .getSingleResult();

            em.getTransaction().commit();
            return member;
        } finally {
            em.close();
        }
    }

    public void save(Member newMember) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
             em.persist(newMember);
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }
}
