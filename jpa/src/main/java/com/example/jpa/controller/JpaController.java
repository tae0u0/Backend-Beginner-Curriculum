package com.example.jpa.controller;

import com.example.jpa.controller.dto.SaveMemberRequest;
import com.example.jpa.domain.Member;
import com.example.jpa.service.JpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jpa")
public class JpaController {
    private final JpaService service;

    @GetMapping("/member/{memberId}")
    public ResponseEntity<Member> findMember(
            @PathVariable("memberId") Long memberId
    ) {
        Member member = service.findMember(memberId);
        return ResponseEntity.ok(member);
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<Member>> findAllMemberByTeamId(
            @PathVariable("teamId") Long teamId
    ) {
        List<Member> members = service.findMemberByTeam(teamId);
        return ResponseEntity.ok(members);
    }

    @PostMapping("/member")
    public ResponseEntity<String> saveMember(
            @RequestBody SaveMemberRequest request
    ) {
        service.saveMember(request);
        return ResponseEntity.ok("멤버를 추가하였습니다.");
    }

}
