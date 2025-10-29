package com.example.jpa.service;

import com.example.jpa.controller.dto.SaveMemberRequest;
import com.example.jpa.domain.Member;
import com.example.jpa.domain.Team;
import com.example.jpa.domain.repository.MemberRepository;
import com.example.jpa.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaService {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public Member findMember(Long memberId) {
        Member findMember = memberRepository.findById(memberId);
        return findMember;
    }

    public List<Member> findMemberByTeam(Long teamId) {
        List<Member> findMembers = teamRepository.findByTeamId(teamId);
        return findMembers;
    }

    public void saveMember(SaveMemberRequest request) {
        Team team = teamRepository.findById(request.teamId());
        Member newMember = new Member(request.name(), team);
        memberRepository.save(newMember);
    }
}
