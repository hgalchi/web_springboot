package com.example.WebSpringboot.part05.security.service;

import com.example.WebSpringboot.part05.Entity.ClubMember;
import com.example.WebSpringboot.part05.repository.ClubMemberRepoistory;
import com.example.WebSpringboot.part05.security.dto.ClubAuthMemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClubUserDetailService implements UserDetailsService {

    private final ClubMemberRepoistory repoistory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("ClubUserDetailsService loadUserByUsername" + username);

        Optional<ClubMember> result = repoistory.findByEmail(username, false);

        if (result.isEmpty()) {
            throw new UsernameNotFoundException("다시 한번 체크해주세요");
        }

        ClubMember clubMember = result.get();
        log.info("================================");
        log.info(clubMember);

        ClubAuthMemberDTO c = new ClubAuthMemberDTO(
                clubMember.getEmail(),
                clubMember.getPassword(),
                clubMember.isFromSocial(),
                clubMember.getRoleSet().stream()
                        .map(role -> new SimpleGrantedAuthority(
                                "ROLE_" + role.name())).collect(Collectors.toSet())
        );

        c.setName(clubMember.getName());
        c.setFromSocial(clubMember.isFromSocial());

        return c;
    }
}
